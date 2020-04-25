package com.master4.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name="nom", nullable = false)
    private String nom;
    
    @Column(name="prenom", nullable = false)
    private String prenom;

    @Column(name="email", nullable = false, unique = true)
    private String email;
    
    @Column(name="role", nullable = false)
    private String role;
    
    @Column(name="password", nullable = false)
    private String password;

    @Column(name="created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name="modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<Article> articles;

    public User(long id) {
        this.id=id;
    }
}
