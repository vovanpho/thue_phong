package com.example.demo.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.entity.impl.UserDetailsImpl;

public class SpringSecurityAuditorAwareImpl implements AuditorAware<String>{

	
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication==null||!authentication.isAuthenticated()) {
			return Optional.of("anonymous");
		}
		return Optional.of(((UserDetailsImpl) authentication.getPrincipal()).getUsername());
	}

}
