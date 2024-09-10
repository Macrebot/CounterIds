package macrebot.global.counter.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import macrebot.global.counter.models.Counter;

public interface CounterRepository extends MongoRepository<Counter, Long> {

    Boolean deleteIdsById(Long id);

}
