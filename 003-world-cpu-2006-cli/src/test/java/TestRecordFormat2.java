public class TestRecordFormat2 {
    public static void main(String[] args) {
        System.out.printf(" %-3s %-20s %2s  %2s  %2s  %2s   %2s  %2s  %3s  %3s%n",
                "#", "Team", "P", "W", "D", "L", "GF", "GA", "GD", "Pts");
        System.out.printf(" %-3d %s %-17s %2d  %2d  %2d  %2d   %2d  %2d  %3s  %3s%n",
                1, "🇲🇽", "Mexico", 0, 0, 0, 0, 0, 0, "  0", "  0");
        System.out.printf(" %-3d %s %-17s %2d  %2d  %2d  %2d   %2d  %2d  %3s  %3s%n",
                2, "🇿🇦", "South Africa", 0, 0, 0, 0, 0, 0, "  0", "  0");
    }
}
