/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package deu.se.ood.taghandler;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author user
 */
@Slf4j
public class HelloTagHandler2 extends SimpleTagSupport {
    
    @Getter @Setter
    private String user;
    @Getter @Setter
    private int count = 1;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     * @throws jakarta.servlet.jsp.JspException
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            for(int i=0; i<count; i++){
                out.println(String.format("%s님 , 안녕하십니까? <br>", user));
            }
        } catch (java.io.IOException ex) {
            log.error("HelloTagHandler2: 예외 = {}", ex.getMessage());
        }
    }

}
