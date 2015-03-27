
// change name of the class to HeapManager once everything is coded

// how to find how many rows a heap has?

// rows = log2 ( array.length + 1 )

//

// TODO: refactor this class into 2 classes:
//  HeapManager  to do heapify and subTree sorting
//  HeapSort    to sort array using HeapManager

// TODO: rewrite HeapSort in a simpler code


public class HeapSort {

    private static int sortedElements = 0;
    private static int heapifySubTreeFunctionCallCounter = 0;


    // sorting:
    public static int[] sort(int[] array) {

        if (Main.debugMessagesOn) System.out.println("sort array function called");

        // organize the whole array as a heap
        heapify(array);
        if (Main.debugMessagesOn) System.out.println("Heapify Sub Tree function called " + heapifySubTreeFunctionCallCounter+ " times");

        if (Main.debugMessagesOn) printArrayAsHeap(array);

        int indexOfLastElement = array.length - 1;


        while (sortedElements < array.length) {

            swapChildWithParent(array, indexOfLastElement, 0);   // swap root and last element

            if (Main.debugMessagesOn) System.out.println("swapped root and last element");
            if (Main.debugMessagesOn) printArrayAsHeap(array);

            sortedElements++;           // lock the sorted element
            indexOfLastElement--;

            heapifySubTree(array, 0);    // restore order

        }

        if (Main.debugMessagesOn) {
            System.out.println();
            System.out.println("ARRAY SORTED");
            System.out.println("Heapify Sub Tree function called total of " + heapifySubTreeFunctionCallCounter+ " times");
            System.out.println();
        }

        System.out.println("****************   Heapify Sub Tree function called TOTAL OF __ " + heapifySubTreeFunctionCallCounter+ " __ times   **************** ");
        System.out.println("*****************************************   To sort array of __ " + sortedElements + " __ elements   ************* ");
        return array;
    }


    // organize heap (largest element on top of the tree)  ( Max-heapify )
    public static int[] heapify(int[] array) {

        if (Main.debugMessagesOn) System.out.println("heapify function called");

        int lastSubTree = findParentIndex(array.length - 1) + 1;
        int currentSubTree = lastSubTree;

        // for every sub-Tree from last to first...
        for (int t = currentSubTree; t > 0; t--) {
            // ... heapify subtree
            heapifySubTree(array, t - 1);          // parent index   =    tree index - 1

            if (Main.debugMessagesOn) System.out.println("Hepified subTree " + t);
            if (Main.debugMessagesOn) printArrayAsHeap(array);
        }
        if (Main.debugMessagesOn) System.out.println("HEAPIFY COMPLETE");
    return array;
    }




    // heapify sub-tree recursively to fix conflicts asap
    private static int[] heapifySubTree(int[] array, int parentIndex) {

        heapifySubTreeFunctionCallCounter++;
        if (Main.debugMessagesOn) System.out.println("heapifySubTree function called for subTree with parent index " + parentIndex);

        int leftChildIndex = findLeftChildIndex(parentIndex);
        int rightChildIndex = findRightChildIndex(parentIndex);

        // if we're trying to heapify elements that are already sorted... stop! (dont heapify this subtree)
        if (leftChildIndex >= array.length - sortedElements) {                          // could be bugged
           return array;
        }

        // if we're at last tree with only one child ( left child )
        if (rightChildIndex >= array.length - sortedElements ) {                        // could be bugged
            // compare only child to parent and swap
            if ( array[leftChildIndex] > array[parentIndex] ) {
                swapChildWithParent(array, leftChildIndex, parentIndex);
            }
        } else {    // we're looking at regular sub-tree with 1 parent and 2 children

            // if left child >= right child > parent
            if ( (array[leftChildIndex] >= array[rightChildIndex]) && (array[leftChildIndex] > array[parentIndex])){
                swapChildWithParent(array, leftChildIndex, parentIndex);

                // fix potential conflicts
                if(checkForConflict(array, parentIndex * 2 + 1)) {
                    if (Main.debugMessagesOn) System.out.println("conflict in subTree with parent index " + (parentIndex * 2 + 1) );
                    heapifySubTree(array, parentIndex * 2 + 1);
                }

            } else if ((array[rightChildIndex] > array[leftChildIndex]) && (array[rightChildIndex] > array[parentIndex])) {
                // if right child > left child > parent
                swapChildWithParent(array, rightChildIndex, parentIndex);

                // fix potential conflicts
                if (checkForConflict(array, parentIndex * 2 + 2)) {
                    if (Main.debugMessagesOn) System.out.println("conflict in subTree with parent index " + (parentIndex * 2 + 2) );
                    heapifySubTree(array, parentIndex * 2 + 2);
                }
            }
        }
        return array;

    }

    // check subtree for conflict
    private static boolean checkForConflict(int[] array, int parentIndex) {

        if (Main.debugMessagesOn) System.out.println("checkForConflict function called");

        int leftChildIndex = findLeftChildIndex(parentIndex);
        int rightChildIndex = findRightChildIndex(parentIndex);

        // if there exists right child (and it is within unsorted array...
        if(!(rightChildIndex >= array.length - 1 - sortedElements)) {

            //... and it is larger than parent ... then there is conflict (and we will need to sort sub-tree)
            if (array[rightChildIndex] > array[parentIndex]) {
                return true;
            }
        }

        // if there exists left child (and it is within unsorted array...
        if (!(leftChildIndex >= array.length - 1 - sortedElements)) {

            //... and it is larger than parent ... then there is conflict (and we will need to sort sub-tree)
            if( array[leftChildIndex] > array[parentIndex] ) {
                return true;
            }
        }

        return false;

    }

    // find left child's index
    private static int findLeftChildIndex(int parentIndex) {

        return  2 * parentIndex + 1;
    }

    // find right child's index
    private static int findRightChildIndex(int parentIndex) {
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

    // check if child is left child
    private static boolean childIsRightChild(int childIndex) {
        if (childIndex % 2 == 0) {
            return true;
        } else return false;
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
    public static void printArrayAsHeap(int[] array) {
        System.out.println("printing array as a binary heap tree:");

        double row = 1;

        int lastIndexInRow = (int)(Math.pow(2,row) - 2);

        for (int i = 0; i < array.length; i++) {

            // if(Main.debugMessagesOn) System.out.println("i = " + i + " row = " + row + " lastIndexInRow = " + lastIndexInRow);

            System.out.print(array[i] + " ");

            if (i == lastIndexInRow){
                System.out.println();
                row++;
                lastIndexInRow = (int)(Math.pow(2,row) - 2);
            }
        }

        System.out.println();
            System.out.println();
    }


    // count how many rows a heap has
    public static int findNumberOfRowsInHeap(int[] array) {

        int numberOfRows = (int)Math.ceil(Logarithm.log2((double)(array.length + 1)));

        return numberOfRows;
    }




}
