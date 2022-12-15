import java.util.HashMap;
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

    public static void isStringPalindrome(String stringInput) {
        String originalStr = stringInput;
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

    public static void repeatedChars(String input) {
        // Split string into char array
        char[] charArray = input.toCharArray();

        // use char as map key every iteration
        HashMap<Character, Integer> map = new HashMap<>();

        // for each loop to loop over the char array
        for(char c: charArray) {
            // If char already exists increment count
            if(map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, ++count);
            } else {
                // This will initialize the char at count 1
                map.put(c, 1);
            }
        }

        // Loop through the keys which are characters
        for(char c: map.keySet()) {
            // Print char out if value is greater than 1
            if(map.get(c) > 1) {
                System.out.print(c + ": " + map.get(c) + ", ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a random number or word (\"q\" to quit): ");
        // Scan input
        Scanner sc = new Scanner(System.in);

        while (true) {
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

                // Change decimal to percent value
                System.out.println(percentChange(doubleInput) + "%");

                // Round double to integer
                double rounded = Math.round(doubleInput);
                System.out.println("Rounded number: " + rounded);

                // Check if rounded number is a palindrome
                isNumPalindrome((int) rounded);
            }

            // Check if input is a string
            else if (sc.hasNext()) {
                String stringInput = sc.next();

                if (stringInput.equals("q")) {
                    System.out.println("Exited");
                    return;
                }

                // Utilize isStringPalindrome method
                isStringPalindrome(stringInput);

                // Print out number of char in string
                System.out.println(stringInput.length() + " number of chars in " + stringInput);

                // Convert string into pig latin
                pigLatinConversion(stringInput);

                // Print out repeated chars
                System.out.print("Repeated chars are: ");
                repeatedChars(stringInput);
            }

            // Ask user if they like to quit or continue
            System.out.println();
            System.out.println("Enter 'q' to quit or enter a random # or word to continue");
        }
    }
}