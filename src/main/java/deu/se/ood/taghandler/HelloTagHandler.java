/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package deu.se.ood.taghandler;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author user
 */
@Slf4j
public class HelloTagHandler extends SimpleTagSupport {
    
    @Override
    public void doTag() throws JspException {
       JspWriter out = getJspContext().getOut();
        
        try {   
            out.println("안녕하십니까?");
        } catch (java.io.IOException ex) {
            log.error("HelloTagHandler: 예외 = {}", ex.getMessage());
        }
    }
    
}
