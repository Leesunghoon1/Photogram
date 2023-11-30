package com.cos.photogramstart.web.dto.image;

import org.springframework.web.multipart.MultipartFile;

import com.cos.photogramstart.domain.image.Image;
import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data
public class ImageUploadDto {
	
	
	private MultipartFile File;
	private String Caption;
	
	public Image toEntity(String postImageUrl, User user) {
		return Image.builder()
				.caption(Caption)
				.postImageUrl(postImageUrl)
				.user(user)
				.build();
	}
}
