package deu.se.ood.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
@Controller
@Slf4j
public class Ch05Controller {
    
    @GetMapping("/ch05/eltest")
    public String eltest() {
        log.debug("호출");
        return "/ch05/eltest/index";
    }
    
    @GetMapping("/ch05/elimplicitobject")
    public String elImplicitObject() {
        log.debug("호출");
        return "/ch05/elimplicitobject/index";
    }
    
    @GetMapping("/ch05/simpletagtest/{number}")
    public String simpleTagTest(@PathVariable Integer number) {
        return String.format("ch05/simpletagtest/index%d", number);
    }
}
