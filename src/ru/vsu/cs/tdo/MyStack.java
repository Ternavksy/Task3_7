package ru.vsu.cs.shepliakovvladislavvyacheslavovich;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Stack;

public class MyStack extends SimpleLinkedListDouble {


    private interface UseStack<T> {
        T push(T value);
        T pop() throws MyStackException, SimpleLinkedListException;
        public int size();
    }

    static class MyUseStack implements UseStack<Double> {
        private MyStack stack = new MyStack();

        @Override
        public Double push(Double value) {
            return stack.push(value);
        }

        @Override
        public Double pop() throws MyStackException, SimpleLinkedListException {
            return stack.pop();
        }

        @Override
        public int size() {
            return stack.count();
        }
    }

    static class StandartStack implements UseStack<Double> {
        private Stack<Double> stack = new Stack<>();

        @Override
        public Double push(Double value) {
            return stack.push(value);
        }

        @Override
        public Double pop() {
            return stack.pop();
        }

        @Override
        public int size() {
            return stack.size();
        }
    }
    public static class MyStackException extends Exception {
            public MyStackException(String message) {
                super(message);
            }
    }

    private static void tryMakeIOperation(char symbol, UseStack<Double> stack) throws MyStackException, SimpleLinkedListException {
        if (stack.size() < 2) {
            throw new InputMismatchException();
        } else {
            switch (symbol) {
                case '+': {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a + b);
                    break;
                }
                case '-': {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a - b);
                    break;
                }
                case '*': {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a * b);
                    break;
                }
                case '/': {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a / b);
                    break;
                }
                default: {
                    throw new InputMismatchException();
                }
            }
        }
    }



    public static double getAnswerValue(String inputString, String stackString) throws MyStackException, SimpleLinkedListException {
        UseStack<Double> stack;
        if (stackString.equals("My")) {
            stack = new MyUseStack();
        } else {
            stack = new StandartStack();
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == ' ') {
                if (!builder.isEmpty()) {
                    stack.push(Double.parseDouble(new String(builder)));
                    builder.setLength(0);
                }
                continue;
            }
            if (Character.isDigit(inputString.charAt(i)) || inputString.charAt(i) == '.' ) {
                builder.append(inputString.charAt(i));
            } else {
                tryMakeIOperation(inputString.charAt(i), stack);
            }
        }
        if (stack.size() == 1) {
            return stack.pop();
        } else {
            throw new MyStackException("Incorrect Expression");
        }
    }



    public MyStack() {

    }

    public MyStack(double[] array) {
        for (int i = 0; i < array.length; i++) {
            this.addFirst(array[i]);
        }
    }

    public MyStack(List<Double> list) {
        for (int i = 0; i < list.size(); i++) {
            this.addFirst(list.get(i));
        }
    }


    public Double push(Double value) {
        this.addFirst(value);
        return value;
    }

    public Double pop() throws MyStackException, SimpleLinkedListException {
        double result = this.peek();
        this.removeFirst();
        return result;
    }

    public double peek() throws MyStackException, SimpleLinkedListException {
        if (this.empty()) {
            throw new MyStackException("Stack is empty");
        }
        return this.getFirst();
    }

    public int count() {
        return super.size();
    }

    public boolean empty() {
        return this.count() == 0;
    }
}
