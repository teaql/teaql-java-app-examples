import java.util.logging.*;
public class TestJULSilence {
    public static void main(String[] args) throws Exception {
        LogManager.getLogManager().reset();
        io.teaql.worldcup.Wc2026Cli.main(new String[]{"groups"});
    }
}
