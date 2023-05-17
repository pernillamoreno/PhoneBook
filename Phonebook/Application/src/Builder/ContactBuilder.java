package Builder;
import JavaBean.Contact;
import java.util.ArrayList;
public class ContactBuilder {

    private Contact contact;

    public ContactBuilder(){
        this.contact = new Contact();
    }

    public ContactBuilder setFirstName(String firstName) {
        contact.setFirstName(firstName);
        return this;
    }

    public ContactBuilder setLastName(String lastName) {
        contact.setLastName(lastName);
        return this;
    }

    public ContactBuilder setAge(int age) {
        contact.setAge(age);
        return this;
    }

    public ContactBuilder setAddress(ArrayList<String> address) {
        contact.setAddress(address);
        return this;
    }

    public ContactBuilder setTelephoneNumber(ArrayList<String> telephoneNumbers){
        contact.setTelephoneNumbers(telephoneNumbers);
        return this;
    }

    public Contact build(){
        return contact;
    }
}