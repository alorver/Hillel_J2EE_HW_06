package edu.avo.hillel_j2ee_hw_06.repository;

import edu.avo.hillel_j2ee_hw_06.model.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Integer> {
}
