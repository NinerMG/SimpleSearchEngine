package SimpleSearchEngine;

import java.util.ArrayList;

public class ContactsList {
    private ArrayList<Contact> contactList;

    public ContactsList(){
        this.contactList = new ArrayList<>();
    }
    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void addContactToList(Contact contact){
        contactList.add(contact);
    }

    public void printAll(){
        contactList.forEach(contact -> System.out.println(contact.getLine()));
    }

    public String getContact(int index){
        return contactList.get(index).getLine();
    }
}
