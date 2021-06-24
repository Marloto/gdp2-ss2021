package stream;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

class Message {
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

// https://pastie.io/xociis.java
public class Streaming {
    public static Message last = null;

    public static void main(String[] args) {
        List<String> messages = Arrays.asList(
            "1581697831661:Message 1", 
            "1581553746009:Message 2",
            "1588854263313:Message 3", 
            "1589381962905:Message 4", 
            "1589379566771:Message 5");
        handleList(messages);
    }

    public static void handleList(List<String> messages) {
        messages.stream()
            .map(str -> str.split(":"))
            .map(strArr -> new Message(Long.valueOf(strArr[0]), strArr[1]))
            .filter(msgObj -> last == null || msgObj.getTime() > last.getTime())
            .peek(msgObj -> last = msgObj)
            .forEach(msg -> System.out.println(msg));
    }

}