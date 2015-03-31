
/*
 * Find Usages  ALT + F7
 *
 * 2^2  is not correct Java form.   Java form is    Math.pow(2,2)


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



        // create array
        // int[] array = ArrayManager.generateRandomArray(ARRAY_LENGTH);
        int[] array = {3,1,4,5,2,2,3,3,3,9,1,2,3,10,6,7};                      // manual array for debugging

        // print unsorted array
        System.out.println("Unsorted array:");
        ArrayManager.print(array);


        // *** APPLY SORTING ALGORITHM ***

        // recursively break array into 1-element arrays then merge them while sorting
        array = CountingSort.sort(array);

        // print sorted array
        System.out.println();
        System.out.println("Sorted array:");
        ArrayManager.print(array);


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
