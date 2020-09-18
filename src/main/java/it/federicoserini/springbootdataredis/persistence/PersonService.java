package it.federicoserini.springbootdataredis.persistence;

import it.federicoserini.springbootdataredis.Person;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Federico Serini
 */
@Log4j2
@AllArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    public void insert(Person person){
        personRepository.save(person);
    }

    public Person findById(Long id) {
        return personRepository.findById(id);
    }

    public Map<Long, Person> findAll() {
        return personRepository.findAll();
    }
}
