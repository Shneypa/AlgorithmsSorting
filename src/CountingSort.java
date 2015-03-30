

public class CountingSort {

    public static int[] sort(int[] array) {

        return array;
    }
}
    // array      2 4 6 8 2 5 7 11

    // array of indexes    (values show how many times that element is present in array)   "values"

    // values.length = max(array)


    // array  >>> values    Function count(array)

    //  count:          0 0 2 0 1 1 1 1 1 0  0  1
    //  values:         0 1 2 3 4 5 6 7 8 9 10 11


    // cummulative (number of elements with this value or less)

    //  count:          0 0 2 2 3 4 5 6 7 7  7  8               <<<  the last 11 is on the 8th position
    //  values:         0 1 2 3 4 5 6 7 8 9 10 11                   the last 8 is on the 7th position ...


    //
    // position         0 1 2 3 4 5 6 7 8 9 10 11



    // sorted array      2 2 4 5 6 7 8 11
    // position            2 3 4 5 6 7 8



