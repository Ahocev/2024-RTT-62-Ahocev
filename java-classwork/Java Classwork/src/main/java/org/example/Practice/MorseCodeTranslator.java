import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {  // Infinite loop to keep asking for input until broken by "exit"
            System.out.println("Enter your Morse Code (separate each symbol with space), or type 'exit' to quit:");

            String morseCodeString = input.nextLine();
            if (morseCodeString.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program.");
                break;  // Break the loop and exit the program
            }

            String[] morseCodeSymbols = morseCodeString.split(" ");
            StringBuilder translatedText = new StringBuilder();

            for (String symbol : morseCodeSymbols) {
                switch (symbol) {
                    case "*-":    translatedText.append("A"); break;
                    case "-***":  translatedText.append("B"); break;
                    case "-*-*":  translatedText.append("C"); break;
                    case "-**":   translatedText.append("D"); break;
                    case "*":     translatedText.append("E"); break;
                    case "**-*":  translatedText.append("F"); break;
                    case "--*":   translatedText.append("G"); break;
                    case "****":  translatedText.append("H"); break;
                    case "**":    translatedText.append("I"); break;
                    case "*---":  translatedText.append("J"); break;
                    case "-*-":   translatedText.append("K"); break;
                    case "*-**":  translatedText.append("L"); break;
                    case "--":    translatedText.append("M"); break;
                    case "-*":    translatedText.append("N"); break;
                    case "---":   translatedText.append("O"); break;
                    case "*--*":  translatedText.append("P"); break;
                    case "--*-":  translatedText.append("Q"); break;
                    case "*-*":   translatedText.append("R"); break;
                    case "***":   translatedText.append("S"); break;
                    case "-":     translatedText.append("T"); break;
                    case "**-":   translatedText.append("U"); break;
                    case "***-":  translatedText.append("V"); break;
                    case "*--":   translatedText.append("W"); break;
                    case "-**-":  translatedText.append("X"); break;
                    case "-*--":  translatedText.append("Y"); break;
                    case "--**":  translatedText.append("Z"); break;
                    default:      translatedText.append(""); // Append nothing for unmatched symbols
                }
            }

            // Print the translated text
            System.out.println("Translated text: " + translatedText.toString());
        }

        input.close(); // Close the scanner to free up resources after the loop is exited
    }
}