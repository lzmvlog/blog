package com.shaojie.blog.dao;

import com.shaojie.blog.model.Chain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ShaoJie
 * @Date 2019/10/10
 */
@Repository
@Transactional
@RepositoryDefinition(domainClass = Chain.class, idClass = Integer.class)
public interface ChainRepository {

    /**
     * 查询友链
     *
     * @return
     */
    @Query(value = "SELECT id,url,nickname,remark FROM chain",nativeQuery = true)
    List<Chain> queryAll();

}
