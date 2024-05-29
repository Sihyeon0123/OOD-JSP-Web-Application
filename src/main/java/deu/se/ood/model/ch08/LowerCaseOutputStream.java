package deu.se.ood.model.ch08;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.WriteListener;

import java.io.IOException;

public class LowerCaseOutputStream extends ServletOutputStream {
    private ServletOutputStream mSos = null;

    public LowerCaseOutputStream(ServletOutputStream sos) {
        this.mSos = sos;
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {

    }

    @Override
    public void write(int b) throws IOException {
        int C = (b == -1) ? b : Character.toLowerCase((char) b);
        mSos.write(C);
    }
}
