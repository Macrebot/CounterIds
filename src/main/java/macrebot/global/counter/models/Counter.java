package macrebot.global.counter.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "counters")
public class Counter {

    // Atributes
    private Long id;
    private String description;
    private Long counterIds;

    // Constructor
    public Counter(Long id, String description) {
        this.id = id;
        this.description = description;
        this.counterIds = 0L;
    }

    // Getters & Setters
    public Long getCounterIds() {
        return counterIds;
    }

    public void setCounterIds(Long counterIds) {
        this.counterIds = counterIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
