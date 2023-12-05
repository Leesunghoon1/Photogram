package com.cos.photogramstart.domain.user;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.cos.photogramstart.domain.image.Image;

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
	
	@Column(length = 20, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String name;
	
	private String website;
	
	private String bio;
	@Column(nullable = false)
	private String email;
	
	private String phone;
	
	private String gender;
	
	
	private String profilelmageUrl;
	
	private String role; //권한 
	
	
	// 나는 연관관계의 주인이 아니다, 그러므로 테이블에 컬럼을 만들지마
	// user를 select 할때 해당 User id 로 등록된 image들을 다 가져와
	// Lazy일때는 User을 select 할 때 해당 User id로 등록된 image를 가져오지 - 대신 getImages()함수가 호출될 대 가져와
	// Eager =  User을 select 할 때 해당 User id로 등록된 image를 전부 join해서 가져와!
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Image> images; //양방향 매핑
	
	private LocalDateTime createDate;
	
	
	
	
	@PrePersist //디비에 insert 되기 직전에 실행
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}
	
}
