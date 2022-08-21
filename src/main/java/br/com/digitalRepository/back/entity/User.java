package br.com.digitalRepository.back.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.digitalRepository.back.entity.enums.RoleType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author Franciuíne Almeida (franciuine.almeida@ecomp.ufsm.br)
 * @version Jun 6, 2022
 */

@Entity
@Table(name = "users")
public class User{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
	private Long id;
	private String name;
	private String username;
	private String password;
	private RoleType role;
	private String token;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	public RoleType getRole() {
		return role;
	}

	public boolean getIsAdmin()
	{
		return this.role == RoleType.ROLE_ADMIN;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRole(RoleType role) {
		this.role = role;
	}

	@Transient
	public String getToken() {
		return token;
	}

	public void setToken(String generateToken) {
		this.token = generateToken;

	}

	public void setPassword(String password) {
		this.password = password;

	}	
	
}