package com.cmv.borusan.model.entity;

import com.cmv.borusan.model.base.ExtendedModel;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends ExtendedModel {
    @Column(name = "username",length = 60,unique = true)
    private String username;

    private String password;

    @Column(name = "name_surname")
    private String nameSurname;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    //Todo db'ye bak kolon isimleri neler
}
