
/*
 * Find Usages  ALT + F7
 *
 * 2^2  is not correct Java form.   Java form is    Math.pow(2,2)
 *
 * Print functions take a lot of time ! make sure they are not operating while measuring algorithm run times !


/*
    ВОПРОСЫ:



    1. Правильно ли я использую цикл "пока массив не отсортирован..."
        Не добавляет ли это лишних операций?
        А: добавляет.

    2. Как сделать "опцию подсчета операций", которую можно "включать и выключать" ?
    A: Считать нужно время в миллисекундах.

    3. И как правильно считать операции?
    А: Можно нормально считать, если есть параллельные процессы.



    6. Если  я хочу сгруппировать BubbleSort.java, InsertionSort.java, SelectionSort.java,
    мне надо их в новую папку кинуть или в ноый package?
    И как правильно сделать это чтобы классы друг друга не потеряли?



*/

public class Main {

    public static final int ARRAY_LENGTH = 100;           // change this value to play around with array size.

    //              utility variables:
    public static int operations = 0;
    public static boolean countOperations = true;

    public static final boolean debugMessagesOn = false;
    public static final boolean showIterations = false;
                                                        //


    public static void main(String[] args) {

        singleTest();
        // Testing.experiment();
    }


    private static void singleTest() {

        long startTimeWithPrinting = System.currentTimeMillis();

        // create array
        int[] array = ArrayManager.generateRandomArray(ARRAY_LENGTH);
        // int[] array = {313,621,834,435,845,855,417,18,810,12};                      // manual array for debugging

        // print unsorted array
        System.out.println("Unsorted array:");
        ArrayManager.print(array);

        long startTimeAlgorithm = System.currentTimeMillis();

        // *** APPLY SORTING ALGORITHM ***
        array = RadixSort.sort(array);

        long timeTakenForAlgorithm = System.currentTimeMillis() - startTimeAlgorithm;

        // print sorted array
        System.out.println();
        System.out.println("Sorted array:");
        ArrayManager.print(array);

        // time taken in milliseconds
        long timeTakenWithPrintingTwice = System.currentTimeMillis() - startTimeWithPrinting;
        System.out.println();
        System.out.println("Time for algorithm:   " + timeTakenForAlgorithm + " ms for " + array.length + " elements");



/*
        // print how many operations it took
        System.out.println();
        System.out.println("Operations: " + Main.operations);
        System.out.println();

        // calculate number of rows in a heap
        System.out.println("Array as heap:  number of rows (tree depth): " + HeapSort.findNumberOfRowsInHeap(array));
        System.out.println();

        */

        // TODO: Automate time complexity table
    }
}
