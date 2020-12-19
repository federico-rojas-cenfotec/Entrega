package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.CheckComboBox;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControlCancion implements Initializable {
    @FXML
    private TextField idNombreCancion;
    @FXML
    private TextField idsubirCancion;
    @FXML
    private DatePicker idFechaLanzamiento;
    @FXML
    private CheckComboBox idenlistarCanciones;
    ControladorB dosContraladorB = new ControladorB();

    @FXML
    void registrar(ActionEvent event) {
        ControladorB unaCancion = new ControladorB();

        String nombreCancion = idNombreCancion.getText();
        LocalDate fechalanzamiento = idFechaLanzamiento.getValue();
        String subaCancion = idsubirCancion.getText();

        unaCancion.agregarCanciones(nombreCancion, fechalanzamiento, subaCancion);
    }

    public void regresarMenu(MouseEvent mouseEvent) {
        new ToScene().toScene("home.fxml", mouseEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       for (int i = 0; i < dosContraladorB.listarCancionesSubidas().length; i++) {
            idenlistarCanciones.getItems().addAll(dosContraladorB.listarCancionesSubidas()[i]);
       }

    }
}
