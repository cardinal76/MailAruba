package it.cardinali.MailAruba.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import it.cardinali.MailAruba.dto.MessaggioDTO;

public interface GestioneCasellaArubaService {

	
	CompletableFuture<String> inserisciMessaggio(String idCasella, String data)  throws NoSuchAlgorithmException, InterruptedException;
	//void inserisci()  ;
	
	List<MessaggioDTO> ricercaMessaggi(String idCasella, String tipoMessagghio, String data);
	
	
	MessaggioDTO ricercaMessaggio(String idCasella, String idMessaggio);
}
