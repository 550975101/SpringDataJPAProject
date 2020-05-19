package com.zhx.springdatajpaproject;

import com.zhx.springdatajpaproject.dao.UsersRepositoryByName;
import com.zhx.springdatajpaproject.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UsersRepositoryByNameTest {

    @Autowired
    private UsersRepositoryByName usersRepositoryByName;

    //通过name查询人名
    @Test
    public void findByName() {
        List<Users> list = usersRepositoryByName.findByName("zhangdan");
        for (Users u : list) {
            System.out.println(u);
        }
    }

    //通过name和age，都满足的数据
    @Test
    public void findByNameAndAge() {
        List<Users> list = usersRepositoryByName.findByNameAndAge("zhangdan", 25);
        for (Users u : list) {
            System.out.println(u);
        }
    }

    //查询一zhang开头的name
    @Test
    public void findByNameLike() {
        List<Users> list = usersRepositoryByName.findByNameLike("zhang");
        for (Users u : list) {
            System.out.println(u);
        }
    }

    //查询以name开头的，满足条件的数据
    @Test
    public void findByNameStartsWith() {
        List<Users> list = usersRepositoryByName.findByNameStartsWith("zhang");
        for (Users u : list) {
            System.out.println(u);
        }
    }

    //查询以name结尾的数据
    @Test
    public void findByNameEndingWith() {
        List<Users> list = usersRepositoryByName.findByNameEndingWith("n");
        for (Users u : list) {
            System.out.println(u);
        }
    }


}
