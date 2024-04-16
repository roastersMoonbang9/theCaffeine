package com.theCaffeine.mes.scrt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.theCaffeine.mes.comm.user.model.EnterpriseVO;

import lombok.Data;

@Data
public class CustomUserDetails implements UserDetails {
	
	private EnterpriseVO enterVO;
	
	public CustomUserDetails(EnterpriseVO enterVO) {
		this.enterVO = enterVO;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authlist = new ArrayList<>();
		authlist.add(new SimpleGrantedAuthority(enterVO.getAuthNo()));
		return authlist;
	}

	@Override
	public String getPassword() {
		return "{noop}" + enterVO.getPw();
	}

	@Override
	public String getUsername() {
		return enterVO.getId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}