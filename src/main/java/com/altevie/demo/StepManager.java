package com.altevie.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import it.gov.mlps.datamodels.informationdelivery.smartworking.AnnullaComunicazioneInput;
import it.gov.mlps.datamodels.informationdelivery.smartworking.CreaComunicazioneInput;
import it.gov.mlps.datamodels.informationdelivery.smartworking.ModificaComunicazioneInput;
import it.gov.mlps.datamodels.informationdelivery.smartworking.SezioneAccordoSmartWorking;
import it.gov.mlps.datamodels.informationdelivery.smartworking.SezioneAccordoSmartWorkingInput;
import it.gov.mlps.datamodels.informationdelivery.smartworking.SezioneDatoreLavoro;
import it.gov.mlps.datamodels.informationdelivery.smartworking.SezioneLavoratore;
import it.gov.mlps.datamodels.informationdelivery.smartworking.SezioneRapportoLavoroCrea;
import it.gov.mlps.datamodels.informationdelivery.smartworking.SezioneRapportoLavoroModifica;
import it.gov.mlps.datamodels.informationdelivery.smartworking.SezioneSoggettoAbilitatoInput;

@Component
public class StepManager {
	
	private static final Logger logger = LoggerFactory.getLogger(StepManager.class);
	
	private static final String FORMAT_DATE_CSV = "dd/MM/yyyy";
	
	private String outputPath ;	
    private JAXBContext contextCrea;
    private JAXBContext contextModifica;
    private JAXBContext contextAnnulla;
	
	private boolean isContinue = true;
	private HashMap<String, ArrayList<AnnullaComunicazioneInput>> annullaList = new HashMap<>();
	private HashMap<String, ArrayList<CreaComunicazioneInput>> creaList = new HashMap<>();
	private HashMap<String, ArrayList<ModificaComunicazioneInput>> modificaList = new HashMap<>();
	
	public void doSteps() {		
		
		checkFile();
		if(isContinue) {
			try {
				readFile();
			} catch (CsvValidationException e) {
				logger.error("Error in parse csv:", e);
			}
		}
		if(isContinue) {
			checkOutputFolder();
		}
		if(isContinue) {
			try {
				writeXml();
			} catch (JAXBException e) {
				logger.error("Error in jaxb:", e);
			}
		}
	}
	
	public void checkOutputFolder() {
		Date timestamp = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String format = formatter.format(timestamp);
		outputPath = ConfigPropertiesSmart.outputPath;
		outputPath = outputPath + "_" + format; 
		
		File f = new File(outputPath);
		logger.info("Check exists output folders:"+ outputPath); 
		if(!f.exists()) { 
			f.mkdir();
		}
		
		if(!CollectionUtils.isEmpty(creaList)) {
			f = new File(outputPath+ConfigPropertiesSmart.invioPath);
			logger.info("Check exists output folders:"+ outputPath+ConfigPropertiesSmart.invioPath); 
			if(!f.exists()) { 
				f.mkdir();
			}
			creaList.forEach((key, value) -> {
				File fi = new File(outputPath+ConfigPropertiesSmart.invioPath + "/" + key);
				if(!fi.exists()) { 
					fi.mkdir();
				}
			});
		}
		
		if(!CollectionUtils.isEmpty(annullaList)) {
			f = new File(outputPath+ConfigPropertiesSmart.annullaPath);
			logger.info("Check exists output folders:"+ outputPath+ConfigPropertiesSmart.annullaPath); 
			if(!f.exists()) { 
				f.mkdir();
			}
			annullaList.forEach((key, value) -> {
				File fi = new File(outputPath+ConfigPropertiesSmart.annullaPath + "/" + key);
				if(!fi.exists()) { 
					fi.mkdir();
				}
			});
		}
		
		if(!CollectionUtils.isEmpty(modificaList)) {
			f = new File(outputPath+ConfigPropertiesSmart.modificaPath);
			logger.info("Check exists output folders:"+ outputPath+ConfigPropertiesSmart.modificaPath); 
			if(!f.exists()) { 
				f.mkdir();
			}
			modificaList.forEach((key, value) -> {
				File fi = new File(outputPath+ConfigPropertiesSmart.modificaPath + "/" + key);
				if(!fi.exists()) { 
					fi.mkdir();
				}
			});
		}

	}
	
