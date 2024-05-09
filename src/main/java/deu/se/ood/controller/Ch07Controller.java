package deu.se.ood.controller;

import jakarta.servlet.ServletContext;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.tags.shaded.org.apache.regexp.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
//        유저별로 따로 폴더 생성
//        String basePath = ctx.getRealPath("/WEB-INF") + File.separator + "upload" + File.separator + username;
        String basePath = ctx.getRealPath("/WEB-INF") + File.separator + "upload";

        log.debug("upload.do: basePath = {}", basePath);
        File baseDir = new File(basePath);
        if(!baseDir.exists()){
            baseDir.mkdirs();
        }
        if (upfile.isEmpty()) {
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

    @GetMapping("/ch07/download")
    public String ch07Download(Model model) {
        String folder = ctx.getRealPath("/WEB-INF/upload");
        model.addAttribute("targetDirectory", folder);
        return "ch07/download/index";
    }

    @PostMapping("/ch07/download.do")
    public ResponseEntity<Resource> ch07DownloadDo(@RequestParam("filename") String fileName) {
        log.info("download.do: fileName = {}", fileName);
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
