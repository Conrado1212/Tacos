package tacos;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Order {
    // @NotBlank(message="ID is required")
    private Long id;
    // @NotBlank(message="ID is required")
    private Date placedAt;
    // @NotBlank(message="Name is required")
    private String dName;
    // @NotBlank(message="Street is required")
    private String dStreet;
    // @NotBlank(message="City is required")
    private String dCity;
    // @NotBlank(message="State is required")
    private String dState;
    // @NotBlank(message="Zip code is required")
    private String dZip;
    // @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;
    // @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
    // message="Must be formatted MM/YY")
    private String ccExpiration;
    // @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    // 书上缺失designs字段和addDesign()函数
    // @Size(min=1, message="Each order must contain at least 1 design of Taco")
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco design) {
        tacos.add(design);
    }
}
