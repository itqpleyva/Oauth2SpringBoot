# OAuth2Example
<p>Three endpoints are provided</p>

<ul>
<li>http://localhost:8081/</li>
<li>http://localhost:8081/user</li>
<li>http://localhost:8081/secured</li>
</ul>

<p>The last endpoint is secured using Facebook autentication</p>

<p>The main dependencies:</p>


		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-oauth2-client</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
    
  <p>Application.properties file:</p>
  
    spring:
    security:
      oauth2:
        client:
          registration:
            facebook:
              client-id: 609915459871136 // facebook app id
              client-secret: 44e4d8eb49584adc628505d7135a1921 // facebook secret key
    server:
      port: 8081
