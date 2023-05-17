package JavaBean;

import java.util.ArrayList;

public class Output {

    public Output(){
    }

    public void printFirstMenu(Boolean adminPrivilege){
        System.out.println("-Welcome to phone book-");
        if(!adminPrivilege)
        {
            System.out.println("Logged in as guest");
        }
        else
        {
            System.out.println("Logged in as admin");
        }
        System.out.println("1. Create new profile.");
        System.out.println("2. Search for profile");
        if (!adminPrivilege) {
            System.out.println("3. Login");
        }
        else
        {
            System.out.println("3. Update contact.");
            System.out.println("4. Delete contact");
        }
        System.out.println("Write 'quit' to quit");
        System.out.println("Write number or word:");
    }

    public void printLogin(){
        System.out.println("Write password to login: ");
    }

    public void printContactDeleted(){
        System.out.println("Contact deleted!");
    }

    public void printWriteFirstName(){
        System.out.println("Write first name: ");
    }

    public void printWriteLastname(){
        System.out.println("Write last name: ");
    }

    public void printWriteAge(){
        System.out.println("Write age: ");
    }

    public void printWriteCity(){
        System.out.println("Write city: ");
    }
    public  void printWritePostcode(){
        System.out.println("Write postcode: ");
    }
    public void printWriteStreetName(){
        System.out.println("Write street name: ");
    }
    public void printWritePortNumber(){
        System.out.println("Write port number: ");
    }

    public void printWriteTelephoneNumber(){
        System.out.println("Write telephone number(s) with a space between each number: ");
    }

    public void printUpdateHelp(){
        System.out.println("Add the new information. If you don't want to change, write '.'");
    }

    public  void printSearchMenu(){
        System.out.println("1. Search by last name.");
        System.out.println("2. Search by street name");
        System.out.println("3. Search by first name.");
        System.out.println("4. Search freely");
    }

    public void printDeleteContact(){
        System.out.println("Write the index of the contact you want to remove!");
    }

    public void printUpdateContact(){
        System.out.println("Write index of the user you want to update!");
    }

    public void printContact(Contact contact){
        System.out.println("Index: " + contact.getContactIndex());
        System.out.println("First name: " + contact.getFirstName());
        System.out.println("Last name: " + contact.getLastName());
        System.out.println("Age: " + contact.getAge());
        // 0 = City, 1 = Postcode, 2 = Street name, 3 = Port number
        System.out.println("Address: " + contact.getAddress().get(0) + " " + contact.getAddress().get(1) +
                " " + contact.getAddress().get(2) + " " + contact.getAddress().get(3));

        //Loop through all the numbers
        for (String telephoneNumber: contact.getTelephoneNumbers())
        {
            System.out.println("Telephonenumber: " + telephoneNumber);
        }

        System.out.println("");
    }

    public void printSearchLastName(){
        System.out.println("Write their last name: ");
    }

    public void printSearchStreetName(){
        System.out.println("Write their street name: ");
    }

    public void printSearchFirstName(){
        System.out.println("Write their first name");
    }

    public void printSearchFree(){
        System.out.println("Write anything you want to search on: ");
    }

    public void printNoContactFound(){
        System.out.println("No contact found, please try again!");
    }

    public void printContactsFound(ArrayList<Contact> contacts){
        if (!contacts.isEmpty()) {

            for (int i = 0; i < contacts.size(); i++) {
                //Get the current contact in array list contacts.
                Contact contact = contacts.get(i);

                ArrayList<String> address = contact.getAddress();

                String telephoneNumbers = "";

                //Get telephone numbers in one string.
                for (int k = 0; k < contact.getTelephoneNumbers().size(); k++) {
                    telephoneNumbers = telephoneNumbers + contact.getTelephoneNumbers().get(k) + " ";
                }

                System.out.println("Index: " + contact.getContactIndex());
                System.out.println("First name: " + contact.getFirstName());
                System.out.println("Last name: " + contact.getLastName());
                System.out.println("Age: " + contact.getAge());
                System.out.println("Address: " + address.get(0) + " " + address.get(1) +
                        " " + address.get(2) + " " + address.get(3));
                //Loop through all the numbers
                for (String telephoneNumber : contact.getTelephoneNumbers()) {
                    System.out.println("Telephonenumber: " + telephoneNumber);
                }
                System.out.println("");
            }
        }
        else
        {
            printNoContactFound();
        }
    }
}
