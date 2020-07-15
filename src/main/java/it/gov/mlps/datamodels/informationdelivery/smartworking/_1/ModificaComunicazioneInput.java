
package it.gov.mlps.datamodels.informationdelivery.smartworking._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ModificaComunicazione_Input complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModificaComunicazione_Input"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodiceComunicazione" type="{http://mlps.gov.it/DataModels/InformationDelivery/SmartWorking/1.0}CodiceComunicazione"/&gt;
 *         &lt;element name="SezioneRapportoLavoro" type="{http://mlps.gov.it/DataModels/InformationDelivery/SmartWorking/1.0}SezioneRapportoLavoro_Modifica"/&gt;
 *         &lt;element name="SezioneAccordoSmartWorking" type="{http://mlps.gov.it/DataModels/InformationDelivery/SmartWorking/1.0}SezioneAccordoSmartWorking_Input"/&gt;
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
@XmlType(name = "ModificaComunicazione_Input", propOrder = {
    "codiceComunicazione",
    "sezioneRapportoLavoro",
    "sezioneAccordoSmartWorking",
    "sezioneSoggettoAbilitato",
    "codTipologiaComunicazione"
})
@XmlRootElement(name = "ModificaComunicazione_Input")
public class ModificaComunicazioneInput
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "CodiceComunicazione", required = true)
    protected String codiceComunicazione;
    @XmlElement(name = "SezioneRapportoLavoro", required = true)
    protected SezioneRapportoLavoroModifica sezioneRapportoLavoro;
    @XmlElement(name = "SezioneAccordoSmartWorking", required = true)
    protected SezioneAccordoSmartWorkingInput sezioneAccordoSmartWorking;
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
     * Gets the value of the sezioneRapportoLavoro property.
     * 
     * @return
     *     possible object is
     *     {@link SezioneRapportoLavoroModifica }
     *     
     */
    public SezioneRapportoLavoroModifica getSezioneRapportoLavoro() {
        return sezioneRapportoLavoro;
    }

    /**
     * Sets the value of the sezioneRapportoLavoro property.
     * 
     * @param value
     *     allowed object is
     *     {@link SezioneRapportoLavoroModifica }
     *     
     */
    public void setSezioneRapportoLavoro(SezioneRapportoLavoroModifica value) {
        this.sezioneRapportoLavoro = value;
    }

    /**
     * Gets the value of the sezioneAccordoSmartWorking property.
     * 
     * @return
     *     possible object is
     *     {@link SezioneAccordoSmartWorkingInput }
     *     
     */
    public SezioneAccordoSmartWorkingInput getSezioneAccordoSmartWorking() {
        return sezioneAccordoSmartWorking;
    }

    /**
     * Sets the value of the sezioneAccordoSmartWorking property.
     * 
     * @param value
     *     allowed object is
     *     {@link SezioneAccordoSmartWorkingInput }
     *     
     */
    public void setSezioneAccordoSmartWorking(SezioneAccordoSmartWorkingInput value) {
        this.sezioneAccordoSmartWorking = value;
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
