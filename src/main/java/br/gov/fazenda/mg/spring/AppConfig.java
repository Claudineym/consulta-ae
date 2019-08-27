/**
 * 
 */
package br.gov.fazenda.mg.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author claudiney.viana
 *
 */
@Configuration
//@EnableJpaRepositories("br.gov.fazenda.mg.repository")
//@EnableTransactionManagement(proxyTargetClass = true)
public class AppConfig  {
	
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        // Create an encoder with strength 31
        // values from 4 .. 31 are valid; the higher the value, the more work has to be done to calculate the hash
        return new BCryptPasswordEncoder(12);
    }
	
}
