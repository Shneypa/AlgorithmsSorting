
public class WickedJavaMath {

    public static void examples() {

                                        // "Tales of wicked java math"

                        System.out.println("Welcome to \"Tales of wicked java math\" !  Enjoy !");



        // Tale 1. Cannot divide int by int and get accurate result !

        System.out.println("Tale 1. Cannot divide int by int and get accurate result !   example: ");

        System.out.println("int a = 11");
        System.out.println("int b = 4");
        int a = 11;
        int b = 4;

        int c = a/b;
        System.out.println("int c = a / b");
        System.out.println("c = " + c);

        System.out.println();
        System.out.println("int / int    is like division without the remainder");
        System.out.println();
        System.out.println("To get accurate results, we have to divide    double / double");
        System.out.println();

        double k = (double)a / (double) b;
        System.out.println("double k = (double)a / (double) b");
        System.out.println("k = " + k);

        System.out.println();
        System.out.println("So we have to feed  Math.ceil or   Math.floor,  with doubles only !!!");
        System.out.println("it will be rounded to 4.0  or something  and after that we cast to int as last step");
        System.out.println();
        System.out.println("Example: we split array of 9 elements into 2 arrays. Calculate length of sub-arrays (5 and 4)");
        System.out.println("");
        System.out.println("int parentArrayLength = 9");
        int parentArrayLength = 9;
        int leftSubArrayLength = (int)Math.ceil((double)parentArrayLength / 2);
        int rightSubArrayLength =(int)Math.floor((double) parentArrayLength / 2);
        System.out.println("left sub-array length:      (int)Math.ceil((double)parentArrayLength / 2)");
        System.out.println("left sub-array length:      (int)Math.ceil(9.0 / 2)");
        System.out.println("left sub-array length:      (int)Math.ceil(4.5)");
        System.out.println("left sub-array length:      (int)(5.0)");
        System.out.println("left sub-array length:      5");
        System.out.println();
        System.out.println("THE END !");

    }
}
