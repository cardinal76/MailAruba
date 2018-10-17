package it.cardinali.MailAruba.serviceImpl;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import it.cardinali.MailAruba.dto.MessaggioDTO;
import it.cardinali.MailAruba.repository.MailRepository;
import it.cardinali.MailAruba.service.GestioneCasellaArubaService;
import it.cardinali.MailAruba.service.GestisciFileSystemService;
import it.cardinali.MailAruba.service.LeggiCasellaMailService;
@Service
public class GestioneCasellaArubaServiceImpl implements GestioneCasellaArubaService{

	private static final Logger logger = LoggerFactory.getLogger(GestioneCasellaArubaServiceImpl.class);
	@Autowired
	private MailRepository mailRepository;
	@Autowired
	LeggiCasellaMailService leggiCasellaService;
	@Autowired
	GestisciFileSystemService gestisciFileSystemService;
	
//	@Override
//	public void inserisci() {
//		long start = System.currentTimeMillis();
//		CompletableFuture<String> page1 = null;
//		try {
//			page1 = inserisciMessaggio("", "");
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} 
//
//        // Wait until they are all done
//        CompletableFuture.allOf(page1).join();
//
//        // Print results, including elapsed time
//        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
//        try {
//			logger.info("--> " + page1.get());
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
//
//	}
	
	
	
	@Async
	public CompletableFuture<String> inserisciMessaggio(String idCasella, String idMessaggio ) throws NoSuchAlgorithmException, InterruptedException {
		
		 Thread.sleep(15 * 1000);
         logger.info("Processing complete");
		 
		 
		//TODO  LEGGO MAIL ACCOUNT
		// TODO  lettura cartella mail e lettura messaggi
//		leggiCasellaService.leggiCasellaMail();
//		
//
//		
//		// TODO fare hash 
//		
////		bouncy castle
////
//		String originalString ="";
//		MessageDigest digest = MessageDigest.getInstance("SHA-256");
//		byte[] hash = digest.digest(
//		  originalString.getBytes(StandardCharsets.UTF_8));
//		String sha256hex = new String(Hex.encode(hash));
//		
//		//se hash presente in tabella salto la posizione altrimenti vado avanti poi inserisco
//		// TODO scrittura su FS
//		gestisciFileSystemService.scriviFile();
//		
//		
//		//TODO  LEGGO MAIL ACCOUNT	
//		// TODO  inserisco in MAIL
//		Mail mail = new Mail();
//		//setto i dati di insert
//		mailRepository.save(mail);

		 logger.info("-----------fine-------------");
		 
		 return CompletableFuture.completedFuture("risultati");
	}

	@Override
	public List<MessaggioDTO> ricercaMessaggi(String idCasella, String tipoMessagghio, String data) {
		// TODO ritorno la lista degli identificativi
		return null;
	}

	@Override
	public MessaggioDTO ricercaMessaggio(String idCasella, String idMessaggio) {
		// TODO ritorno il messaggio
		// e lo mappo nell apposito oggetto
		return null;
	}

	
	
	
	

	 
	 

	 
	 
	 
	 
	 
	 
}
