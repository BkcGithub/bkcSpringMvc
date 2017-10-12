package com.bkc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class Hello {
    @Controller
    @RequestMapping(value = "test")
    public class TestController {

        @RequestMapping(value = "hello", produces = {"text/plain;charset=UTF-8"})
        @ResponseBody
        public String returnString() {
            return "hello return string 这是中文";
        }
    }
}

