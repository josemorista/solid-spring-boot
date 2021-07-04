package br.com.springboot.modules.users.repositories;

import java.util.ArrayList;

import br.com.springboot.modules.users.dtos.CreateUserDTO;
import br.com.springboot.modules.users.entities.User;

public interface IUsersRepository {
	User create(CreateUserDTO data);

	ArrayList<User> all();

	User findById(String id);
}
