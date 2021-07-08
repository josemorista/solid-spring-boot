package br.com.springboot.modules.users.infra.pg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.modules.users.entities.User;

public interface JpaUsersRepository extends JpaRepository<User, String> {
}