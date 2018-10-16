package it.cardinali.MailAruba.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the mail database table.
 * 
 */
@Entity
@NamedQuery(name="Mail.findAll", query="SELECT m FROM Mail m")
public class Mail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idmail;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataricezione;

	private String hash;

	private String headermessaggio;

	private String headerxriferimento;

	private int idmessaggio;

	private String mittente;

	private String oggetto;

	private String pathfull;

	private String tipomessaggio;

	public Mail() {
	}

	public int getIdmail() {
		return this.idmail;
	}

	public void setIdmail(int idmail) {
		this.idmail = idmail;
	}

	public Date getDataricezione() {
		return this.dataricezione;
	}

	public void setDataricezione(Date dataricezione) {
		this.dataricezione = dataricezione;
	}

	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getHeadermessaggio() {
		return this.headermessaggio;
	}

	public void setHeadermessaggio(String headermessaggio) {
		this.headermessaggio = headermessaggio;
	}

	public String getHeaderxriferimento() {
		return this.headerxriferimento;
	}

	public void setHeaderxriferimento(String headerxriferimento) {
		this.headerxriferimento = headerxriferimento;
	}

	public int getIdmessaggio() {
		return this.idmessaggio;
	}

	public void setIdmessaggio(int idmessaggio) {
		this.idmessaggio = idmessaggio;
	}

	public String getMittente() {
		return this.mittente;
	}

	public void setMittente(String mittente) {
		this.mittente = mittente;
	}

	public String getOggetto() {
		return this.oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	public String getPathfull() {
		return this.pathfull;
	}

	public void setPathfull(String pathfull) {
		this.pathfull = pathfull;
	}

	public String getTipomessaggio() {
		return this.tipomessaggio;
	}

	public void setTipomessaggio(String tipomessaggio) {
		this.tipomessaggio = tipomessaggio;
	}

}