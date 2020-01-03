package com.shaojie.blog.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ShaoJie
 * @Date 2019/10/9
 */
@Entity
@Data
@Table(name = "article")
public class Article {

    /**
     * 文章的id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 文章的主题
     */
    @Column(name = "theme", length = 100)
    private String theme;

    /**
     * 文章的内容
     */
    @Column(name = "context", columnDefinition = "mediumtext")
    private String context;

    /**
     * 文章创建的时间
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 查看的次数
     */
//    @Column(name = "see_num")
//    private Integer seeNum;

    /**
     * 文章类型
     * 1、技术
     * 2、随笔
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    public Article() {
    }

}
