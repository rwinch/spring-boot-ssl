package sample.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SslClientApplication.class)
@WebAppConfiguration
public class SslClientApplicationTests {
	@Autowired
	RestTemplate rest;

	@Test
	public void restTemplateAccesses() {
		rest.getForEntity("https://localhost:8443/hello", String.class);
	}
}