	public void checkFile() {
		File f = new File(ConfigPropertiesSmart.sourceFile);
		logger.info("Check exists file:"+ ConfigPropertiesSmart.sourceFile); 
		if(!(f.exists() && !f.isDirectory())) { 
			logger.info("Please check file in :"+ ConfigPropertiesSmart.sourceFile);
			isContinue=false;
		}
	}

	public void readFile() throws CsvValidationException {
		Reader reader = null;
		try {           
			reader = new FileReader(ConfigPropertiesSmart.sourceFile);

			CSVParser parser = new CSVParserBuilder()
					.withSeparator(ConfigPropertiesSmart.delimeterCsv.charAt(0))
					.withIgnoreQuotations(true)
					.build();

			CSVReader csvReader = new CSVReaderBuilder(reader)
					.withSkipLines(0)
					.withCSVParser(parser)
					.build();

			String[] line = csvReader.readNext();
			logger.info("Lettura header:" + Arrays.toString(line));
			int i = 1;
			while ((line = csvReader.readNext()) != null) {
				logger.info("Lettura rigo: " + i + " : " + Arrays.toString(line));
				populateBeans(line);
				i++;
			}
			reader.close();
		} catch (IOException e) {
			logger.error("Error: " + e.getMessage());
		}
	}
	
	private void populateBeans(String[] line) {
		String tipoInvio = line[16];
		logger.info("Tipo invio: " + tipoInvio);
		if("I".equals(tipoInvio)) {
			populateInvio(line);
		}else if("M".equals(tipoInvio)) {
			populateModifica(line);
		}else if("A".equals(tipoInvio)) {
			populateAnnulla(line);
		}else {
			logger.info("Tipo invio non valorizzato: riga tracciato ignorata.");
		}		
	}

	private void populateAnnulla(String[] line) {
		AnnullaComunicazioneInput annulla = new AnnullaComunicazioneInput();
		
	    SezioneSoggettoAbilitatoInput abilitato = new SezioneSoggettoAbilitatoInput();	     
	    
	    annulla.setCodTipologiaComunicazione(line[16]);
	    annulla.setCodiceComunicazione(line[18]);
	    
	    annulla.setSezioneSoggettoAbilitato(abilitato);	
		annulla.getSezioneSoggettoAbilitato().setCodTipologiaSoggettoAbilitato(line[20]);
		annulla.getSezioneSoggettoAbilitato().setCodiceFiscaleSoggettoAbilitato(line[21]);
		
		if(annullaList.get(line[18])!=null){
			annullaList.get(line[18]).add(annulla);
		}else {
			ArrayList<AnnullaComunicazioneInput> lista = new ArrayList<AnnullaComunicazioneInput>();
			lista.add(annulla);
			annullaList.put(line[18], lista);
		}		
	}

	private void populateModifica(String[] line) {
		ModificaComunicazioneInput modifica = new ModificaComunicazioneInput();
		
	    SezioneRapportoLavoroModifica rapporto = new SezioneRapportoLavoroModifica();
	    SezioneAccordoSmartWorkingInput smart = new SezioneAccordoSmartWorkingInput();
	    SezioneSoggettoAbilitatoInput abilitato = new SezioneSoggettoAbilitatoInput();
	    
		modifica.setSezioneRapportoLavoro(rapporto);
		modifica.getSezioneRapportoLavoro().setCodTipologiaRapportoLavoro(line[8]);
		modifica.getSezioneRapportoLavoro().setPosizioneINAIL(line[9]);
		modifica.getSezioneRapportoLavoro().setTariffaINAIL(line[10]);
		
		modifica.setSezioneAccordoSmartWorking(smart);		
		modifica.getSezioneAccordoSmartWorking().setDataSottoscrizioneAccordo(getCalendarByCsv(line[11]));
		modifica.getSezioneAccordoSmartWorking().setTipologiaDurataPeriodo(line[12]);
		modifica.getSezioneAccordoSmartWorking().setDataInizioPeriodo(getCalendarByCsv(line[14]));
		modifica.getSezioneAccordoSmartWorking().setDataFinePeriodo(getCalendarByCsv(line[15]));
		
		modifica.setCodTipologiaComunicazione(line[16]);
		
		modifica.setCodiceComunicazione(line[18]);
		
		modifica.setSezioneSoggettoAbilitato(abilitato);
		modifica.getSezioneSoggettoAbilitato().setCodTipologiaSoggettoAbilitato(line[20]);
		modifica.getSezioneSoggettoAbilitato().setCodiceFiscaleSoggettoAbilitato(line[21]);
		
		if(modificaList.get(line[18])!=null){
			modificaList.get(line[18]).add(modifica);
		}else {
			ArrayList<ModificaComunicazioneInput> lista = new ArrayList<ModificaComunicazioneInput>();
			lista.add(modifica);
			modificaList.put(line[18], lista);
		}	
		
	}

