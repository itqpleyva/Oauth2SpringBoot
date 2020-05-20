package Main;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

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
