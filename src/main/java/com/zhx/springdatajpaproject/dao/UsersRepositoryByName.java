package com.zhx.springdatajpaproject.dao;

import com.zhx.springdatajpaproject.entity.Users;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Repository接口的方法名称命名查询
 *
 * Repository接口使用
 * 1、提供了方法名称命名方式
 * 持久层接口编写：
 *
 * UsersRepositoryByNameTest   测试包下的测试类
 */
public interface UsersRepositoryByName extends Repository<Users, Integer> {
    //方法名称必须要遵循驼峰式命名规则。findBy(关键字)+属性名称(首字母要大写)+查询条件
    /**
     * idea有提示 很方便 直接写 方法名 就可以 会有提示
     */

    /**
     * 通过name查询人名
     *
     * @param name
     * @return
     */
    List<Users> findByName(String name);

    /**
     * 通过name和age，都满足的数据
     *
     * @param name
     * @param age
     * @return
     */
    List<Users> findByNameAndAge(String name, Integer age);


    /**
     * 查询like name
     * 测试的参数可以是{"zhang%","%zhang%"}
     * 测试的参数如果是{"zhang"},意味着精确查找name为zhang的数据
     *
     * @param name
     * @return
     */
    List<Users> findByNameLike(String name);

    /**
     * 查询以name开头的，满足条件的数据
     *
     * @param name
     * @return
     */
    List<Users> findByNameStartsWith(String name);

    /**
     * 查询以name结尾的数据
     *
     * @param name
     * @return
     */
    List<Users> findByNameEndingWith(String name);

}
