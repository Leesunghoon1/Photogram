package com.cos.photogramstart.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//JPA - Java Persistence API(DB)자바로 데이터를 영구적으로 저장할 수 있는 API를 제공)


@Builder
@AllArgsConstructor //전체 생성자
@NoArgsConstructor //기본생성자
@Data
@Entity // 디비에 테이블을 생성
public class User {
	
	@Id //프라이머리키
	@GeneratedValue(strategy = GenerationType.IDENTITY) //번호 증가 전략이 데이터베이스를 따라간다.
	private int id;
	
	private String username;
	
	private String password;
	
	private String name;
	
	private String website;
	
	private String bio;
	
	private String email;
	
	private String phone;
	
	private String gender;
	
	
	private String profilelmageUrl;
	
	private String role; //권한 
	
	
	private LocalDateTime createDate;
	
	
	
	
	@PrePersist //디비에 insert 되기 직전에 실행
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}
	
}