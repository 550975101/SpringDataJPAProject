package com.zhx.springdatajpaproject.dao;

import com.zhx.springdatajpaproject.entity.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * CrudRepository接口的使用
 * CrudRepository接口，主要完成一些增删改查的操作。
 * 注意：CrudRepository接口继承Repository接口
 *
 * UserRepositoryCrudRepositoryTest  测试包下的测试类
 */

public interface UserRepositoryCrudRepository extends CrudRepository<Users,Integer> {
}
