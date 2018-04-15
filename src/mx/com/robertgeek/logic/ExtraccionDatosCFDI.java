package mx.com.robertgeek.logic;

/**
 *
 * @author robert Pojo de Datos para mostrar los datos en la tabla
 */
public class ExtraccionDatosCFDI {

    private String nombreEmisor;
    private String rfcEmisor;
    private String fecha;
    private String serie;
    private String folio;
    private String concepto;
    private String tipoDeComprobante;
    private String subtotal;
    private String importeIVA;
    private String total;
    private String versionFactura;
    private String moneda;

    public ExtraccionDatosCFDI(String nombreEmisor, String rfcEmisor, String fecha, String serie, String folio, String concepto, String tipoDeComprobante, String subtotal, String importeIVA, String total, String versionFactura, String moneda) {
        this.nombreEmisor = nombreEmisor;
        this.rfcEmisor = rfcEmisor;
        this.fecha = fecha;
        this.serie = serie;
        this.folio = folio;
        this.concepto = concepto;
        this.tipoDeComprobante = tipoDeComprobante;
        this.subtotal = subtotal;
        this.importeIVA = importeIVA;
        this.total = total;
        this.versionFactura = versionFactura;
        this.moneda = moneda;
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }

    public String getRfcEmisor() {
        return rfcEmisor;
    }

    public void setRfcEmisor(String rfcEmisor) {
        this.rfcEmisor = rfcEmisor;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getImporteIVA() {
        return importeIVA;
    }

    public void setImporteIVA(String importeIVA) {
        this.importeIVA = importeIVA;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @return the tipoDeComprobante
     */
    public String getTipoDeComprobante() {
        return tipoDeComprobante;
    }

    /**
     * @param tipoDeComprobante the tipoDeComprobante to set
     */
    public void setTipoDeComprobante(String tipoDeComprobante) {
        this.tipoDeComprobante = tipoDeComprobante;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the versionFactura
     */
    public String getVersionFactura() {
        return versionFactura;
    }

    /**
     * @param versionFactura
     */
    public void setVersionFactura(String versionFactura) {
        this.versionFactura = versionFactura;
    }

    /**
     * @return the moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}
