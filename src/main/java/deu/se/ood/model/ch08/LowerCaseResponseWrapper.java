package deu.se.ood.model.ch08;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.IOException;

public class LowerCaseResponseWrapper extends HttpServletResponseWrapper {

    public LowerCaseResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return new LowerCaseOutputStream(this.getResponse().getOutputStream());
    }

}
