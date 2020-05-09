package io.spring.security.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@SpringBootApplication
public class SpringSecurityOauthResourceServer1 {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOauthResourceServer1.class, args);
	}

}
