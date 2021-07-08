package br.com.springboot.modules.users.infra.pg.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Date;

import com.fasterxml.uuid.Generators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.springboot.modules.users.dtos.CreateUserDTO;
import br.com.springboot.modules.users.entities.User;
import br.com.springboot.modules.users.repositories.IUsersRepository;

@Component
public class UsersRepository implements IUsersRepository {

	@Autowired
	private JpaUsersRepository repository;

	@Override
	public User create(CreateUserDTO data) {
		User user = new User(Generators.randomBasedGenerator().generate().toString(), data.firstname, data.lastname,
				new Date(), new Date());
		this.repository.save(user);
		return user;
	}

	@Override
	public List<User> all() {
		List<User> users = this.repository.findAll();
		return users;
	}

	@Override
	public User findById(String id) {
		Optional<User> user = this.repository.findById(id);
		if (!user.isPresent()) {
			return null;
		}
		return user.get();
	}

}
