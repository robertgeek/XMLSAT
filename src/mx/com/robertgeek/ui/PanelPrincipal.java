package mx.com.robertgeek.ui;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import mx.com.robertgeek.logic.OperacionesIO;

/**
 *
 * @author robert
 */
public class PanelPrincipal extends VBox {

    //Botones para interatuar con la intefaz grafica.
    private final Button seleccionaXML;
    private final Button exportar;
    
    //Tabla que muestra los datos exportados del CFDI
    private final TablaMuestraXML tabla;
    
    //Operaciones de I/O
    private OperacionesIO opIO;

    public PanelPrincipal() {
        super(15);
        super.setPadding(new Insets(20, 28, 20, 30));
        opIO = new OperacionesIO();

        seleccionaXML = new Button("Selecciona XML's");
        seleccionaXML.setStyle("-fx-background-radius: 25px;");

        exportar = new Button("Exportar a CSV");
        exportar.setStyle("-fx-background-radius: 25px;");
        
        tabla = new TablaMuestraXML(opIO.getDatosCFDI());
        tabla.setStyle("fx-margin-left:-120px;");

        seleccionaXML.setOnAction((final ActionEvent e) -> {
            opIO.procesaOperacionesIO();
        });

        exportar.setOnAction((final ActionEvent e) -> {
            opIO.exportandoCSV(opIO.getDatosCFDI());
        });
        super.getChildren().addAll(seleccionaXML, tabla, exportar);
        super.setStyle("-fx-background-color: #353434");
        
    }
}
