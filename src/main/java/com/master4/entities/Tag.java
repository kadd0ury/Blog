package com.master4.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tags")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = false, unique = true, length = 150)
	@NotNull(message = "le titre doit etre non NULLE ")
	@NotEmpty(message = "le titre doit etre non VIDE")
	@Size(min = 3, message = "{le titre doit contient au minimum 3 charactere}")
	private String title;

	@Column(name = "created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name = "modified")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	@ManyToMany(mappedBy = "tagList")
	List<Article> ArticleList;

	@Transient
	private Boolean used;

	public Tag(long id) {
		this.id = id;
	}
}
