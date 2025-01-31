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
}
