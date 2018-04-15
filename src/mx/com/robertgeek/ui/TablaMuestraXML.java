package mx.com.robertgeek.ui;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mx.com.robertgeek.logic.ExtraccionDatosCFDI;

/**
 *
 * @author robert Tabla que muestra los datos de un CFDI
 */
public class TablaMuestraXML extends TableView<ExtraccionDatosCFDI> {

    private TableColumn titulo;
    private final TableColumn versionFactura;
    private final TableColumn nombre;
    private final TableColumn rfc;
    private final TableColumn fecha;
    private final TableColumn serie;
    private final TableColumn folio;
    private final TableColumn concepto;
    private final TableColumn tipoComprobante;
    private final TableColumn subtotal;
    private final TableColumn iva;
    private final TableColumn total;
    private final TableColumn moneda;

    //Constructor para la TABLA MUESTRA XML recibe un objeto estado, un objeto operaciones en base, una cadena que es el titulo de la tabla, Arreglo de imagenes para hacer que se pueda cambiar dinamicamente los headers.
    //Si se necesita agregar una columna más solo se debe de agregar un tableColumn y el setCellValueFactory llamarlo igual que como viene de la base.
    public TablaMuestraXML(ObservableList<ExtraccionDatosCFDI> data) {

        this.titulo = new TableColumn("Extracción de Información XML");

        versionFactura = new TableColumn("Version Factura");
        versionFactura.setCellValueFactory(new PropertyValueFactory<>("versionFactura"));

        nombre = new TableColumn("Nombre");
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombreEmisor"));

        rfc = new TableColumn("RFC");
        rfc.setCellValueFactory(new PropertyValueFactory<>("rfcEmisor"));

        fecha = new TableColumn("Fecha");
        fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        serie = new TableColumn("Serie");
        serie.setCellValueFactory(new PropertyValueFactory<>("serie"));

        folio = new TableColumn("Folio");
        folio.setCellValueFactory(new PropertyValueFactory<>("folio"));

        concepto = new TableColumn("Concepto");
        concepto.setCellValueFactory(new PropertyValueFactory<>("concepto"));

        tipoComprobante = new TableColumn("Tipo Comprobante");
        tipoComprobante.setCellValueFactory(new PropertyValueFactory<>("tipoDeComprobante"));

        subtotal = new TableColumn("Subtotal");
        subtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));

        iva = new TableColumn("IVA");
        iva.setCellValueFactory(new PropertyValueFactory<>("importeIVA"));

        total = new TableColumn("Total");
        total.setCellValueFactory(new PropertyValueFactory<>("total"));

        moneda = new TableColumn("Moneda");
        moneda.setCellValueFactory(new PropertyValueFactory<>("moneda"));

        this.titulo.getColumns().add(versionFactura);
        this.titulo.getColumns().add(nombre);
        this.titulo.getColumns().add(rfc);
        this.titulo.getColumns().add(fecha);
        this.titulo.getColumns().add(serie);
        this.titulo.getColumns().add(folio);
        this.titulo.getColumns().add(concepto);
        this.titulo.getColumns().add(tipoComprobante);
        this.titulo.getColumns().add(subtotal);
        this.titulo.getColumns().add(iva);
        this.titulo.getColumns().add(total);
        this.titulo.getColumns().add(moneda);
        super.getColumns().add(this.titulo);

        if (data.isEmpty()) {
            super.setPlaceholder(new Label("Aún no se ha extraido informacion de los XML"));
        }
        super.setItems(data);
    }

    /**
     * @return the titulo
     */
    public TableColumn getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(TableColumn titulo) {
        this.titulo = titulo;
    }
}
