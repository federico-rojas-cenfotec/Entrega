package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    public void Registrar(ActionEvent actionEvent) {
        new ToScene().toScene("registroUsuarioFinal.fxml", actionEvent);
    }

    @FXML private TextField nombreUsuario;
    @FXML private TextField contrasenna;
    @FXML private Label idError;
    //@FXML private JFXPasswordField idpasswordUsuario;

    private ControladorB unControlador = new ControladorB();

    public void InicioSesion(ActionEvent event) {
        String userName = nombreUsuario.getText();//username es para traerse lo que el usuario digito
        String password = contrasenna.getText();


        int resultado = unControlador.iniciarSesion(userName, password);
        System.out.println(resultado);

        if (resultado == 0){
            new ToScene().toScene("home.fxml", event);//event en el caso de la escena home. Y si se pone aqui event en el parametro del metod se poe event. O cuando se pone actionEvent aqui se pone tambien actionEvent
        }else{
            idError.setText("Credenciales no válidas");
        }
    }
}
