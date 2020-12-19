package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.apache.commons.mail.EmailException;

import java.time.LocalDate;

public class ControlUsuarioFinal {

    @FXML
    private TextField idnombre;

    @FXML
    private TextField idapellido1;

    @FXML
    private TextField idapellido2;

    @FXML
    private TextField idavatar;

    @FXML
    private TextField correo;

    @FXML
    private TextField contrasenna;

    @FXML
    private DatePicker fechaNac;

    @FXML
    private TextField pais;

    @FXML
    private TextField numeroIdentificacion;

    @FXML
    void registro(ActionEvent event) {
        ControladorB uno = new ControladorB();

        String nombreUsuario = idnombre.getText();
        String apellido1 = idapellido1.getText();
        String apellido2 = idapellido2.getText();
        String avatar = idavatar.getText();
        String email = correo.getText();
        String clave = contrasenna.getText();
        LocalDate fechaNacido = fechaNac.getValue();
        String nombrePais = pais.getText();
        String cedula = numeroIdentificacion.getText();

        try {
            uno.crearUsuarioFinal(nombreUsuario, apellido1, apellido2, avatar, email, clave, fechaNacido, nombrePais, cedula);
        } catch (EmailException e) {
            e.printStackTrace();
        }
        new ToScene().toScene("sample.fxml",event);
    }
}
