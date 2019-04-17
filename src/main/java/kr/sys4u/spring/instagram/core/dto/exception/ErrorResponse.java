package kr.sys4u.spring.instagram.core.dto.exception;

import lombok.Data;

@Data
public class ErrorResponse {
	private String message;
	private boolean successed;
	private Object payload;
}
