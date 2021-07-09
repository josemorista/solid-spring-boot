package br.com.springboot.shared.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorResponse {
	public String message;
	public HttpStatus status;
}
