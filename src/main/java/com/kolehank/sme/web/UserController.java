package com.kolehank.sme.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kolehank.sme.model.User;
import com.kolehank.sme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by huangke on 2015/8/31.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

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

        return userService.getByID(new Long(1));
    }

    @RequestMapping(value = "user/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("huang", "Hello");
        return "user/index";
    }
}
