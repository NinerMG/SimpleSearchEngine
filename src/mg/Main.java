package mg;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String[] input = scanner.nextLine().toLowerCase().split(" ");

        String find = scanner.nextLine().toLowerCase();

        List<String> inputList = Arrays.asList(input);


        if (inputList.contains(find)) {
            System.out.println(inputList.indexOf(find)+1);
        } else {
            System.out.println("NOT FOUND");


        }
    }
}
