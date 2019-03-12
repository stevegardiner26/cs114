package lab7b;

import java.util.Comparator;

public class MyComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < o1.toString().length(); i++) {
            if (o1.toString().substring(i, i+1).equals("1")) {
                count1 += 1;
            }
        }
        for(int i = 0; i < o2.toString().length(); i++) {
            if (o2.toString().substring(i, i+1).equals("1")) {
                count2 += 1;
            }
        }
        if(count1 > count2) {
            return 1;
        } else if (count1 < count2) {
            return -1;
        } else {
            return  0;
        }
    }
}
