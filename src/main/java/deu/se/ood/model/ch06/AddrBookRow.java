package deu.se.ood.model.ch06;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class AddrBookRow {
    private String email;
    private String name;
    private String phone;
}
