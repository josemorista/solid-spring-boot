package br.com.springboot.modules.users.infra.pg.repositories;

import java.util.List;
import java.util.Date;

import com.fasterxml.uuid.Generators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import br.com.springboot.modules.users.dtos.CreateUserDTO;
import br.com.springboot.modules.users.entities.User;
import br.com.springboot.modules.users.infra.pg.entities.UserEntity;
import br.com.springboot.modules.users.repositories.IUsersRepository;

@Component
public class UsersRepository implements IUsersRepository {

	private interface JpaUsersRepository extends JpaRepository<UserEntity, String> {
	}

	@Autowired
	private JpaUsersRepository repository;

	@Override
	public User create(CreateUserDTO data) {
		UserEntity user = new UserEntity(Generators.randomBasedGenerator().generate().toString(), data.firstname,
				data.lastname, new Date(), new Date());
		this.repository.save(user);
		return user;
	}

	@Override
	public List<User> all() {
		List users = this.repository.findAll();
		return users;
	}

	@Override
	public User findById(String id) {
		User user = this.repository.getById(id);
		return user;
	}

}