	private void populateInvio(String[] line) {
		CreaComunicazioneInput invio = new CreaComunicazioneInput();
		SezioneDatoreLavoro datore = new SezioneDatoreLavoro();
		SezioneLavoratore lavoratore = new SezioneLavoratore();
		SezioneRapportoLavoroCrea rapporto = new SezioneRapportoLavoroCrea();
		SezioneAccordoSmartWorking smart = new SezioneAccordoSmartWorking();
		SezioneSoggettoAbilitatoInput abilitato = new SezioneSoggettoAbilitatoInput();
		
		invio.setSezioneDatoreLavoro(datore);
		invio.getSezioneDatoreLavoro().setCodiceFiscaleDatoreLavoro(line[0]);
		invio.getSezioneDatoreLavoro().setDenominazioneDatoreLavoro(line[1]);
		
		invio.setSezioneLavoratore(lavoratore);
		invio.getSezioneLavoratore().setCodiceFiscaleLavoratore(line[2]);		
		invio.getSezioneLavoratore().setDataNascitaLavoratore(getCalendarByCsv(line[3]));
		invio.getSezioneLavoratore().setCognomeLavoratore(line[4]);
		invio.getSezioneLavoratore().setNomeLavoratore(line[5]);		
		invio.getSezioneLavoratore().setCodComuneNascitaLavoratore(line[6]);
		
		invio.setSezioneRapportoLavoro(rapporto);
		invio.getSezioneRapportoLavoro().setDataInizioRapportoLavoro(getCalendarByCsv(line[7]));
		invio.getSezioneRapportoLavoro().setCodTipologiaRapportoLavoro(line[8]);
		invio.getSezioneRapportoLavoro().setPosizioneINAIL(line[9]);
		invio.getSezioneRapportoLavoro().setTariffaINAIL(line[10]);
		
		invio.setSezioneAccordoSmartWorking(smart);
		invio.getSezioneAccordoSmartWorking().setDataSottoscrizioneAccordo(getCalendarByCsv(line[11]));
		invio.getSezioneAccordoSmartWorking().setTipologiaDurataPeriodo(line[12]);
		//manca durata periodo in mesi line[11]
		invio.getSezioneAccordoSmartWorking().setDataInizioPeriodo(getCalendarByCsv(line[14]));
		invio.getSezioneAccordoSmartWorking().setDataFinePeriodo(getCalendarByCsv(line[15]));
		
		invio.setCodTipologiaComunicazione(line[16]);
		
		invio.setSezioneSoggettoAbilitato(abilitato);
		invio.getSezioneSoggettoAbilitato().setCodTipologiaSoggettoAbilitato(line[20]);
		invio.getSezioneSoggettoAbilitato().setCodiceFiscaleSoggettoAbilitato(line[21]);
		
		if(creaList.get(line[0])!=null){
			creaList.get(line[0]).add(invio);
		}else {
			ArrayList<CreaComunicazioneInput> lista = new ArrayList<CreaComunicazioneInput>();
			lista.add(invio);
			creaList.put(line[0], lista);
		}		
	}

