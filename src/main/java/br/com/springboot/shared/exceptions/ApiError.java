package br.com.springboot.shared.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiError extends RuntimeException {
	private HttpStatus status;
	private String message;

	private class ErrorResponseBody {
		private String error;

		public String getError() {
			return error;
		}

		public ErrorResponseBody(String error) {
			this.error = error;
		}
	}

	public ErrorResponseBody getResponseBody() {
		return new ErrorResponseBody(this.message);
	}

}
