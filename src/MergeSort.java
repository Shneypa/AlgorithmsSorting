

public class MergeSort {


    public static int[] sort(int[] array) {




        return array;
    }

    // recursively break down array
    public static int[] breakDown(int[] parentArray) {

        if ( parentArray.length == 1 ) {
            if (Main.debugMessagesOn) System.out.println("element " + parentArray[0]);
            return parentArray;
        }

        if (Main.debugMessagesOn) System.out.println("Breaking down array with length " + parentArray.length);

        int p = parentArray.length;                               // length of parent array
        int l = (int)Math.ceil((double)p / 2);            // length of left sub-array
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
        breakDown(leftArray);

        // breakdown right array
        breakDown(rightArray);

        return parentArray;
    }


    // Merge arrays
    public static void mergeArrays() {

    }

}
