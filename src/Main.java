import java.util.Scanner;
import java.lang.Math; // Need this library to use Math.round

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter a random number or word (\"q\" to quit): ");
        // Scan input
        Scanner sc = new Scanner(System.in);
        // While loop to run as long as input is not q
        while (!sc.nextLine().equals("q")) {
            // Check if input is an int
            if (sc.hasNextInt()) {
                int numInput = sc.nextInt();
                // System.out.println("int: " + numInput);
                int remainder;
                int reverseNum = 0;
                int originalNum = numInput;
                while (numInput != 0) {
                    // Use modulo 10 to get last int in number
                    remainder = originalNum % 10;
                    reverseNum = reverseNum * 10 + remainder;
                    numInput /= 10;
                }
                if (originalNum == reverseNum) {
                    System.out.println(originalNum + " is a palindrome!");
                } else {
                    System.out.println(originalNum + " is NOT a palindrome!");
                }
            }
            // Check if input is a double
            else if (sc.hasNextDouble()) {
                double doubleInput = sc.nextDouble();
                // System.out.println("double: " + doubleInput);
                double originalNum = doubleInput;

                // Check if double is palindrome
                int remainder;
                int reverseNum = 0;


                // Change decimal to percent value
                double percentVersion = doubleInput * 100;
                System.out.println(percentVersion + "%");

                // Round double to integer
                double rounded = Math.round(doubleInput);
                System.out.println("Rounded number: " + rounded);
            }
            // Check if input is a string
            else if(sc.hasNext()) {
                String stringInput = sc.next();
                String originalStr = stringInput;
                // System.out.println("String: " + stringInput);
                if(stringInput.equals("q")) {
                    System.out.println("Exited");
                    break;
                }
                int length = stringInput.length();
                // Initialize empty string to rewrite originalStr
                String reversed = "";
                // Start at end of string
                for (int i = length-1; i >= 0; i--) {
                    reversed = reversed + stringInput.charAt(i);
                }
                // Check if originalStr matches reversed
                if(originalStr.toLowerCase().equals(reversed.toLowerCase())) {
                    System.out.println(stringInput + " is a palindrome!");
                } else {
                    System.out.println(stringInput + " is NOT a palindrome!");
                }

                // Print out number of char in string
                System.out.println(length + " number of chars in " + stringInput);

                // Convert string into pig latin
                char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
                for (int i = 0; i < length; i++) {

                }

            }

        }
    }
}