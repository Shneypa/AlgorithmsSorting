import java.lang.reflect.Array;

public class SelectionSort {

    public static void sort(int[] array) {

        // "show iterations" mode title
        if (Main.showIterations) {
            System.out.println();
            System.out.println("SelectionSort iterations: ");
        }

        int indexOfSmallestElement = 0;

        // for every position to be sorted...
        for (int k = 0; k < array.length; k++) {

            int smallestElement = array[k];

            // go through remaining right part of array and find smallest element
            for (int i = k + 1; i < array.length; i++) {

                if (array[i] < smallestElement) {
                    smallestElement = array[i];
                    indexOfSmallestElement = i;
                    Main.operations+=2;
                }
            }

            // degugging messages:
            if (Main.debugMessagesOn) System.out.println("SmallestElement: " + smallestElement);
            if (Main.debugMessagesOn) System.out.println("index: "+ indexOfSmallestElement);
            if (Main.debugMessagesOn) System.out.println("After swap: ");

            // ...swap that value with smallest
            array[indexOfSmallestElement] = array[k];
            array[k] = smallestElement;
            Main.operations +=2;
            if (Main.showIterations) ArrayManager.print(array);

        }
    }
}
