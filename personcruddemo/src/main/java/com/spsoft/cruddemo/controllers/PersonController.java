package com.spsoft.cruddemo.controllers;

import javax.validation.Valid;

import com.spsoft.cruddemo.entities.Person;
import com.spsoft.cruddemo.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * 
 * @author vsury
 * 
 * REST API which stores, updates , retrieves and delete Person entities 
 */

@Controller
public class PersonController {
    
    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    @GetMapping("/new")
    public String showSignUpForm(Person person) {
        return "add-person";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        model.addAttribute("person", person);
        return "update-person";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        personRepository.delete(person);
        model.addAttribute("persons", personRepository.findAll());
        return "index";
    }

    @PostMapping("/addperson")
    public String addUser(@Valid Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-person";
        }

        personRepository.save(person);
        model.addAttribute("persons", personRepository.findAll());

        return "index";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            person.setId(id);
            return "update-person";
        }
        
        personRepository.save(person);
        model.addAttribute("persons", personRepository.findAll());
        return "index";
    }
    

}
