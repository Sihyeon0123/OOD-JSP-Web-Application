package deu.se.ood.beans.ch04;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SumSpringBean {
    @Getter
    @Setter
    private int n;
    @Getter
    private int result;

    public SumSpringBean() {
        log.debug("The instance SumBean created...");
        this.result = 0;
    }

    public void calculate(){
        result = n * (n + 1) / 2;
    }
}
