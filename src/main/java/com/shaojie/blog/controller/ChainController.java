package com.shaojie.blog.controller;

import com.shaojie.blog.dao.ChainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ShaoJie
 * @Date 2019/10/10
 */
@Controller
public class ChainController {

    @Autowired
    private ChainRepository chainRepository;

    /**
     * 友链
     *
     * @return
     */
    @GetMapping(value = "/chain")
    public String china(Model model) {
        model.addAttribute("chain", chainRepository.queryAll());
        return "chain";
    }

}
