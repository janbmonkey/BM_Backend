package com.example.BM_Backend;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    UserService(){
        System.out.println("Ctor UserService");
    }

    @Transactional
    public UserEntity getUser(long id) {
        return entityManager.find(UserEntity.class, id);
    }

    @Transactional
    public void setUser(long id, UserEntity userEntity){
        UserEntity userRef = entityManager.getReference(UserEntity.class, id);
        userRef = userEntity;
    }

    @Transactional
    public void addUser(UserEntity userEntity){
        entityManager.persist(userEntity);
    }
}
