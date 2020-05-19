package com.zhx.springdatajpaproject;

import com.zhx.springdatajpaproject.dao.UsersJpaRepository;
import com.zhx.springdatajpaproject.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class UsersJpaRepositoryTest {

    @Autowired
    private UsersJpaRepository usersJpaRepository;

    @Test
    public void save() {
        Users u = new Users();
        u.setName("zhangsan");
        u.setAge(22);
        u.setAddress("zhongguohaidian");
        usersJpaRepository.save(u);
    }

    /**
     * RepositoryPagingAndSorting 接口排序
     */
    @Test
    public void pagingAndSorting() {
        //order 定义排序规则
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        //sort对象封装了排序规则
        Sort sort = Sort.by(order);
        List<Users> list = usersJpaRepository.findAll(sort);
        for (Users users : list) {
            System.out.println(users);
        }
    }
}
