package io.spring.security.springsecurity.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {
	
	@Autowired
	@Qualifier("restTemplate1")
	private RestTemplate restTemplate1;
	
	@Autowired
	@Qualifier("restTemplate2")
	private RestTemplate restTemplate2;
	
	@Value("#{ @environment['resource1.baseUrl'] }")
    private String serverBaseUrl1;
	
	@Value("#{ @environment['resource2.baseUrl'] }")
    private String serverBaseUrl2;
	
	
    @GetMapping("/getResource1")
    public String getResource1(Principal principal) {
    	return restTemplate1.getForObject(serverBaseUrl1 + "/mod", String.class);
    }

    @GetMapping("/getResource2")
    public String getResource2(Principal principal) {
    	return restTemplate2.getForObject(serverBaseUrl2 + "/mod", String.class);
    }
    
    @GetMapping("/admin")
	public String getAdmin() {
		return("<H1>Welcome Admin</H1>");
	}
}