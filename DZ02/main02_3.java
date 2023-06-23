package DZ02;

public class main02_3 {

    public static void main(String[] args) {
        String s = "a".repeat(1000);
        long st = System.nanoTime();
        String sr = s.replace('a', 'A');
        long et = System.nanoTime();
        long fts = et - st;
        System.out.println("Время выполнения замены с использованием String         : " + fts + " наносекунд");

        st = System.nanoTime();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'a') {
                sb.setCharAt(i, 'A');
            }
        }
        sr = sb.toString();
        et = System.nanoTime();
        long ftsb = et - st;
        System.out.println("Время выполнения замены с использованием StringBuilder  : " + ftsb + " наносекунд");
    }
}