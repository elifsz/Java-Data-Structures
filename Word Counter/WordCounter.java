
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author elif
 */
public class WordCounter {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        File commonWordFile = new File("commonwords.txt");
        ArrayList<String> commonWords = new ArrayList<>();
        Scanner scCommonWord = new Scanner(commonWordFile);
        //read common word file and 
        //add the arraylist
        while (scCommonWord.hasNextLine()) {
            String temp = scCommonWord.nextLine();
            commonWords.add(temp);
        }
        //read 3 book file and add array list
        String[] fileName = {"dyssy10.txt", "tomsawyer.txt", "totc.txt"};
        for (int i = 0; i < fileName.length; i++) {
            File fileBook = new File(fileName[i]);
            HashMap<String, Integer> mapWord = new HashMap<>();
            ArrayList<String> booksWords = new ArrayList<>();
            Scanner scBook = new Scanner(fileBook);
            while (scBook.hasNextLine()) {
                String[] temp = scBook.nextLine().toLowerCase().split("[^a-zA-Z']");
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j].length() > 1) {
                        booksWords.add(temp[j]);
                    }
                }
            }
            //using haspmap for same words
            for (int j = 0; j < booksWords.size(); j++) {
                if (mapWord.containsKey(booksWords.get(j))) {
                    int count = mapWord.get(booksWords.get(j));
                    mapWord.put(booksWords.get(j), count + 1);
                } else {
                    mapWord.put(booksWords.get(j), 1);
                }
            }
            //remove haspmap commonwords
            for (int j = 0; j < commonWords.size(); j++) {
                if (mapWord.containsKey(commonWords.get(j))) {
                    mapWord.remove(commonWords.get(j));
                }
            }

            System.out.println("please write number of words: ");
            int numberOfWords = sc.nextInt();
            System.out.println("BOOK NAME: "+fileName[i]);
            //writing haspmap
            for (Map.Entry<String, Integer> entry : mapWord.entrySet()) {
                if (entry.getValue() > numberOfWords) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }
            }
        }

    }
}
