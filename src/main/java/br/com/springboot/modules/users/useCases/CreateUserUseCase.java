package br.com.springboot.modules.users.useCases;

import org.springframework.http.HttpStatus;

import br.com.springboot.modules.users.dtos.CreateUserDTO;
import br.com.springboot.modules.users.entities.User;
import br.com.springboot.modules.users.repositories.IUsersRepository;
import br.com.springboot.shared.exceptions.ApiError;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateUserUseCase {
	private IUsersRepository usersRepository;

	public User execute(CreateUserDTO data) {
		if (data.firstname == null || data.lastname == null) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Missing body parameter");
		}
		return this.usersRepository.create(data);
	}
}
