package com.example.springbootjdbcdemo.service;

import com.example.springbootjdbcdemo.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {
    @Autowired
    private UserService userService;
    public State getState(){
        State state = new State();
        state.setReturn_msg("成功");
        state.setReturn_code("0");
        state.setData(userService.getList());
        return state;
    }
}
