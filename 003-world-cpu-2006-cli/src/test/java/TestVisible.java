public class TestVisible {
    public static void main(String[] args) {
        String s = "🇲🇽 Mexico";
        int len = io.teaql.worldcup.util.AnsiColors.visibleLength(s);
        System.out.println("String length: " + s.length());
        System.out.println("Visible length: " + len);
    }
}
