package lab4b;
import java.io.*;

public class Reverse<E> extends LList<E> {

    public static LList reverseList(LList list) {
        LList<String> temp = new LList<>();

        while (list.length() != 0) {
            temp.insert(list.getValue().toString());
            list.remove();
        }
        return temp;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Print the list");
        String fileName = "C:\\Users\\steve\\Documents\\GitHub\\cs114\\src\\lab4b\\test.dat";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        LList<String> LL = new LList<>();
        String line;
        while((line = br.readLine()) != null){
            //process the line
            LL.append(line);
        }
        System.out.println(LL);

        System.out.println("Print the list after reverse");
        System.out.println(reverseList(LL));

    }
}
