package com.zhx.springdatajpaproject;

import com.zhx.springdatajpaproject.dao.UserRepositoryCrudRepository;
import com.zhx.springdatajpaproject.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserRepositoryCrudRepositoryTest {

    @Autowired
    private UserRepositoryCrudRepository userRepositoryCrudRepository;

    //保存客户数据

    /**
     * 自增不传id 就是保存  传了也不按你的来 id是自增的  现在id最大5  你传个100  看看库里那条新插入的 id还是6
     */
    @Test
    public void saveUsers() {
        Users u = new Users();
        u.setName("guobin");
        u.setAge(25);
        u.setAddress("zhongguohaidian");
        userRepositoryCrudRepository.save(u);
    }

    /**
     * 自增不传id 就是保存  传了也不按你的来 id是自增的  现在id最大5  你传个100  看看库里那条新插入的 id还是6
     *
     * 如果传id  库里刚好有这个id 每次保存前
     * 他会先发一个select * from users where id = ‘5’
     *
     * 存在则更新
     * 不存在则更新  ---很垃圾
     * 垃圾在 原来数据库非空的值  这个传的实体没有这个属性的话 就设置为null
     * 就是 update users set address='', age ='' ,name where id = 5
     * 无论啥时候更新全量字段 对就这么个意思
     *
     */
    @Test
    public void updateSave() {
        Users u = new Users();
        u.setId(5);
        u.setName("guobin");
        u.setAge(25);
        u.setAddress("zhongguohaidian");
        userRepositoryCrudRepository.save(u);
    }

    /**
     * 通过id查找数据
     */
    @Test
    public void findById() {
        //jdk1.8  Optional 类 可以看看
        Optional<Users> users = userRepositoryCrudRepository.findById(5);
        System.out.println(users);
    }

    /**
     * 查询全部数据
     */
    @Test
    public void findAll() {
        Iterable<Users> list = userRepositoryCrudRepository.findAll();
        for (Users users : list) {
            System.out.println(users);
        }
    }

    /**
     * 通过id删除数据
     * 垃圾的一批  id不存在的话 就报 EmptyResultDataAccessException  No class  *** with id * exists!
     */
    @Test
    public void deleteById() {
        this.userRepositoryCrudRepository.deleteById(8);
    }

}
