package com.shaojie.blog.sercvice;

import com.shaojie.blog.model.Article;
import org.springframework.data.domain.Page;

/**
 * @author ShaoJie
 * @Date 2019/11/12
 */
public interface ArticleService {
//
//    /**
//     * 查询所有文章
//     *
//     * @param pageNum
//     * @param pageSize
//     * @return
//     */
//    Page<Article> listArticle(int pageNum, int pageSize);

    /**
     * 根据类型查询 Article
     *
     * @param type 文章类型
     * @return
     */
    Page<Article> queryAllByType(Integer type, int pageNum, int pageSize);


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
    Integer updateSeeNum(String theme);

}
