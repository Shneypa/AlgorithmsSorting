
// sorting numbers from 0 to 99

// create 10 buckets for each range of numbers (0-9, 10-19, 20-29,.. 90-99)

// sort each non-empty bucket using some simple sorting algorithm (e.g. InsertionSort)

// put elements back into original array


import java.util.ArrayList;
import java.util.LinkedList;

public class BucketSort {

    private static ArrayList<LinkedList> BucketHolder = new ArrayList();

    private static int toBucket = 0;

    public static int[] sort(int[] array) {

    // create 10 buckets for each range of numbers (0-9, 10-19, 20-29,.. 90-99)

        for (int i = 0; i < 10; i++) {

            BucketHolder.add(new LinkedList<Integer>());

        }

        // put elements from original array to respective buckets

        for (int i = 0; i < array.length; i++) {

            toBucket = array[i] / 10;
            BucketHolder.get(toBucket).add(array[i]);
        }

        LinkedList<Integer> currentBucket;

        // sort each non-empty bucket using some simple sorting algorithm (e.g. InsertionSort)
        for (int i = 0; i < 10; i++) {

            currentBucket = BucketHolder.get(i);

            for (int j = 0; j < currentBucket.size(); j++) {

                for (int k = 0; k < j; k++) {

                    if (currentBucket.get(i) < currentBucket.get(k)) {



                    }

                }

            }


        }

    // put elements back into original array

        return array;
    }
}
