package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.CheckComboBox;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControlGenero implements Initializable {
    @FXML private TextField idNombreGenero;
    @FXML private TextField idDescripcion;
    @FXML private CheckComboBox idlistarGeneros;
    ControladorB tresContraladorB = new ControladorB();

    @FXML
    void registrar(ActionEvent event) {
        ControladorB unGenero = new ControladorB();

        String nombreGeneroCancion = idNombreGenero.getText();
        String descripcionGeneroCancion = idDescripcion.getText();

        unGenero.registrarGeneroMusical(nombreGeneroCancion, descripcionGeneroCancion);
    }

    public void regresarMenu(MouseEvent mouseEvent) {
        new ToScene().toScene("home.fxml",mouseEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < tresContraladorB.listarGeneros().length; i++) {
            idlistarGeneros.getItems().addAll(tresContraladorB.listarGeneros()[i]);
        }
    }
}