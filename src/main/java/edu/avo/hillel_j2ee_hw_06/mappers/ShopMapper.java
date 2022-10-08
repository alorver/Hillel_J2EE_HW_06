package edu.avo.hillel_j2ee_hw_06.mappers;

import edu.avo.hillel_j2ee_hw_06.dto.ShopDTO;
import edu.avo.hillel_j2ee_hw_06.model.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShopMapper {
    ShopMapper INSTANCE = Mappers.getMapper( ShopMapper.class );
    ShopDTO toShopDTO(Shop shop);
    Shop toShop(ShopDTO shopDTO);
}