	public void writeXml() throws JAXBException {
		
		if(!CollectionUtils.isEmpty(creaList)) {			
			contextCrea = JAXBContext.newInstance(CreaComunicazioneInput.class);			
			Marshaller marshallerCrea = contextCrea.createMarshaller();
			creaList.forEach((key, value) -> {
				try {
					for (CreaComunicazioneInput each : value) {
						marshallerCrea.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
						marshallerCrea.marshal(each, new File(outputPath+ConfigPropertiesSmart.invioPath + "/" + key + "/" + key 
								+ "-" + each.getSezioneLavoratore().getCodiceFiscaleLavoratore() + ".xml"));
					}
				} catch (Exception e) {
					logger.error("ERROR: ", e);
				}
			});
		}
		
		
		if(!CollectionUtils.isEmpty(annullaList)) {			
			contextAnnulla = JAXBContext.newInstance(AnnullaComunicazioneInput.class);			
			Marshaller marshallerAnnulla = contextAnnulla.createMarshaller();
			annullaList.forEach((key, value) -> {
				try {
					for (AnnullaComunicazioneInput each : value) {
						marshallerAnnulla.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
						marshallerAnnulla.marshal(each, new File(outputPath+ConfigPropertiesSmart.annullaPath + "/" + key + "/" 
						+ each.getCodiceComunicazione() + ".xml"));
					}
				} catch (Exception e) {
					logger.error("ERROR: ", e);
				}
			});
		}
		
		if(!CollectionUtils.isEmpty(modificaList)) {			
			contextModifica = JAXBContext.newInstance(ModificaComunicazioneInput.class);			
			Marshaller marshallerModifica = contextModifica.createMarshaller();
			modificaList.forEach((key, value) -> {
				try {
					for (ModificaComunicazioneInput each : value) {
						marshallerModifica.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
						marshallerModifica.marshal(each, new File(outputPath+ConfigPropertiesSmart.modificaPath + "/" + key + "/" 
						+ each.getCodiceComunicazione() + ".xml"));
					}
				} catch (Exception e) {
					logger.error("ERROR: ", e);
				}
			});
		}
		
	}
	
	private Calendar getCalendarByCsv(String valueString) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_CSV);
		Date date;
		Calendar cal = null;
		try {
			date = sdf.parse(valueString);
			cal = Calendar.getInstance();
			cal.setTime(date);
		} catch (ParseException e) {
			logger.error("Cannot convert string date : " + valueString);
		}
		return cal;
	}

	
