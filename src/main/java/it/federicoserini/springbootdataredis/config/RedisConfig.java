package it.federicoserini.springbootdataredis.config;

import it.federicoserini.springbootdataredis.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import static it.federicoserini.springbootdataredis.constants.RedisConnectionConstants.HOST;
import static it.federicoserini.springbootdataredis.constants.RedisConnectionConstants.PORT;

/**
 * @author Federico Serini
 */
@Configuration
public class RedisConfig {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(new RedisStandaloneConfiguration(HOST, PORT));
    }

    @Bean
    public RedisTemplate<String, Person> redisTemplate() {
        RedisTemplate<String, Person> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        return template;
    }

}
