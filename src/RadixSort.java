// REMAINING ISSUES:

// 1. How to find K ? (number of passes, i.e. max length of numbers? )


// n = number of numbers
// d = number of digits (10)
// k = number of passes (length of numbers)


import java.util.ArrayList;
import java.util.LinkedList;

public class RadixSort {

    private static ArrayList<LinkedList> ListHolder = new ArrayList();

    private static int numberOfPasses = 6;              // number of passes (length of numbers)
    private static int radix = 10;                      // base of numerical system. 10 for decimal, 2 for binary, 16 for hex, etc...
                                                        // *** only works for 10 at the moment ***

    public static int[] sort(int[] array) {

        // fill ListHolder with 10  buckets ( LinkedLists )

        for (int i = 0; i < radix; i++) {

            ListHolder.add(new LinkedList<Integer>());

        }


        int m = radix;      // to find remainder
        int k = 1;          // to find appropriate digit in remainder


        for (int j = numberOfPasses; j > 0; j--) {


            // A PASS


            // 1. go through each element in array and put into according bucket
            for (int i = 0; i < array.length; i++) {

                int digit = array[i] % m;
                digit = digit / k;

                ListHolder.get(digit).add(array[i]);
            }


            // 2. reorder array.
            int i = 0;
            LinkedList<Integer> currentList;

            for (int l = 0; l < radix; l++) {

                currentList = ListHolder.get(l);

                while (!currentList.isEmpty()) {

                    array[i] = currentList.removeFirst();
                    i++;

                }
            }


            // 3. at the end of the pass, increase m and k to move to next digit
            m *= radix;
            k *= radix;

        }

        return array;
    }

}
