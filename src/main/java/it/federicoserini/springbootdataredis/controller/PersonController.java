package it.federicoserini.springbootdataredis.controller;

import it.federicoserini.springbootdataredis.Person;
import it.federicoserini.springbootdataredis.persistence.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Federico Serini
 */
@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody Person person) {
        log.debug("Creating a new {}", person);
        service.insert(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(1);
    }

    @GetMapping
    public ResponseEntity<Person> findById(@RequestParam Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Map<Long, Person>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
    
}




