package com.shaojie.blog.sercvice.impl;

import com.shaojie.blog.dao.ChainRepository;
import com.shaojie.blog.model.Chain;
import com.shaojie.blog.sercvice.ChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ShaoJie
 * @Date 2019/11/12
 */
@Service
@Transactional
public class ChainServiceImpl implements ChainService {

    @Autowired
    private ChainRepository chainRepository;

    public Page<Chain> listChin(int pageNum, int pageSize) {
        return chainRepository.findAll(PageRequest.of(pageNum, pageSize));
    }

}
