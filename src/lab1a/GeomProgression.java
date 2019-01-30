package lab1a;

public class GeomProgression extends  Progression {
    long base;

    public GeomProgression() {
        super.first = 1;
        this.base = 2;
    }

    public void setbase(long base) {
        this.base = base;
    }

    public long nextValue() {
        return cur = this.base * cur;
    }

    public void printProgression(int n) {
        super.nextValue();
        super.printProgression(n);
    }
}
