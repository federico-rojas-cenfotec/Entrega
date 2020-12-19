package sample;

import javafx.scene.input.MouseEvent;

public class ControlHome {

    /*public void registrarListar(MouseEvent mouseEvent) {

    }*/

    public void crearLista(MouseEvent mouseEvent) {
        new ToScene().toScene("registroListaReproduccion.fxml", mouseEvent);
    }

    public void registrarCompositor(MouseEvent mouseEvent) {
        new ToScene().toScene("registroCompositor.fxml", mouseEvent);
    }

    public void registrarArtista(MouseEvent mouseEvent) {
        new ToScene().toScene("registroArtista.fxml", mouseEvent);
    }

    public void registrarCancion(MouseEvent mouseEvent) {
        new ToScene().toScene("registroCancion.fxml", mouseEvent);
    }

    public void registrarAlbum(MouseEvent mouseEvent) {
        new ToScene().toScene("registroAlbum.fxml", mouseEvent);
    }

    public void registrarGenero(MouseEvent mouseEvent) {
        new ToScene().toScene("registroGenero.fxml", mouseEvent);
    }

    public void salir(MouseEvent mouseEvent) {
        new ToScene().toScene("sample.fxml", mouseEvent);
    }
}
