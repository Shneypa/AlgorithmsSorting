// Test speed of different algorithms on different Input data and number of elements:

// Random data
    // BubbleSort
        // n = 10
        // n = 100
        // n = 1000
        // ...
        // n = 1 000 000 000
    // InsertionSort
        // n = 10
        // n = ...
    // SelectionSort

// Reverse Data
    // BubbleSort
        // ...
    // InsertionSort
        // ...
    // SelectionSort

// Sorted Data





public class Testing {

    private static int n = 10;
    private static int row = 1;
    private static int orderOfGrowth = 10;      // n = 10 100 1000 10000 ....
    private static int maxOrder = 9;            // max n = 1 000 000 000


    // create array that will hold time results for BubbleSort
    private static double[] bubbleSortTimes = new double[maxOrder];
    private static double[] insertionSortTimes = new double[maxOrder];
    private static double[] selectionSortTimes = new double[maxOrder];


    public static void experiment() {
        fillRow();
    }


    public static void fillRow() {

        // create input data sample
        int[] sampleArray = ArrayManager.generateRandomArray(n);

        if (row > maxOrder) return;                     // stop recursion if we hit max row

        System.out.print("n = " + n + "    ");

        // measure time of an algorithm
        long startTime = System.currentTimeMillis();
        //BubbleSort.sort(sampleArray);                         // TODO: BubbleSort has unnecessary checks which slow it down !
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        bubbleSortTimes[row] = runTime;

        System.out.print("BubbleSort: " + runTime + "    ");

        // measure time of an algorithm
        startTime = System.currentTimeMillis();
        InsertionSort.sort(sampleArray);                         // BubbleSort has unnecessary checks which slow it down !
        endTime = System.currentTimeMillis();
        runTime = endTime - startTime;
        insertionSortTimes[row] = runTime;

        System.out.print("InsertionSort: " + runTime + "    ");

        // measure time of an algorithm
        startTime = System.currentTimeMillis();
        SelectionSort.sort(sampleArray);                         // BubbleSort has unnecessary checks which slow it down !
        endTime = System.currentTimeMillis();
        runTime = endTime - startTime;
        selectionSortTimes[row] = runTime;

        System.out.print("SelectionSort: " + runTime + "    ");

        System.out.println();

        n = n * orderOfGrowth;
        row++;

        fillRow();
    }



}
