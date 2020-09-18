package it.federicoserini.springbootdataredis.persistence;

import it.federicoserini.springbootdataredis.Person;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author Federico Serini
 */
@Repository
public interface PersonRepository {
    void save(Person person);
    Person findById(Long id);
    Map<Long, Person> findAll();
}
