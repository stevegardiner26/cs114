package lab5b;
import java.util.*;
import java.io.*;

public class Driver {

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\steve\\Documents\\GitHub\\cs114\\src\\lab5b\\infix.dat";
        File file = new File(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                String post = changePostfix(line);
                System.out.println(post);
            }
        } finally {
            reader.close();
        }

    }

    static String changePostfix(String s) {
        Stack<String> stack = new Stack<>();
        System.out.println("Converting " + s + " to PostFix:");
        char c;
        StringTokenizer tokenizer = new StringTokenizer(s, "+*/() ", true);
        StringBuffer postfix = new StringBuffer(s.length());
        boolean validInfix = true;
        int numCounter = 0;
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (isNumeric(token)) {
                postfix.append(" ").append(token);
                numCounter++;
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.peek().equals("(")) {
                    postfix.append(" ").append(stack.pop());
                }
                stack.pop();
            } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                if(!stack.empty()) {
                    if(hasPrecendence(stack.peek(), token)) {
                        postfix.append(" ").append(stack.pop());
                    }
                }
                numCounter = 0;
                stack.push(token);
            }
        }
        while (!stack.empty()) {
            if(stack.peek().equals("(")) {
                return "Invalid Conversion";
            }
            postfix.append(" ").append(stack.pop());
        }

        if(numCounter > 1) {
            return "Invalid Conversion";
        }
        return postfix.toString();
    }

    public static boolean hasPrecendence(String stack, String token) {
        boolean stackHasPrecendence = false;
        int stackPrec = 0;
        int tokenPrec = 0;
        switch(stack) {
            case "+":
                stackPrec = 1;
                break;
            case "-":
                stackPrec = 1;
                break;
            case "*":
                stackPrec = 2;
                break;
            case "/":
                stackPrec = 2;
                break;
        }
        switch(token) {
            case "+":
                tokenPrec = 1;
                break;
            case "-":
                tokenPrec = 1;
                break;
            case "*":
                tokenPrec = 2;
                break;
            case "/":
                tokenPrec = 2;
                break;
        }

        if (stackPrec >= tokenPrec) {
            stackHasPrecendence = true;
        } else {
            stackHasPrecendence = false;
        }
        return stackHasPrecendence;
    }

    public static boolean isNumeric(String num) {
        try {
            int i = Integer.parseInt(num);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

}
