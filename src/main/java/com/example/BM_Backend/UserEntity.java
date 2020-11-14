package com.example.BM_Backend;

import javax.persistence.*;

@Entity
@Table(name="USER")
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="NAME", length=50, nullable=false, unique=true)
    private String name;

    @Column(name="EMAIL", length=50, nullable=false, unique=false)
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //@ElementCollection
    //Set<String> userList = new HashSet<>();
}
