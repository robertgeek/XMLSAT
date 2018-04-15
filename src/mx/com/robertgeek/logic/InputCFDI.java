package mx.com.robertgeek.logic;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mx.com.robertgeek.ui.Mensajes;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author robert
 */
public class InputCFDI {

    //Objeto de para guardar los datos del XML
    public ExtraccionDatosCFDI exdat;
    private String fecha;
    private String moneda;
    private String serie;
    private String folio;
    private String versionFactura;
    private String tipoComprobante;
    private String subtotal;
    private String total;
    private String nombre;
    private String rfc;
    private final StringBuilder conceptoString = new StringBuilder();
    private String impuestosTrasladados;

    /**
     * Metodo que se recibe un CFDI.xml para poder extraer datos de un CFDI XML
     *
     * @param path
     * @return
     */
    public ExtraccionDatosCFDI xmlCDFI(String path) {
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                @Override
                public void startElement(String uri, String localName, String tagName,
                        Attributes attributes) throws SAXException {

                    if (tagName.equalsIgnoreCase("cfdi:Comprobante")) {
                        for (int i = 0; i < attributes.getLength(); i++) {
                            switch (attributes.getQName(i).toLowerCase()) {
                                case "fecha":
                                    fecha = attributes.getValue(i);
                                    break;
                                case "serie":
                                    serie = attributes.getValue(i);
                                    break;
                                case "folio":
                                    folio = attributes.getValue(i);
                                    break;
                                case "version":
                                    versionFactura = attributes.getValue(i);
                                    break;
                                case "tipodecomprobante":
                                    tipoComprobante = attributes.getValue(i);
                                    break;
                                case "subtotal":
                                    subtotal = attributes.getValue(i);
                                    break;
                                case "total":
                                    total = attributes.getValue(i);
                                    break;
                                case "moneda":
                                    moneda = attributes.getValue(i);
                                    break;
                            }
                        }
                    }

                    if (tagName.equalsIgnoreCase("cfdi:Emisor")) {

                        for (int i = 0; i < attributes.getLength(); i++) {
                            switch (attributes.getQName(i).toLowerCase()) {
                                case "rfc":
                                    rfc = attributes.getValue(i);
                                    break;
                                case "nombre":
                                    nombre = attributes.getValue(i);
                                    break;
                            }
                        }
                    }

                    if (tagName.equalsIgnoreCase("cfdi:Concepto")) {
                        for (int i = 0; i < attributes.getLength(); i++) {
                            if (attributes.getQName(i).equalsIgnoreCase("descripcion")) {
                                conceptoString.append(attributes.getValue(i))
                                        .append("-PrecioUnitario ");

                            }
                            if (attributes.getQName(i).equalsIgnoreCase("importe")) {
                                conceptoString.append(attributes.getValue(i))
                                        .append(" ");
                            }
                        }
                    }

                    if (tagName.equalsIgnoreCase("cfdi:Impuestos")) {
                        for (int i = 0; i < attributes.getLength(); i++) {
                            if (attributes.getQName(i).equalsIgnoreCase("totalImpuestosTrasladados")) {
                                impuestosTrasladados = attributes.getValue(i);
                            }

                        }
                    }
                }

                @Override
                public void endElement(String uri, String localName,
                        String qName) throws SAXException {
                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                }
            };

            saxParser.parse(path, handler);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            Mensajes m = new Mensajes();
            m.muestraError("Error", e.getMessage());
        }

        exdat = new ExtraccionDatosCFDI(
                nombre,
                rfc,
                fecha,
                serie,
                folio,
                conceptoString.toString(),
                tipoComprobante,
                subtotal,
                impuestosTrasladados,
                total,
                versionFactura,
                moneda);
        nombre = "";
        rfc = "";
        fecha = "";
        serie = "";
        folio = "";
        tipoComprobante = "";
        subtotal = "";
        impuestosTrasladados = "";
        total = "";
        versionFactura = "";
        conceptoString.setLength(0);
        moneda = "";
        return exdat;
    }

}
