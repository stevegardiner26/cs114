package lab6a;
import java.util.*;

public class Driver {

    public static void main(String[] args) {
        String string = "1234";
        System.out.println("For String " + string);
        printSubsets(string);
    }

    public static void printSubsets(String s) {
        Queue<CState> queue = new LinkedList<>();
        LinkedList<String> list = new LinkedList<>();
        int length = s.length();
        //Adding the First state
        CState c = new CState("", s);
        queue.add(c);
        //While the queue is not empty
        while(!queue.isEmpty()) {
            //Remove the first state
            CState removed = queue.poll();
            //Visit the state

            CState child1 = new CState(removed.pre() + removed.suff().substring(0,1), removed.suff().substring(1));
            CState child2 = new CState(removed.pre(), removed.suff().substring(1));

            if(!child1.suff().equals("")) {
                queue.add(child1);
            } else {
                list.add(child1.pre());
            }
            if(!child2.suff().equals("")) {
                queue.add(child2);
            } else {
                list.add(child2.pre());
            }
        }


        while(!list.isEmpty()) {
            System.out.println(list.peek());
            list.poll();
        }
    }
}


//while the queue is not empty
// remove the first state
// visit the state
// generate all possible children
//for all the children:
//  if the children are valid
//      add the children


/*"" & abcd -> a & bcd, "" & bcd
a & bcd -> ab & cd, a & cd
ab & cd -> abc & d, ab & d
"" & d -> d & ""
d & "" -> not valid

//Bredth First Search
//Create a queue
// add first state */