import io.teaql.core.utils.Convert;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;

public class TestJackson {
    public static void main(String[] args) {
        Convert.registerModule(new JavaTimeModule());
        try {
            LocalDate d = Convert.convert(LocalDate.class, "2026-06-11");
            System.out.println("SUCCESS: " + d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
