package edu.avo.hillel_j2ee_hw_06.dto;

//import edu.avo.hillel_j2ee_hw_06.model.Person;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
public class PersonDTO {

    private Integer id;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;

//    public PersonDTO(Person person) {
//        this.id = person.getId();
//        this.firstName = person.getFirstName();
//        this.lastName = person.getLastName();
//        this.email = person.getEmail();
//    }

}
