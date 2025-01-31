package SimpleSearchEngine;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserInput {

    Scanner scanner;

    public UserInput(){
        scanner = new Scanner(System.in);
    }

    public int getNumber(String message){
        System.out.println(message);
        while(true){
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number > 0){
                    return number;
                } else {
                    System.out.println("Error! Number should be greater than zero.");
                }
            } catch (NumberFormatException e){
                System.out.println("Error! Enter finite number.");
            }
        }
    }

    public String getLine(){
        try{
            return scanner.nextLine();
        } catch (NoSuchElementException | IllegalStateException e){
            System.err.println("Error during reading line: " + e.getMessage());
            return " ";
        }
    }
}
