package timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private long time;
    private String message;

    public Message(long time, 
            String message) {
        this.time = time;
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public String toFormattedTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY hh:mm:ss");
        return sdf.format(new Date(time));
    }

    public String toString() {
        return this.toFormattedTime() + " " + this.message;
    }
}