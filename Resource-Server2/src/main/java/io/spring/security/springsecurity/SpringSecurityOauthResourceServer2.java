package io.spring.security.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@SpringBootApplication
public class SpringSecurityOauthResourceServer2 {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOauthResourceServer2.class, args);
	}

}
