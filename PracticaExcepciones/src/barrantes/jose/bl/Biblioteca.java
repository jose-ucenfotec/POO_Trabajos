package barrantes.jose.bl;

public class Biblioteca {

    private Material[] materiales;
    private Usuario[] usuarios;
    private int totalMateriales;
    private int totalUsuarios;

    public Biblioteca() {
        materiales = new Material[50];
        usuarios = new Usuario[50];
    }

    public void registrarMaterial(Material material) {
        materiales[totalMateriales] = material;
        totalMateriales++;
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios[totalUsuarios] = usuario;
        totalUsuarios++;
    }

    public Material buscarMaterial(String id) throws MaterialNoEncontradoException {

        for (int i = 0; i < totalMateriales; i++) {
            if (materiales[i].getId().equals(id)) {
                return materiales[i];
            }
        }

        throw new MaterialNoEncontradoException("Material no encontrado.");
    }

    public Usuario buscarUsuario(int id) throws UsuarioNoEncontradoException {

        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i].getId() == id) {
                return usuarios[i];
            }
        }

        throw new UsuarioNoEncontradoException("Usuario no encontrado.");
    }

    public void prestarMaterial(int usuarioId, String materialId)
            throws OperacionBibliotecaException {

        try {

            Usuario usuario = buscarUsuario(usuarioId);
            Material material = buscarMaterial(materialId);

            ((Prestable) material).prestar();
            usuario.prestarMaterial(material);

        } catch (BibliotecaException e) {

            throw new OperacionBibliotecaException(
                    "Error al realizar el préstamo",
                    e
            );
        }
    }

    public void devolverMaterial(int usuarioId, String materialId)
            throws UsuarioNoEncontradoException,
            MaterialNoEncontradoException {

        Usuario usuario = buscarUsuario(usuarioId);
        Material material = buscarMaterial(materialId);

        ((Prestable) material).devolver();
        usuario.devolverMaterial(material);
    }
}