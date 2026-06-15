package io.teaql.worldcup;

import io.teaql.worldcup.command.GroupCommand;
import io.teaql.worldcup.command.GroupsCommand;
import io.teaql.worldcup.command.RankCommand;
import io.teaql.worldcup.command.RecordCommand;
import io.teaql.worldcup.db.DatabaseManager;
import io.teaql.worldcup.db.SeedData;
import io.teaql.worldcup.util.AnsiColors;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * FIFA World Cup 2026 CLI — main entry point.
 *
 * <p>Provides a command-line interface for exploring World Cup 2026
 * groups, fixtures, standings, and match results.</p>
 *
 * <p>Usage: {@code wc2026 [COMMAND] [OPTIONS]}</p>
 */
@Command(
        name = "wc2026",
        description = "FIFA World Cup 2026 CLI — groups, fixtures, standings & more",
        mixinStandardHelpOptions = true,
        version = "wc2026-cli 1.0.0-SNAPSHOT",
        header = {
                "",
                AnsiColors.BOLD + AnsiColors.CYAN + "⚽  FIFA World Cup 2026 CLI" + AnsiColors.RESET,
                AnsiColors.DIM + "   United States · Mexico · Canada" + AnsiColors.RESET,
                ""
        },
        subcommands = {
                GroupsCommand.class,
                GroupCommand.class,
                RankCommand.class,
                RecordCommand.class
        }
)
public class Wc2026Cli implements Runnable {

    /**
     * When invoked without a subcommand, print usage help.
     */
    @Override
    public void run() {
        if (System.console() == null) {
            new CommandLine(this).usage(System.out);
            return;
        }

        System.out.println(AnsiColors.bold(AnsiColors.GREEN + "Welcome to FIFA World Cup 2026 Interactive CLI!" + AnsiColors.RESET));
        System.out.println(AnsiColors.DIM + "Type 'help' for commands, 'clear' to clear screen, 'exit' or 'quit' to exit." + AnsiColors.RESET);
        System.out.println();
        
        try {
            org.jline.terminal.Terminal terminal = org.jline.terminal.TerminalBuilder.builder().system(true).build();
            CommandLine cmd = new CommandLine(this);
            org.jline.reader.Parser parser = new org.jline.reader.impl.DefaultParser();
            
            org.jline.reader.LineReader reader = org.jline.reader.LineReaderBuilder.builder()
                .terminal(terminal)
                .completer(new picocli.shell.jline3.PicocliJLineCompleter(cmd.getCommandSpec()))
                .parser(parser)
                .build();
            
            String prompt = AnsiColors.bold(AnsiColors.CYAN + "wc2026> " + AnsiColors.RESET);
            
            while (true) {
                try {
                    String line = reader.readLine(prompt);
                    if (line == null || line.trim().isEmpty()) {
                        continue;
                    }
                    line = line.trim();
                    if (line.equalsIgnoreCase("exit") || line.equalsIgnoreCase("quit")) {
                        break;
                    }
                    if (line.equalsIgnoreCase("clear")) {
                        terminal.puts(org.jline.utils.InfoCmp.Capability.clear_screen);
                        terminal.flush();
                        continue;
                    }
                    if (line.equalsIgnoreCase("help")) {
                        cmd.usage(System.out);
                        continue;
                    }
                    
                    org.jline.reader.ParsedLine parsedLine = reader.getParser().parse(line, 0);
                    String[] splitArgs = parsedLine.words().toArray(new String[0]);
                    cmd.execute(splitArgs);
                    System.out.println();
                } catch (org.jline.reader.UserInterruptException | org.jline.reader.EndOfFileException e) {
                    break;
                }
            }
        } catch (java.io.IOException e) {
            System.err.println("Failed to initialize terminal: " + e.getMessage());
        }
    }

    /**
     * Application entry point.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // Silence java.util.logging
        java.util.logging.LogManager.getLogManager().reset();
        
        // Intercept standard output to hide ExecutionLog
        System.setOut(new io.teaql.worldcup.util.LogInterceptor(System.out));
        
        // Initialize database before executing any command
        DatabaseManager db = DatabaseManager.getInstance();
        try {
            io.teaql.core.UserContext ctx = db.getContext();
            SeedData.seed(ctx);
        } catch (Exception e) {
            e.printStackTrace();
            // Non-fatal: commands will check isInitialized() and show a helpful error
        }

        int exitCode = new CommandLine(new Wc2026Cli()).execute(args);

        db.close();
        System.exit(exitCode);
    }
}
