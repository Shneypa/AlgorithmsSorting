

public class MergeSort {


     // recursively break down array
    public static int[] sort(int[] parentArray) {

        // if we broke down to 1-element array, stop recursive breakdown and start merging...
        if ( parentArray.length == 1 ) {
            if (Main.debugMessagesOn) System.out.println("element " + parentArray[0]);
            return parentArray;
        }

        if (Main.debugMessagesOn) System.out.println("Breaking down array with length " + parentArray.length);

        int p = parentArray.length;                                       // length of parent array
        int l = (int)Math.ceil((double)p / 2);          // length of left sub-array
        int r = (int)Math.floor((double)p / 2);                                               // length of right sub-array

        if (Main.debugMessagesOn) System.out.println("Left sub-array length " + l);
        if (Main.debugMessagesOn) System.out.println("Right sub-array length " + r);


        int[] leftArray = new int[l];
        int[] rightArray = new int[r];

        // initialize left array
        for (int i = 0; i < l; i++) {
            leftArray[i] = parentArray[i];
        }

        // initialize right array
        for (int i = 0; i < r; i++) {
            rightArray[i] = parentArray[l+i];
        }

        // break down left array
        leftArray = sort(leftArray);

        // breakdown right array
        rightArray = sort(rightArray);

        // Merge two sub-arrays into one sorted array
        parentArray = mergeArrays(leftArray, rightArray);

        return parentArray;
    }


    // Merge arrays  using while loops
    public static int[] mergeArrays(int[] leftArray, int[] rightArray) {

        int[] mergedArray = new int[leftArray.length + rightArray.length];
        int i = 0;      // index of element we are currently filling in merged array

        int j = 0;      // index of active element of left array
        int k = 0;      // ----------------------- of right array


        // while both arrays have unpicked elements
        while ((j < leftArray.length) && (k < rightArray.length)) {

            if (leftArray[j] <= rightArray[k]) {
                mergedArray[i] = leftArray[j];
                i++;
                j++;
            } else {
                mergedArray[i] = rightArray[k];
                i++;
                k++;
            }
        }

        // add remaining 'tail' from left array
        while (j < leftArray.length){
            mergedArray[i] = leftArray[j];
            i++;
            j++;
        }

        // or add remaining tail from right array
        while (k < rightArray.length) {
            mergedArray[i] = rightArray[k];
            i++;
            k++;
        }

        return mergedArray;

    }









    // ^^^ this Merge function was replaced by the above Merge function that uses while-loops ^^^
    // it is just for illustration now (to see how While-Loops compare to For-If-Continue loops)
    //
    // Merge arrays using " if logic"   and "continue to reset loop"
    public static int[] mergeArrays2(int[] leftArray, int[] rightArray) {

        int[] mergedArray = new int[leftArray.length + rightArray.length];

        int j = 0;      // index of active element of left array
        int k = 0;      // ----------------------- of right array



        for (int i = 0; i < mergedArray.length; i++) {

            // add remaining 'tail' from right array                //
            if (j == leftArray.length) {                            //
                mergedArray[i] = rightArray[k];                     //
                k++;                                                //
                continue;                                           //   this part is executed last
            }                                                       //
            // or add remaining 'tail' from left array              //  (after we've used all elements of one of sub-arrays)
            if (k== rightArray.length) {                            //
                mergedArray[i] = leftArray[j];                      //
                j++;                                                //
                continue;                                           //
            }

            // compare elements while we have them in both sub-arrays
            if (leftArray[j] <= rightArray[k] ) {
                mergedArray[i] = leftArray[j];
                j++;

            } else {
                mergedArray[i] = rightArray[k];
                k++;
            }


        }

        return mergedArray;

    }
}
