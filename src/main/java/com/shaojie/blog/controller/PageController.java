package com.shaojie.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ShaoJie
 * @Date 2019/10/7
 */
@Controller
public class PageController {

    /**
     * 查看技术文章页面
     *
     * @return
     */
    @GetMapping(value = "/detail")
    public String detail() {
        return "detail";
    }

}
