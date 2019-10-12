package com.shaojie.blog.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author ShaoJie
 * @Date 2019/10/10
 */
@Entity
@Data
@Table(name = "chain")
public class Chain {

    /**
     * 友链id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 友链地址
     */
    @Column(name = "url",length = 100)
    private String url;

    /**
     * 友链昵称
     */
    @Column(name = "nickname",length = 100)
    private String nickname;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    public Chain() {
    }

    public Chain(String url, String nickname) {
        this.url = url;
        this.nickname = nickname;
    }

}
