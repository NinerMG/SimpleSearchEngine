package SimpleSearchEngine;
import java.util.Scanner;

public class UserInput {
    Scanner scanner;

    public UserInput(){
        this.scanner = new Scanner(System.in);
    }
    public String userInput(){
        String userInput;
        while(true) {
            try {
                userInput = scanner.nextLine().trim();

                if (!userInput.matches("[a-zA-Z ]+")){
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter only words in lists");
            }
        }
        return userInput;
    }
}
