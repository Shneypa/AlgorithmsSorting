// BubbleSort compares two elements and swaps the larger one to the right
// 1 4 3 2
// 1 3 4 2
// 1 3 2 4
// 1 2 3 4

// BubbleSort's      O =  n^2
// because we compare to every element

public class BubbleSort {

    public static int[] sort(int[] array) {

       // title
       if (Main.showIterations == true) {
           System.out.println();
           System.out.println("BubbleSort iterations:");

       }


       while(!ArrayManager.isSorted(array)) {               // TODO: clear this unnecessary check

            if (Main.showIterations == true) System.out.println("inner loop:");

            // check first and second element and swap if second is smaller. keep checking all elements...
            for (int i = 0; i < array.length - 1; i++) {

               if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    if (Main.countOperations) Main.operations = Main.operations + 3;

                    // shows bubblesort iteration in detail
                    if (Main.showIterations == true) {
                        ArrayManager.print(array);
                    }
                }
            }
        }

        return array;
    }




}
