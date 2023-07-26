package zad5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TestRPN {
    public static void main(String[] args) {
       RPNCalculation rpnCalculation = new RPNCalculation(256);
       RPNGenerator rpnGenerator = new RPNGenerator(256);

       try {
           //wyrazenie algebraiczne z pliku
          BufferedReader expr = new BufferedReader(new FileReader("expression.txt"));
          System.out.println("Wyrażenie algebraiczne: "+ expr.readLine());

          //wyrazenie ONP
           var ONP = rpnGenerator.loadFromFile("expression.txt");
            System.out.println("Wyrażenie ONP: "+ ONP);

          //wynik
           var result = rpnCalculation.calculate(ONP);
           System.out.println("Wynik: "+ result);

       }catch (Exception e){
          System.out.println(e.toString());
      }

    }
}