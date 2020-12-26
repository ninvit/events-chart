package ninvit.model;

import java.time.LocalDateTime;

import javax.persistence.Id;

/**
 * This is just an event stub, feel free to expand it if needed.
 */
public class Event {

    @Id
    private String type;
    private LocalDateTime timestamp;

    public Event(String type, LocalDateTime timestamp) {
        this.type = type;
        this.timestamp = timestamp;
    }

    public Event(){
        
    }


    public String getType() {
        return type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
