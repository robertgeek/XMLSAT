package mx.com.robertgeek.ui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Contiene métodos para mostrar mensajes(Dialogs) al usuario.
 *
 * @author Miguel Mendoza.
 * @version Octubre 2014.
 */
public class Mensajes {
    
    //Mensajes para mostrar en ventanas.

    /**
     * Muestra un Dialog con cierto mensaje de error.
     *
     * @param msj1 El primer mensaje.
     * @param msj2 El segundo mensaje.
     */
    public void muestraError(String msj1, String msj2) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(msj1);
        alert.setContentText(msj2);
        alert.showAndWait();
    }

    /**
     * Muestra un Dialog con cierto mensaje de advertencia.
     *
     * @param msj1 El primer mensaje.
     * @param msj2 El segundo mensaje.
     */
    public void muestraAdvertencia(String msj1, String msj2) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("ADVERTENCIA");
        alert.setHeaderText(msj1);
        alert.setContentText(msj2);
        alert.showAndWait();
    }

    /**
     * Muestra un Dialog con un mensaje.
     *
     * @param title El título del Dialog.
     * @param msj1 El primer mensaje.
     * @param msj2 El segundo mensaje.
     */
    public void muestraMensaje(String title, String msj1, String msj2) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(msj1);
        alert.setContentText(msj2);
        alert.showAndWait();
    }
}
