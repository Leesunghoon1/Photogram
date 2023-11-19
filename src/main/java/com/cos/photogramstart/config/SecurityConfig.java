package com.cos.photogramstart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // 해당 파일로 시큐리티를 활성화
@Configuration // IOC    
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		super.configure(http); 이게 있어서 로그인 페이지로 가로채감 지워야지 기존 시큐리티가 가지고 있는 기능이 다 비활성화됨.
		http.csrf().disable();
		
		http.authorizeRequests()
		.antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**").authenticated() //인증이 필요한 로그인
		.anyRequest().permitAll()
		.and()
		.formLogin() //form 로그인 할껀데
		.loginPage("/auth/signin") //이쪽으로 자동으로 가게하곘다.
		.defaultSuccessUrl("/"); //로그인을 정상 처리되면 / 로 가겠다
		
		
	}
}
