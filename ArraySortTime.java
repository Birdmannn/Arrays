import java.util.*;


public class ArraySortTime {

    public static void main(String[] args) {
        int[] intArray = new int[10000];
        int[] intArrayCopy;
        long startTime, endTime, compTime;
        double seconds;
        String[] words = new String[20];
        String[] wordsCopy;

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int)(1000*Math.random())+1;
        }

        intArrayCopy = Arrays.copyOf(intArray,intArray.length);

        startTime = System.nanoTime();
        Arrays.sort(intArray);
        endTime = System.nanoTime();
        compTime = endTime - startTime;
        seconds =  compTime/1000_000_000;



        System.out.println("Compile Time for Arrays.sort() method: ");
        System.out.println("In Nanoseconds: " + compTime + "ns");
        System.out.println("In Seconds:    " + seconds + "s");
        System.out.println();

        startTime = System.nanoTime();
        selectionSort(intArrayCopy);
        endTime = System.nanoTime();
        compTime = endTime - startTime;
        seconds =  compTime/1000_000_000;

        System.out.println("Compile Time for selectionSort() method: ");
        System.out.println("In Nanoseconds: " + compTime + "ns");
        System.out.println("In seconds:    " + seconds + "s");


        System.out.println("\n\nThese are random strings in no order:\n");
        for (int i = 0; i < words.length; i++) {
            words[i] = randomString();
            System.out.println("   " + words[i]);
        }

        wordsCopy = Arrays.copyOf(words, 20);

        startTime = System.nanoTime();
        Arrays.sort(words);
        endTime = System.nanoTime();
        compTime = endTime - startTime;

        System.out.println("\nThese are the random strings in increasing order: \n");
        for (String str : words) {
            System.out.println("   " + str);
        }
        System.out.println("\nIt took " + compTime + "ns for Arrays.sort() method.");

        startTime = System.nanoTime();
        selectionSort(wordsCopy);
        endTime = System.nanoTime();
        compTime = endTime - startTime;

        System.out.println("It took " + compTime + "ns for selectionSort() method.");
        System.out.print("\n\n\nEnd of program.");

    }


    static void selectionSort(int[] A) {
        for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
            int maxLoc = 0;
            for (int j = 1; j <= lastPlace; j++) {
                if(A[j] > A[maxLoc]) {
                    maxLoc = j;
                }
            }
            int temp = A[maxLoc];
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;
        }
    }

    static void selectionSort(String[] A) {
        for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
            int maxLoc = 0;
            for (int j = 1; j <= lastPlace; j++) {
                if(A[j].compareTo(A[maxLoc]) > 0) {
                    maxLoc = j;
                }
            }
            String temp = A[maxLoc];
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;
        }
    }


    static String randomString() {
        int N = 5+(int)(21*Math.random());
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char ch = (char)('a'+(int)(26*Math.random()));
            str.append(ch);
        }
        return str.toString();
    }
}
