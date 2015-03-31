

// QuickSort(array, start, end)

// if start < end

    // pivotIndex = Partition(array, start, end)
    // QuickSort(array, 0, pivotIndex -1)
    // QuickSort(array, pivotIndex + 1, end)




import java.util.Random;

public class QuickSort {

    private static int pIndex = 0;


    public static int[] sort(int[] array) {

        // pass full array into the sorting function
        array = sortPart(array, 0, array.length - 1);

        return array;
    }




    public static int[] sortPart(int[] array, int start, int end) {

        // if array is 1 element long, exit function
        if (start >= end) return array;

        array = partition(array, start, end);
        sortPart(array, start, pIndex - 1);
        sortPart(array, pIndex + 1, end);

        return array;
    }




    public static int[] partition(int[] array, int start, int end) {

        // choose pivot element as a random element from array
        Random rand = new Random();
        int pivotIndex = start + rand.nextInt(end-start);
        int pivot = array[pivotIndex];

        // put pivot in the end of array
        int temp1 = array[end];
        array[end] = pivot;
        array[pivotIndex] = temp1;


        pIndex = start;

        // compare all array elements to pivot and swap if needed
        for (int i = start; i < end; i++) {

            // if element is less than pivot, put it into left side  ( at position 'pIndex' )
            if (array[i] <= pivot) {
                
                int temp = array[pIndex];
                array[pIndex] = array[i];
                array[i] = temp;
                pIndex++;

            }

        }
        // after all comparisons, put pivot at it's correct position ( ' pIndex ' )
        int temp2 = array[pIndex];
        array[pIndex] = pivot;
        array[end] = temp2;

        return array;

    }
}
