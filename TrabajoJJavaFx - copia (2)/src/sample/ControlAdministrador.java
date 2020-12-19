package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.commons.mail.EmailException;

import java.sql.SQLException;

public class ControlAdministrador {
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
    void registro(ActionEvent event) {
        ControladorB admin = new ControladorB();

        String nombreAdm = idnombre.getText();
        String apellido1Adm = idapellido1.getText();
        String apellido2Adm = idapellido2.getText();
        String avatarAdm = idavatar.getText();
        String emailAdm = correo.getText();
        String claveAdm = contrasenna.getText();

        try {
            admin.crearAdministrador(nombreAdm,apellido1Adm,apellido2Adm,avatarAdm,emailAdm,claveAdm);
        } catch (EmailException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
