package com.kolehank.sme.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kolehank.sme.model.DemoUser;
import com.kolehank.sme.model.User;
import com.kolehank.sme.service.DemoUserService;
import com.kolehank.sme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by huangke on 2015/8/31.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    DemoUserService demoUserService;

    @RequestMapping(value = "/user/index")
    public String index() {
        return "user/index";
    }

    @RequestMapping(value = "user/json")
    @ResponseBody
    public String json() {

        User u = new User();
        u.setUsername("huangke");
        u.setPassword("admin");
        u.setId(new Long(1));
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(u);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "user/jsonobj")
    @ResponseBody
    public User jsonobj() {
        User u = new User();
        u.setUsername("huangke");
        u.setPassword("admin");
        u.setId(new Long(1));
        return u;
    }

    @RequestMapping(value = "user/add")
    @ResponseBody
    public User add() {
        User u = new User();
        u.setUsername("test");
        u.setPassword("admin");
        userService.add(u);
        return u;
    }

    @RequestMapping(value = "user/getp")
    @ResponseBody
    public User getp() {
        return demoUserService.getUser(new Long(1));
    }

    @RequestMapping(value = "user/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("huang", "Hello");
        return "user/index";
    }

    @RequestMapping(value = "demo/jsonobj")
    @ResponseBody
    public DemoUser demo() {
        DemoUser user = new DemoUser();
        user.setUsername("afafa");
        user.setPassword("dafafa");
        demoUserService.add(user);

        return demoUserService.getDemoUser(new Long(1));
    }

    @RequestMapping(value = "demo/list")
    @ResponseBody
    public List<DemoUser> list(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

        return demoUserService.getPageList(pageNum, pageSize);
    }
}
