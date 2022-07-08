import textio.TextIO;

import java.util.ArrayList;
import java.util.Arrays;


public class ProcessText {

    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<>();
        boolean read, check;
        int count = 0;

        System.out.println("This program will let you select a file, and it would arrange all words in the file\nin alphabetical order.");
        System.out.println("Do you wish to continue?");
        read = TextIO.getlnBoolean();

        if(!read) {
            System.out.println("\n\nGoodbye.");
        }
        else {
            check = TextIO.readUserSelectedFile();
            if(check) {
                while(true) {
                    String str = readNextWord();
                    if(str == null)
                        break;
                    wordList.add(str.toLowerCase());
                    count++;
                }
                if(count < 1) {
                    System.out.println("There were no words in the selected file.");
                }
                else {
                    String[] words = new String[wordList.size()];
                    for(int i = 0; i < words.length; i++) {
                        words[i] = wordList.get(i);
                    }
                    Arrays.sort(words);

                    for(int i = 0; i < words.length-1; i++) {
                        if(words[i].equals(words[i + 1])) {
                            for(int j = i+1; j < words.length; j++) {
                                words[j-1] = words[j];
                            }
                            count--;
                        }
                    }
                    String[] words2 = Arrays.copyOf(words,count);

                    TextIO.writeUserSelectedFile();
                    for(String word : words2) {
                        TextIO.putln(word);
                    }
                    TextIO.putln("\n\nNumber of words: " + count);

                    TextIO.writeStandardOutput();
                    System.out.println("\nEnd of program...");
                }


            }
            else {
                System.out.println("No file was selected.");
            }

        }
    }

    private static String readNextWord() {
        char ch = TextIO.peek();
        while (ch != TextIO.EOF && !Character.isLetter(ch)) {
                //Skip past non-letters.
            TextIO.getAnyChar();
            ch = TextIO.peek();
        }
        if(ch == TextIO.EOF)
            return null;

        String word = "";
        while (true) {
            word += TextIO.getAnyChar();
            ch = TextIO.peek();
            if(ch == '\'') {
                TextIO.getAnyChar();
                ch = TextIO.peek();

                if(Character.isLetter(ch)) {
                    word += "\'" + TextIO.getAnyChar();
                    ch = TextIO.peek();
                }
                else
                    break;
            }
            if(!Character.isLetter(ch)) {
                   //If the next character is not a letter, the word is finished, so break out of the loop.
                break;
            }
            // If we haven't broken out of the loop, next char is a letter.
        }
        return word;    // Return word that has been read.
    }
}
