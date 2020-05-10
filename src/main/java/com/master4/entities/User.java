package com.master4.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nom", nullable = false)
	@NotNull(message = "the name cannot be null")
	@NotEmpty(message = "the name cannot be empty")
	@Size(min = 3, message = "{le nom doit contient au minimum 3 charactere}")

	private String nom;

	@Column(name = "prenom", nullable = false)
	@NotNull(message = "le prenom doit etre non NULLE ")
	@NotEmpty(message = "le prenom doit etre non VIDE")
	@Size(min = 3, message = "{le prenom doit contient au minimum 3 charactere}")
	private String prenom;

	@Column(name = "email", nullable = false, unique = true)
	@Email(message = "Entrer un email valid")
	@Email(regexp = ".+@.+\\..+")
	private String email;

	@Column(name = "role", nullable = false)
	@NotNull(message = "le role doit etre non NULLE ")
	@NotEmpty(message = "le role doit etre non VIDE")
	private String role;

	@Column(name = "password", nullable = false)
	@Pattern(regexp = "((?=.*[A-Z]).{6,10})", message = "Le mot de passe doit avoir une majuscule, une minuscule et doit comprendre entre 6 et 10 caractères")
	private String password;

	@Column(name = "created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Column(name = "modified")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Article> articles;

	public User(long id) {
		this.id = id;
	}
}
