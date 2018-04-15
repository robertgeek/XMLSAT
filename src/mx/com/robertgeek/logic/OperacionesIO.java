package mx.com.robertgeek.logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mx.com.robertgeek.ui.Mensajes;

/**
 *
 * @author robert
 */
public class OperacionesIO {

    //Objeto Observable list que sirve para mostrar datos como filas en la TablaMuestraXML
    private ObservableList<ExtraccionDatosCFDI> datosCFDI = FXCollections.observableArrayList();

    //Objeto que descompone los archivos que vienen del JFileChooser
    private InputCFDI inCFDI;

    Mensajes m = new Mensajes();

    public void procesaOperacionesIO() {
        datosCFDI.clear();
        //JFilechooser obtiene el path de los archivos.
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Archivos XML (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        //Lista que guarda los archivos adjuntados del File Chooser
        List<File> files = fileChooser.showOpenMultipleDialog(new Stage());
        if (files != null) {
            inCFDI = new InputCFDI();
            //Para cada file que esta en la lista files se extrae su path para procesarlo en el inCFDI
            files.stream().forEach((file) -> {

                datosCFDI.add(inCFDI.xmlCDFI(file.toString()));
            });
        }
    }

    public void exportandoCSV(ObservableList<ExtraccionDatosCFDI> XMLtoCSV) {

        //Verifica que tenga datos el Observable List
        if (XMLtoCSV.isEmpty()) {

            m.muestraError("No hay datos para exportar", "Cargue primero los XML");
        } else {
            //Se usa la clase writer para escribir en el archivo
            Writer writerCSV = null;
            try {
                //Usamos un JFileChooser para ver donde se exportara el archivo CSV
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Archivos CSV (*.csv)", "*.csv");
                fileChooser.getExtensionFilters().add(extFilter);

                //Salvamos el archivo con el metodo showSaveDialog
                File file = fileChooser.showSaveDialog(new Stage());
                if (file != null) {
                    writerCSV = new BufferedWriter(new FileWriter(file));
                    //Escribo primero el header del archivo para saber a que corresponde cada columna.
                    String header = "VersionFactura;Nombre;RFC;Fecha;Serie;Folio;Concepto;TipoDeComprobante;Subtotal;IVA;Total;Moneda\n";
                    writerCSV.write(header);
                    //Extraemos los datos de cada fila en la tabla.
                    for (ExtraccionDatosCFDI cfdi : XMLtoCSV) {
                        String text = String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",cfdi.getVersionFactura(),
                                cfdi.getNombreEmisor(), cfdi.getRfcEmisor(), cfdi.getFecha(),
                                cfdi.getSerie(), cfdi.getFolio(),
                                cfdi.getConcepto(), cfdi.getTipoDeComprobante(), cfdi.getSubtotal(),
                                cfdi.getImporteIVA(), cfdi.getTotal(),cfdi.getMoneda());
                        //Escribimos los datos en el archivo.
                        writerCSV.write(text);
                    }

                }
            } catch (IOException ex) {
                m.muestraError("Error al exportar a CSV", ex.getMessage());
            } finally {
                try {

                    if (writerCSV != null) {
                        writerCSV.flush();
                        writerCSV.close();
                        m.muestraMensaje("Conversión Exítosa", "El archivo ha sido exportado exitosamente", "");
                    }

                } catch (IOException e) {
                    m.muestraError("Error al escribir archivo", e.getMessage());
                }
            }
        }
    }

    /**
     * @return the datosCFDI
     */
    public ObservableList<ExtraccionDatosCFDI> getDatosCFDI() {
        return datosCFDI;
    }

    /**
     * @param datosCFDI the datosCFDI to set
     */
    public void setDatosCFDI(ObservableList<ExtraccionDatosCFDI> datosCFDI) {
        this.datosCFDI = datosCFDI;
    }
}
