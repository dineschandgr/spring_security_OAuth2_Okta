package io.spring.security.springsecurity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringSecurityOauthClientApplication implements CommandLineRunner  {

	  
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOauthClientApplication.class, args);
	}

	@Value("#{ @environment['resource1.baseUrl'] }")
    private String serverBaseUrl1;
	
	@Bean(name="restTemplate1")
	@Primary
	protected RestTemplate restTemplateResource1() {
	     return new OAuth2RestTemplate(oAuthDetails1());
	}
	
	/*
	 * @Bean protected RestTemplate restTemplateResource2() { return new
	 * OAuth2RestTemplate(oAuthDetails2()); }
	 */
	
	@Bean
    @ConfigurationProperties("resource1.oauth2.client")
    protected ClientCredentialsResourceDetails oAuthDetails1() {
        return new ClientCredentialsResourceDetails();
    }
	
	@Bean(name="restTemplate2")
	protected RestTemplate restTemplateResource2() {
	     return new OAuth2RestTemplate(oAuthDetails2());
	}
	
	
	@Bean
    @ConfigurationProperties("resource2.oauth2.client")
    protected ClientCredentialsResourceDetails oAuthDetails2() {
        return new ClientCredentialsResourceDetails();
    }


	@Override
	public void run(String... args) throws Exception {
		//System.out.println(restTemplate1.getForObject(serverBaseUrl1 + "/mod", String.class));
		
	}
	
}
