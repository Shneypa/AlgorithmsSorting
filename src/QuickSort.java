

// QuickSort(array, start, end)

// if start < end

    // pivotIndex = Partition(array, start, end)
    // QuickSort(array, 0, pivotIndex -1)
    // QuickSort(array, pivotIndex + 1, end)




import java.util.Random;

public class QuickSort {

    public static int[] sort(int[] array, int start, int end) {

        // if array is 1 -element long, exit function


       // pivotIndex = partition(array, start, end);
       // sort(array, lo, pivot);
       // sort(array, pivot + 1, hi);

        return array;
    }




    public static int[] partition(int[] array, int start, int end) {

        Random rand = new Random();
        int pIndex = rand.nextInt(array.length);

        // choose pivot element as a random element from array
        int pivot = array[pIndex];

        // put pivot in the end of array
        array[pIndex] = array[end];
        array[end] = pivot;
        pIndex = end;


        // compare all array elements to pivot and swap if needed
        for (int i = start; i < end; i++) {

            if (array[i] > pivot) {

                array[pIndex] = array[i];
                array[i] = pivot;
                pIndex = i;

            }

        }

        return array;

    }
}
