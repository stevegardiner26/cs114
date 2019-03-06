package lab5a;
import java.util.*;
import java.io.*;

public class Driver {

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\steve\\Documents\\GitHub\\cs114\\src\\lab5a\\html.dat";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        BufferedReader reader = new BufferedReader(new FileReader (file));
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        String         ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
        } finally {
            reader.close();
        }

        if(isBalanced(stringBuilder.toString()).isEmpty()) {
            System.out.println("The input file is a matched HTML document");
        } else {
            System.out.println("Mismatched match tag " + isBalanced(stringBuilder.toString()).peek());
            System.out.println("Error on Input HTML File");
        }
    }

    private static Stack<String> isBalanced(String s) {
        Stack<String> balanceStack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(builder.length() >= 1) {
                builder.delete(0, builder.length());
            }
            if(s.charAt(i) == '<') {
                if(s.charAt(i+1) == '/') {
                    i += 2;
                    while(s.charAt(i) != '>') {
                        builder.append(s.charAt(i));
                        i++;
                    }
                    if(builder.toString().equals(balanceStack.peek())){
                        balanceStack.pop();
                    }
                } else {
                    i++;
                    while(s.charAt(i) != '>') {
                        builder.append(s.charAt(i));
                        i++;
                    }
                    balanceStack.push(builder.toString());
                }
            }
        }
        return balanceStack;
    }
}
