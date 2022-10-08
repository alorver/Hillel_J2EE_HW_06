package edu.avo.hillel_j2ee_hw_06.controller;

import edu.avo.hillel_j2ee_hw_06.dto.CartDTO;
import edu.avo.hillel_j2ee_hw_06.dto.PersonDTO;
import edu.avo.hillel_j2ee_hw_06.mappers.CartMapper;
import edu.avo.hillel_j2ee_hw_06.mappers.PersonMapper;
import edu.avo.hillel_j2ee_hw_06.model.Person;
import edu.avo.hillel_j2ee_hw_06.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static edu.avo.hillel_j2ee_hw_06.constants.PersonControllerConstants.ErrorMessages.*;


@Slf4j
@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


/*
    @PostMapping("/create")
    public String createPerson(@RequestBody @Valid PersonDTO personDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("Main fields are empty");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Main fields are empty");
        }
        final Person person = new Person(personDTO);
        return String.format("Person Id=%d is added ", personService.createPerson(person));
    }
*/

    @GetMapping("/newPerson")
    public String createPerson(Model model) {

        PersonDTO personDTO = new PersonDTO();
//        personDTO.setFirstName("John");
        model.addAttribute("personDTO", personDTO);
        return "personForm";

//        return String.format("Person Id=%d is added ", personService.createPerson(person));
    }


    @PostMapping("/savePerson")
    public String savePerson(@ModelAttribute("personDTO") @Valid PersonDTO personDTO, Model model, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("Main fields are empty");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Main fields are empty");
        }
//        final Person person = new Person(personDTO);
        final Person person = PersonMapper.INSTANCE.toPerson(personDTO);
        person.setId(personService.createPerson(person));
        model.addAttribute("person", person );
        return "personSuccess";

//        return String.format("Person Id=%d is added ", personService.createPerson(person));
    }

//    @RequestMapping(value = {"/personList"}, method = RequestMethod.GET)
    @GetMapping(value = {"/personList"})
    public String findAll(Model model) {

        List<PersonDTO> persons = personService.findAll().stream()
                .map(PersonMapper.INSTANCE::toPersonDTO)
                .collect(Collectors.toList());

        model.addAttribute("persons", persons );
        return "personList";
    }
/*
    @GetMapping("/findAll")
    public List<PersonDTO> findAll() {
        return personService.findAll().stream()
                .map(PersonDTO::new)
                .collect(Collectors.toList());
    }
*/

    @GetMapping("/findPersonById/{id}")
    public PersonDTO findById(@PathVariable("id") int id) {
        Person person = personService.findById(id);
        if (person == null) {
            log.error(PERSON_NOT_FOUND);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, PERSON_NOT_FOUND);
        }
        return PersonMapper.INSTANCE.toPersonDTO(person);
    }


    @DeleteMapping("/deletePersonById/{id}")
    public String deleteById(@PathVariable("id") int id) {
        if (!personService.deletePerson(id)) {
            log.error(PERSON_NOT_FOUND);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, PERSON_NOT_FOUND);
        }
        return String.format("Person Id=%d is deleted", id);
    }


    @PutMapping("/updatePerson")
    public String updatePerson(@RequestBody @Valid PersonDTO personDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("Nothing is filled");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nothing is filled");
        }
        final Person person = PersonMapper.INSTANCE.toPerson(personDTO);
        if (!personService.updatePerson(person)) {
            log.error(PERSON_NOT_FOUND);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, PERSON_NOT_FOUND);
        }
        return String.format("Person Id=%d is updated", person.getId());
    }

    @GetMapping("/addPersonCart/{personId}/{cartId}")
    public String addPersonCart(@PathVariable("personId") int personId,
                                @PathVariable("cartId") int cartId) {
        if (!personService.addPersonCart(personId, cartId)) {
            log.error(PERSON_OR_CART_IS_NOT_FOUND);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, PERSON_OR_CART_IS_NOT_FOUND);
        }
        return String.format("Cart Id=%d is added", cartId);
    }

    @DeleteMapping("/deletePersonCart/{personId}/{cartId}")
    public String deletePersonCart(@PathVariable("personId") int personId,
                                   @PathVariable("cartId") int cartId) {
        if (!personService.deletePersonCart(personId, cartId)) {
            log.error(PERSON_OR_CART_IS_NOT_FOUND);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, PERSON_OR_CART_IS_NOT_FOUND);
        }
        return String.format("Cart Id=%d is deleted", cartId);
    }

    @GetMapping("/getPersonCarts/{personId}")
    public List<CartDTO> getPersonCarts(@PathVariable("personId") int personId) {
        return personService.findPersonCarts(personId).stream()
                .map(CartMapper.INSTANCE::toCartDTO)
                .collect(Collectors.toList());
    }


}
