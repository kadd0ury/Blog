package com.master4.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "articles")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "title")
	@NotNull(message = "le titre doit etre non NULLE ")
	@NotEmpty(message = "le titre doit etre non VIDE")
	@Size(min = 3, message = "{le titre doit contient au minimum 3 charactere}")
	private String title;

	@Column(name = "body")
	@Type(type = "text")
	@Size(min = 3, message = "{le body doit contient au minimum 3 charactere}")
	@NotNull(message = "title cannot be left empty")
	@NotEmpty(message = "the title cannot be empty")
	private String body;

	@Column(name = "published", columnDefinition = "int default 0")
	private Boolean published;

	@Column(name = "created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name = "modified")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	@Transient
	private int myUser;

	@ManyToOne
	private User user;

	@Size(min = 1, message = "selectionner au moins une tag")
	@ManyToMany
	@JoinTable(name = "articles_tags", joinColumns = {
			@JoinColumn(referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "id") })
	List<Tag> tagList;

}
