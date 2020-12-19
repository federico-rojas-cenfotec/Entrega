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

public class ControlArtista implements Initializable {
    @FXML
    private TextField idArtistanombre;
    @FXML
    private TextField idapellido1;
    @FXML
    private TextField idpaisNacimiento;
    @FXML
    private TextField idnombreArtistico;
    @FXML
    private DatePicker fechaNacimientoArtista;
    @FXML
    private DatePicker fechaDefuncionArtista;
    @FXML
    private TextField descripcion;
    @FXML
    private CheckComboBox idlistarArtistas;
    ControladorB fourContraladorB = new ControladorB();

    @FXML
    void registro(ActionEvent event) {
        ControladorB unArtista = new ControladorB();

        String nombreArtista = idArtistanombre.getText();
        String apellidoArtista = idapellido1.getText();
        String paisNacimiento = idpaisNacimiento.getText();
        String nombreArtistico = idnombreArtistico.getText();
        String fechaNaciArtista = String.valueOf(fechaNacimientoArtista.getValue());
        String fechaDefArtista = String.valueOf(fechaDefuncionArtista.getValue());
        String descripcionArtista = descripcion.getText();

        unArtista.registrarArtista(nombreArtista, apellidoArtista, paisNacimiento, nombreArtistico, fechaNaciArtista, fechaDefArtista, descripcionArtista);
    }

    public void regresarMenu(MouseEvent mouseEvent) {
        new ToScene().toScene("home.fxml", mouseEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            for (int i = 0; i < fourContraladorB.listarArtistas().length; i++) {
                idlistarArtistas.getItems().addAll(fourContraladorB.listarArtistas()[i]);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
