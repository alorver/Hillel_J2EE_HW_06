package edu.avo.hillel_j2ee_hw_06.dto;

import edu.avo.hillel_j2ee_hw_06.model.Cart;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class CartDTO {

    private Integer id;
    @NotBlank
    private String description;
    private BigDecimal summa;

//    // Conctructor is using as input RequestBoby parser
//    public CartDTO(Integer id, String description, BigDecimal summa) {
//        this.id = id;
//        this.description = description;
//        this.summa = summa;
//    }
//
//    public CartDTO(Cart cart) {
//        this.id = cart.getId();
//        this.description = cart.getDescription();
//        this.summa = cart.getSumma() == null ? new BigDecimal("0.00") : cart.getSumma();
//    }
}
