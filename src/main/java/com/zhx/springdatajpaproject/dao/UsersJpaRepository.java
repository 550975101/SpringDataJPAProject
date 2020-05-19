package com.zhx.springdatajpaproject.dao;

import com.zhx.springdatajpaproject.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository接口
 * 前言：该接口继承了PagingAndSortingRepository接口。对继承的父接口中方法的返回值进行适配。
 * 例如：父接口中的方法的返回值是是迭代器，而在子类(JpaRepository)返回值是Lis集合。
 *
 * 这个接口 其实就够用了单表的操作几乎都有
 */
public interface UsersJpaRepository extends JpaRepository<Users,Integer> {
}
