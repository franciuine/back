package br.com.digitalRepository.back.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.digitalRepository.back.audit.AuditUserDate;
import br.com.digitalRepository.back.entity.enums.RoleType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author Franciuíne Almeida (franciuine.almeida@ecomp.ufsm.br)
 * @version Jun 6, 2022
 */

@Data
@Entity
@Table(name = "users")
public class User extends AuditUserDate {

	private Long id;
	private String name;
	private String username;
	private String password;
	private RoleType role;
	private String token;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@Column(nullable = false, length = 100)
	public String getName() {
		return name;
	}

	@Column(unique = true, nullable = false, length = 20)
	public String getUsername() {
		return username;
	}

	@Column(nullable = false)
	public String getPassword() {
		return password;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 15)
	public RoleType getRole() {
		return role;
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