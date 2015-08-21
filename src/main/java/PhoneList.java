import java.util.ArrayList;

public class PhoneList {
	private static ArrayList<PhoneList> contacts = new ArrayList<PhoneList>();
	private String mPhoneNumber;
	private int mId;

public PhoneList(String phonenumber){
		mPhoneNumber = phonenumber;
		contacts.add(this);
		mId = contacts.size();
	} //end public PhoneList constructor

  public String getPhoneNumber() {
    return mPhoneNumber;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<PhoneList> all() {
    return contacts;
  }

  public static PhoneList find(int id) {
    try {
      return contacts.get(id-1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }
  public static void clear() {
    contacts.clear();
  }
} //end PhoneList Class 
