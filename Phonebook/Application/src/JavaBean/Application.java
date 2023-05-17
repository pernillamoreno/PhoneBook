package JavaBean;

import Builder.ContactBuilder;
import User.User;
import User.Admin;
import User.Guest;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private Output output;
    private PhoneBook phoneBook;
    private Scanner scanner;
    private User user;


    public Application(){
        output = new Output();
        phoneBook = PhoneBook.getInstance();
        scanner = new Scanner(System.in);
        user = new Guest();
    }

    public void runApplication(){

         boolean quitApplication = false;

         //Menu
        while(!quitApplication)
        {
            //Print the menu
            output.printFirstMenu(user.getAdminPrivilege());

            String menuInput = scanner.nextLine();

            //Create contact
            if(menuInput.equals("1"))
            {
                createContact();
            }

            //JavaBean.Search contact
            else if(menuInput.equals("2"))
            {
                searchContact();
            }

            //Login
            else if(menuInput.equals("3") && !user.getAdminPrivilege())
            {
                //Not secure way to store password at all...
                String adminPassword = "test123";
                output.printLogin();
                menuInput = scanner.nextLine();
                if(menuInput.equals(adminPassword)){
                    user = new Admin();
                }

            }

            //Update contact
            else if (menuInput.equals("3") && user.getAdminPrivilege())
            {
                output.printUpdateContact();
                int contactIndexInput = scanner.nextInt();
                Contact contact = phoneBook.getContactList().get(contactIndexInput);
                output.printContact(contact);
                output.printUpdateHelp();
                updateContact(contact, contactIndexInput);
            }

            //Delete contact
            else if (menuInput.equals("4") && user.getAdminPrivilege())
            {
                output.printDeleteContact();
                int contactIndexInput = scanner.nextInt();
                phoneBook.deleteContact(contactIndexInput);
                output.printContactDeleted();
            }
            else if (menuInput.equals("quit"))
            {
                quitApplication = true;
            }
            //Reset buffer
            scanner = new Scanner(System.in);
        }
    }

    private void searchContact(){
        output.printSearchMenu();
        String menuInput = scanner.nextLine();
        ArrayList<Contact> foundContacts = new ArrayList<>();

        //Search last name
        if (menuInput.equals("1"))
        {
            output.printSearchLastName();
            menuInput = scanner.nextLine();
            Contact contact = phoneBook.searchLastName(menuInput);
            if (contact != null){
                foundContacts.add(phoneBook.searchLastName(menuInput));
            }

        }
        //Search street name
        else if (menuInput.equals("2")) {
            output.printSearchStreetName();
            menuInput = scanner.nextLine();
            foundContacts = phoneBook.searchAddress(menuInput);

        }
        //Search first name
        else if (menuInput.equals("3")) {
            output.printSearchFirstName();
            menuInput = scanner.nextLine();
            foundContacts = phoneBook.searchFirstName(menuInput);

        }
        //Search free
        else if (menuInput.equals("4")) {
            output.printSearchFree();
            menuInput = scanner.nextLine();
            foundContacts = phoneBook.searchFree(menuInput);


        }

        //If no user where found, else print out the contacts
        if(foundContacts.isEmpty())
        {
            output.printNoContactFound();
        }
        else
        {
            output.printContactsFound(foundContacts);
        }
    }

    public void updateContact(Contact contact, int index){
        ArrayList<String> address = contact.getAddress();
        ArrayList<String> telephoneNumbersList = contact.getTelephoneNumbers();
        Contact modifiedContact = contact;
        scanner = new Scanner(System.in);

        //First name
        output.printWriteFirstName();
        String firstName = scanner.nextLine();
        if(!firstName.equals("."))
        {
            modifiedContact.setFirstName(firstName);
        }

        //Last name
        output.printWriteLastname();
        String lastName = scanner.nextLine();
        if(!lastName.equals("."))
        {
            modifiedContact.setLastName(lastName);
        }

        //Age
        output.printWriteAge();
        String age = scanner.nextLine();
        if(!age.equals("."))
        {
            modifiedContact.setAge(Integer.parseInt(age));
        }

        //City
        output.printWriteCity();
        String city = scanner.nextLine();
        if(!city.equals("."))
        {
            address.set(0, city);
        }

        //Postcode
        output.printWritePostcode();
        String postCode = scanner.nextLine();
        if(!postCode.equals("."))
        {
            address.set(1, postCode);
        }

        //Street name
        output.printWriteStreetName();
        String streetName = scanner.nextLine();
        if(!streetName.equals("."))
        {
            address.set(2, postCode);
        }

        //Port number
        output.printWritePortNumber();
        String portNumber = scanner.nextLine();
        if(!portNumber.equals("."))
        {
            address.set(3, portNumber);
        }

        //Telephone numbers
        output.printWriteTelephoneNumber();
        String telephoneNumbers = scanner.nextLine();
        if(!telephoneNumbers.equals(".")) {
            String[] telephoneNumbersArray = telephoneNumbers.split(" ");
            for (String telephoneNumber : telephoneNumbersArray) {
                telephoneNumbersList.add(telephoneNumber);
            }
        }

        modifiedContact.setAddress(address);
        modifiedContact.setTelephoneNumbers(telephoneNumbersList);

        phoneBook.updateContact(modifiedContact, index);


    }



    private void createContact(){
        ArrayList<String> address = new ArrayList<>();
        ArrayList<String> telephoneNumbersList = new ArrayList<>();
        ContactBuilder contactBuilder = new ContactBuilder();

        //First name
        output.printWriteFirstName();
        String firstName = scanner.nextLine();


        //Last name
        output.printWriteLastname();
        String lastName = scanner.nextLine();


        //Age
        output.printWriteAge();
        int age = Integer.parseInt(scanner.nextLine());


        //City
        output.printWriteCity();
        String city = scanner.nextLine();
        address.add(city);

        //Postcode
        output.printWritePostcode();
        String postCode = scanner.nextLine();
        address.add(postCode);

        //Street name
        output.printWriteStreetName();
        String streetName = scanner.nextLine();
        address.add(streetName);

        //Port number
        output.printWritePortNumber();
        String portNumber = scanner.nextLine();
        address.add(portNumber);

        //Telephone numbers
        output.printWriteTelephoneNumber();
        String telephoneNumbers = scanner.nextLine();
        String[] telephoneNumbersArray = telephoneNumbers.split(" ");
        for(String telephoneNumber : telephoneNumbersArray){
            telephoneNumbersList.add(telephoneNumber);
        }


        //Building the contact
        contactBuilder
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setAddress(address)
                .setTelephoneNumber(telephoneNumbersList);

        Contact createdContact = contactBuilder.build();
        phoneBook.createContact(createdContact);

    }
}
