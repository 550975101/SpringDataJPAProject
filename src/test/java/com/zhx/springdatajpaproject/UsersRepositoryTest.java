package com.zhx.springdatajpaproject;

import com.zhx.springdatajpaproject.dao.UsersRepository;
import com.zhx.springdatajpaproject.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void saveUser(){
        Users u = new Users();
        u.setName("zhangdan");
        u.setAge(25);
        u.setAddress("beijing");
        usersRepository.save(u);
    }

}
