//import java.io.File;
//import java.util.ArrayList;
//import java.util.Calendar;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
//
//import it.gov.mlps.datamodels.informationdelivery.smartworking.CreaComunicazioneInput;
//import it.gov.mlps.datamodels.informationdelivery.smartworking.SezioneAccordoSmartWorking;
//import it.gov.mlps.datamodels.informationdelivery.smartworking.SezioneDatoreLavoro;
//import it.gov.mlps.datamodels.informationdelivery.smartworking.SezioneLavoratore;
//import it.gov.mlps.datamodels.informationdelivery.smartworking.SezioneRapportoLavoroCrea;
//import it.gov.mlps.datamodels.informationdelivery.smartworking.SezioneSoggettoAbilitatoInput;

//package com.example.demo;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class DemoApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}

//	public void writeXml() throws JAXBException {
//		
//		context = JAXBContext.newInstance(CreaComunicazioneInput.class);
//		
//		CreaComunicazioneInput ccrea = new CreaComunicazioneInput();
//		SezioneDatoreLavoro datore = new SezioneDatoreLavoro();
//		SezioneLavoratore lavor = new SezioneLavoratore();
//		SezioneRapportoLavoroCrea rapporto = new SezioneRapportoLavoroCrea();
//		SezioneAccordoSmartWorking smart = new SezioneAccordoSmartWorking();
//		SezioneSoggettoAbilitatoInput abilt = new SezioneSoggettoAbilitatoInput();
//		
//		ccrea.setCodTipologiaComunicazione("I");
//		ccrea.setSezioneDatoreLavoro(datore);
//		ccrea.getSezioneDatoreLavoro().setCodiceFiscaleDatoreLavoro("12345678901");
//		ccrea.getSezioneDatoreLavoro().setDenominazioneDatoreLavoro("Ciao Azienda");
//		ccrea.setSezioneLavoratore(lavor);
//		ccrea.getSezioneLavoratore().setCodiceFiscaleLavoratore("AAABBB00A01H501U");
//		ccrea.getSezioneLavoratore().setNomeLavoratore("adasd");
//		ccrea.getSezioneLavoratore().setCognomeLavoratore("dadasdasd");
//		ccrea.getSezioneLavoratore().setDataNascitaLavoratore(Calendar.getInstance());
//		ccrea.getSezioneLavoratore().setCodComuneNascitaLavoratore("H501");
//		ccrea.setSezioneRapportoLavoro(rapporto);
//		ccrea.getSezioneRapportoLavoro().setDataInizioRapportoLavoro(Calendar.getInstance());
//		ccrea.getSezioneRapportoLavoro().setCodTipologiaRapportoLavoro("A00");
//		ccrea.getSezioneRapportoLavoro().setPosizioneINAIL("123456789");
//		ccrea.getSezioneRapportoLavoro().setTariffaINAIL("1234");
//		
//		ccrea.setSezioneAccordoSmartWorking(smart);
//		ccrea.getSezioneAccordoSmartWorking().setDataSottoscrizioneAccordo(Calendar.getInstance());
//		ccrea.getSezioneAccordoSmartWorking().setDataFinePeriodo(Calendar.getInstance());
//		ccrea.getSezioneAccordoSmartWorking().setTipologiaDurataPeriodo("TD");
//		
//		ccrea.setSezioneSoggettoAbilitato(abilt);
//		ccrea.getSezioneSoggettoAbilitato().setCodTipologiaSoggettoAbilitato("03");
//		ccrea.getSezioneSoggettoAbilitato().setCodiceFiscaleSoggettoAbilitato("DDDEEE00A01H501U");
//		
//		ArrayList<CreaComunicazioneInput> lista = new ArrayList<CreaComunicazioneInput>();
//		lista.add(ccrea);
//		creaList.put("12345678901", lista);
//		
//		Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        marshaller.marshal(ccrea, new File(CREATE_OUTPUT_PATH + "/12345678901.xml"));
//        
//        		
//	}
//
//}
