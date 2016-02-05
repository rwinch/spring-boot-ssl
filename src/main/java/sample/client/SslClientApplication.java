package sample.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SslClientApplication {
	@Value("${ssl.client.trust-store-path}")
	String trustStorePath;

	@Bean
	public RestTemplate restTemplate() {
		System.setProperty("javax.net.ssl.trustStore", trustStorePath);
		System.setProperty("javax.net.ssl.trustStorePassword", "secret");

		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SslClientApplication.class, args);
	}
}
