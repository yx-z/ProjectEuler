package Problem059;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Each character on a computer is assigned a unique code and the preferred standard is ASCII
 * (American Standard Code for Information Interchange).
 * For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.
 * <p>
 * A modern encryption method is to take a text file, convert the bytes to ASCII,
 * then XOR each byte with a given value, taken from a secret key.
 * The advantage with the XOR function is that using the same encryption key on the cipher text, restores the plain text;
 * for example, 65 XOR 42 = 107, then 107 XOR 42 = 65.
 * <p>
 * For unbreakable encryption, the key is the same length as the plain text message, and the key is made up of random bytes.
 * The user would keep the encrypted message and the encryption key in different locations, and without both "halves",
 * it is impossible to decrypt the message.
 * <p>
 * Unfortunately, this method is impractical for most users, so the modified method is to use a password as a key.
 * If the password is shorter than the message, which is likely, the key is repeated cyclically throughout the message.
 * The balance for this method is using a sufficiently long password key for security, but short enough to be memorable.
 * <p>
 * Your task has been made easy, as the encryption key consists of three lower case characters.
 * Using cipher.txt (right click and 'Save Link/Target As...'), a file containing the encrypted ASCII codes,
 * and the knowledge that the plain text must contain common English words,
 * decrypt the message and find the sum of the ASCII values in the original text.
 */

public class XorDecrypt {
    public static void main(String[] args) throws IOException {
        //init.
        byte[] cipher = readFile("src/Problem059/cipher.txt");
        int maxScore = 0;
        byte[] bestDecrypted = new byte[cipher.length];
        byte[] key = {(byte) 'a', (byte) 'a', (byte) 'a'};

        //iterate through all keys
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    key[0] = (byte) ('a' + i);
                    key[1] = (byte) ('a' + j);
                    key[2] = (byte) ('a' + k);

                    byte[] decrpyted = decrypt(cipher, key);
                    if (score(decrpyted) > maxScore) {
                        maxScore = score(decrpyted);
                        bestDecrypted = decrpyted;
                    }
                }
            }
        }

        //add ascii value
        int sum = 0;
        for (byte b : bestDecrypted) sum += b;
        System.out.println(sum);
    }

    private static byte[] readFile(String fileName) throws IOException {
        String[] file;

        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = bufferedReader.readLine();
        if (line.isEmpty()) return null;
        bufferedReader.close();

        file = line.split(",");

        byte[] ascii = new byte[file.length];
        for (int i = 0; i < file.length; i++)
            ascii[i] = Byte.parseByte(file[i]);

        return ascii;
    }

    private static byte[] decrypt(byte[] message, byte[] key) {
        byte[] dycrypted = new byte[message.length];
        for (int i = 0; i < message.length; i++)
            dycrypted[i] = (byte) (message[i] ^ key[i % key.length]);
        return dycrypted;
    }

    //evaluate if the decrypted msg is readable
    private static int score(byte[] b) {
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            char c = (char) b[i];
            if (c >= 'A' && c <= 'Z')
                sum += 1;  // Uppercase letters are good
            else if (c >= 'a' && c <= 'z')
                sum += 2;  // Lowercase letters are excellent
            else if (c < 0x20 || c == 0x7F)
                sum -= 1;  // Control characters are  bad
        }
        return sum;
    }
}