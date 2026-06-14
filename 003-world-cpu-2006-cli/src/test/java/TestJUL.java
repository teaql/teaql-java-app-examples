import java.util.logging.*;
public class TestJUL {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("");
        Handler[] handlers = logger.getHandlers();
        for (Handler h : handlers) {
            System.out.println("Handler: " + h.getClass().getName());
        }
    }
}
