package cn.com.sit.examplefeignclient.controller;

import cn.com.sit.examplefeignclient.feignclients.MenuServieInterface;
import cn.com.sit.examplefeignclient.feignclients.TokenServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FeignTestController {

    @Autowired
    TokenServiceInterface tokenSer;

    @Autowired
    MenuServieInterface menuServ;

    @RequestMapping(value = "/getsession",method = RequestMethod.GET)
    public String getSession(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password){
        Map<String,String> login=new HashMap<String,String>();

        login.put("username",username);
        login.put("password",password);


        return tokenSer.getSessionString(login);
    }


    @RequestMapping(value = "/menu",method = RequestMethod.GET)
    public String getMenu(@RequestHeader("Authorization") String Authorization){


        return menuServ.getMenu(Authorization);
    }
}
