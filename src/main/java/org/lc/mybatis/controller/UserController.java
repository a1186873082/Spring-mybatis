package org.lc.mybatis.controller;

import org.lc.mybatis.model.TTest;
import org.lc.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addTest(@RequestBody TTest test) throws Exception{
        userService.insertTest(test);
        return 1;
    }
}
