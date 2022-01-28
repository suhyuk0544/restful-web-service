package com.example.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {



    @GetMapping(path = "/um")
    public String helloWorld()
    {
        return "hello-world";
    }
    @GetMapping(path = "/um-been")
    public HelloWorldbeen helloWorldbeen()
    {
        return new HelloWorldbeen("hello-world");
    }


    @GetMapping(path = "/um-been/path-variable/{name}")
    public HelloWorldbeen helloWorldbeen(@PathVariable String name)
    {
        return new HelloWorldbeen(String.format("hello-world %s",name));
    }
}
