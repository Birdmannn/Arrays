public class PrintTranspose {

    public static void main(String[] args) {

        int[][] A = {{2, 4, 6},
                {3, 4, 5},
                {6, 0, 1}};

        System.out.println("For the given array below: ");
        for (int[] ints : A) {                               //for each row in A
            for (int i = 0; i < A.length; i++) {
                System.out.print("   " + ints[i] + ",  ");   //print each value in the row
            }
            System.out.println();
        }
        System.out.println("\n\nThe transpose is: ");
        printTranspose(A);

    }

    static int[][] transpose(int[][] intArray) {
        int[][] B = new int[intArray.length][intArray.length];

        for(int i = 0; i < B.length; i++) {     //makes i constant.
            for(int j = 0; j < B.length; j++) {    //moves through j before going to the next i
                B[j][i] = intArray[i][j];
            }
        }
        return B;
    }

    static void printTranspose(int[][] A) {
        int[][] transA = transpose(A);

        for (int[] ints : transA) {
            for (int i = 0; i < transA.length; i++) {
                System.out.print("   " + ints[i] + ",  ");
            }
            System.out.println();
        }
    }
}
