
package it.gov.mlps.datamodels.informationdelivery.smartworking._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SezioneDatoreLavoro complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SezioneDatoreLavoro"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodiceFiscaleDatoreLavoro" type="{http://mlps.gov.it/DataModels/InformationDelivery/SmartWorking/1.0}CodiceFiscale"/&gt;
 *         &lt;element name="DenominazioneDatoreLavoro" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SezioneDatoreLavoro", propOrder = {
    "codiceFiscaleDatoreLavoro",
    "denominazioneDatoreLavoro"
})
public class SezioneDatoreLavoro
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "CodiceFiscaleDatoreLavoro", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String codiceFiscaleDatoreLavoro;
    @XmlElement(name = "DenominazioneDatoreLavoro", required = true)
    protected String denominazioneDatoreLavoro;

    /**
     * Gets the value of the codiceFiscaleDatoreLavoro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscaleDatoreLavoro() {
        return codiceFiscaleDatoreLavoro;
    }

    /**
     * Sets the value of the codiceFiscaleDatoreLavoro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscaleDatoreLavoro(String value) {
        this.codiceFiscaleDatoreLavoro = value;
    }

    /**
     * Gets the value of the denominazioneDatoreLavoro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneDatoreLavoro() {
        return denominazioneDatoreLavoro;
    }

    /**
     * Sets the value of the denominazioneDatoreLavoro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneDatoreLavoro(String value) {
        this.denominazioneDatoreLavoro = value;
    }

}
