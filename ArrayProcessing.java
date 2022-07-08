import textio.TextIO;

import java.util.ArrayList;

public class ArrayProcessing {

    static void sortArray(double[] A) {
        for(int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
            int maxLoc = 0;
            for(int j = 1; j <= lastPlace; j++) {
                if(A[j] > A[maxLoc]) {
                    maxLoc = j;
                }
            }
            double temp = A[maxLoc];
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;
        }
    }

    public static void main(String[] args) {
        var list = new ArrayList<Double>();
        int count = 0;
        double number;


        System.out.println("This program will take in a sequence of positive real numbers from the user and sort it.");
        System.out.println("Type \"0\" to end.\n\n");

        while (true) {
            number = TextIO.getlnDouble();
            if(number <= 0)
                break;
            list.add(number);
            count++;
        }

        if(count == 0) {
            System.out.println("No valid input recorded.");
        }
        else {
            double[] list2 = new double[count];
            for(int i = 0; i < count; i++) {
                list2[i] = list.get(i);
            }
            sortArray(list2);


            System.out.println("\nThese are the numbers you entered in increasing order:\n");

            for(int i = 0; i < count; i++) {
                System.out.println(list2[i]);
            }
            System.out.println();
            System.out.print("End of program.");

        }



    }
}
