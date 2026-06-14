public class TestAnsiG {
    public static void main(String[] args) {
        System.out.printf("%-5s %-20s %-4s%n", "Rank", "Team", "Grp");
        System.out.printf("%4d  %s %s\033[28G%-4s%n", 1, "🇺🇸", "United States", "D");
        System.out.printf("%4d  %s %s\033[28G%-4s%n", 2, "🇲🇽", "Mexico", "A");
    }
}
