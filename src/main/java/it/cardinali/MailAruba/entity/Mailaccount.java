package it.cardinali.MailAruba.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mailaccount database table.
 * 
 */
@Entity
@NamedQuery(name="Mailaccount.findAll", query="SELECT m FROM Mailaccount m")
public class Mailaccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idmailaccount;

	private String descrizione;

	private String indirizzo;

	private String password;

	private String portaImap;

	private String serverImap;

	public Mailaccount() {
	}

	public int getIdmailaccount() {
		return this.idmailaccount;
	}

	public void setIdmailaccount(int idmailaccount) {
		this.idmailaccount = idmailaccount;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPortaImap() {
		return this.portaImap;
	}

	public void setPortaImap(String portaImap) {
		this.portaImap = portaImap;
	}

	public String getServerImap() {
		return this.serverImap;
	}

	public void setServerImap(String serverImap) {
		this.serverImap = serverImap;
	}

}