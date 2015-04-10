
// sorting n numbers

// 1. create optimal number of buckets

    // n = 100 .        create 10 buckets for each range of numbers (0-9, 10-19, 20-29,.. 90-99)
    // n = 10 000.      create 100 buckets to hold 100 elements each
    // n = 1 000 000.   create 1000 buckets to hold 1000 elements each


// 2. sort each non-empty bucket using some simple sorting algorithm (e.g. InsertionSort)

// 3. put elements back into original array


// KNOWN ISSUES:
// creating buckets which may end up empty and not needed

import java.util.ArrayList;
import java.util.LinkedList;

public class BucketSort {

    private static ArrayList<LinkedLizt> BucketHolder = new ArrayList();

    private static int toBucket = 0;
    private static int numberOfBuckets = 10;


    public static int[] sort(int[] array) {

        // 1. create optimal number of buckets

        numberOfBuckets = (int)Math.ceil(Math.sqrt((double)array.length));

        for (int i = 0; i < numberOfBuckets; i++) {

            BucketHolder.add(new LinkedLizt());

        }

        // 2. put elements from original array to respective buckets
        // insert function puts elements in sorted order
        for (int i = 0; i < array.length; i++) {


            toBucket = array[i] / numberOfBuckets;
            BucketHolder.get(toBucket).insert(array[i]);
        }

        // 3. put elements back into original array
        int i = 0;

        // for every bucket...
        for (int k = 0; k < numberOfBuckets; k++) {

            // ...  pick from first to last elements of it
            LinkedLizt currentBucket = BucketHolder.get(k);

            while (!currentBucket.isEmpty()) {
                array[i] = currentBucket.first.value;
                currentBucket.removeFirst();
                i++;

            }
        }


        return array;
    }


    //  utility function, prints whats in all buckets
    public void print() {

        for (int i = 0; i < numberOfBuckets; i++) {
            System.out.print("Bucket " + i + ": ");
            BucketHolder.get(i).print();
        }
    }


}
