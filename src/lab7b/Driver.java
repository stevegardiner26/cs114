package lab7b;
import java.util.Comparator;

public class Driver {

    public static void main(String[] args) {
        int a = 41;
        int b = 40;
        compareNums(a, b);
        a = 40;
        b = 3;
        compareNums(a, b);
    }

    public static void compareNums(int a, int b) {
        String a_binary = toBinary(a);
        String b_binary = toBinary(b);
        //System.out.println(c.compare(a, b));
        MyComparator c = new MyComparator();
        int output = c.compare(a_binary, b_binary);
        if(output >= 1) {
            System.out.println(a + " has more 1's bit than " + b);
        } else if(output == 0) {
            System.out.println(a + " and " + b + " have the same number of 1's bit");
        } else if(output == -1) {
            System.out.println(a + " has less 1's bit than " + b);
        }
    }

    public static String toBinary(int num) {
        return Integer.toString(num,2);
    }
}