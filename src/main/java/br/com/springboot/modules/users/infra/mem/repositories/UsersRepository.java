package br.com.springboot.modules.users.infra.mem.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import br.com.springboot.modules.users.dtos.CreateUserDTO;
import br.com.springboot.modules.users.entities.User;
import br.com.springboot.modules.users.repositories.IUsersRepository;

public class UsersRepository implements IUsersRepository {

	static UsersRepository instance = null;
	private ArrayList<User> users;

	private UsersRepository() {
		this.users = new ArrayList<>();
	}

	static public UsersRepository getInstance() {
		if (UsersRepository.instance == null) {
			instance = new UsersRepository();
		}
		return instance;
	}

	@Override
	public User create(CreateUserDTO data) {
		User user = new User(Integer.toString(1 + this.users.size()), data.firstname, data.lastname, new Date(),
				new Date());
		this.users.add(user);
		return user;
	}

	@Override
	public ArrayList<User> all() {
		return this.users;
	}

	@Override
	public User findById(String id) {
		Optional<User> user = (this.users.stream().filter(el -> el.getId().equals(id)).findFirst());
		if (user.isPresent())
			return user.get();
		return null;
	}

}
