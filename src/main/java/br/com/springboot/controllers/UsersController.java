package br.com.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.modules.users.dtos.CreateUserDTO;
import br.com.springboot.modules.users.entities.User;
import br.com.springboot.modules.users.repositories.IUsersRepository;
import br.com.springboot.modules.users.useCases.CreateUserUseCase;
import br.com.springboot.modules.users.useCases.GetUserByIdUseCase;
import br.com.springboot.shared.exceptions.ApiError;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private IUsersRepository usersRepository;

	@GetMapping("/")
	public List<User> index() {
		return this.usersRepository.all();
	}

	@GetMapping("/{id}")
	public User show(@PathVariable("id") String id) {
		return (new GetUserByIdUseCase(this.usersRepository).execute(id));
	}

	@PostMapping("/")
	public User store(@RequestBody CreateUserDTO body) {
		return (new CreateUserUseCase(usersRepository).execute(body));
	}

	@ExceptionHandler(ApiError.class)
	public ResponseEntity<String> handleApiError(ApiError exception) {
		return ResponseEntity.status(exception.getStatus()).body(exception.getMessage());
	}
}