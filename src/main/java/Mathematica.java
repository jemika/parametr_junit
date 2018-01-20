
public class Mathematica {

    public static void main(String[] args) {
        System.out.println(division(4, 0));
    }
    public static double multiply(double firstFactor, double secondFactor){
        return firstFactor * secondFactor;
    }

    public static int division(int dividend, int divider){
        return dividend / divider;
    }

    public static int factorial(int number) throws Exception {
        Exception e = new ArithmeticException();
        if (number < 0 ) throw e;
        int result = 1;
        while(number != 0){
            result *= number;
            number--;
        }
        return result;
    }
}
