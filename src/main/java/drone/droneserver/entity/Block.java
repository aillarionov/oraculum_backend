package drone.droneserver.entity;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author alex
 */
public class Block {

    private String type;
    private Long timestamp;

    private Set<String> previous;
    private Integer version;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Set<String> getPrevious() {
        return previous;
    }

    public void setPrevious(Set<String> previous) {
        this.previous = previous;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}
