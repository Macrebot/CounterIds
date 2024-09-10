package macrebot.global.counter.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import macrebot.global.counter.models.Counter;
import macrebot.global.counter.services.CounterService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/counters")
public class CounterController {

    @Autowired
    private CounterService counterService;

    @GetMapping
    public ResponseEntity<?> getAllCounters() {
        return ResponseEntity.ok(counterService.getAllCounters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCounterById(@PathVariable Long id) {
        Counter counter = counterService.getCounterById(id);

        if (counter != null) {
            return ResponseEntity.ok(counter);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Counter not found with the id: " + id);
    }

    @GetMapping("/{id}/nextId")
    public ResponseEntity<?> nextId(@PathVariable Long id) {
        Long response = counterService.getIdUpdate(id);
        if (response > -1L) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Counter not found with the id: " + id);
    }

    @PostMapping
    public ResponseEntity<?> createCounter(@RequestBody Counter counter) {
        counterService.createCounter(counter);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(counter.getId())
                .toUri();

        return ResponseEntity.created(location).body(counter);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCounterById(@PathVariable Long id) {
        boolean deleted = counterService.deleteCounterById(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
