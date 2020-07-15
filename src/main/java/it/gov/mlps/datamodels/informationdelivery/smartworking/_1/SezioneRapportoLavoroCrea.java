
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
 * <p>Java class for SezioneRapportoLavoro_Crea complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SezioneRapportoLavoro_Crea"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DataInizioRapportoLavoro" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
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
@XmlType(name = "SezioneRapportoLavoro_Crea", propOrder = {
    "dataInizioRapportoLavoro",
    "codTipologiaRapportoLavoro",
    "posizioneINAIL",
    "tariffaINAIL"
})
public class SezioneRapportoLavoroCrea
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "DataInizioRapportoLavoro", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar dataInizioRapportoLavoro;
    @XmlElement(name = "CodTipologiaRapportoLavoro", required = true)
    protected String codTipologiaRapportoLavoro;
    @XmlElement(name = "PosizioneINAIL", required = true)
    protected String posizioneINAIL;
    @XmlElement(name = "TariffaINAIL", required = true)
    protected String tariffaINAIL;

    /**
     * Gets the value of the dataInizioRapportoLavoro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getDataInizioRapportoLavoro() {
        return dataInizioRapportoLavoro;
    }

    /**
     * Sets the value of the dataInizioRapportoLavoro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioRapportoLavoro(Calendar value) {
        this.dataInizioRapportoLavoro = value;
    }

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
