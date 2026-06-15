package io.teaql.worldcup.util;

/**
 * ANSI terminal color constants and helper methods.
 *
 * <p>Provides escape sequences for foreground colors, background colors,
 * and text styles. Helper methods wrap a string with the specified style
 * and automatically append {@link #RESET}.</p>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 *   System.out.println(AnsiColors.bold("World Cup 2026"));
 *   System.out.println(AnsiColors.green("✔ Match loaded"));
 * }</pre>
 */
public final class AnsiColors {

    private AnsiColors() {
        // utility class — no instantiation
    }

    // ── Styles ──────────────────────────────────────────────────────────

    /** Reset all attributes. */
    public static final String RESET   = "\u001B[0m";
    /** Bold / increased intensity. */
    public static final String BOLD    = "\u001B[1m";
    /** Dim / decreased intensity. */
    public static final String DIM     = "\u001B[2m";

    // ── Foreground colors ───────────────────────────────────────────────

    /** Red foreground. */
    public static final String RED     = "\u001B[31m";
    /** Green foreground. */
    public static final String GREEN   = "\u001B[32m";
    /** Yellow foreground. */
    public static final String YELLOW  = "\u001B[33m";
    /** Blue foreground. */
    public static final String BLUE    = "\u001B[34m";
    /** Magenta foreground. */
    public static final String MAGENTA = "\u001B[35m";
    /** Cyan foreground. */
    public static final String CYAN    = "\u001B[36m";
    /** White foreground. */
    public static final String WHITE   = "\u001B[37m";

    // ── Background colors ───────────────────────────────────────────────

    /** Red background. */
    public static final String BG_RED   = "\u001B[41m";
    /** Green background. */
    public static final String BG_GREEN = "\u001B[42m";
    /** Blue background. */
    public static final String BG_BLUE  = "\u001B[44m";

    // ── Helper methods ──────────────────────────────────────────────────

    /**
     * Wraps {@code text} in bold.
     *
     * @param text the string to style
     * @return the styled string
     */
    public static String bold(String text) {
        return BOLD + text + RESET;
    }

    /**
     * Wraps {@code text} in green.
     *
     * @param text the string to style
     * @return the styled string
     */
    public static String green(String text) {
        return GREEN + text + RESET;
    }

    /**
     * Wraps {@code text} in red.
     *
     * @param text the string to style
     * @return the styled string
     */
    public static String red(String text) {
        return RED + text + RESET;
    }

    /**
     * Wraps {@code text} in yellow.
     *
     * @param text the string to style
     * @return the styled string
     */
    public static String yellow(String text) {
        return YELLOW + text + RESET;
    }

    /**
     * Wraps {@code text} in cyan.
     *
     * @param text the string to style
     * @return the styled string
     */
    public static String cyan(String text) {
        return CYAN + text + RESET;
    }

    public static int visibleLength(String s) {
        String noAnsi = s.replaceAll("\u001B\\[[;\\d]*m", "");
        int len = 0;
        for (int i = 0; i < noAnsi.length(); i++) {
            char c = noAnsi.charAt(i);
            if (Character.isHighSurrogate(c)) {
                len += 1; // Regional indicators and emojis generally take 1 cell per surrogate pair (e.g. flag = 2 pairs = 2 cells)
                i++;
            } else if (c == '\uFE0F') {
                // skip
            } else {
                len++;
            }
        }
        return len;
    }

    public static String padRight(String s, int n) {
        int visible = visibleLength(s);
        if (visible >= n) {
            return s;
        }
        return s + " ".repeat(n - visible);
    }
}
