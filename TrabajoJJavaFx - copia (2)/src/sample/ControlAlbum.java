package sample;

import javafx.collections.ObservableList;
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

public class ControlAlbum implements Initializable {
    @FXML private TextField idNombreAlbum;
    @FXML private DatePicker idfechaLanzamiento;
    @FXML private TextField idimagenAlbum;
    @FXML private CheckComboBox listaCancionesAlbum;

    ControladorB unControladorB = new ControladorB();

    @FXML
    void registrar(ActionEvent event) {
        ControladorB unAlbum = new ControladorB();

        String nombreAlbum = idNombreAlbum.getText();
        LocalDate fechaLanzamiento = idfechaLanzamiento.getValue();
        String imagenAlbum = idimagenAlbum.getText();
        ObservableList list = listaCancionesAlbum.getCheckModel().getCheckedItems();
        String nombreCanciones[]=new String[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
            nombreCanciones[i]= String.valueOf(list.get(i));
        }

        unControladorB.registrarAlbum(nombreAlbum, fechaLanzamiento, imagenAlbum);
        unControladorB.agregarCancionesAlbum(nombreCanciones, nombreAlbum);
    }

    public void regresarMenu(MouseEvent mouseEvent) {
        new ToScene().toScene("home.fxml", mouseEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < unControladorB.listarCancionesParaAlbumes().length; i++) {
            listaCancionesAlbum.getItems().addAll(unControladorB.listarCancionesParaAlbumes()[i]);
        }
    }

    /*@Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < unControladorB.listarCancionesParaAlbumes().length; i++) {
                listaCancionesAlbum1.getItems().addAll(dosControladorB.listarCancionesParaAlbumes()[i]);
            }
    }*/
}
