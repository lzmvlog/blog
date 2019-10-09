package com.shaojie.blog.controller;

import com.shaojie.blog.dao.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ShaoJie
 * @Date 2019/10/9
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 访问首页
     *
     * @return
     */
    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("index", articleRepository.queryAllByType(1));
        return "index";
    }

    /**
     * 文章详情
     *
     * @return
     */
    @GetMapping(value = "/detail/{theme}")
    public String detail(Model model, @PathVariable(value = "theme") String theme) {
        articleRepository.updateSeeNum(theme);
        model.addAttribute("det", articleRepository.queryAllByTheme(theme));
        return "detail";
    }

    /**
     * 技术
     *
     * @return
     */
    @GetMapping(value = "/skill")
    public String skill(Model model) {
        model.addAttribute("skill", articleRepository.queryAllByType(2));
        return "skill";
    }

    /**
     * 随笔
     *
     * @return
     */
    @GetMapping(value = "/vlog")
    public String vlog(Model model) {
        model.addAttribute("vlog", articleRepository.queryAllByType(3));
        return "vlog";
    }

}
