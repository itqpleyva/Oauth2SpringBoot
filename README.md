# OAuth2Example
<p>Four endpoints are provided</p>

<ul>
<li>http://localhost:8081/</li>

<li>http://localhost:8081/secured</li>

<li>http://localhost:8081/login</li>

<li>http://localhost:8081/logout</li>
</ul>

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
  <p>Security configuration:</p>
     
	@Configuration
	public class SecurityConfig extends WebSecurityConfigurerAdapter {
  	  @Override
  	  public void configure(HttpSecurity http) throws Exception {

      	  http
     	   .authorizeRequests()
      	    .antMatchers("/","/login","/logout","/webjars/**").permitAll()
    	    .anyRequest().authenticated()
		.and()
      	  .logout()
      	  .logoutUrl("/logout")
       	   .logoutSuccessUrl("/")
         	.and()
      	  .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        	.and()
      	  .oauth2Login().loginPage("/login")
      	  .authorizationEndpoint()
		.baseUri("/login/oauth2/authorization")
		;  
    }
}

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
  <p>To obtain user data and printed un secured page:</p>
  
  	@GetMapping("/secured")
   	public String secured(Principal principal, Model model) {
    	
        if (principal != null) {
        	OAuth2AuthenticationToken oAuth2Authentication = (OAuth2AuthenticationToken) principal;
        	OAuth2User authentication =  oAuth2Authentication.getPrincipal();
            model.addAttribute("user",authentication.getAttributes().get("name").toString());
        } 

        return "secured";
    }
   <p>In secured.html page:</p>
   		
	<div class="card-body">
		<h2 class="card-title">Welcome to Secured Page <span class="text-success" th:text="${user}"></span></h2>	
		<div class="mt-4">
			<a class="btn btn-danger" href="/logout">logout</a>
		</div>
	</div>
