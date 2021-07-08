package br.com.springboot.modules.users.useCases;

import org.springframework.http.HttpStatus;

import br.com.springboot.modules.users.entities.User;
import br.com.springboot.modules.users.repositories.IUsersRepository;
import br.com.springboot.shared.exceptions.ApiError;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetUserByIdUseCase {
	private IUsersRepository usersRepository;

	public User execute(String id) {
		User user = this.usersRepository.findById(id);
		if (user == null)
			throw new ApiError(HttpStatus.NOT_FOUND, "User not found");
		return user;
	}
}
