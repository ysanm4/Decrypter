import java.util.Scanner;

public class BruteForce {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the BruteForce Decoder!");
        System.out.println("What you need to do is provide the encoded text and keep trying random keys until the text has been decoded.");
        System.out.println("Also, do not add spaces between the text because it will break the code.");

        System.out.print("Enter the encoded text: ");
        String encodedText = scanner.nextLine().toLowerCase();

        while (true) {
            System.out.print("Enter a random key: ");
            String key = scanner.nextLine().toLowerCase();

            String decodedText = decodeVigenere(encodedText, key);

            System.out.println("Decoded text '" + key + "': " + decodedText);

            System.out.print("Is this the correct decoding? (yes/no): ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("yes")) {
                System.out.println("Successfully decoded!!!");
                break;
            }
        }

        scanner.close();
    }

    private static String decodeVigenere(String text, String key) {
        StringBuilder decodedText = new StringBuilder();

        String extendedKey = extendKey(key, text.length());

        for (int i = 0; i < text.length(); i++) {
            char encodedChar = text.charAt(i);
            char keyChar = extendedKey.charAt(i);

            char decodedChar = (char) (((encodedChar - keyChar + 26) % 26) + 'A');
            decodedText.append(decodedChar);
        }

        return decodedText.toString().toLowerCase();
    }

    private static String extendKey(String key, int length) {
        StringBuilder extendedKey = new StringBuilder();

        for (int i = 0; i < length; i++) {
            extendedKey.append(key.charAt(i % key.length()));
        }

        return extendedKey.toString();
    }
}
