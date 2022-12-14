package edu.avo.hillel_j2ee_hw_06.mappers;

import edu.avo.hillel_j2ee_hw_06.dto.ProductDTO;
import edu.avo.hillel_j2ee_hw_06.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDTO toProductDTO(Product product);
    Product toProduct(ProductDTO productDTO);
}
