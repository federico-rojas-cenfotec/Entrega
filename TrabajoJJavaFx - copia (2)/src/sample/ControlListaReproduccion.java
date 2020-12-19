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

public class ControlListaReproduccion implements Initializable {
    @FXML private TextField idNombreLista;
    @FXML private TextField idcalificacionLista;
    @FXML private DatePicker idFechaCreacionLista;
    @FXML private CheckComboBox idlistaReproduccion;
    ControladorB unControladorB = new ControladorB();

    @FXML
    void registrar(ActionEvent event) {
        ControladorB unaListaReproduccion = new ControladorB();

        String nombreLista = idNombreLista.getText();
        LocalDate fechaCreacionLista = idFechaCreacionLista.getValue();
        int calificacionLista = Integer.parseInt(idcalificacionLista.getText());
        ObservableList list = idlistaReproduccion.getCheckModel().getCheckedItems();
        String nombreCanciones[]=new String[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
            nombreCanciones[i]= String.valueOf(list.get(i));
        }

        unControladorB.registrarListaReproduccion(nombreLista, fechaCreacionLista, calificacionLista);
        unControladorB.agregarCancionesLista(nombreCanciones, nombreLista);
    }

    public void regresarMenu(MouseEvent mouseEvent) {
        new ToScene().toScene("home.fxml", mouseEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < unControladorB.listarCancionesParaAlbumes().length; i++) {
            idlistaReproduccion.getItems().addAll(unControladorB.listarCancionesParaAlbumes()[i]);
        }
    }
}