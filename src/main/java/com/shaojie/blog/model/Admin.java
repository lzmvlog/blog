package com.shaojie.blog.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author ShaoJie
 * @Date 2019/11/18
 */
@Entity
@Data
@Table(name = "admin")
public class Admin {

    /**
     * 管理账号id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 管理账号
     */
    @Column(name = "name")
    private String name;

    /**
     * 管理密码
     */
    @Column(name = "password")
    private String password;

}
