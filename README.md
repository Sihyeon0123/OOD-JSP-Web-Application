# 객체지향설계 강의 노트

## 목차
- [소개](#소개)
- [강의 일정](#강의-일정)
- [학습 내용](#주차별-내용)
  - [1장](#1장)
  - [2장](#2장)
  - [3장](#3장)
  - [4장](#4장)
  - [5장](#5장)
  - [6장](#6장)
  - [7장](#7장)
  - [8장](#8장)


## 소개
이 저장소는 객체지향설계 강의에서 매주 배운 내용을 정리한 노트입니다. 각 주차별로 강의에서 다룬 주제, 중요한 개념, 예제 코드 및 과제 등을 포함합니다.

## 강의 일정
- 강의명: 객체지향설계
- 교수님: 이종민
- 학기: 4학년 1학기
- 강의 시간: 4시간

## 주차별 내용

### 1장
**주제:** [JSP, Spring Boot 개요 및 MVC 패턴]
- JSP와 Spring Boot의 개요
- MVC 패턴의 개념 및 활용

**내용 요약:**
- JSP는 Java Server Pages의 약자로, 서버 측에서 동적으로 HTML을 생성하는 기술입니다.
- Spring Boot는 Spring Framework를 기반으로 한 경량화된 애플리케이션 개발 도구입니다.
- MVC 패턴은 Model-View-Controller의 약자로, 애플리케이션의 구조를 세 가지 역할로 나누어 설계하는 디자인 패턴입니다.

**중요 개념:**
- **JSP**: 동적 웹 페이지 생성, 서블릿과의 관계
- **Spring Boot**: 자동 설정, 스타터 프로젝트, 내장 서버
- **MVC 패턴**: 모델(데이터), 뷰(사용자 인터페이스), 컨트롤러(비즈니스 로직)

<hr/>

### 2장
**주제:** [JSP 주석 및 HTML 주석의 차이, JSP 선언, 스크립틀릿 표현식, 스크립틀릿 사용]
- JSP 주석과 HTML 주석의 차이
- JSP 선언문, 스크립틀릿 표현식, 스크립틀릿 사용법

**내용 요약:**
- JSP 주석은 서버 측에서 처리되지 않으며, HTML 주석은 클라이언트에게 전달됩니다.
- JSP 선언문은 <%! %> 태그를 사용하여 변수나 메소드를 선언합니다.
- 스크립틀릿 표현식은 <%= %> 태그를 사용하여 결과를 출력합니다.
- 스크립틀릿은 <% %> 태그를 사용하여 자바 코드를 포함합니다.

**중요 개념:**
- JSP 주석: <%-- 주석 내용 --%>
- HTML 주석: <!-- 주석 내용 -->
- JSP 선언문: <%! int counter = 0; %>
- 스크립틀릿 표현식: <%= counter %>
- 스크립틀릿: <% counter++; %>

**예제 코드:**
```jsp
<%-- JSP 주석 --%>
<!-- HTML 주석 -->
<%! int counter = 0; %>
<%= counter %>
<%
    counter++;
    out.println("Counter: " + counter);
%>
```

<hr/>

### 3장
**주제:** [JSP 에러 페이지 설정, include, 라이브러리 사용법]
- JSP 에러 페이지 설정
- include 지시어와 액션 태그
- JSP에서 라이브러리 사용법

**내용 요약:**
- 에러 페이지는 isErrorPage와 errorPage 속성을 사용하여 설정합니다.
- include 지시어는 정적 포함을, include 액션 태그는 동적 포함을 처리합니다.
- JSP에서 라이브러리를 사용하려면 <%@ taglib %> 지시어를 사용합니다.

**중요 개념:**
- 에러 페이지 설정: isErrorPage="true", errorPage="error.jsp"
- include 지시어: <%@ include file="header.jsp" %>
- include 액션 태그: <jsp:include page="header.jsp" />
- 라이브러리 사용법: <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

**예제 코드:**
```jsp
<%-- 에러 페이지 설정 --%>
<%@ page isErrorPage="true" %>
<%@ page errorPage="error.jsp" %>

<%-- include 지시어 --%>
<%@ include file="header.jsp" %>

<%-- include 액션 태그 --%>
<jsp:include page="header.jsp" />

<%-- 라이브러리 사용법 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:out value="${message}" />
```

<hr/>

### 4장
**주제:** [Beans, Forward]
- JSP에서 Beans 사용법
- forward 액션 태그
- @GetMapping, @PostMapping
- @Autowired

**내용 요약:**
- Beans는 재사용 가능한 소프트웨어 컴포넌트입니다.
- forward 액션 태그를 사용하여 다른 페이지로 요청을 전달합니다.
- @GetMapping은 GET 요청을 처리하고, @PostMapping은 POST 요청을 처리합니다.
- @Autowired는 스프링의 의존성 주입을 위한 어노테이션입니다.

**중요 개념:**
- Beans 사용법: <jsp:useBean id="person" class="com.example.Person" />
- forward 액션 태그: <jsp:forward page="nextPage.jsp" />
- @GetMapping: @GetMapping("/path")
- @PostMapping: @PostMapping("/path")
- @Autowired: 의존성 주입

**예제 코드:**
```jsp
<%-- Beans 사용법 --%>
<jsp:useBean id="person" class="com.example.Person" />
<jsp:setProperty name="person" property="name" value="John Doe" />
<jsp:getProperty name="person" property="name" />

<%-- forward 액션 태그 --%>
<jsp:forward page="nextPage.jsp" />
```

```java
// @GetMapping, @PostMapping 예제
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello, GET!";
    }

    @PostMapping("/hello")
    public String postHello() {
        return "Hello, POST!";
    }
}

// @Autowired 예제
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final MyRepository myRepository;

    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }
}
```

<hr/>

### 5장
**주제:** [EL 표현식, EL 표현식 묵시적 객체, 심플태그, 태그 파일, <c:url>]
- EL(Expression Language) 표현식
- EL 표현식 묵시적 객체
- 심플태그, 태그 파일
- <c:import url> 사용법

**내용 요약:**
- EL 표현식은 JSP에서 데이터를 쉽게 접근하고 출력하는 방법을 제공합니다.
- 묵시적 객체는 JSP에서 기본적으로 제공하는 객체입니다.
- 심플태그와 태그 파일을 사용하여 커스텀 태그를 정의할 수 있습니다.
- <c:import url> 태그를 사용하여 다른 리소스를 포함할 수 있습니다.

**중요 개념:**
- EL 표현식: ${expression}
- 묵시적 객체: pageContext, request, session, application
- 심플태그: <simpletag> 정의
- 태그 파일: .tag 파일로 커스텀 태그 정의
- <c\:url>: 다른 리소스 포함

**예제 코드:**
```jsp
<%-- EL 표현식 --%>
${person.name}

<%-- 묵시적 객체 사용 --%>
${sessionScope.user}

<%-- 심플태그 예제 --%>
<%@ tag body-content="empty" %>
<%! public void doTag() throws JspException, IOException { %>
  <p>Custom Simple Tag</p>
<%! } %>

<%-- 태그 파일 예제 --%>
<%@ tag description="Example Tag" pageEncoding="UTF-8"%>
<%! void doTag() throws JspException, IOException { %>
  <p>Custom Tag File Content</p>
<%! } %>

<%-- <c:import url> 사용법 --%>
<c:import url="header.jsp" />
```

<hr/>

### 6장
**주제:** [@PropertySource, @Value, <spring:eval expression>, 시스템 프로퍼티에 DB 관련 정보 추가]
- @PropertySource 어노테이션
- @Value 어노테이션
- <spring:eval expression> 사용법
- 시스템 프로퍼티에 DB 관련 정보 추가

**내용 요약:**
- @PropertySource는 외부 프로퍼티 파일을 로드하는 데 사용됩니다.
- @Value는 프로퍼티 값을 주입하는 데 사용됩니다.
- <spring:eval expression>은 JSP에서 스프링 표현식을 평가하는 데 사용됩니다.
- 시스템 프로퍼티에 DB 관련 정보를 추가하여 설정할 수 있습니다.

**중요 개념:**
- @PropertySource: @PropertySource("classpath:application.properties")
- @Value: @Value("${property.name}")
- <spring:eval expression>: 스프링 표현식 평가
- 시스템 프로퍼티: System.setProperty("db.url", "jdbc:mysql://localhost:3306/mydb")

**예제 코드:**
```java
// @PropertySource, @Value 예제
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${db.url}")
    private String dbUrl;

    // getter
    public String getDbUrl() {
        return dbUrl;
    }
}
```

```jsp
<%-- <spring:eval expression> 사용법 --%>
<spring:eval expression="@appConfig.getDbUrl()" />
```

```java
// 시스템 프로퍼티 설정 예제
public class DatabaseConfig {
    static {
        System.setProperty("db.url", "jdbc:mysql://localhost:3306/mydb");
        System.setProperty("db.username", "root");
        System.setProperty("db.password", "password");
    }
}
```

<hr/>

### 7장
**주제:** [ServletContext, ResponseEntity, 파일 업로드 및 다운로드]
- ServletContext
- ResponseEntity
- 파일 업로드 및 다운로드 구현

**내용 요약:**
- ServletContext는 서블릿이 실행되는 컨텍스트 정보를 제공합니다.
- ResponseEntity는 스프링에서 응답 데이터를 조작하는 데 사용됩니다.
- 파일 업로드와 다운로드를 구현하는 방법을 배웁니다.

**중요 개념:**
- ServletContext: 서블릿 컨텍스트 정보 제공
- ResponseEntity: 응답 데이터 조작
- 파일 업로드: MultipartFile 사용
- 파일 다운로드: 파일 스트림 제공

**예제 코드:**
```java
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
```

```java
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
```

<hr/>

### 8장
**주제:** [웹 초기화 및 파일 필터]
- 웹 초기화 설정
- 파일 필터 구현

**내용 요약:**
- 웹 초기화는 서블릿 컨테이너가 시작될 때 애플리케이션 설정을 구성하는 과정입니다.
- 파일 필터는 특정 요청을 가로채서 처리하는 데 사용됩니다.

**중요 개념:**
- **웹 초기화**: `WebApplicationInitializer` 인터페이스 구현
- **파일 필터**: `javax.servlet.Filter` 인터페이스 구현


**예제 코드:**
```java
// 웹 초기화 예제
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}

// 파일 필터 예제
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 초기화 코드
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Request received at " + request.getRemoteAddr());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 정리 코드
    }
}
```
