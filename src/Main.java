
/*
 * Created by Пользователь on 23.03.2015.
 */


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
*/

public class Main {

    public static int operations = 0;
    public static boolean countOperations = true;

    public static final boolean debugMessagesOn = false;
    public static final boolean showIterations = false;



    public static void main(String[] args) {

        // create array
        int[] array = ArrayManager.generateRandomArray(10);

        // print unsorted array
        System.out.println("Unsorted array:");
        ArrayManager.print(array);

        // apply sorting algorithm
        SelectionSort.sort(array);

        // print sorted array
        System.out.println();
        System.out.println("Sorted array:");
        ArrayManager.print(array);

        System.out.println();
        System.out.println("Operations: " + Main.operations);

        // TODO: Automate n N table

    }
}
