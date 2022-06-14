import java.util.ArrayList;

public class Phonebook
{
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    
    
    /**
     * [Based off assignment prompt]
     * Takes a Contact and adds it to the list of contacts. Once the 
     * contact has been added, the sort method is called to sort that new 
     * contact into the phone book.
     *
     * @precondition inputed object with name.
     * @param e - Contact object to be added into contacts ArrayList
     * 
     * @postcondition Contact object is added to contacts and contacts is sorted via sort()
     */
    public void addContact(Contact e){
        contacts.add(e);
        this.sort();
    }
    
    /**
     * [Based off assignment prompt]
     * sorts the contact list by name in alphabetical order A-Z
     * 
     * 
     * 
    */
    public void sort(){
       // use insertion sorting
       // traverse array
       for(int i = 1; i < contacts.size(); i++)
       {
           Contact currentVal = contacts.get(i);
           int sorted = i - 1;
           
           // find min, use compared in second piece
           /*
            current contact is greater than currentVal
            compared: this is alphabetically higher = neg.
           */
           while(sorted > -1 && Integer.toString(contacts.get(sorted).getName().compareTo(currentVal.getName())).indexOf("-") == -1){
               contacts.set(sorted + 1,contacts.get(sorted));
               sorted--;
           }
           
           // swap places
           contacts.set(sorted + 1,currentVal);
       }
       
    }
    
    public void printPhonebook(){
        for(Contact e : contacts)
            System.out.println(e.getName());
    }
}
