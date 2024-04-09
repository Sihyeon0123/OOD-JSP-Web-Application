package deu.se.ood.beans.ch04;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class SumBean {
    @Getter @Setter
    private  int n;
    @Getter @Setter
    private  int result;

    public SumBean() {
        log.debug("The instance SumBean created...");
        result = 0;
    }

    public void calculate(){
        result = n * (n + 1) / 2;
    }
}
