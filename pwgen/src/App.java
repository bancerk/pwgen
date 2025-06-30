import java.security.SecureRandom;
import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Password Generator!\nDisclaimer: This program's sole aim is to generate random passwords with your specifications.\nIt will not store or remember any of the generated passwords.");
        Scanner scanner = new Scanner(System.in);
        SecureRandom secureRandom = new SecureRandom();
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nPlease answer the following prompts to determine the complexity of the password\n");
            System.out.print("Please enter desired character length: ");
            int passwordLength = scanner.nextInt();
            scanner.nextLine();
            boolean isUppercase = ask(scanner, "Include uppercase letters ? (Yes/No)");
            boolean isLowercase = ask(scanner, "Include lowercase letters ? (Yes/No)");
            boolean isNumbers = ask(scanner, "Include numbers ? (Yes/No)");
            boolean isSpecial = ask(scanner, "Include special characters ? (Yes/No)");
            StringBuilder chars = new StringBuilder();
            if (isUppercase) chars.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            if (isLowercase) chars.append("abcdefghijklmnopqrstuvwxyz");
            if (isNumbers) chars.append("0123456789");
            if (isSpecial) chars.append("!@#$%^&*()-+");
            if (chars.length() == 0) {
                System.out.println("No character types selected. Please select at least one type.");
                continue;
            }
            List<Character> passwordChars = new ArrayList<>();
            if (isNumbers) addRandomChars(passwordChars, "0123456789", 2, secureRandom);
            if (isSpecial) addRandomChars(passwordChars, "!@#$%^&*()-+", 2, secureRandom);
            for (int i = passwordChars.size(); i < passwordLength; i++)
                passwordChars.add(chars.charAt(secureRandom.nextInt(chars.length())));
            Collections.shuffle(passwordChars, secureRandom);
            StringBuilder generatedPassword = new StringBuilder();
            for (char c : passwordChars) generatedPassword.append(c);
            System.out.println("Generated Password: " + generatedPassword);
            System.out.println();
            System.out.print("Do you want to generate another password? (Yes/No): ");
            String cont = scanner.nextLine();
            if (cont.equalsIgnoreCase("No")) {
                System.out.println("Thank you for using the Password Generator!");
                isRunning = false;
            } else if (!cont.equalsIgnoreCase("Yes")) {
                System.out.println("Invalid input. Exiting the program.");
                isRunning = false;
            }
        }
        scanner.close();
    }
    private static boolean ask(Scanner scanner, String prompt) {
        System.out.print(prompt + " ");
        String ans = scanner.nextLine();
        return ans.equalsIgnoreCase("Yes");
    }
    private static void addRandomChars(List<Character> list, String chars, int count, SecureRandom rnd) {
        for (int i = 0; i < count; i++)
            list.add(chars.charAt(rnd.nextInt(chars.length())));
    }
}
