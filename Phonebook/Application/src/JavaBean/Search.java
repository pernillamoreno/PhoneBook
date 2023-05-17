package JavaBean;

import java.util.ArrayList;

public class Search {
    public Search(){

    }

    //searching for searchedLastName in every contact in contactList
    public Contact searchLastName(ArrayList<Contact> contactList, String searchedLastName) {
        for (Contact contact: contactList) {
            //If contact is found, add index to contact and return it
            if(contact.getLastName().equals(searchedLastName)) {
                contact.setContactIndex(contactList.indexOf(contact));
                return contact;
            }
        }
        return null;
    }

    //searching for searchedAddress in every contact in contactList
    public ArrayList<Contact> searchAddress(ArrayList<Contact> contactList, String searchedAddress) {
        ArrayList<Contact> contactsFoundList = new ArrayList<>();

        for (Contact contact: contactList) {
            //If contact is found, add index to contact and add it to contactsFoundList
            if(contact.getAddress().get(2).equals(searchedAddress)) {
                contact.setContactIndex(contactList.indexOf(contact));
                contactsFoundList.add(contact);
            }
        }

        return contactsFoundList;
    }

    //searching for searchFirstName in every contact in contactList
    public ArrayList<Contact> searchFirstName(ArrayList<Contact> contactList, String searchedFirstName) {

        ArrayList<Contact> contactsFoundList = new ArrayList<>();

        for (Contact contact: contactList) {
            //If contact is found, add index to contact and add it to contactsFoundList
            if (contact.getFirstName().equals(searchedFirstName)) {
                contact.setContactIndex(contactList.indexOf(contact));
                contactsFoundList.add(contact);
            }
        }

        return contactsFoundList;
    }

    //searching for searchedFreeSearch in every contact in contactList
    public ArrayList<Contact> searchFree(ArrayList<Contact> contactList, String searchedFreeSearch) {

        ArrayList<Contact> contactsFoundList = new ArrayList<>();

        for (Contact contact: contactList) {
            //If contact is found, add index to contact and add it to contactsFoundList

            //Last name
            if (contact.getLastName().contains(searchedFreeSearch)) {
                contact.setContactIndex(contactList.indexOf(contact));
                contactsFoundList.add(contact);
            }
            //Age
            else if (String.valueOf(contact.getAge()).contains(searchedFreeSearch)) {
                contact.setContactIndex(contactList.indexOf(contact));
                contactsFoundList.add(contact);
            }
            //First name
            else if (contact.getFirstName().contains(searchedFreeSearch)) {
                contact.setContactIndex(contactList.indexOf(contact));
                contactsFoundList.add(contact);
            }
            //Address and telephone numbers
            else if(searchAddressTelephoneNumber(contact, searchedFreeSearch)){
                contact.setContactIndex(contactList.indexOf(contact));
                contactsFoundList.add(contact);
            }
        }
        return contactsFoundList;
    }

    private boolean searchAddressTelephoneNumber(Contact contact, String searchedFreeSearch) { //

        for (String telephoneNumber: contact.getTelephoneNumbers()) {
            if (telephoneNumber.contains(searchedFreeSearch)) {
                return true;
            }

        }
        for (String address: contact.getAddress()) {
            if (address.contains(searchedFreeSearch)) {
                return true;
            }
        }
        return false;
    }
}
