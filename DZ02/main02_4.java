package DZ02;

public class main02_4 {

    public static void main(String[] args) {
        String input = ".3 + 1.56 = ";
        String[] parts = input.split(" ");
        double firstNumber = Double.parseDouble(parts[0]);
        double secondNumber = Double.parseDouble(parts[2]);
        double result = firstNumber + secondNumber;
        String output = input + result;
        System.out.println(output);
    }
}