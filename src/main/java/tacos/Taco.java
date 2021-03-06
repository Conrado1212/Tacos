package tacos;

import lombok.Data;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class Taco {
    // @NotNull
    private Long id;
    // @NotNull
    private Date createdAt;
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;


    // private List<Ingredient> ingredients;
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<String> ingredients;

}
