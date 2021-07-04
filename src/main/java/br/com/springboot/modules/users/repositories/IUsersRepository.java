package br.com.springboot.modules.users.repositories;

import java.util.List;

import br.com.springboot.modules.users.dtos.CreateUserDTO;
import br.com.springboot.modules.users.entities.User;

public interface IUsersRepository {
	User create(CreateUserDTO data);

	List<User> all();

	User findById(String id);
}
