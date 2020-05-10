package com.master4.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Login {
	@Size(min = 3, message = "{le titre doit contient au minimum 3 charactere}")
	@NotNull(message = "title cannot be left empty")
	@NotEmpty(message = "the title cannot be empty")
	String username;
	@Pattern(regexp = "((?=.*[A-Z]).{6,10})", message = "\r\n"
			+ "Le mot de passe doit avoir une majuscule, une minuscule et doit comprendre entre 6 et 10 caractères")
	String password;

}
