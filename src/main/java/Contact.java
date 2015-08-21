import java.util.ArrayList;

public class Contact { //class Contact
    private int mId;
    private String mFirstName, mSecondName, mDob; 
    private static ArrayList<Contact> instances = new ArrayList<Contact>();
    private ArrayList<PhoneList> mPhoneList;

  public Contact(String firstname, String secondname, String dob) {
    mFirstName = firstname;
    mSecondName = secondname;
    mDob = dob; 
    instances.add(this); //add(this) adds this Contact object being created to the ArrayListContact
    mId = instances.size(); //persists across all unit tests
    mPhoneList = new ArrayList<PhoneList>();// number of objects in array list
  }// constructor has all the instructions for making a new instance of the class task
  //constructors are named after the class, they are actually methods

  public String getFirstName(){
    return mFirstName;
  }

  public String getSecondName(){
    return mFirstName;
  }

  public String getDob(){
    return mDob;
  }

  public int getId(){
    return mId;
  }
  
  public ArrayList<PhoneList> getPhoneList() {
    return mPhoneList;
  }

  public void addPhoneList(PhoneList phone){
    mPhoneList.add(phone); //this method will get input from elsewhere
  }

  public static ArrayList<Contact> all() {
    return instances;
  }

  public static void clear() {
    instances.clear(); //dumps everything out of contacts object
  }
  
  public static Contact find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }
} //class Contact
