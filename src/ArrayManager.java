import java.util.Random;


public class ArrayManager {

    // GENERATES ARRAY OF n RANDOM NUMBERS
    public static int[] generateRandomArray(int size ){

        Random rand = new Random();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size);
        }

        return array;

    }


    // PRINTS ARRAY (long arrays are printed in rows of N elements)
    public static void print(int[] array) {
        int elementsPerRow = 50;
        int elementCounter = 0;

        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");
            elementCounter++;

            if (elementCounter == elementsPerRow) {
                System.out.println();
                elementCounter = 0;
            }
        }
        System.out.println();
    }


    // Checks if array is sorted (TODO: Optimize this check)
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length-1; i++)
            if (array[i] > array[i+1]) {
                Main.operations++;
                return false;
            }
        return true;
    }

}
