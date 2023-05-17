package JavaBean;

import java.util.ArrayList;

public class Contact {
    private String firstName;
    private String lastName;
    private int age;

    private int contactIndex;

    private ArrayList<String> address; //(city, post code, street name, port number);
    private ArrayList<String> telephoneNumbers; //(One user can have multiply telephone numbers)

    public Contact(){
        contactIndex = 0;
    }

    public int getContactIndex() {
        return contactIndex;
    }

    public void setContactIndex(int contactIndex) {
        this.contactIndex = contactIndex;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge(){
        return age ;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public ArrayList<String> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<String> address) {
        this.address = address;
    }

    public ArrayList<String> getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public void setTelephoneNumbers(ArrayList<String> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }
}