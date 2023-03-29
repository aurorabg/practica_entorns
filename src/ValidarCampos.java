import java.util.Random;

public class ValidarCampos {
    public static void validarCampos(String nombre, String email, String password, String codigo) {

        String[] nombresExistentes = { "Juan_123", "Maria_456", "Pedro-789", "Sofia_123", "Luisa-456",
                "Pablo_789", "Ana_123", "Carlos-456", "Lucia_789", "Marta_123" };
        if (nombre.length() > 16) {
            System.out.println("El nombre de usuario no cumple con las restricciones.");
            return;
        }
        if (!Character.isUpperCase(nombre.charAt(0))) {
            System.out.println("El nombre de usuario no cumple con las restricciones.");
            return;
        }
        if (!nombre.matches("^[A-Za-z][a-z]*[-_][0-9]{3}$")) {
            System.out.println("El nombre de usuario no cumple con las restricciones.");
            return;
        }
        for (String nombreExistente : nombresExistentes) {
            if (nombre.equalsIgnoreCase(nombreExistente)) {
                System.out.println("El nombre de usuario ya existe.");
                return;
            }
        }
        if (!email.contains("@")) {
            System.out.println("El correo electrónico no cumple con las restricciones.");
            return;
        }
        if (!email.matches("^.*@(paucasesnovescifp|yahoo|gmail|hotmail)\\.(com|es|cat)$")) {
            System.out.println("El correo electrónico no cumple con las restricciones.");
            return;
        }
        if (password.length() != 8) {
            System.out.println("La contraseña no cumple con las restricciones.");
            return;
        }
        if (!Character.isUpperCase(password.charAt(0))) {
            System.out.println("La contraseña no cumple con las restricciones.");
            return;
        }
        if (!password.matches("^[A-Za-z0-9]*[@\\-_#][0-9]{2}$")) {
            System.out.println("La contraseña no cumple con las restricciones.");
            return;
        }
        String codigoAutogenerado = generarCodigoSeguridad();
        System.out.println("Código autogenerado: " + codigoAutogenerado);
        if (!codigo.equals(codigoAutogenerado)) {
            System.out.println("El código de seguridad no coincide.");
            return;
        }
        System.out.println(
                "El registro se ha realizado con éxito: " + nombre + " " + email + " " + password + " " + codigo);
    }

    private static String generarCodigoSeguridad() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String numeros = "1234567890";
        String simbolos = "@-_#";
        String caracteres = letras + numeros + simbolos;
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }
}
