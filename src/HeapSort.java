
// change name of the class to HeapManager once everything is coded

// how to find how many rows a heap has?

// rows = log2 ( array.length + 1 )


public class HeapSort {

    // organize heap
    public static int[] organize(int[] array) {

        // for every element from i = 0 to array.length

            // check if any child is bigger.
            // then swap with bigger child
                // swap that child to the top
                // (check that child's parent)

        return array;
    }



    // find left child's index
    private static int leftChildIndex(int parentIndex) {
        return  2 * parentIndex + 1;
    }

    // find right child's index
    private static int rightChildIndex(int parentIndex) {
        return  2 * parentIndex + 2;
    }

    // find parent index by floor rounding
    private static int findParentIndex(int childIndex) {
        return (int)Math.floor((childIndex - 1)/2);
    }

    // find parent index by whether child has odd or even index
    private static int findParentIndexByOddEven(int childIndex) {
        int parentIndex = 0;

        if (childIndex % 2 == 0) {
            parentIndex = (childIndex - 2) / 2;
        } else {
            parentIndex = (childIndex - 1) / 2;
        }

        return parentIndex;
    }

    // swap child-parent values
    private static int[] swapChildWithParent(int[] array, int childIndex, int parentIndex) {

        int temp = array[parentIndex];
        array[parentIndex] = array[childIndex];
        array[childIndex] = temp;

        return array;
    }

    // rise element to the top if it is worthy
    private static void riseToTheTop(int[] array, int childIndex) {

        int parentIndex = findParentIndex(childIndex);

        // if child > parent...
        if (array[childIndex] > array[parentIndex]) {
            // ... swap
            swapChildWithParent(array,childIndex,parentIndex);
        }

    }

    // delete element at index i
    private static void deleteAtIndex(int index) {

    }


    // print heap
    public static void printHeap(int[] array) {
        System.out.println();
        System.out.println("printing array as a binary heap tree:");

        double row = 1;

        int lastIndexInRow = (int)(Math.pow(2,row) - 2);

        for (int i = 0; i < array.length; i++) {

            if(Main.debugMessagesOn) System.out.println("i = " + i + " row = " + row + " lastIndexInRow = " + lastIndexInRow);

            System.out.print(array[i] + " ");

            if (i == lastIndexInRow){
                System.out.println();
                row++;
                lastIndexInRow = (int)(Math.pow(2,row) - 2);
            }
        }



    }


    // count how many rows a heap has
    public static int findNumberOfRowsInHeap(int[] array) {

        int numberOfRows = (int)Math.ceil(Logarithm.log2((double)(array.length + 1)));

        return numberOfRows;
    }


    // sorting:
    // remove grandparent  (put it into sorted part of array)
    // organize heap
    // ...
    private static int[] sort(int[] array) {

        return array;
    }

}
