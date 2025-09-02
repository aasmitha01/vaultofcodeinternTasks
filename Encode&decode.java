import java.util.Scanner; 
public class TextEncoderDecoder { 
    // Method to encode a message 
    public static String encode(String message, int shift) { 
        StringBuilder encoded = new StringBuilder(); 
        for (char ch : message.toCharArray()) { 
            if (Character.isUpperCase(ch)) { 
                // Shift uppercase letters 
                char c = (char) ((ch - 'A' + shift) % 26 + 'A'); 
                encoded.append(c); 
            } else if (Character.isLowerCase(ch)) { 
                // Shift lowercase letters 
                char c = (char) ((ch - 'a' + shift) % 26 + 'a'); 
                encoded.append(c); 
            } else { 
                // Keep non-letters unchanged 
                encoded.append(ch); 
            } 
        } 
        return encoded.toString(); 
    } 
    // Method to decode a message 
    public static String decode(String message, int shift) { 
        // Decoding is just encoding with negative shift 
        return encode(message, 26 - (shift % 26)); 
    } 
    // Method to display menu 
    public static void showMenu() { 
        System.out.println("\n=== Text Encoder & Decoder ==="); 
        System.out.println("1. Encode a message"); 
        System.out.println("2. Decode a message"); 
        System.out.println("3. Exit"); 
        System.out.print("Enter your choice: "); 
    } 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        int choice; 
        do { 
            showMenu(); 
            choice = sc.nextInt(); 
            sc.nextLine(); // consume newline 
            switch (choice) { 
                case 1: 
                    System.out.print("Enter message to encode: "); 
                    String message = sc.nextLine(); 
                    System.out.print("Enter shift value: "); 
                    int shift = sc.nextInt(); 
                    sc.nextLine(); 
                    String encoded = encode(message, shift); 
                    System.out.println("Encoded Message: " + encoded); 
                    break; 
                case 2: 
                    System.out.print("Enter message to decode: "); 
                    String encodedMsg = sc.nextLine(); 
                    System.out.print("Enter shift value: "); 
                    int shiftDecode = sc.nextInt(); 
                    sc.nextLine(); 
                    String decoded = decode(encodedMsg, shiftDecode); 
                    System.out.println("Decoded Message: " + decoded); 
                    break; 
                case 3: 
                    System.out.println("Exiting program. Goodbye!"); 
                    break; 
                default: 
                    System.out.println("Invalid choice! Please try again."); 
            } 
        } while (choice != 3); 
        sc.close(); 
    } 
} 
 
 
