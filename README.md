# spring_security_OAuth2_Okta
spring security OAuth2 using Okta Authorization server and 2 Spring boot Resource servers and 1 Spring boot client

#Requirements

1. Create an Authorization Server Application

  1. Login to developer.okta.com and create a machine to machine application. Note down the client_id and the client_secret
  2. Go to API menu and select Authorization Servers
  3. Add an Authorization Server and name the scope as custom_mod
  4. Note down the authorization server uri okta_uri/oauth2/default
  5. The Application and the Authorization server is ready and running


2. Create 2 resource servers

  1. Create a spring boot resource server application by downlaoding the pom.xml file
  2. Populate the client_id, client_secret and the tokeninfo uri in the application.yml file as provided
  3. The resource server will use this information to communication to the authorization server 
     to authorize the client app to access the resources
  4. Repeat the same step for resorce server 2 but change the resource url and the output


3. Create a client to cosume resources from resource servers

    1. Create a spring boot client application by downlaoding the pom.xml file
    2. Provide the baseUrl for the 2 resource servers in the application.yml file
    3. Provide client_id, client_secret and the accessTokenUri for the client app to obtain access token from the Authorization server
    4. Provide an user name and password for spring security login
    
    
#Steps

1. The Authorization Server runs in Okta
2. Resource Server App 1 runs in http://localhost:8080 (This url cannot be accessed due to Authorization)
3. Resource Server App 2 runs in http://localhost:8081 (This url cannot be accessed due to Authorization)
4. Oauth Client App 1 runs in http://localhost:8083
5. Access the url http://localhost:8083/getResource1 to hit the resource server 1.
6. The client app will communicate with authorization server by providing the client_id and client_secret and the scope
7. The authorization server authenticates the client app and sends the access token to the client app
8. The client app will use this access token to communicate with the resource server
9. The Resource Server will communicate with the authorization server  by providing the client_id, client_secret and the access token
10. Once the authorization server verifies the access token and sends the response to the resource server, it checks the scope and 
    provides the resource to the client app
11. The same steps are repeated for the Resource server when you hit the uri http://localhost:8083/getResource2
12. Spring security handles all the steps in the backend by using spring-security-oauth2-autoconfigure. 
13. Developer has to write very few lines of code to achieve this


<img width="1000" alt="API Architecture" src="https://github.com/dineschandgr/spring_security_OAuth2_Okta/blob/master/Oauth2_client_credentials.bmp">
