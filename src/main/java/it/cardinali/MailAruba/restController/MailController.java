package it.cardinali.MailAruba.restController;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.cardinali.MailAruba.service.GestioneCasellaArubaService;

@RestController
public class MailController {
	@Autowired
	GestioneCasellaArubaService gestioneCasellaArubaService;
	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	private Boolean isCompleted = false;
	
	@RequestMapping("/ping")
    public ResponseEntity<String> ping()  {
		logger.info("inizio");
		return new ResponseEntity<String>("E' finito ? ----> "+isCompleted, HttpStatus.OK);
	}
	  
	  
	
	  @RequestMapping("/casella/{idCasella}/scansione/{data}")
	    public ResponseEntity<String> fetchCasella(@RequestParam(value="idCasella") String idCasella,
	    		@RequestParam(value="data") String data) throws NoSuchAlgorithmException, InterruptedException, ExecutionException {
		  logger.info("inizio");
		  
		  // Start the clock
	        // Kick of multiple, asynchronous lookups
		  CompletableFuture pippo = gestioneCasellaArubaService.inserisciMessaggio(idCasella, data);
		  pippo.whenCompleteAsync((result, error) -> {
		        logger.info("ciao completatoooooooooooooooooooo" + result.toString());
		        isCompleted=true;
		    });
		  //CompletableFuture.allOf(pippo).join();
		  
	       logger.info("inizio 2");
	    	HttpHeaders headers = new HttpHeaders();
		    
		    headers.add("Content-Description", "Json di risposta");
//		    headers.add("Content-Disposition", "attachment; filename="+"nome");
//		    headers.add("Content-Transfer-Encoding", "binary");
//		    headers.add("Access-Control-Expose-Headers", "content-disposition, Content-Type, Access-Control-Allow-Headers,Content-Length");
		    headers.add("Content-Type", "application/json");
		    logger.info("inizio 3");
	    	return new ResponseEntity<String>("Tutto a posto", headers, HttpStatus.OK);
	    }
	
	
	
	    
		  @RequestMapping("/casella/{idCasella}/messaggio/{tipoMessaggio}/scansione/{data}")
		    public ResponseEntity<byte[]> ricerca(@RequestParam(value="idCasella") String idCasella,
		    		@RequestParam(value="tipoMessaggio") String tipoMessaggio,
		    		@RequestParam(value="data") String data) {
			  
			  
			  
		    	HttpHeaders headers = new HttpHeaders();
			    
//			    headers.add("Content-Description", "File Transfer");
			    headers.add("Content-Disposition", "attachment; filename="+"nome");
//			    headers.add("Content-Transfer-Encoding", "binary");
//			    headers.add("Access-Control-Expose-Headers", "content-disposition, Content-Type, Access-Control-Allow-Headers,Content-Length");
			    headers.add("Content-Type", "application/octet-stream");
			  
			    
			    
			    //ritorno un json,   elenco messaggi, lista di oggetti messaggio
		    	return new ResponseEntity<>(headers, HttpStatus.OK);
		    }
		
		    
		    
		    
		    
		    
			  @RequestMapping("/casella/{idCasella}/messaggio/{idMessaggio}")
			    public ResponseEntity<byte[]> messaggio(@RequestParam(value="idCasella") String idCasella,
			    		@RequestParam(value="idMessaggio") String idMessaggio) {
				  
				  
				  
			    	HttpHeaders headers = new HttpHeaders();
				    
//				    headers.add("Content-Description", "File Transfer");
				    headers.add("Content-Disposition", "attachment; filename="+"nome");
//				    headers.add("Content-Transfer-Encoding", "binary");
//				    headers.add("Access-Control-Expose-Headers", "content-disposition, Content-Type, Access-Control-Allow-Headers,Content-Length");
				    headers.add("Content-Type", "application/octet-stream");
				  
				    
				    
				    //ritorno un json, ritorno oggetto messaggio singolo
			    	return new ResponseEntity<>(headers, HttpStatus.OK);
			    }
	    
	    
	    
	    
	    
	
}
