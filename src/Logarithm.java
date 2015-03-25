// Math.log(x) is natural logarithm:
//
// log  (x)
//    e


// Math.log1p(x) is natural logarithm of (x + 1) :
//
// log  (x + 1.0)
//    e


// Math.log10(x) is base 10 logarithm:
//
// log  (x)
//    10


// all log functions return _doubles_


public class Logarithm {

    // log (x)
    //    b
    public static double log(double x, double base) {

        return Math.log(x)/Math.log(base);

    }

    // binary logarithm
    //
    // log  (x)
    //    2
    public static double log2(double x) {

        return Logarithm.log(x,2.0);

    }
}
