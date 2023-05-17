package JavaBean;

import java.util.ArrayList;
public class PhoneBook {
    private static ArrayList<Contact> contactList;
    private static Search search;

    private static PhoneBook phoneBook;


    private PhoneBook() {
        contactList = new ArrayList<>();
        search = new Search();
    }

    public static PhoneBook getInstance() {

        //Creates new instance of phonebook if there isn't one already
        if( phoneBook == null) {
            phoneBook = new PhoneBook();

        }
        return phoneBook;
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public Contact searchLastName(String lastName) {
        Contact contact = new Contact();
        contact = search.searchLastName(contactList,lastName);

        return contact;
    }

    public ArrayList<Contact> searchAddress(String address) {
        ArrayList<Contact> contactsFoundList = new ArrayList<>();
        contactsFoundList = search.searchAddress(contactList,address);

        return contactsFoundList;
    }

    public ArrayList<Contact> searchFirstName(String firstName) {
        ArrayList<Contact> contactsFoundList = new ArrayList<>();
        contactsFoundList = search.searchFirstName(contactList,firstName);

        return contactsFoundList;
    }

    public ArrayList<Contact> searchFree(String searchFree) {
        ArrayList<Contact> contactsFoundList = new ArrayList<>();
        contactsFoundList = search.searchFree(contactList, searchFree);

        return contactsFoundList;
    }

    public void createContact(Contact contact) {

        contactList.add(contact);
    }

    public void updateContact(Contact contact, int index) {

        contactList.set(index,contact);
    }

    public void deleteContact(int index) {

        contactList.remove(index);
    }
}