
package it.gov.mlps.datamodels.informationdelivery.smartworking._1;

import java.io.Serializable;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for SezioneAccordoSmartWorking complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SezioneAccordoSmartWorking"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DataSottoscrizioneAccordo" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="DataInizioPeriodo" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="DataFinePeriodo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="TipologiaDurataPeriodo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="StreamPDF" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SezioneAccordoSmartWorking", propOrder = {
    "dataSottoscrizioneAccordo",
    "dataInizioPeriodo",
    "dataFinePeriodo",
    "tipologiaDurataPeriodo",
    "streamPDF"
})
public class SezioneAccordoSmartWorking
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "DataSottoscrizioneAccordo", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar dataSottoscrizioneAccordo;
    @XmlElement(name = "DataInizioPeriodo", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar dataInizioPeriodo;
    @XmlElement(name = "DataFinePeriodo", type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar dataFinePeriodo;
    @XmlElement(name = "TipologiaDurataPeriodo", required = true)
    protected String tipologiaDurataPeriodo;
    @XmlElement(name = "StreamPDF", required = true)
    protected byte[] streamPDF;

    /**
     * Gets the value of the dataSottoscrizioneAccordo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getDataSottoscrizioneAccordo() {
        return dataSottoscrizioneAccordo;
    }

    /**
     * Sets the value of the dataSottoscrizioneAccordo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataSottoscrizioneAccordo(Calendar value) {
        this.dataSottoscrizioneAccordo = value;
    }

    /**
     * Gets the value of the dataInizioPeriodo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getDataInizioPeriodo() {
        return dataInizioPeriodo;
    }

    /**
     * Sets the value of the dataInizioPeriodo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioPeriodo(Calendar value) {
        this.dataInizioPeriodo = value;
    }

    /**
     * Gets the value of the dataFinePeriodo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getDataFinePeriodo() {
        return dataFinePeriodo;
    }

    /**
     * Sets the value of the dataFinePeriodo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFinePeriodo(Calendar value) {
        this.dataFinePeriodo = value;
    }

    /**
     * Gets the value of the tipologiaDurataPeriodo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipologiaDurataPeriodo() {
        return tipologiaDurataPeriodo;
    }

    /**
     * Sets the value of the tipologiaDurataPeriodo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipologiaDurataPeriodo(String value) {
        this.tipologiaDurataPeriodo = value;
    }

    /**
     * Gets the value of the streamPDF property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getStreamPDF() {
        return streamPDF;
    }

    /**
     * Sets the value of the streamPDF property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setStreamPDF(byte[] value) {
        this.streamPDF = value;
    }

}
