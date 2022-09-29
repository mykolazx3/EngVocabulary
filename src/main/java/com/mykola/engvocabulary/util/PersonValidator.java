package com.mykola.engvocabulary.util;

import com.mykola.engvocabulary.models.Person;
import com.mykola.engvocabulary.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    //хєровий код, можна замінити
    private final PersonDetailsService personDetailsService;

    @Autowired
    public PersonValidator(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }
    //хєровий код, можна замінити

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        //хєровий код, можна замінити
        try {
            personDetailsService.loadUserByUsername(person.getUsername());
        } catch (UsernameNotFoundException ignored) {
            return;//Все ок, користувач з таким іменем не знайдений
        }

        errors.rejectValue("username", "", "людина з таким іменем уже існує");
        //хєровий код, можна замінити
    }
}
