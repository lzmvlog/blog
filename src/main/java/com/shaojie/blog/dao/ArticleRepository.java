package com.shaojie.blog.dao;

import com.shaojie.blog.model.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ShaoJie
 * @Date 2019/10/9
 */
@Repository
@Transactional
@RepositoryDefinition(domainClass = Article.class, idClass = Integer.class)
public interface ArticleRepository {

    /**
     * 根据类型查询 Article
     *
     * @param type 文章类型
     * @return
     */
    List<Article> queryAllByType(Integer type);

    /**
     * 查询所有的文章
     *
     * @return
     */
    @Query(value = "SELECT article.id,article.context,article.create_time,article.msg_num,article.remark,article.see_num,article.theme,article.type FROM article ",nativeQuery = true)
    List<Article> queryAllArticle();

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
    @Query(value = "UPDATE article SET see_num = see_num + 1 WHERE theme = :theme ", nativeQuery = true)
    Integer updateSeeNum(String theme);

}
