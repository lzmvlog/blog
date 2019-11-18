package com.shaojie.blog.controller;

import com.shaojie.blog.model.Admin;
import com.shaojie.blog.sercvice.impl.AdminServiceImpl;
import com.shaojie.blog.sercvice.impl.ArticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ShaoJie
 * @Date 2019/11/18
 */
@Controller
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private ArticeServiceImpl articeService;

    @GetMapping("/ShaoJie/admin/login")
    public String index() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "name") String name, @RequestParam(name = "password") String password) {
        Admin ShaoJie = adminService.findByNameAndPassword(name, password);
        if (ShaoJie == null) {
            return "admin/login";
        } else {
            return "admin/index";
        }
    }

    @GetMapping("/article-list.html")
    public String articleList(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        model.addAttribute("article", articeService.listArticle(pageNum, pageSize));
        return "admin/article-list";
    }


    @GetMapping("/article-add.html")
    public String articleAdd() {
        return "admin/article-add";
    }

}
