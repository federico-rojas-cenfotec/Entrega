package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.CheckComboBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControlCompositor implements Initializable {
    @FXML
    private TextField idnombre;
    @FXML
    private TextField idapellido1;
    @FXML
    private TextField idpaisNacimiento;
    @FXML
    private TextField idedad;
    @FXML private CheckComboBox idlistarCompositores;
    ControladorB fiveContraladorB = new ControladorB();

    @FXML
    void registro(ActionEvent event) {
        ControladorB unCompositor = new ControladorB();

        String nombreCompositor = idnombre.getText();
        String apellido = idapellido1.getText();
        String paisNacimiento = idpaisNacimiento.getText();
        int edadCompositor = Integer.parseInt(idedad.getText());

        unCompositor.registrarCompositor(nombreCompositor, apellido, paisNacimiento, edadCompositor);
    }

    public void regresarMenu(MouseEvent mouseEvent) {
        new ToScene().toScene("home.fxml", mouseEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            for (int i = 0; i < fiveContraladorB.listarCompositores().length; i++) {
                idlistarCompositores.getItems().addAll(fiveContraladorB.listarCompositores()[i]);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
