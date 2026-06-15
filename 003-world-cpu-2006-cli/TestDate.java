import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestDate {
    public static void main(String[] args) {
        String dateStr = "2026-06-14T14:37:43.267134668+00:00";
        LocalDateTime ldt = LocalDateTime.parse(dateStr, DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(ldt);
    }
}
