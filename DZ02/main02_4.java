package DZ02;

public class main02_4 {

    public static void main(String[] args) {
        String s = ".3 + 1.56 = ";
        String[] parts = s.split(" ");
        double a = Double.parseDouble(parts[0]);
        double b = Double.parseDouble(parts[2]);
        double c = a + b;
        String d = s + c;
        System.out.println(d);
    }
}