import textio.TextIO;
import java.util.ArrayList;
public class PrintArray {

    public static void main(String[] args) {
        int noOfInts, maxValue;

        System.out.println("Enter the number of integers: ");
        noOfInts = TextIO.getlnInt();
        System.out.println("Enter the maximum value: ");
        maxValue = TextIO.getlnInt();
        System.out.println();

        int[] intValues = createIntegerList(noOfInts, maxValue);
        System.out.println("These are the random values generated: ");

        for(int intValue : intValues) {
            System.out.println(intValue);
        }


    }


    static int[] createIntegerList(int N, int max) {
        var integerList = new ArrayList<Integer>();

        while(integerList.size() < N) {
            int value = (int)((max+1)*Math.random());
            integerList.add(value);
        }
        int[] intArray = new int[integerList.size()];
        for(int i = 0; i < integerList.size(); i++) {
            intArray[i] = integerList.get(i);
        }

        return intArray;
    }



}
