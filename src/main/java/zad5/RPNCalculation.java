package zad5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RPNCalculation {
    protected final TArrayStack<Integer> stack;
    protected final int defaultBufferSize = 256;


    //konstruktor
     public RPNCalculation(int bufferSize) {
         if (bufferSize < 64) {
             stack = new TArrayStack<>(defaultBufferSize);
         } else {
             stack = new TArrayStack<>(bufferSize);
         }
     }

        protected int calculate (String onp){
            String[] tokens = onp.trim().split("\\s+");

            for (var token : tokens) {
                if (isNumberOrVariable(token)) {
                    stack.push(Integer.valueOf(token));

                } else if (isOperation(token)) {
                    int a2 = stack.pop();
                    int a1 = stack.pop();
                    int w1 = calculateExpression(a1, a2, token);
                    stack.push(w1);
                } else {
                    throw new IllegalArgumentException(String.format("%s is not a valid operation", token));
                }
            }
            return stack.pop();
        }

        private boolean isNumberOrVariable (String token){
            var sign = token.toLowerCase().charAt(0);
            if (sign >= '0' && sign <= '9' ||
                    sign >= 'a' && sign <= 'z') {
                return true;
            } else {
                return false;
            }

        }private boolean isOperation (String token){
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                    return true;
                default:
                    return false;
            }

        }
        private int calculateExpression ( int a1, int a2, String token){
            switch (token) {
                case "+":
                    return a1 + a2;
                case "-":
                    return a1 - a2;
                case "*":
                    return a1 * a2;
                case "/":
                    return a1 / a2;
                case "%":
                    return a1 % a2;
                default:
                    throw new IllegalArgumentException();
            }
        }

    public String loadFromFile(String file){
        try(BufferedReader bufferedReader = new BufferedReader( new FileReader(file))){
            String line = bufferedReader.readLine();
            String result = String.valueOf(calculate(line));
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    }







