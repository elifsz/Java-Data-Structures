
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author elif
 */
public class PalindromeDetector {

    public static boolean isPalindrome(String sentence) {
        String newSentence;
        newSentence = sentence.replaceAll("[^a-zA-Z0-9]", "");
        for (int i = 0; i < newSentence.length() / 2; i++) {
            if (newSentence.toLowerCase().charAt(i) != newSentence.toLowerCase().charAt(newSentence.length() - i - 1)) {
                return false;
            }
        }
        return true;

    }

    public static boolean palindromes(String sentence, MyDeque mys) {
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) != (Character) mys.eject()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("palindromes.txt");
        /* Scanner scanner = new Scanner(file);
        MyDeque<String> my = new MyDeque<String>();
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            my.inject(data);
        }
        for (int i = 0; i < my.myArrayList.size(); i++) {
            String remove = my.pop();
            if (isPalindrome(remove)) {
                System.out.println(" \" " + remove + " \" " + " is a palindrome");
            }
        }
        scanner.close();*/

        MyDeque<Character> mys = new MyDeque<>();
        Scanner scanforChar = new Scanner(file);
        while (scanforChar.hasNextLine()) {
            String tempture = scanforChar.nextLine();
            String newTempture = tempture.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            for (int i = 0; i < newTempture.length(); i++) {
                mys.inject(newTempture.charAt(i));
            }
            if (palindromes(newTempture, mys)) {
                System.out.println("\"" + tempture + "\"" + "  is a palindrome");

            }
        }
        scanforChar.close();
    }
}
