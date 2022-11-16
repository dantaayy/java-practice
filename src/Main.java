import java.util.Scanner;
import java.lang.Math; // Need this library to use Math.round

public class Main {

    // Integer palindrome function
    public static int isNumPalindrome(int n) {
        int remainder;
        int reverseNum = 0;
        int originalNum = n;
        while (n != 0) {
            // Use modulo 10 to get last int in number
            remainder = n % 10;
            reverseNum = reverseNum * 10 + remainder;
            n /= 10;
        }
        if (originalNum == reverseNum) {
            System.out.println(originalNum + " is a palindrome!");
        } else {
            System.out.println(originalNum + " is NOT a palindrome!");
        }
        return reverseNum;
    }

    // Fibonacci Function
    private static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        // placeholders for fib func for speed efficiency
        int a = 0;
        int b = 1;
        int sum = a + b;

        while(n > 1) {
            sum = a + b;
            a = b;
            b = sum;
            n--;
        }
        // return previous fib number
        return a;
    }

    // Method to change num to percent value
    public static double percentChange(double n) {
        double percentVal = n * 100;
        return percentVal;
    }

    public static void pigLatinConversion(String input) {
        // Convert string into pig latin
        char c;
        int vowelIndex;
        String newWord = input.toLowerCase();

        for (int i = 0; i < newWord.length(); i++) {
            c = newWord.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelIndex = newWord.indexOf(c);
                System.out.println("Pig latin conversion: " + newWord.substring(vowelIndex) + newWord.substring(0,vowelIndex) + "ay");
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a random number or word (\"q\" to quit): ");
        // Scan input
        Scanner sc = new Scanner(System.in);

        // Check if input is an int
        if (sc.hasNextInt()) {
            int numInput = sc.nextInt();
            int originalNum = numInput;

            isNumPalindrome(originalNum);

            // Print fib function
            System.out.println("Previous fib number is: " + fib(numInput));
        }

        // Check if input is a double
        else if (sc.hasNextDouble()) {
            double doubleInput = sc.nextDouble();
            double originalNum = doubleInput;

            // Change decimal to percent value
            System.out.println(percentChange(doubleInput) + "%");

            // Round double to integer
            double rounded = Math.round(doubleInput);
            System.out.println("Rounded number: " + rounded);

            // Check if rounded number is a palindrome
            isNumPalindrome((int) rounded);
        }

        // Check if input is a string
        else if(sc.hasNext()) {
            String stringInput = sc.next();
            String originalStr = stringInput;
            // System.out.println("String: " + stringInput);
            if(stringInput.equals("q")) {
                System.out.println("Exited");
                return;
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
            pigLatinConversion(stringInput);

        }
    }
}