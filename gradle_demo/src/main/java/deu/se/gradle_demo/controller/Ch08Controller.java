package deu.se.gradle_demo.controller;

import jakarta.servlet.ServletContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@PropertySource(value = "classpath:/ch08.properties", encoding = "UTF-8")
public class Ch08Controller {
    @Autowired
    private ServletContext ctx;
    @Value("${dog_sound}")
    private String dogSound;
    @Value("${cat_sound}")
    private String catSound;
    @Value("${bird_sound}")
    private String birdSound;
    @Value("${새울음소리}")
    private String birdSound2;

    @GetMapping("/ch08/init_parameter")
    public String initParameter(Model model) {
        log.debug("/ch08/initParameter");

        model.addAttribute("dogSound", dogSound);
        model.addAttribute("catSound", catSound);
        model.addAttribute("birdSound", birdSound);

        ctx.setAttribute("ctxBirdSound", birdSound2);

        log.debug("dogSound = {}, catSound = {}, birdSound = {}", dogSound, catSound, birdSound2);

        return "ch08/init_parameter/index";
    }

    @GetMapping("/")
    public String index() {
        log.debug("/");
        return "project_list";
    }
}