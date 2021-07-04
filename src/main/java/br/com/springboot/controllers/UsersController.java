package br.com.springboot.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.modules.users.dtos.CreateUserDTO;
import br.com.springboot.modules.users.entities.User;
import br.com.springboot.modules.users.repositories.IUsersRepository;

@RestController
@RequestMapping("/users")
public class UsersController {

	private IUsersRepository usersRepository;

	@GetMapping("/")
	public List<User> index() {
		return this.usersRepository.all();
	}

	@GetMapping("/{id}")
	public User show(@PathVariable("id") String id) {
		return this.usersRepository.findById(id);
	}

	@PostMapping("/")
	public User store(@RequestBody CreateUserDTO body) {
		return this.usersRepository.create(body);
	}
}