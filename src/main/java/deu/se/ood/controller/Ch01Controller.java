package deu.se.ood.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class Ch01Controller {
    @GetMapping("/ch01/old")
    public String ch01() {
        return "ch01/index";
    }
}
