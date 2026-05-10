import java.util.Scanner;

class OutOfRangeException extends Exception {}
class AddZeroException extends Exception {}
class SubtractZeroException extends Exception {}

public class SimpleCalculator {

    static void checkRange(int a, int b, int result) throws OutOfRangeException {
        if (a < 0 || a > 1000 || b < 0 || b > 1000 || result < 0 || result > 1000) {
            throw new OutOfRangeException();
        }
    }

    static int add(int a, int b) throws AddZeroException, OutOfRangeException {
        if (a == 0 || b == 0) {
            throw new AddZeroException();
        }

        int result = a + b;
        checkRange(a, b, result);
        return result;
    }

    static int subtract(int a, int b) throws SubtractZeroException, OutOfRangeException {
        if (a == 0 || b == 0) {
            throw new SubtractZeroException();
        }

        int result = a - b;
        checkRange(a, b, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();

        try {
            if (exp.contains("+")) {
                String[] parts = exp.split("\\+");

                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);

                System.out.println(add(a, b));
            } 
            else if (exp.contains("-")) {
                String[] parts = exp.split("-");

                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);

                System.out.println(subtract(a, b));
            }
        } 
        catch (AddZeroException e) {
            System.out.println("AddZeroException");
        } 
        catch (SubtractZeroException e) {
            System.out.println("SubtractZeroException");
        } 
        catch (OutOfRangeException e) {
            System.out.println("OutOfRangeException");
        }

        sc.close();
    }
}