package br.gov.fazenda.mg.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
	/*@Autowired    
    private UserDetailServiceImpl userDetailsService;	*/
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
    	.antMatchers("/","/login", "/logout", "/auth", "/resources/**").permitAll()
    	.antMatchers("/app/**").permitAll()
    	.antMatchers("/ConsultaNFeForm").permitAll()
    	//.antMatchers("/pages/*").hasRole("USERS").anyRequest().permitAll()
    	.and()
    	.formLogin()
    		.loginPage("/login").failureUrl("/login?error") 
    		.loginProcessingUrl("/j_spring_security_check")    		
    		.defaultSuccessUrl("/pages/*")    		   		
    		.usernameParameter("username").passwordParameter("password")    		
		.and()
			.logout().logoutSuccessUrl("/")
		.and()
			.csrf().disable();
		
    	
		/*http
		.authorizeRequests()
			.antMatchers("/", "/public/**").permitAll() 
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.defaultSuccessUrl("/login", true)
			.permitAll()
			.and()
		.httpBasic()
			.and()
		.csrf().disable()
		.logout()
			.logoutSuccessUrl("/");*/
    }   
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());    	
    	//auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    	auth.inMemoryAuthentication().withUser("user").password("123456").roles("USERS");
    }       
}