import io.teaql.core.UserContext;
import org.reflections.Reflections;
import java.util.Set;

public class FindContext {
    public static void main(String[] args) {
        System.out.println("Searching...");
        Reflections reflections = new Reflections("io.teaql");
        Set<Class<? extends UserContext>> classes = reflections.getSubTypesOf(UserContext.class);
        for(Class c : classes) {
            System.out.println(c.getName());
        }
    }
}
