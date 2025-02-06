package SimpleSearchEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchEngine {

    UserInput userInput;
    FileReader fileReader;
    ContactsList contacts;
    InvertedIndexSearch invertedIndexSearch;
    Map<String, Set<Integer>> invertedIndex;

    public SearchEngine(){
        userInput = new UserInput();
        fileReader = new FileReader();
        contacts = new ContactsList();
        invertedIndexSearch = new InvertedIndexSearch();
    }

    public void start(){
            chooseInputData();
            appLoop();
    }

    private void appLoop(){
        while (true){
            menuPrint();
            int input = userInput.getNumber();
            System.out.println();
            switch (input){
                case 1:
                    //searchContacts();
                    searchContactsInvertedSearch();
                    break;
                case 2:
                    contacts.printAll();
                    break;
                case 0:
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
                    System.out.println();
            }
        }
    }

    private void menuPrint(){
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }

    private void chooseInputData(){
        System.out.println("Do you want to read data from txt file? (yes/no)");
        String input = userInput.getLine().toLowerCase();

        if("yes".equals(input)){
            addContactsFromFile();

        } else {
            addContactsFromTerminal();
        }
    }

    private void addContactsFromTerminal(){
        int numberOfContacts = userInput.getNumber("Enter the number of people:");
        System.out.println("Enter all people:");
        ArrayList<String> linesTemp = new ArrayList<>();
        for (int i = 0; i < numberOfContacts; i++){
            String contact = userInput.getLine();
            contacts.addContactToList(new Contact(contact));
            linesTemp.add(contact);
        }
        invertedIndex = invertedIndexSearch.buildInvertedIndex(linesTemp);
    }

    private void addContactsFromFile(){
        int numberOfLines = userInput.getNumber("Enter the number of lines to read:");

        if (numberOfLines > 40){
            System.out.println("Unfortunately our list is smaller than 40. Please enter less number");
            addContactsFromFile();
        } else {
            ArrayList<String> lines = fileReader.readLinesFromFile(numberOfLines);

            for (String line : lines) {
                contacts.addContactToList(new Contact(line));
            }
            invertedIndex = invertedIndexSearch.buildInvertedIndex(lines);
        }
    }

    private void searchContacts(){
        int searchQueries = userInput.getNumber("Enter the number of search queries:");

        for(int i = 0; i < searchQueries; i++){
            System.out.println("Enter data to search people:");
            String searchData = userInput.getLine();
            search(searchData);
        }
    }

    private void searchContactsInvertedSearch(){
        int searchQueries = userInput.getNumber("Enter the number of search queries:");

        for(int i = 0; i < searchQueries; i++){
            System.out.println("Enter data to search people:");
            String searchData = userInput.getLine();
            Set<Integer> result = invertedIndexSearch.search(searchData, invertedIndex);

            if (!result.isEmpty()){
                System.out.println(result.size() + " persons found: ");
                for(int index : result) {
                    System.out.println(contacts.getContact(index));
                }
            } else {
                System.out.println("No matching people found.");
            }
        }
    }

    private void search(String searchData){
        List<Contact> searchResult = contacts.getContactList().stream()
                .filter(contact -> contact.getLine().toLowerCase().contains(searchData.toLowerCase()))
                .collect(Collectors.toList());

        if (searchResult.isEmpty()){
            System.out.println("No matching people found.");
        } else {
            System.out.println("Found people: ");
            searchResult.forEach(contact -> System.out.println(contact.getLine()));
        }
    }
}
