package experiment2.tables;


import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Pincode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String pincode;
    private int count;

    @OneToOne
    private CreditCard card;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pincode pincode = (Pincode) o;
        return Objects.equals(id, pincode.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
