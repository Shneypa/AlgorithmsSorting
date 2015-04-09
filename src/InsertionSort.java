
public class InsertionSort {

    public static void sort(int[] array) {

    // first element is already a shot "sorted array"
    // now we take next element and find appropriate place for it

    for (int i = 1; i < array.length; i++) {        // for every element from index 1 to last element of array

        for (int k = 0; k < i; k++) {               // compare i-th element to every element in the sorted part to find it's spot


            if(array[i] < array[k]){

                // rewrite whole array 1 step to the right
                int temp = array[i];
                for (int j = i-1; j >= k; j--) {
                    array[j+1]= array[j];

                }
                // insert new element into correct position
                array[k] = temp;




            }

        }

    }


    }
}
