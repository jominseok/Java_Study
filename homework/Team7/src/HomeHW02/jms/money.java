package HomeHW02.jms;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class money {
    @NonNull
    private Integer month;
    private Integer day;
    private String memo;
    @NonNull
    private Integer moneyIn, moneyOut;
}
