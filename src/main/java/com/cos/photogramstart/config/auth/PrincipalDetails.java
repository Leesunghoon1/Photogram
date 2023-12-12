package com.cos.photogramstart.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;


@Data
public class PrincipalDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private User user;
	public PrincipalDetails(User user) {
		this.user = user;
	}

	//권한이라는게 한개가 아닐 수 있음.(3개 이상의 권한)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collector = new ArrayList<>();
		collector.add(() -> { return user.getRole();});
		return collector;
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {

		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		//계정만료 ?
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		//락?
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		//비밀번호가 만료 ?
		return true;
	}

	@Override
	public boolean isEnabled() {
		//로그인 안한 기간 ?
		return true;
	}

}
