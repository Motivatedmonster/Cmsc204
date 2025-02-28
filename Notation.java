package assignment2;

import java.util.*;  

public class Notation {
    public static String infixToPostfix(String infix) 
            throws InvalidNotationFormatException, QueueOverflowException, StackOverflowException, StackUnderflowException, QueueUnderflowException {
        MyStack<Character> stack = new MyStack<>(infix.length()); 
        MyQueue<Character> postfix = new MyQueue<>(infix.length());  
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c)) {  
                postfix.enqueue(c); 
           } 
            else if (c == '(') {  
                stack.push(c); 
            } 
            else if (c == ')') {  
               while (!stack.isEmpty() && stack.top() != '(') {
                    postfix.enqueue(stack.pop());
              }
                if (stack.isEmpty()) {
                    throw new InvalidNotationFormatException("Mismatched parentheses.");
                }
                stack.pop();
           } 
            else if (isOperator(c)) {  
               while (!stack.isEmpty() && stack.top() != '(' && prioirty(stack.top()) >= prioirty(c)) {
                    postfix.enqueue(stack.pop());
                }
               stack.push(c);
            } 
            else {
                throw new InvalidNotationFormatException("Invalid character found.");
           }
        }
       while (!stack.isEmpty()) {
            if (stack.top() == '(') {
                throw new InvalidNotationFormatException("Unmatched parenthesis.");
           }
            postfix.enqueue(stack.pop());
        }
        return queueToString(postfix);
    }

    public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException, StackOverflowException, StackUnderflowException {
        MyStack<String> stack = new MyStack<>(postfix.length());
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.push(Character.toString(c)); 
            } 
            else if (isOperator(c)) {
                if (stack.size() < 2) {
                    throw new InvalidNotationFormatException();
                }
              String operand2 = stack.pop();
                String operand1 = stack.pop();
               String newExpression = "(" + operand1 + " " + c + " " + operand2 + ")";
                stack.push(newExpression); 
            } 
            else {
                throw new InvalidNotationFormatException();
            }
        }
        if (stack.size() != 1) {
            throw new InvalidNotationFormatException();
        }
        return stack.pop();
    }
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    } 
   
    public static double evaluatePostfixExpression(String postfix) 
            throws InvalidNotationFormatException, StackOverflowException, StackUnderflowException {
        MyStack<Double> stack = new MyStack<>(postfix.length());
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (Character.isDigit(c)) {
            	stack.push((double) Character.getNumericValue(c));   
            } 
            else if (isOperator(c)) {
                if (stack.size() < 2) {
                    throw new InvalidNotationFormatException();
                }
               double operand2 = stack.pop();
                double operand1 = stack.pop();

               if (c == '+') {
                  stack.push(operand1 + operand2);
                } else if (c == '-') {
                    stack.push(operand1 - operand2);
                } else if (c == '*') {
                    stack.push(operand1 * operand2);
                } else if (c == '/') {
                    if (operand2 == 0) {
                        throw new ArithmeticException("Can't divide by zero.");
                    }
                    stack.push(operand1 / operand2);
                } else {
                    throw new InvalidNotationFormatException();
                }
            } 
            else {
                throw new InvalidNotationFormatException("Invalid char");
            }
        }

        if (stack.size() != 1) {
           throw new InvalidNotationFormatException("");
        }
     return stack.pop();
    }
    private static int prioirty(char operands) {
        if (operands == '+' || operands == '-') {
            return 1;
        } else if (operands == '*' || operands == '/') {
            return 2;
        } else if (operands == '^') {
            return 3;
        } else {
            return 0;
        }
    }
    private static String queueToString(MyQueue<Character> queue) throws QueueUnderflowException {
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.dequeue());
        }
        return sb.toString();
    }
}
