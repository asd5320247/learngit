package com.example.springbootjdbcdemo.controller;

import com.example.springbootjdbcdemo.entity.State;
import com.example.springbootjdbcdemo.service.StateService;
import com.example.springbootjdbcdemo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/us")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StateService stateService;

    @GetMapping("/list")
    @ResponseBody
    public String getUsers() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(stateService.getState());
        return str;
    }



    @GetMapping("/add")
    @ResponseBody
    public String addUsers() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(stateService.getState());
        return userService.addUser() + str;
    }

    @GetMapping("/update")
    @ResponseBody
    public String updateUsers() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(stateService.getState());
        return userService.updateUser() + str;
    }

    @GetMapping("/delete")
    @ResponseBody
    public String deleteUsers() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(stateService.getState());
        return userService.deleteUser() + str;
    }
}