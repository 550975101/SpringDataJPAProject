package com.zhx.springdatajpaproject;

import com.zhx.springdatajpaproject.dao.UserRepositoryPagingAndSorting;
import com.zhx.springdatajpaproject.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

@SpringBootTest
public class UserRepositoryPagingAndSortingTest {


    @Autowired
    private UserRepositoryPagingAndSorting userRepositoryPagingAndSorting;

    /**
     * RepositoryPagingAndSorting 接口排序
     */
    //springboot2.2.1（含）以上的版本Sort已经不能再实例化了，构造方法已经是私有的了！
    //Sort的属性已有原来的public变为private了，而且我们原来的方法变更为Sort.by()
    //PageRequest的原有的属性由public变为procted
    @Test
    public void pagingAndSorting() {
        //order 定义排序规则
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        //sort对象封装了排序规则
        Sort sort = Sort.by(order);
        List<Users> list = (List<Users>) userRepositoryPagingAndSorting.findAll(sort);
//        Iterable<Users> list = userRepositoryPagingAndSorting.findAll(sort);
        for (Users users : list) {
            System.out.println(users);
        }
    }

    /**
     * RepositoryPagingAndSorting 接口 分页
     */
    @Test
    public void pagingAndSorting2() {
//      Pageable:封装了分页的参数，当前页，每页显示的条数，他的当前页是从0开始的
//      PageRequest(page,size): page 当前页  size 每页显示的条数
        //第一页 显示数量2 如果不够2条就显示应有条数
//      Pageable pageable = new PageRequest(0, 2);
        Pageable pageable = PageRequest.of(0, 2);
//        返回值Page对象
        Page<Users> page = userRepositoryPagingAndSorting.findAll(pageable);
        System.out.println("总条数:" + page.getTotalElements());
        System.out.println("总页数:" + page.getTotalPages());
        List<Users> list = page.getContent();
        for (Users users : list) {
            System.out.println(users);
        }
    }

    /**
     * RepositoryPagingAndSorting 接口 排序+分页
     */
    @Test
    public void pagingAndSorting3() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0, 2, sort);
        Page<Users> page = userRepositoryPagingAndSorting.findAll(pageable);
        System.out.println("总条数:" + page.getTotalElements());
        System.out.println("总页数:" + page.getTotalPages());
        List<Users> list = page.getContent();
        for (Users users : list) {
            System.out.println(users);
        }
    }

}
