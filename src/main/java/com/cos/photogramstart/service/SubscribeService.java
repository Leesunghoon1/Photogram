package com.cos.photogramstart.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.subscribe.SubscribeRepository;
import com.cos.photogramstart.handler.ex.CustomApiException;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class SubscribeService {
	
	private final SubscribeRepository subscribeRepository;
	
	
	@Transactional //데이터베이스에 영향을 주면 트렌젝션 겅러주는게 좋음
	public void 구독하기(int fromUserId, int toUserId) {
		try {
			subscribeRepository.mSubscribe(fromUserId, toUserId);
		} catch (Exception e) {
			throw new CustomApiException("이미 구독을 하였습니다.");
		}
	}
	
	@Transactional
	public void 구독취소하기(int fromUserId, int toUserId) {
		subscribeRepository.mUnSubscribe(fromUserId, toUserId);
	}
}
