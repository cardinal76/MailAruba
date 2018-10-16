package it.cardinali.MailAruba.serviceImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;

import it.cardinali.MailAruba.service.GestisciFileSystemService;
@Service
public class GestisciFileSystemServiceImpl implements GestisciFileSystemService {

	@Override
	public void scriviFile() {
		String path = "C:/soluzionijava.txt";//ID_CASELLA/AAAA/MM/GG
		try {
			File file = new File(path);
			FileWriter fw = new FileWriter(file);
			fw.write("Scrivo una riga nel file !!!");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		

			

}
