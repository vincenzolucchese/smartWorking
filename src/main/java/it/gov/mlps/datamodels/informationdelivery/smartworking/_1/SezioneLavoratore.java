
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
 * <p>Java class for SezioneLavoratore complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SezioneLavoratore"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodiceFiscaleLavoratore" type="{http://mlps.gov.it/DataModels/InformationDelivery/SmartWorking/1.0}CodiceFiscale"/&gt;
 *         &lt;element name="NomeLavoratore" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="CognomeLavoratore" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="DataNascitaLavoratore" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="CodComuneNascitaLavoratore" type="{http://mlps.gov.it/DataModels/InformationDelivery/SmartWorking/1.0}CodiceComune"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SezioneLavoratore", propOrder = {
    "codiceFiscaleLavoratore",
    "nomeLavoratore",
    "cognomeLavoratore",
    "dataNascitaLavoratore",
    "codComuneNascitaLavoratore"
})
public class SezioneLavoratore
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "CodiceFiscaleLavoratore", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String codiceFiscaleLavoratore;
    @XmlElement(name = "NomeLavoratore", required = true)
    protected String nomeLavoratore;
    @XmlElement(name = "CognomeLavoratore", required = true)
    protected String cognomeLavoratore;
    @XmlElement(name = "DataNascitaLavoratore", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar dataNascitaLavoratore;
    @XmlElement(name = "CodComuneNascitaLavoratore", required = true)
    protected String codComuneNascitaLavoratore;

    /**
     * Gets the value of the codiceFiscaleLavoratore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscaleLavoratore() {
        return codiceFiscaleLavoratore;
    }

    /**
     * Sets the value of the codiceFiscaleLavoratore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscaleLavoratore(String value) {
        this.codiceFiscaleLavoratore = value;
    }

    /**
     * Gets the value of the nomeLavoratore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeLavoratore() {
        return nomeLavoratore;
    }

    /**
     * Sets the value of the nomeLavoratore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeLavoratore(String value) {
        this.nomeLavoratore = value;
    }

    /**
     * Gets the value of the cognomeLavoratore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCognomeLavoratore() {
        return cognomeLavoratore;
    }

    /**
     * Sets the value of the cognomeLavoratore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCognomeLavoratore(String value) {
        this.cognomeLavoratore = value;
    }

    /**
     * Gets the value of the dataNascitaLavoratore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getDataNascitaLavoratore() {
        return dataNascitaLavoratore;
    }

    /**
     * Sets the value of the dataNascitaLavoratore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataNascitaLavoratore(Calendar value) {
        this.dataNascitaLavoratore = value;
    }

    /**
     * Gets the value of the codComuneNascitaLavoratore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodComuneNascitaLavoratore() {
        return codComuneNascitaLavoratore;
    }

    /**
     * Sets the value of the codComuneNascitaLavoratore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodComuneNascitaLavoratore(String value) {
        this.codComuneNascitaLavoratore = value;
    }

}
