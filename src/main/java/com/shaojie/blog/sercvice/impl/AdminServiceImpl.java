package com.shaojie.blog.sercvice.impl;

import com.shaojie.blog.dao.AdminRepository;
import com.shaojie.blog.model.Admin;
import com.shaojie.blog.sercvice.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ShaoJie
 * @Date 2019/11/18
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin findByNameAndPassword(String name, String password) {
        return adminRepository.findByNameAndPassword(name ,password);
    }
}
