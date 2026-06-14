public class LogChecker {
    public static void main(String[] args) throws Exception {
        System.out.println(org.slf4j.LoggerFactory.getLogger("ExecutionLog").getClass().getName());
    }
}