//////////////////////////////////////////////////////////////////////////////////////////////////7
	
	private void tempAddCrea(String CFdatore, String lavoratore) {
		CreaComunicazioneInput ccrea = new CreaComunicazioneInput();
		SezioneDatoreLavoro datore = new SezioneDatoreLavoro();
		SezioneLavoratore lavor = new SezioneLavoratore();
		SezioneRapportoLavoroCrea rapporto = new SezioneRapportoLavoroCrea();
		SezioneAccordoSmartWorking smart = new SezioneAccordoSmartWorking();
		SezioneSoggettoAbilitatoInput abilt = new SezioneSoggettoAbilitatoInput();
		
		ccrea.setCodTipologiaComunicazione("I");
		ccrea.setSezioneDatoreLavoro(datore);
		ccrea.getSezioneDatoreLavoro().setCodiceFiscaleDatoreLavoro(CFdatore);
		ccrea.getSezioneDatoreLavoro().setDenominazioneDatoreLavoro("Ciao Azienda");
		ccrea.setSezioneLavoratore(lavor);
		ccrea.getSezioneLavoratore().setCodiceFiscaleLavoratore(lavoratore);
		ccrea.getSezioneLavoratore().setNomeLavoratore("adasd");
		ccrea.getSezioneLavoratore().setCognomeLavoratore("dadasdasd");
		ccrea.getSezioneLavoratore().setDataNascitaLavoratore(Calendar.getInstance());
		ccrea.getSezioneLavoratore().setCodComuneNascitaLavoratore("H501");
		ccrea.setSezioneRapportoLavoro(rapporto);
		ccrea.getSezioneRapportoLavoro().setDataInizioRapportoLavoro(Calendar.getInstance());
		ccrea.getSezioneRapportoLavoro().setCodTipologiaRapportoLavoro("A00");
		ccrea.getSezioneRapportoLavoro().setPosizioneINAIL("123456789");
		ccrea.getSezioneRapportoLavoro().setTariffaINAIL("1234");
		
		ccrea.setSezioneAccordoSmartWorking(smart);
		ccrea.getSezioneAccordoSmartWorking().setDataSottoscrizioneAccordo(Calendar.getInstance());
		ccrea.getSezioneAccordoSmartWorking().setDataFinePeriodo(Calendar.getInstance());
		ccrea.getSezioneAccordoSmartWorking().setTipologiaDurataPeriodo("TD");
		
		ccrea.setSezioneSoggettoAbilitato(abilt);
		ccrea.getSezioneSoggettoAbilitato().setCodTipologiaSoggettoAbilitato("03");
		ccrea.getSezioneSoggettoAbilitato().setCodiceFiscaleSoggettoAbilitato("DDDEEE00A01H501U");
		
		if(creaList.get(CFdatore)!=null){
			creaList.get(CFdatore).add(ccrea);
		}else {
			ArrayList<CreaComunicazioneInput> lista = new ArrayList<CreaComunicazioneInput>();
			lista.add(ccrea);
			creaList.put(CFdatore, lista);
		}	
		
	}
	
	private void tempAddModify(String comunicazione) {
		ModificaComunicazioneInput modifica = new ModificaComunicazioneInput();
		
	    SezioneRapportoLavoroModifica rapporto = new SezioneRapportoLavoroModifica();
	    SezioneAccordoSmartWorkingInput smart = new SezioneAccordoSmartWorkingInput();
	    SezioneSoggettoAbilitatoInput abilitato = new SezioneSoggettoAbilitatoInput();
	     
	    
	    modifica.setCodTipologiaComunicazione("M");
	    modifica.setCodiceComunicazione(comunicazione);
		modifica.setSezioneAccordoSmartWorking(smart);
		modifica.setSezioneRapportoLavoro(rapporto);
		modifica.setSezioneSoggettoAbilitato(abilitato);
		
		modifica.getSezioneRapportoLavoro().setCodTipologiaRapportoLavoro("XXX");
		modifica.getSezioneRapportoLavoro().setPosizioneINAIL("XXXXX");
		modifica.getSezioneRapportoLavoro().setTariffaINAIL("13123");
		
		modifica.getSezioneAccordoSmartWorking().setDataSottoscrizioneAccordo(Calendar.getInstance());
		modifica.getSezioneAccordoSmartWorking().setDataFinePeriodo(Calendar.getInstance());
		modifica.getSezioneAccordoSmartWorking().setTipologiaDurataPeriodo("TD");
		
		modifica.getSezioneSoggettoAbilitato().setCodiceFiscaleSoggettoAbilitato("AAASSS33S33S222S");
		modifica.getSezioneSoggettoAbilitato().setCodTipologiaSoggettoAbilitato("AAA");
		
		if(modificaList.get(comunicazione)!=null){
			modificaList.get(comunicazione).add(modifica);
		}else {
			ArrayList<ModificaComunicazioneInput> lista = new ArrayList<ModificaComunicazioneInput>();
			lista.add(modifica);
			modificaList.put(comunicazione, lista);
		}	
		
	}
	
	private void tempAddAnnulla(String comunicazione) {
		AnnullaComunicazioneInput annulla = new AnnullaComunicazioneInput();
		
	    SezioneSoggettoAbilitatoInput abilitato = new SezioneSoggettoAbilitatoInput();	     
	    
	    annulla.setCodTipologiaComunicazione("A");
	    annulla.setCodiceComunicazione(comunicazione);
	    annulla.setSezioneSoggettoAbilitato(abilitato);
		
		annulla.getSezioneSoggettoAbilitato().setCodiceFiscaleSoggettoAbilitato("AAASSS33S33S222S");
		annulla.getSezioneSoggettoAbilitato().setCodTipologiaSoggettoAbilitato("AAA");
		
		if(annullaList.get(comunicazione)!=null){
			annullaList.get(comunicazione).add(annulla);
		}else {
			ArrayList<AnnullaComunicazioneInput> lista = new ArrayList<AnnullaComunicazioneInput>();
			lista.add(annulla);
			annullaList.put(comunicazione, lista);
		}		
	}
	
	public void tempReadFile() {
		tempAddCrea("12345678901", "AAABBB00A01H501U");
		tempAddCrea("11111111111", "AAABBB00A01H501U");
		
		tempAddAnnulla("ANN_12345");
		tempAddAnnulla("ANN_11111");
		
		tempAddModify("MOD_11111");
		tempAddModify("MOD_22222");
	}
}
