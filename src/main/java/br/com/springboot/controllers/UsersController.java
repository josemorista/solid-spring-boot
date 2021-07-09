package br.com.springboot.controllers;

import java.util.List;

import com.google.gson.Gson;

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
//import br.com.springboot.modules.users.infra.mem.repositories.UsersRepository;
import br.com.springboot.modules.users.infra.pg.repositories.UsersRepository;
import br.com.springboot.modules.users.repositories.IUsersRepository;
import br.com.springboot.modules.users.useCases.CreateUserUseCase;
import br.com.springboot.modules.users.useCases.GetUserByIdUseCase;
import br.com.springboot.shared.exceptions.ApiError;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private IUsersRepository usersRepository;

	private static final Gson gson = new Gson();

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
		return (new CreateUserUseCase(this.usersRepository).execute(body));
	}

	@ExceptionHandler(ApiError.class)
	public ResponseEntity<String> handleApiError(ApiError exception) {
		return ResponseEntity.status(exception.getStatus()).body(UsersController.gson.toJson(exception.getResponseBody()));
	}
}