package edu.avo.hillel_j2ee_hw_06.dto;

import edu.avo.hillel_j2ee_hw_06.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductDTO {

    private Integer id;

    @NotBlank
    private String name;
    @NotNull
    private BigDecimal price;

//    // Conctructor is using as input RequestBoby parser
//    public ProductDTO(Integer id, String name, BigDecimal price) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//    }
//
//    public ProductDTO(Product product) {
//        this.id = product.getId();
//        this.name = product.getName();
//        this.price = product.getPrice() == null ? new BigDecimal("0.00") : product.getPrice();
//    }

}
