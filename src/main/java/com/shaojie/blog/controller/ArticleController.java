package com.shaojie.blog.controller;

import com.shaojie.blog.sercvice.impl.ArticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ShaoJie
 * @Date 2019/10/9
 */
@Controller
public class ArticleController {

    /**
     * 导航类型
     */
    private static final Integer SKILL = 1;
    private static final Integer VLOG = 2;

    @Autowired
    private ArticeServiceImpl articeService;

    /**
     * 访问首页
     *
     * @return
     */
    @GetMapping(value = "/")
    public String index(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "6") int pageSize) {
        model.addAttribute("index", articeService.listArticle(pageNum, pageSize));
        return "index";
    }

    /**
     * 技术
     *
     * @return
     */
    @GetMapping(value = "/skill")
    public String skill(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "6") int pageSize) {
        model.addAttribute("skill", articeService.queryAllByType(SKILL, pageNum, pageSize));
        return "skill";
    }

    /**
     * 随笔
     *
     * @return
     */
    @GetMapping(value = "/vlog")
    public String vlog(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "6") int pageSize) {
        model.addAttribute("vlog", articeService.queryAllByType(VLOG, pageNum, pageSize));
        return "vlog";
    }

    /**
     * 文章详情
     *
     * @param model
     * @param theme
     * @param session
     * @return
     * @throws UnknownHostException
     */
    @GetMapping(value = "/detail/{theme}")
    public String detail(Model model, @PathVariable(value = "theme") String theme, HttpSession session) throws UnknownHostException {
        // 点赞控制
        if (null != session.getAttribute(theme)) {
            if (!(InetAddress.getLocalHost().getHostAddress().equals(session.getAttribute(theme)))) {
                articeService.updateSeeNum(theme);
                session.setAttribute(theme, InetAddress.getLocalHost().getHostAddress());
            }
        }
        if (null == session.getAttribute(theme)) {
            articeService.updateSeeNum(theme);
            session.setAttribute(theme, InetAddress.getLocalHost().getHostAddress());
        }
        model.addAttribute("det", articeService.queryAllByTheme(theme));
        return "detail";
    }

}