
package it.gov.mlps.datamodels.informationdelivery.smartworking._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SezioneSoggettoAbilitato_Input complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SezioneSoggettoAbilitato_Input"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodTipologiaSoggettoAbilitato" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="CodiceFiscaleSoggettoAbilitato" type="{http://mlps.gov.it/DataModels/InformationDelivery/SmartWorking/1.0}CodiceFiscale" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SezioneSoggettoAbilitato_Input", propOrder = {
    "codTipologiaSoggettoAbilitato",
    "codiceFiscaleSoggettoAbilitato"
})
public class SezioneSoggettoAbilitatoInput
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "CodTipologiaSoggettoAbilitato", required = true)
    protected String codTipologiaSoggettoAbilitato;
    @XmlElement(name = "CodiceFiscaleSoggettoAbilitato")
    @XmlSchemaType(name = "anySimpleType")
    protected String codiceFiscaleSoggettoAbilitato;

    /**
     * Gets the value of the codTipologiaSoggettoAbilitato property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipologiaSoggettoAbilitato() {
        return codTipologiaSoggettoAbilitato;
    }

    /**
     * Sets the value of the codTipologiaSoggettoAbilitato property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipologiaSoggettoAbilitato(String value) {
        this.codTipologiaSoggettoAbilitato = value;
    }

    /**
     * Gets the value of the codiceFiscaleSoggettoAbilitato property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscaleSoggettoAbilitato() {
        return codiceFiscaleSoggettoAbilitato;
    }

    /**
     * Sets the value of the codiceFiscaleSoggettoAbilitato property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscaleSoggettoAbilitato(String value) {
        this.codiceFiscaleSoggettoAbilitato = value;
    }

}
