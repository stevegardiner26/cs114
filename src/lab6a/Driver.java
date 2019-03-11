package lab6a;
import java.util.*;

public class Driver {

    public static void main(String[] args) {
        String string = "1234";
        System.out.println("For String " + string);
        printSubsets(string);
    }

    public static void printSubsets(String s) {
        Queue<String> queue = new PriorityQueue<>();
        LinkedList<String> list = new LinkedList<>();
        int length = s.length();
        //Adding the First state
        queue.add(s.substring(0,1));



        while(!list.isEmpty()) {
            System.out.println(list.peek());
            list.poll();
        }
    }
}

/*"" & abcd -> a & bcd, "" & bcd
a & bcd -> ab & cd, a & cd
ab & cd -> abc & d, ab & d
"" & d -> d & ""
d & "" -> not valid

//Bredth First Search
//Create a queue
// add first state

//while the queue is not empty
// remove the first state
// visit the state
// generate all possible children
//for all the children:
//  if the children are valid
//      add the children
*/