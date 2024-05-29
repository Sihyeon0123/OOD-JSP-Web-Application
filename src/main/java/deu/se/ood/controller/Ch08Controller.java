package deu.se.ood.controller;

import deu.se.ood.model.ch08.FileFilter;
import deu.se.ood.model.ch08.Upper2LowerFilter;
import jakarta.servlet.ServletContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

        log.debug("dogSound = {}, catSound = {}, birdSound", dogSound, catSound, birdSound2);

        return "ch08/init_parameter/index";
    }

    @Bean
    public FilterRegistrationBean<FileFilter> fileFilter(){
        log.debug("fileFilter() called...");
        FilterRegistrationBean<FileFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new FileFilter());
        bean.addUrlPatterns("/ch08/filter/download.do");;
        bean.setOrder(1);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<Upper2LowerFilter> upper2LowerFilter(){
        log.debug("upper2LowerFilter() called...");
        FilterRegistrationBean<Upper2LowerFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new Upper2LowerFilter());
        bean.addUrlPatterns("/ch08/filter/download.do");;
        bean.setOrder(2);
        return bean;
    }

    @GetMapping("/ch08/filter")
    public String filter(Model model) {
        model.addAttribute("targetDirectory", ctx.getRealPath("/WEB-INF/upload"));
        return "ch08/filter/index";
    }

    @PostMapping("/ch08/filter/download.do")
    public ResponseEntity<Resource> downloadDo(@RequestParam("file_name")String fileName) {
        // 1. 내려받을 파일이 있는 경로를 설정
        String basePath = ctx.getRealPath("/WEB-INF") + File.separator + "upload";
        Path path = Paths.get(basePath + File.separator + fileName);
        String contentType = null;

        // 2. 파일의 Content-Type 찾기
        try{
            contentType = Files.probeContentType(path);
            log.debug("file: {}, Content-Tpye: {}", path.toString(), contentType);
        } catch (IOException e) {
            log.error("download.do: 오류 발생 - {}", e.getMessage());
        }

        // 파일이 존재하는지 확인
        if (!Files.exists(path)) {
            log.error("download.do: 파일이 존재하지 않습니다.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // 3. HTTP 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(
                ContentDisposition.builder("attachment").filename(fileName, StandardCharsets.UTF_8).build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);

        // 4. 파일을 입력 스트림으로 만들어 내려받기 준비
        Resource resource = null;
        try{
            resource = new InputStreamResource(Files.newInputStream(path));
        } catch (IOException e) {
            log.error("download.do:  오류 발생 - {}", e.getMessage());
        }

        if(resource == null){
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
        }
    }
}