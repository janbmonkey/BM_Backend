package com.example.BM_Backend;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="USER")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="NAME", length=50, nullable=false, unique=true)
    private String name;

    @Column(name="EMAIL", length=50, nullable=false, unique=false)
    private String email;
}
