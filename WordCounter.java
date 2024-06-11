import java.util.Scanner;
import java.util.regex.Pattern;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Word Counter!");
        System.out.print("Enter a text or provide a file (type 'file' to read from a file): ");
        String input = scanner.nextLine();

        String text;
        if (input.equalsIgnoreCase("file")) {
            // Read text from a file (you can implement this part)
            // For demonstration, let's assume the text is already read from the file
            text = "This is a sample text. Count the words in this text!";
        } else {
            text = input;
        }

        // Split the text into words using space and punctuation as delimiters
        String[] words = text.split("[\\s.,;!?]+");

        // Initialize a counter for the number of words
        int wordCount = words.length;

        // Display the total word count
        System.out.println("Total words: " + wordCount);

        // Additional features:
        // 1. Ignoring common words (stop words)
        // 2. Unique word count
        // 3. Frequency of each word (optional)

        // Close the scanner
        scanner.close();
    }
}