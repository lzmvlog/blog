package com.shaojie.blog.dao;

import com.shaojie.blog.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ShaoJie
 * @Date 2019/11/18
 */
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    /**
     * 管理员登录
     *
     * @param name
     * @param password
     * @return
     */
    Admin findByNameAndPassword(String name, String password);

}
