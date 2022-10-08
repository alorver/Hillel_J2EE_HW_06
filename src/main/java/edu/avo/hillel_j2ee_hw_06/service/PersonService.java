package edu.avo.hillel_j2ee_hw_06.service;

import edu.avo.hillel_j2ee_hw_06.model.Cart;
import edu.avo.hillel_j2ee_hw_06.model.Person;

import java.util.List;
import java.util.Set;

public interface PersonService {
    Integer createPerson(Person person);
    List<Person> findAll();
    Person findById(Integer personId);

    boolean deletePerson(Integer personId);
    boolean updatePerson(Person person);

    boolean addPersonCart(Integer personId, Integer cartId);
    boolean deletePersonCart(Integer personId, Integer cartId);
    Set<Cart> findPersonCarts(Integer personId);
}
