
package it.gov.mlps.datamodels.informationdelivery.smartworking._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreaComunicazione_Input complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreaComunicazione_Input"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SezioneDatoreLavoro" type="{http://mlps.gov.it/DataModels/InformationDelivery/SmartWorking/1.0}SezioneDatoreLavoro"/&gt;
 *         &lt;element name="SezioneLavoratore" type="{http://mlps.gov.it/DataModels/InformationDelivery/SmartWorking/1.0}SezioneLavoratore"/&gt;
 *         &lt;element name="SezioneRapportoLavoro" type="{http://mlps.gov.it/DataModels/InformationDelivery/SmartWorking/1.0}SezioneRapportoLavoro_Crea"/&gt;
 *         &lt;element name="SezioneAccordoSmartWorking" type="{http://mlps.gov.it/DataModels/InformationDelivery/SmartWorking/1.0}SezioneAccordoSmartWorking"/&gt;
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
@XmlType(name = "CreaComunicazione_Input", propOrder = {
    "sezioneDatoreLavoro",
    "sezioneLavoratore",
    "sezioneRapportoLavoro",
    "sezioneAccordoSmartWorking",
    "sezioneSoggettoAbilitato",
    "codTipologiaComunicazione"
})
@XmlRootElement(name = "CreaComunicazione_Input")
public class CreaComunicazioneInput
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "SezioneDatoreLavoro", required = true)
    protected SezioneDatoreLavoro sezioneDatoreLavoro;
    @XmlElement(name = "SezioneLavoratore", required = true)
    protected SezioneLavoratore sezioneLavoratore;
    @XmlElement(name = "SezioneRapportoLavoro", required = true)
    protected SezioneRapportoLavoroCrea sezioneRapportoLavoro;
    @XmlElement(name = "SezioneAccordoSmartWorking", required = true)
    protected SezioneAccordoSmartWorking sezioneAccordoSmartWorking;
    @XmlElement(name = "SezioneSoggettoAbilitato")
    protected SezioneSoggettoAbilitatoInput sezioneSoggettoAbilitato;
    @XmlElement(name = "CodTipologiaComunicazione", required = true)
    protected String codTipologiaComunicazione;

    /**
     * Gets the value of the sezioneDatoreLavoro property.
     * 
     * @return
     *     possible object is
     *     {@link SezioneDatoreLavoro }
     *     
     */
    public SezioneDatoreLavoro getSezioneDatoreLavoro() {
        return sezioneDatoreLavoro;
    }

    /**
     * Sets the value of the sezioneDatoreLavoro property.
     * 
     * @param value
     *     allowed object is
     *     {@link SezioneDatoreLavoro }
     *     
     */
    public void setSezioneDatoreLavoro(SezioneDatoreLavoro value) {
        this.sezioneDatoreLavoro = value;
    }

    /**
     * Gets the value of the sezioneLavoratore property.
     * 
     * @return
     *     possible object is
     *     {@link SezioneLavoratore }
     *     
     */
    public SezioneLavoratore getSezioneLavoratore() {
        return sezioneLavoratore;
    }

    /**
     * Sets the value of the sezioneLavoratore property.
     * 
     * @param value
     *     allowed object is
     *     {@link SezioneLavoratore }
     *     
     */
    public void setSezioneLavoratore(SezioneLavoratore value) {
        this.sezioneLavoratore = value;
    }

    /**
     * Gets the value of the sezioneRapportoLavoro property.
     * 
     * @return
     *     possible object is
     *     {@link SezioneRapportoLavoroCrea }
     *     
     */
    public SezioneRapportoLavoroCrea getSezioneRapportoLavoro() {
        return sezioneRapportoLavoro;
    }

    /**
     * Sets the value of the sezioneRapportoLavoro property.
     * 
     * @param value
     *     allowed object is
     *     {@link SezioneRapportoLavoroCrea }
     *     
     */
    public void setSezioneRapportoLavoro(SezioneRapportoLavoroCrea value) {
        this.sezioneRapportoLavoro = value;
    }

    /**
     * Gets the value of the sezioneAccordoSmartWorking property.
     * 
     * @return
     *     possible object is
     *     {@link SezioneAccordoSmartWorking }
     *     
     */
    public SezioneAccordoSmartWorking getSezioneAccordoSmartWorking() {
        return sezioneAccordoSmartWorking;
    }

    /**
     * Sets the value of the sezioneAccordoSmartWorking property.
     * 
     * @param value
     *     allowed object is
     *     {@link SezioneAccordoSmartWorking }
     *     
     */
    public void setSezioneAccordoSmartWorking(SezioneAccordoSmartWorking value) {
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
