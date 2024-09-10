package macrebot.global.counter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import macrebot.global.counter.models.Counter;
import macrebot.global.counter.repositories.CounterRepository;

@Service
public class CounterService {

    @Autowired
    private CounterRepository counterRepository;

    public Counter createCounter(Counter counter) {
        return counterRepository.save(counter);
    }

    public List<Counter> getAllCounters() {
        return counterRepository.findAll();
    }

    public Counter getCounterById(Long id) {
        return counterRepository.findById(id).orElse(null);
    }

    public Long getIdUpdate(Long id) {
        Counter counter = counterRepository.findById(id).orElse(null);
        if (counter != null) {
            Long nextId = counter.getCounterIds() + 1;
            counter.setCounterIds(nextId);
            counterRepository.save(counter);
            return nextId;
        }
        return -1L;
    }

    public Boolean deleteCounterById(Long id) {
        Optional<Counter> optionalCounter = counterRepository.findById(id);

        if (optionalCounter.isPresent()) {
            counterRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
