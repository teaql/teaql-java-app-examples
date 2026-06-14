public class TestFix {
    public static void main(String[] args) {
        String s = "🇲🇽 Mexico";
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isHighSurrogate(c)) {
                len += 1; // 1 cell per surrogate pair
                i++;
            } else {
                len++;
            }
        }
        System.out.println("Visible length: " + len);
    }
}
