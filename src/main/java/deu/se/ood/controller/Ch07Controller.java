package deu.se.ood.controller;

import jakarta.servlet.ServletContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@Slf4j
public class Ch07Controller {
    @Autowired
    private ServletContext ctx;

    @GetMapping("/ch07/upload")
    public String ch07Upload() {
        return "ch07/upload/index";
    }

    @PostMapping("/ch07/upload.do")
    public String ch07UploadDo(@RequestParam String username, @RequestParam MultipartFile upfile, Model model) {
        log.debug("upload.do: username = {}, upfile = {}, File.separator = {}", username, upfile, File.separator);

        String basePath = ctx.getRealPath("/WEB-INF") + File.separator + "upload";

        log.debug("upload.do: basePath = {}", basePath);
        File baseDir = new File(basePath);
        if(!baseDir.exists()){
            baseDir.mkdirs();
        }
        if (!upfile.isEmpty()) {
            log.debug("upload.do: upfile = {}", upfile.getOriginalFilename());
            model.addAttribute("exec_message",
                    String.format("username(%s)이 없가나 upload 파일(%s) 지정이 되지 않습니다.", username, upfile.getOriginalFilename()));
        } else{
            log.debug("upfile = \"{}\"", upfile.getOriginalFilename());
            File f = new File(basePath + File.separator + upfile.getOriginalFilename());
            try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f))){
                bos.write(upfile.getBytes());
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }

            model.addAttribute("exec_message",
                    String.format("username = %s, %s 파일 저장이 잘 되었습니다.", username, upfile.getOriginalFilename()));
        }
        return "ch07/upload/index";
    }
}
