package com.cos.photogramstart.domain.subscribe;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cos.photogramstart.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@AllArgsConstructor //전체 생성자
@NoArgsConstructor //기본생성자
@Data
@Entity // 디비에 테이블을 생성
@Table(
		uniqueConstraints = {
				@UniqueConstraint(
					name="subscribe_uk",
					columnNames = {"fromUserId", "toUserId"}
					)
		}
		) //unique 제약조건 걸기
public class Subscribe {

	@Id // 프라이머리키
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 데이터베이스를 따라간다.
	private int id;
	
	
	@JoinColumn(name = "fromUserId") //이렇게 컬럼명 만들어! 니맘대로 만들지 말고!! 
	@ManyToOne // 1:n 관계의 유저가 1이니까 이렇게 적으면 알아서 테이블 생성해줌 
	private User fromUser;
	
	@JoinColumn(name = "toUserId")
	@ManyToOne
	private User toUser;


	private LocalDateTime createDate;
	

	@PrePersist //디비에 insert 되기 직전에 실행
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}
	
}
