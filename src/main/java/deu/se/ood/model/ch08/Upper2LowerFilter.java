package deu.se.ood.model.ch08;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Slf4j
public class Upper2LowerFilter implements Filter {
    private static final boolean debug = true;
    private FilterConfig filterConfig = null;

    public Upper2LowerFilter() {}

    private void doBeforeProcessing(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        if(debug){
            log.debug("Upper2LowerFilter:DoBeforeProcessing");
        }
    }

    private void doAfterProcessing(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {
        if(debug){
            log.debug("Upper2LowerFilter:doAfterProcessing()");
        }
    }

    private String getOutput(String fileName){
        String htmlText = "";
        try{
            File f = ResourceUtils.getFile("classpath:ch08/improper_file_type.txt");
            try(FileReader fr = new FileReader(f, StandardCharsets.UTF_8)){
                char[] cb = new char[1024];
                int numberOfBytes = fr.read(cb);
                htmlText = htmlText.replace("%%FILE_NAME%%", fileName);
                log.debug("바이트 수 = {}, 파일 내용: {}", numberOfBytes, htmlText);
            } catch (IOException e) {
                log.error("부적절 파일 유형 파일 읽기 예외 발생: {}", e.getMessage());
            }
        } catch (FileNotFoundException e) {
            log.error("부적절 파일 유형 파일 읽기 예외 발생: {}", e.getMessage());
        }

        return htmlText;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(debug){
            log.debug("Upper2LowerFilter:doFilter()");
        }

        doBeforeProcessing(servletRequest, servletResponse);

        Throwable problem = null;
        try{
            LowerCaseResponseWrapper myResponse = new LowerCaseResponseWrapper((HttpServletResponse) servletResponse);
            filterChain.doFilter(servletRequest, myResponse);
        }catch (Throwable e){
            problem = e;
            e.printStackTrace();
        }

        doAfterProcessing(servletRequest, servletResponse);

        if (problem != null) {
            if(problem instanceof ServletException){
                throw (ServletException)problem;
            }
            if(problem instanceof IOException){
                throw (IOException)problem;
            }
            sendProcessingError(problem, servletResponse);
        }
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("test:Initializing filter");
            }
        }
    }

    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("test()");
        }
        StringBuffer sb = new StringBuffer("test(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }
}
