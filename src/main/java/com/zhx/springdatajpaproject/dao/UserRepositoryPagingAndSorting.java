package com.zhx.springdatajpaproject.dao;

import com.zhx.springdatajpaproject.entity.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * PagingAndSortingRepository接口
 * 前言：该接口提供了分页与排序的操作，该接口继承了CrudRepository
 *
 * UserRepositoryPagingAndSortingTest  测试包下的测试类
 */
public interface UserRepositoryPagingAndSorting extends PagingAndSortingRepository<Users,Integer> {
}
