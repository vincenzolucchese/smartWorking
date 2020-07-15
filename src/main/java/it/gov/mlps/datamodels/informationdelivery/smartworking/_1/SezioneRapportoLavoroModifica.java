
package it.gov.mlps.datamodels.informationdelivery.smartworking._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SezioneRapportoLavoro_Modifica complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SezioneRapportoLavoro_Modifica"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodTipologiaRapportoLavoro" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PosizioneINAIL" type="{http://mlps.gov.it/DataModels/InformationDelivery/SmartWorking/1.0}PAT"/&gt;
 *         &lt;element name="TariffaINAIL" type="{http://mlps.gov.it/DataModels/InformationDelivery/SmartWorking/1.0}TariffaINAIL"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SezioneRapportoLavoro_Modifica", propOrder = {
    "codTipologiaRapportoLavoro",
    "posizioneINAIL",
    "tariffaINAIL"
})
public class SezioneRapportoLavoroModifica
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "CodTipologiaRapportoLavoro", required = true)
    protected String codTipologiaRapportoLavoro;
    @XmlElement(name = "PosizioneINAIL", required = true)
    protected String posizioneINAIL;
    @XmlElement(name = "TariffaINAIL", required = true)
    protected String tariffaINAIL;

    /**
     * Gets the value of the codTipologiaRapportoLavoro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipologiaRapportoLavoro() {
        return codTipologiaRapportoLavoro;
    }

    /**
     * Sets the value of the codTipologiaRapportoLavoro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipologiaRapportoLavoro(String value) {
        this.codTipologiaRapportoLavoro = value;
    }

    /**
     * Gets the value of the posizioneINAIL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosizioneINAIL() {
        return posizioneINAIL;
    }

    /**
     * Sets the value of the posizioneINAIL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosizioneINAIL(String value) {
        this.posizioneINAIL = value;
    }

    /**
     * Gets the value of the tariffaINAIL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTariffaINAIL() {
        return tariffaINAIL;
    }

    /**
     * Sets the value of the tariffaINAIL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTariffaINAIL(String value) {
        this.tariffaINAIL = value;
    }

}
