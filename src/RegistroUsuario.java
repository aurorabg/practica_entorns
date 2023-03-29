public class RegistroUsuario {
    public static void main(String[] args) {
        ValidarCampos registro = new ValidarCampos("Carles_345", "carlescanals345@gmail.com", "Prova_99",
                "abcd1234");
        registro.validarCampos(registro);
    }
}
