package com.zhx.springdatajpaproject.dao;

import com.zhx.springdatajpaproject.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 集成JpaRepository接口泛型第一个参数是实体类 第二个是实体类的主键类型
 *
 * Spring Data JPA 提供的核心接口
 * 1、Repository接口
 * 2、CrudRepository接口
 * 3、PagingAndSortingRepository接口
 * 4、JpaRepository接口
 * 5、JpaSpecificationExecutor接口
 *
 * UsersRepositoryTest 测试包下的测试类
 */
public interface UsersRepository extends JpaRepository<Users,Integer> {
}
