package eventi;

import java.util.Calendar;

/**
 *
 * @author Matteo Gabetta <matteo.gabetta at unipv.it>
 */
public class SportEvent {
    private String type, description;
    private Calendar time;

    public SportEvent(String type, String description, Calendar time) {
        this.type = type;
        this.description = description;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getTime() {
        return time;
    }
    
}
