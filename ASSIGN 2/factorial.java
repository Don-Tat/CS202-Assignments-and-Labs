import java.util.Scanner;

public class factorial {
    public static int factorialRecursive(int n) {
        if (n == 0)
            return 1;
        else if (n < 0)
            return n * factorialRecursive(n + 1);
        else
            return n * factorialRecursive(n - 1);
    }

    // I wasn't able to do this with recursion.
    public static int factorialRecursiveBackwards(int n) {
        int result = 1;
        if (n > 1) {
            for (int i = 1; i <= n; i++)
                result *= i;
        } else {
            for (int i = -1; i >= n; i--)
                result *= i;
        }
        return result;
    }

    /*
     * public static int factorialRecursiveBackwards(int n) {
     * int temp = n - (n-1);
     * if (temp >= n) {
     * return n;
     * } else {
     * return temp * factorialBackwards(temp+1);
     * }
     * }
     */

    // found this on geeksforgeeks
    public static int factorialRecursiveOneLine(int n) {
        return n <= 0 ? 1 : factorialRecursiveOneLine(n - 1) * n;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = input.nextInt();
        System.out.println("Factorial using recursion starting from n: " + factorialRecursive(n));
        System.out.println(
                "Factorial using recursion starting from n using ternary operator doesn't work with negative numbers: "
                        + factorialRecursiveOneLine(n));
        System.out.println("Factorial using backwards iteration: " + factorialRecursiveBackwards(n));
        input.close();
    }
}