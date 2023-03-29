package registro;

import java.util.Random;

public class ValidarCampos {
    private static final String[] usuarios = { "Juan_124", "Maria_456", "Pedro-789", "Sofia_123", "Luisa-456",
            "Pablo_789", "Ana_123", "Carlos-456", "Lucia_789", "Marta_123" };
    private String nombre;
    private String email;
    private String password;
    private String codigo;

    public void validarCampos(ValidarCampos registro) {
        if (!validarNombre(registro.nombre, usuarios)) {
            System.out.println("El nombre de usuario no cumple con las restricciones.");
            return;
        }
        if (!validarEmail(registro.email)) {
            System.out.println("El correo electrónico no cumple con las restricciones.");
            return;
        }
        if (!validarPassword(registro.password)) {
            System.out.println("La contraseña no cumple con las restricciones.");
            return;
        }
        if (!validarCodigo(registro.codigo)) {
            System.out.println("El código de seguridad no coincide.");
            return;
        }
        System.out.println("El registro se ha realizado con éxito: " + registro.nombre + " " + registro.email + " "
                + registro.password + " " + registro.codigo);
    }

    private static boolean validarEmail(String email) {
        // comprueba si el correo electrónico contiene el carácter "@" que separa el
        // nombre de usuario del dominio.
        // Si no se cumple esta condición, se imprime un mensaje de error y se finaliza
        // el programa con la instrucción "return".
        if (!email.contains("@")) {
            System.out.println("El correo electrónico no cumple con las restricciones.");
            return false;
        }
        // verifica si una dirección de correo electrónico cumple con ciertas
        // restricciones.
        // Utiliza una expresión regular para verificar si la dirección de correo
        // electrónico termina en
        // “@paucasesnovescifp.com”, “@paucasesnovescifp.es”, “@paucasesnovescifp.cat”,
        // “@yahoo.com”, “@yahoo.es”,
        // “@yahoo.cat”, “@gmail.com”, “@gmail.es”, “@gmail.cat”, “@hotmail.com”,
        // “@hotmail.es” o “@hotmail.cat”.
        // Si la dirección de correo electrónico no cumple con estas restricciones, se
        // imprime un mensaje y se sale del método actual
        if (!email.matches("^.*@(paucasesnovescifp|yahoo|gmail|hotmail)\\.(com|es|cat)$")) {
            System.out.println("El correo electrónico no cumple con las restricciones.");
            return false;
        }
        return true;
    }

    private static boolean validarNombre(String nombre, String[] usuarios) {
        // Comprueba si la longitud del nombre de usuario es mayor que 16 caracteres.
        // Si se cumple esta condición, se imprime un mensaje de error y se finaliza el
        // programa con la instrucción "return".
        if (nombre.length() > 16) {
            System.out.println("El nombre de usuario no cumple con las restricciones.");
            return false;
        }
        // Comprueba si el primer carácter del nombre de usuario es una letra mayúscula.
        // Si esta condición no se cumple, se imprime un mensaje de error y se finaliza
        // el programa con la instrucción "return".
        if (!Character.isUpperCase(nombre.charAt(0))) {
            System.out.println("El nombre de usuario no cumple con las restricciones.");
            return false;
        }
        // Usa una expresión regular para verificar si el nombre de usuario cumple con
        // un patrón específico.
        // El patrón requerido es que el nombre de usuario comience con una letra
        // mayúscula seguida de una o
        // más letras minúsculas, seguido de un guión o guión bajo y luego tres dígitos.
        // Si esta condición no
        // se cumple, se imprime un mensaje de error y se finaliza el programa con la
        // instrucción "return".
        if (!nombre.matches("^[A-Za-z][a-z]*[-_][0-9]{3}$")) {
            System.out.println("El nombre de usuario no cumple con las restricciones.");
            return false;
        }
        // validación adicional que se realiza después de las verificaciones anteriores
        // y busca si el nombre
        // de usuario ingresado ya existe en una lista preexistente de nombres de
        // usuario, "nombresExistentes".
        for (String nombreExistente : usuarios) {
            if (nombre.equalsIgnoreCase(nombreExistente)) {
                System.out.println("El nombre de usuario ya existe.");
                return false;
            }
        }
        return true;
    }

    private boolean validarPassword(String password) {
        /* Condición para saber si la contraseña cumple con la largaría correcta */
        if (password.length() != 8) {
            // Le hacemos saber al usuario que ha ocurrido un error
            System.out.println("La contraseña no cumple con las restricciones.");
            return false;
        }
        /*
         * Condición para saber si la contraseña cumple con que la primera letra esté en
         * mayúscula
         */
        if (!Character.isUpperCase(password.charAt(0))) {
            // Le hacemos saber al usuario que ha ocurrido un error
            System.out.println("La contraseña no cumple con las restricciones.");
            return false;
        }

        /*
         * Condición para saber si la contraseña cumple con los símbolos y carácteres
         * permitidos
         */
        if (!password.matches("^[A-Za-z0-9]*[@\\-_#][0-9]{2}$")) {
            // Le hacemos saber al usuario que ha ocurrido un error
            System.out.println("La contraseña no cumple con las restricciones.");
            return false;
        }
        return true;
    }

    private boolean validarCodigo(String codigo) {
        String codigoAutogenerado = generarCodigoSeguridad();
        System.out.println("Código autogenerado: " + codigoAutogenerado);
        /* Condición para saber si el código autogenerado es igual al introducido */
        if (!codigo.equals(codigoAutogenerado)) {
            // Le hacemos saber al usuario que ha ocurrido un error
            System.out.println("El código de seguridad no coincide.");
            return false;
        }
        return true;
    }

    /* Método para generar un código de seguridad de forma aleatoria */
    private String generarCodigoSeguridad() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String numeros = "1234567890";
        String simbolos = "@-_#";
        String caracteres = letras + numeros + simbolos;
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            // Creamos el código
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        // Pasamos el código a String
        return sb.toString();
    }

    public static String[] getNombresexistentes() {
        return usuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ValidarCampos(String email, String password, String codigo) {
        this.email = email;
        this.password = password;
        this.codigo = codigo;
    }

    public ValidarCampos(String email) {
        this.email = email;
    }

    public ValidarCampos() {
        this.email = "jdieojww0f";
        this.password = "ncwoei";
    }

    public ValidarCampos(String nombre, String email, String password, String codigo) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.codigo = codigo;
    }
}
