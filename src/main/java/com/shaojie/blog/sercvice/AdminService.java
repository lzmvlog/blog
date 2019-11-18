package com.shaojie.blog.sercvice;

import com.shaojie.blog.model.Admin;

/**
 * @author ShaoJie
 * @Date 2019/11/18
 */
public interface AdminService {

    /**
     * 管理员登录
     *
     * @param name
     * @param password
     * @return
     */
    Admin findByNameAndPassword(String name, String password);

}
