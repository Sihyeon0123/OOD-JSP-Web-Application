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
    
- [참고자료](#참고자료)

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


### 4장
**주제:** [Beans, Forward]
- JSP에서 Beans 사용법
- forward 액션 태그

**내용 요약:**
- Beans는 재사용 가능한 소프트웨어 컴포넌트입니다.
- forward 액션 태그를 사용하여 다른 페이지로 요청을 전달합니다.

**중요 개념:**
- Beans 사용법: <jsp:useBean id="person" class="com.example.Person" />
- forward 액션 태그: <jsp:forward page="nextPage.jsp" />

**예제 코드:**
```jsp
<%-- Beans 사용법 --%>
<jsp:useBean id="person" class="com.example.Person" />
<jsp:setProperty name="person" property="name" value="John Doe" />
<jsp:getProperty name="person" property="name" />

<%-- forward 액션 태그 --%>
<jsp:forward page="nextPage.jsp" />
```


### 장
**주제:** []
- 
**내용 요약:**
- 
**중요 개념:**
- 

**예제 코드:**
```jsp

```


### 장
**주제:** []
- 
**내용 요약:**
- 
**중요 개념:**
- 

**예제 코드:**
```jsp

```


### 장
**주제:** []
- 
**내용 요약:**
- 
**중요 개념:**
- 

**예제 코드:**
```jsp

```


### 장
**주제:** []
- 
**내용 요약:**
- 
**중요 개념:**
- 

**예제 코드:**
```jsp

```
