package SimpleSearchEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchEngine {

    UserInput userInput;
    FileReader fileReader;
    ContactsList contacts;

    public SearchEngine(){
        userInput = new UserInput();
        fileReader = new FileReader();
        contacts = new ContactsList();
    }

    public void start(){
            addContactsFromFile();
            searchContacts();
    }

    private void addContactsFromTerminal(){
        int numberOfContacts = userInput.getNumber("Enter the number of people:");
        System.out.println("Enter all people:");

        for (int i = 0; i < numberOfContacts; i++){
            String contact = userInput.getLine();
            contacts.addContactToList(new Contact(contact));
        }
    }

    private void addContactsFromFile(){
        int numberOfLines = userInput.getNumber("Enter the number of lines to read:");
        ArrayList<String> lines = fileReader.readLinesFromFile(numberOfLines);

        for (String line : lines){
            contacts.addContactToList(new Contact(line));
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
