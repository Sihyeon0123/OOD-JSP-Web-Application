package deu.se.ood.model.ch06;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
public class AddrBookRow {
    @Getter
    private String email;
    @Getter
    private String name;
    @Getter
    private String phone;
}
