package com.spsoft.cruddemo.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spsoft.cruddemo.entities.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    
    List<Person> findByFirstname(String firstname);
    
}
