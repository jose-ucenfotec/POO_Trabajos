package barrantes.jose.bl;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class RegistroErrores {

    public static void registrar(Exception e) {

        try {

            PrintWriter writer = new PrintWriter(new FileWriter("errores.log", true));

            writer.println("[" + LocalDateTime.now() + "] "
                    + e.getClass().getSimpleName()
                    + " - "
                    + e.getMessage());

            writer.close();

        } catch (Exception ex) {
            System.out.println("No se pudo registrar el error.");
        }
    }
}