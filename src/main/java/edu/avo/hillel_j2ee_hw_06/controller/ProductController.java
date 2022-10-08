package edu.avo.hillel_j2ee_hw_06.controller;


import edu.avo.hillel_j2ee_hw_06.dto.ProductDTO;
import edu.avo.hillel_j2ee_hw_06.mappers.ProductMapper;
import edu.avo.hillel_j2ee_hw_06.model.Product;
import edu.avo.hillel_j2ee_hw_06.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductController {

    public static final String PRODUCT_NOT_FOUND = "Product not found";
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public String createProduct(@RequestBody @Valid ProductDTO productDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("Main field is empty");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Main field is empty");
        }

        final Product product = ProductMapper.INSTANCE.toProduct(productDTO);
        return String.format("Product Id=%d is created", productService.createProduct(product));
    }

    @GetMapping("/findAll")
    public List<ProductDTO> findAll() {
        return productService.findAll().stream()
                .map(ProductMapper.INSTANCE::toProductDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/findById/{id}")
    public ProductDTO findById(@PathVariable("id") int id) {
        Product product = productService.findById(id);
        if (product == null) {
            log.error(PRODUCT_NOT_FOUND);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, PRODUCT_NOT_FOUND);
        }
        return ProductMapper.INSTANCE.toProductDTO(product);
    }


    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") int id) {
        if (!productService.deleteProduct(id)) {
            log.error(PRODUCT_NOT_FOUND);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, PRODUCT_NOT_FOUND);
        }
        return String.format("Product Id=%d is deleted", id);
    }


    @PutMapping("/update")
    public String updateProduct(@RequestBody @Valid ProductDTO productDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("Nothing is filled");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nothing is filled");
        }
        final Product product = ProductMapper.INSTANCE.toProduct(productDTO);
        if (!productService.updateProduct(product)) {
            log.error(PRODUCT_NOT_FOUND);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, PRODUCT_NOT_FOUND);
        }
        return String.format("Product Id=%d", product.getId());
    }


}
