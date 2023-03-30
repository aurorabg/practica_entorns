package registro;

public class RegistroUsuario {
    public static void main(String[] args) {
        RegistroUsuario r = new RegistroUsuario();

        /* Creamos un objeto registro.ValidarCampos */
        ValidarCampos registro = new ValidarCampos("Carles_345", "carlescanals345@gmail.com", "Prova_99",
                "abcd1234");
        /** Llamamos al método init */
        r.init(registro);
    }

    /**
     * Método init para llamar a los métodos de la clase registro.ValidarCampos
     * @param registro
     */
    public void init(ValidarCampos registro) {
        /** llamamos al método validarCampos */
        registro.validarCampos(registro);
    }
}
