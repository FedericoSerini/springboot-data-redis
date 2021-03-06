package it.federicoserini.springbootdataredis.persistence;

import it.federicoserini.springbootdataredis.Person;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

import static it.federicoserini.springbootdataredis.constants.RedisEntitiesKeys.PERSON;

/**
 * @author Federico Serini
 */
@Repository
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {

    @NonNull private final RedisTemplate<String, Person> redisTemplate;
    private HashOperations<String, Long, Person> hashOperations;
    private String entityKey;

    @PostConstruct
    private void initHashOperations(){
        hashOperations = redisTemplate.opsForHash();
        entityKey = PERSON;
    }

    @Override
    public void save(Person person) {
        hashOperations.put(entityKey, person.getId(), person);
    }

    @Override
    public Person findById(Long id) {
        return hashOperations.get(entityKey, id);
    }

    @Override
    public Map<Long, Person> findAll() {
        return hashOperations.entries(entityKey);
    }

}
