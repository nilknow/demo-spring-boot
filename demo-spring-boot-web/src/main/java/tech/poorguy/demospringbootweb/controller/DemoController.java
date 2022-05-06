package tech.poorguy.demospringbootweb.controller;

import com.google.common.collect.Streams;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoController {
    @GetMapping("/demo")
    @ApiParam()
    public String demo(){
        return "demo";
    }
}
