/**
 * 
 */
package br.gov.fazenda.mg.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author claudiney.viana
 *
 */
@Service
public class UserService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		return null;
	}

}
