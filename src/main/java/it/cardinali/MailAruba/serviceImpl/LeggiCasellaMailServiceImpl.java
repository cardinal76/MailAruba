package it.cardinali.MailAruba.serviceImpl;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.mail.smtp.SMTPMessage;
import it.cardinali.MailAruba.repository.MailAccountRepository;
import it.cardinali.MailAruba.service.LeggiCasellaMailService;
@Service
public class LeggiCasellaMailServiceImpl implements LeggiCasellaMailService{

	
	public static void main(String[] args) throws MessagingException {
		LeggiCasellaMailServiceImpl leg = new LeggiCasellaMailServiceImpl();
		//leg.leggiCasellaMail();
		
		leg.invio();
		
	}
	
	@Autowired
	private MailAccountRepository mailAccountRepository;
	
	@Override
	public void leggiCasellaMail() {
		//TODO  LEGGO MAIL ACCOUNT     prendo i dati delle properties dal db
		//mailAccountRepository.findAll();
		String protocol = "imap";
			 Properties properties = getServerProperties(protocol, "imaps.pec.aruba.it", "993");
			      Session session = Session.getDefaultInstance(properties);
	
			      try {
			         Store store = session.getStore(protocol);
			         store.connect("marco.cardinali@pec.it", "xxxxxxxxx");
	
			         Folder inbox = store.getFolder("INBOX");
			         inbox.open(Folder.READ_WRITE);
	
			         int count = inbox.getMessageCount();
			         Message[] messages = inbox.getMessages(1, count);
			         for (Message message : messages) {
			            if (!message.getFlags().contains(Flags.Flag.SEEN)) {
			               Address[] fromAddresses = message.getFrom();
			               System.out.println("...................");
			               System.out.println("\t From: "			                  + fromAddresses[0].toString());
			               System.out.println("\t To: "              + parseAddresses(message              .getRecipients(RecipientType.TO)));
			               System.out.println("\t CC: "                  + parseAddresses(message                 .getRecipients(RecipientType.CC)));
			               System.out.println("\t Subject: "                + message.getSubject());
			               System.out.println("\t Sent Date:"			                  + message.getSentDate().toString());
			               try {
			                  System.out.println(message.getContent().toString());
			               } catch (Exception ex) {
			                  System.out.println("Error        reading content!!");
			                  ex.printStackTrace();
			               }
			            }
	
			         }
	
			         inbox.close(false);
			         store.close();
			      } catch (NoSuchProviderException ex) {
			         System.out.println("No provider for protocol: " + protocol);
			         ex.printStackTrace();
			      } catch (MessagingException ex) {
			         System.out.println("Could not connect to the message store");
			         ex.printStackTrace();
			      }
}
		
	 private String parseAddresses(Address[] address) {

	      String listOfAddress = "";
	      if ((address == null) || (address.length < 1))
	         return null;
	      if (!(address[0] instanceof InternetAddress))
	         return null;

	      for (int i = 0; i < address.length; i++) {
	         InternetAddress internetAddress =
	            (InternetAddress) address[0];
	         listOfAddress += internetAddress.getAddress()+",";
	      }
	      return listOfAddress;
	   }

	
	 private Properties getServerProperties(String protocol, String host, String port) {
	      Properties properties = new Properties();
	      properties.put(String.format("mail.%s.host", protocol), host);
	      properties.put(String.format("mail.%s.port", protocol), port);
	      properties.setProperty(String.format("mail.%s.socketFactory.class", protocol), "javax.net.ssl.SSLSocketFactory");
	      properties.setProperty(String.format("mail.%s.socketFactory.fallback", protocol), "false");
	      properties.setProperty(String.format("mail.%s.socketFactory.port", protocol), String.valueOf(port));

	      return properties;
	   }
	 
	 private void invio() throws MessagingException {
		 Properties props = new Properties();
		 
		 props.put("mail.transport.protocol", "smtps");
		 props.put("mail.smtps.host", "smtps.pec.aruba.it"); // esempio smtp.gmail.com
		 props.put("mail.smtps.auth", "true");
		  
		 Session session = Session.getInstance(props,new javax.mail.Authenticator()
		 {
		 public PasswordAuthentication getPasswordAuthentication()
		 {
		 return new PasswordAuthentication( "marco.cardinali@pec.it", "xxxxxxxx");
		 }
		 });
		 MimeMessage messaggioEmail = new MimeMessage( session );
		 
		 
		 //subject, body, attachment,sentDate, From, To
		 messaggioEmail.setSubject("test1");
		 messaggioEmail.setFrom(new InternetAddress("marco.cardinali@pec.it"));
		 messaggioEmail.setText("coap");
		 
		 
		 messaggioEmail.setRecipients(Message.RecipientType.TO,new InternetAddress[] { 
				 new InternetAddress("marco.cardinali@gmail.com") });
		 
		 //messaggioEmail.addRecipient(Message.RecipientType.TO,  new InternetAddress("marco.cardinali@gmail.com")); //new InternetAddress("marco.cardinali@gmail.com")
		 // InternetAddress.parse("marco.cardinali@gmail.com", false)
		 messaggioEmail.setContent("poooooooooooooooooooo", "text/html;charset=UTF-8");
		 
		 
		 messaggioEmail.saveChanges();
		 com.sun.mail.smtp.SMTPMessage mex = new SMTPMessage(messaggioEmail);
		 com.sun.mail.smtp.SMTPSSLTransport t =(com.sun.mail.smtp.SMTPSSLTransport)session.getTransport("smtps"); // <--SMTPS
		 t.setStartTLS(true); //<-- impostiamo il flag per iniziare la comunicazione sicura
		 t.connect( "smtps.pec.aruba.it", "username_vostro_account_pec" ,"password_vostro_account_pec");
		  
		 t.sendMessage( mex, mex.getAllRecipients());
		 t.close();

	}
	 private Properties getServerPropertiesInvio(String protocol, String host, String port) {
	      Properties properties = new Properties();
	      properties.put(String.format("mail.%s.host", protocol), host);
	      properties.put(String.format("mail.%s.port", protocol), port);
	      properties.setProperty(String.format("mail.%s.socketFactory.class", protocol), "javax.net.ssl.SSLSocketFactory");
	      properties.setProperty(String.format("mail.%s.socketFactory.fallback", protocol), "false");
	      properties.setProperty(String.format("mail.%s.socketFactory.port", protocol), String.valueOf(port));

	      return properties;
	   }
	 
	 
//		IMPOSTAZIONI ACCOUNT
//		Nome Completo: Mario Rossi
//		Indirizzo Email: indirizzo di posta certificata (es: nomecasella@pec.nomedominio.xxx)
//		Tipo di Protocollo: IMAP
	 
	 
//		IMPOSTAZIONI SERVER DI POSTA IN ARRIVO
//		Posta in Arrivo (IMAP): imaps.pec.aruba.it
//		Nome account: indirizzo di posta certificata (es: nomecasella@pec.nomedominio.xxx)
//		Password: la password assegnata alla casella
//		Usa SSL: Attiva
//		Autenticazione: Password
//		Porta del server di posta in entrata (IMAP): 993
//		Host del server di posta in entrata: imaps.pec.aruba.it
	 
//		IMPOSTAZIONI SERVER DI POSTA IN USCITA
//		Nome Completo: Mario Rossi
//		Indirizzo Email: indirizzo di posta certificata (es: nomecasella@pec.nomedominio.xxx)
//		Porta del server di posta in uscita (SMTP): 465
//		Host del server di posta in uscita: smtps.pec.aruba.it
	 
	
}
