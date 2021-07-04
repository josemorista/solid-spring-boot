package br.com.springboot.modules.users.infra.pg.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.springboot.modules.users.entities.User;

@Entity
@Table(name = "users")
public class UserEntity extends User {
	@Id
	private String id;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

	public UserEntity(String id, String firstname, String lastname, Date createdAt, Date updatedAt) {
		super(id, firstname, lastname, createdAt, updatedAt);
	}
}
