package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import examspring.Client;
import examspring.Client2;

@Configuration
public class JavaConfig {
	
	@Bean
	public Client client() {
		Client client = new Client();
		client.setHost("서버1");
		return client;
	}
	
	// destroyMethod를 지정하지 않으면 close, shutdown 메서드가 자동실행
	@Bean(initMethod = "connect")
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("서버2");
		return client2;
	}
	
	
}
