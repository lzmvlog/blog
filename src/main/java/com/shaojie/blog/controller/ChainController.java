package com.shaojie.blog.controller;

import com.shaojie.blog.sercvice.impl.ChainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ShaoJie
 * @Date 2019/10/10
 */
@Controller
public class ChainController {

     @Autowired
     private ChainServiceImpl chainService;

    /**
     * 友链
     *
     * @return
     */
    @GetMapping(value = "/chain")
    public String china(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        model.addAttribute("chain", chainService.listChin(pageNum, pageSize));
        return "chain";
    }

}
