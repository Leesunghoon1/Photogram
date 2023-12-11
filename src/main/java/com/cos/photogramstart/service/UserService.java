package com.cos.photogramstart.service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;
import com.cos.photogramstart.handler.ex.CustomException;
import com.cos.photogramstart.handler.ex.CustomValidationApiException;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional(readOnly = true)
	public User 회원프로필(int userId) {
		// select * from image where userId = #{userId};
		
		User userEntity = userRepository.findById(userId).orElseThrow(()->{
			throw new CustomException("해당 프로필 페이지는 없는 페이지입니다.");
		});
		
		
		
		return userEntity;
	}
	
	@Transactional
	public User 회원수정(int id, User user) {
		//1.영속화
		User userEntity = userRepository.findById(id).orElseThrow(() -> { return new CustomValidationApiException("찾을 수 없는 id입니다.");});
		
		

		//1.무조건 찾았다 걱정마 .get() 2. 못찾았어 익셉션 발동시킬게 orElseThrow()
		
		//2.영속화된 오브젝트를 수정 -> 더티체킹 (업데이트 완료)
		userEntity.setName(user.getName());

		String rawPasswrod = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPasswrod);
		
		userEntity.setPassword(encPassword);
		userEntity.setBio(user.getBio());
		userEntity.setWebsite(user.getWebsite());
		userEntity.setPhone(user.getPhone());
		userEntity.setGender(user.getGender());
		return userEntity;
		// 더티체킹 (업데이트 완료) 가 일어남
		
	}
}
