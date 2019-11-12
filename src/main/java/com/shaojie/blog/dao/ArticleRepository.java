package com.shaojie.blog.dao;

import com.shaojie.blog.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author ShaoJie
 * @Date 2019/10/9
 */
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    /**
     * 根据类型查询 Article
     *
     * @param type 文章类型
     * @return
     */
    Page<Article> queryAllByType(Integer type, Pageable pageable);

    /**
     * 根据标题查看文章资讯
     *
     * @param theme
     * @return
     */
    Article queryAllByTheme(String theme);

    /**
     * 更新查看人数
     *
     * @param theme
     * @return
     */
    @Modifying
    @Query(value = "update article set see_num = see_num + 1 where theme = :theme ", nativeQuery = true)
    Integer updateSeeNum(String theme);

}
