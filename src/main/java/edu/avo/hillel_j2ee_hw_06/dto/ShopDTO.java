package edu.avo.hillel_j2ee_hw_06.dto;

import edu.avo.hillel_j2ee_hw_06.model.Shop;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
public class ShopDTO {

    private Integer id;

    @NotBlank
    private String name;
    @NotBlank
    private String webSite;
    @NotBlank
    private String phoneNumber;

//    // Conctructor is using as input RequestBoby parser
//    public ShopDTO(Integer id, String name, String webSite, String phoneNumber) {
//        this.id = id;
//        this.name = name;
//        this.webSite = webSite;
//        this.phoneNumber = phoneNumber;
//    }
//
//    public ShopDTO(Shop shop) {
//        this.id = shop.getId();
//        this.name = shop.getName();
//        this.webSite = shop.getWebSite();
//        this.phoneNumber = shop.getPhoneNumber();
//    }
}
