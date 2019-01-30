package lab1a;

public class ArithProgression extends Progression {
    protected long increment;

    public ArithProgression() {
        super();
        this.increment = 1;
    }

    public long nextValue() {
        return cur = this.increment + cur;
    }

    public void setinc(long increment) {
        this.increment = increment;
    }

    public void printProgression(long n) {
        super.nextValue();
        super.printProgression(n);
    }
}
