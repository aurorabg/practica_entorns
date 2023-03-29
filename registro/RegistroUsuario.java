package registro;

public class RegistroUsuario {
    public static void main(String[] args) {
        RegistroUsuario r = new RegistroUsuario();
        ValidarCampos registro = new ValidarCampos("Carles_345", "carlescanals345@gmail.com", "Prova_99",
                "abcd1234");

        r.init(registro);
    }

    public void init(ValidarCampos registro) {
        registro.validarCampos(registro);
    }
}
