
// Algorithms STAGES:

    // 1. Count frequency ('histogram')
         //  NOTE: we need to know the min and max values of array (to construct histogram count)
        // lets add  findMax and findMin  functions into ArrayManager class

    // 2. Cummulative count (shows position of last element)  ( first position is index 0 )

    // 3. Iterate through original array, putting elements into proper positions and decresing histogram count by 1.




public class CountingSort {

    public static int[] sort(int[] array) {

        // count frequencies
        int[] histogram = new int[array.length];        // temporary solution !!! (how to find length of new array? )
                                                        // values.length = max(array)
        for (int i = 0; i < array.length; i++) {
            histogram[array[i]]++;                      // count how many times value appears in array
        }

        System.out.println("Histogram Array:");
        ArrayManager.print(histogram);

        // cummulative count                            // e.g.: last '3' is in position 7 (index 6)
        for (int i = 1; i < histogram.length; i++) {
            histogram[i] += histogram[i-1];
        }

        System.out.println("Cummulative histogram Array:");
        ArrayManager.print(histogram);



        // translate into sorted array (from last to first element in original array
        int[] sortedArray = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {

            int value  =  array[i];           // take last element of unsorted array

            int position = histogram[value];  // see position of last element with that value in sorted array:

            int index = position - 1;         // index in sorted array   =   position - 1

            sortedArray[index] = value;       // put that value in that index

            histogram[value]--;               // decrease count in cummulative histogram (because we took care of 1 element)
        }



        return sortedArray;
    }


}



