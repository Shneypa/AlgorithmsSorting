
/*
 * Find Usages  ALT + F7
 *
 * 2^2  is not correct Java form.   Java form is    Math.pow(2,2)


/*
    ВОПРОСЫ:

    1. Правильно ли я использую цикл "пока массив не отсортирован..."
        Не добавляет ли это лишних операций?

    2. Как сделать "опцию подсчета операций", которую можно "включать и выключать" ?

    3. И как правильно считать операции?

    4. Что если я хочу сначала прогнать массив через InsertionSort а потом тот же массив (неупорядоченный)
        через BubbleSort (или любой другой алгоритм)
        Как мне правильно считать операции, чтобы потом можно было получить сравнительный результат:

        InsertionSort: 66 Операций
        BubbleSort: 75 Операций
        ...Sort:   ... Операций
        ...Sort:   ... Операций

    5. Как целесообразно настроить автотекст (который пишется при создании нового класса, например:

              Created by Пользователь on 23.03.2015.

    6. Если  я хочу сгруппировать BubbleSort.java, InsertionSort.java, SelectionSort.java,
    мне надо их в новую папку кинуть или в ноый package?
    И как правильно сделать это чтобы классы друг друга не потеряли?



    7. Как вычислить в бинарном дереве ( Heap ) количество рядов ( глубину дерева )

        например, если ряда 3, то элементов 7:

                                             1
                                            1 1
                                           1 1 1 1

        значит, если элементов n, то рядов log 2 ( n + 1 )


    8. в классе HeapSort я постоянно посылаю весь массив по разным функциям.
        это не влияет плохо на производительность?


    9. как настроить читабельность кода?

    10. при дебаггинге IntelliJ каждый раз создает новый процесс Main.
    а мне надо, чтобы она просто перезапускала. (сейчас приходится вручную нажимать каждый раз  Stop 'Main'

*/

public class Main {

    public static final int ARRAY_LENGTH = 100;           // change this value to play around with array size.

    //              utility variables:
    public static int operations = 0;
    public static boolean countOperations = true;

    public static final boolean debugMessagesOn = true;
    public static final boolean showIterations = false;
                                                        //


    public static void main(String[] args) {



        // create array
        //int[] array = ArrayManager.generateRandomArray(ARRAY_LENGTH);
        int[] array = {3,1,4,5,7,8,4};                      // manual array for debugging

        // print unsorted array
        System.out.println("Unsorted array:");
        ArrayManager.print(array);


        // *** APPLY SORTING ALGORITHM ***

        // recursively break array into 1-element arrays
        MergeSort.breakDown(array);

        // print sorted array
        //System.out.println();
        //System.out.println("Sorted array:");
        //ArrayManager.print(array);


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
