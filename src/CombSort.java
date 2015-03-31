// We 'Comb' array with narrower comb each time
// Comb factor empirically best is 1.3
// so at first pass the  gap = array.length / 1.3
// second pass    gap = gap / 1.3
// ...
// last pass gap = 1    (effectively one bubblesort pass)

// worst comment ever ^^  :)

// stay tuned, its really easy actually :)


public class CombSort {


    private static int gap = 0;



    public static int[] sort(int[] array) {

        gap = array.length;

        combPass(array);

        return array;
    }



    // recursive passes
    private static int[] combPass(int[] array) {

        gap = (int)Math.floor((double)gap / 1.3);            // gap gets 1.3 times smaller each pass.

        while (gap >= 1 ) {

            int i = 0;
            int j = i + gap;

            while (j < array.length) {

                if (array[i] > array[j]) {

                    // swap
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
                i++;
                j++;
            }

            combPass(array);
        }

        return array;
    }

}
