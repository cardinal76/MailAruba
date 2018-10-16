package it.cardinali.MailAruba;

import static org.assertj.core.api.Assertions.assertThat;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.cardinali.MailAruba.restController.MailController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailArubaApplicationTests {

	@Autowired
	MailController mailController;
	
	@Test
	public void contextLoads() {
		assertThat(mailController).isNotNull();
	}

	
	@Test
	public void testaMailRest() throws NoSuchAlgorithmException, InterruptedException, ExecutionException {
		mailController.fetchCasella("1", "");
	}
	
}
