package deu.se.ood.beans.ch04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SumBean {
    private Logger log = LoggerFactory.getLogger(getClass());
    private  int n;

    public SumBean() {
        log.debug("The instance SumBean created...");
        result = 0;
    }

    public void calculate(){
        result = n * (n + 1) / 2;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    private  int result;

}
