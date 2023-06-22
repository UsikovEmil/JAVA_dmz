package DZ02;

public class main02_3 {

    public static void main(String[] args) {
        String input = "a".repeat(1000);
        long startTime = System.nanoTime();
        String result = input.replace('a', 'A');
        long endTime = System.nanoTime();
        long durationString = endTime - startTime;
        System.out.println("Время выполнения замены с использованием String         : " + durationString + " наносекунд");

        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'a') {
                sb.setCharAt(i, 'A');
            }
        }
        result = sb.toString();
        endTime = System.nanoTime();
        long durationStringBuilder = endTime - startTime;
        System.out.println("Время выполнения замены с использованием StringBuilder  : " + durationStringBuilder + " наносекунд");
    }
}