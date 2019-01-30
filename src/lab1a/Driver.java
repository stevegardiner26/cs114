package lab1a;

public class Driver {

    public static void main(String[] args) {

        ArithProgression arithmetic = new ArithProgression();
        System.out.println("Arithmetic progression with default increment: ");
        arithmetic.printProgression(10);

        System.out.println("Arithmetic progression with increment 5: ");
        arithmetic.setinc(5);
        arithmetic.printProgression(10);

        System.out.println("Arithmetic progression with increment 10: ");
        arithmetic.setinc(10);
        arithmetic.printProgression(10);


        GeomProgression geometric = new GeomProgression();
        System.out.println("Geometric progression with default base: ");
        geometric.printProgression(10);

        System.out.println("Geometric progression with base 3: ");
        geometric.setbase(3);
        geometric.printProgression(10);

        System.out.println("Geometric progression with base 5: ");
        geometric.setbase(5);
        geometric.printProgression(10);
    }
}
