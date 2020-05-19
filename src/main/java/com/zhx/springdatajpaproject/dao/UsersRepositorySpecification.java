package com.zhx.springdatajpaproject.dao;

import com.zhx.springdatajpaproject.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 这两接口 几乎可以实现任何操作  适用于真实开发环境
 */
public interface UsersRepositorySpecification extends JpaRepository<Users,Integer>, JpaSpecificationExecutor<Users> {
}
