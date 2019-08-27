package br.gov.fazenda.mg.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.fazenda.mg.domain.User;

/**
 * This class is used by spring security to authenticate and authorize user
 **/
@Service("userDetailsService")
@Transactional(readOnly = true)
public class UserDetailServiceImpl implements UserDetailsService  {
	
	/*private final UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	UserDetailServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    } */
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
    	User curruser = new User();
    	curruser.setPasswordHash("123456");
    	curruser.setUsername("admin");
    	curruser.setRole("USERS");
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }	  
} 