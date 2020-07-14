
package it.gov.mlps.datamodels.informationdelivery.smartworking;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AnnullaComunicazione_Input complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnnullaComunicazione_Input"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodiceComunicazione" type="{http://mlps.gov.it/DataModels/InformationDelivery/SmartWorking/1.0}CodiceComunicazione"/&gt;
 *         &lt;element name="SezioneSoggettoAbilitato" type="{http://mlps.gov.it/DataModels/InformationDelivery/SmartWorking/1.0}SezioneSoggettoAbilitato_Input" minOccurs="0"/&gt;
 *         &lt;element name="CodTipologiaComunicazione" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnnullaComunicazione_Input", propOrder = {
    "codiceComunicazione",
    "sezioneSoggettoAbilitato",
    "codTipologiaComunicazione"
})
@XmlRootElement(name = "AnnullaComunicazione_Input")
public class AnnullaComunicazioneInput
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "CodiceComunicazione", required = true)
    protected String codiceComunicazione;
    @XmlElement(name = "SezioneSoggettoAbilitato")
    protected SezioneSoggettoAbilitatoInput sezioneSoggettoAbilitato;
    @XmlElement(name = "CodTipologiaComunicazione", required = true)
    protected String codTipologiaComunicazione;

    /**
     * Gets the value of the codiceComunicazione property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceComunicazione() {
        return codiceComunicazione;
    }

    /**
     * Sets the value of the codiceComunicazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceComunicazione(String value) {
        this.codiceComunicazione = value;
    }

    /**
     * Gets the value of the sezioneSoggettoAbilitato property.
     * 
     * @return
     *     possible object is
     *     {@link SezioneSoggettoAbilitatoInput }
     *     
     */
    public SezioneSoggettoAbilitatoInput getSezioneSoggettoAbilitato() {
        return sezioneSoggettoAbilitato;
    }

    /**
     * Sets the value of the sezioneSoggettoAbilitato property.
     * 
     * @param value
     *     allowed object is
     *     {@link SezioneSoggettoAbilitatoInput }
     *     
     */
    public void setSezioneSoggettoAbilitato(SezioneSoggettoAbilitatoInput value) {
        this.sezioneSoggettoAbilitato = value;
    }

    /**
     * Gets the value of the codTipologiaComunicazione property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipologiaComunicazione() {
        return codTipologiaComunicazione;
    }

    /**
     * Sets the value of the codTipologiaComunicazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipologiaComunicazione(String value) {
        this.codTipologiaComunicazione = value;
    }

}
