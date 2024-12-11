package site.mplace.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Controller
public class HelloController {
    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World";
    }

}

