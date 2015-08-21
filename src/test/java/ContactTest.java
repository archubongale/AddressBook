import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class ContactTest {

  @Test
  public void getName_returnsName_true() {
    Contact testContact = new Contact("Archana", "Bongale", "01/02/3333");
    assertEquals("Archana", testContact.getFirstName());
  }

  @Test
  public void getID_returnsCategoryID(){
    Contact testCategory = new Contact("Archana", "Bongale", "01/02/3333");
    assertTrue(Contact.all().size() == testCategory.getId());
  }

  @Test
  public void getPhoneList_initiallyreturnsEmptyArrayList(){
    Contact testContact = new Contact("Archana", "Bongale", "01/02/3333");
    assertTrue(testContact.getPhoneList() instanceof ArrayList);
  }

  @Test
  public void all_returnsTwoCategories() {
    Contact firstContact = new Contact ("Archana", "Bongale", "01/02/3333");
    Contact secondContact = new Contact ("Maria", "Mendez", "02/03/4444");
    assertTrue(Contact.all().contains(firstContact));
    assertTrue(Contact.all().contains(secondContact));
  }
  @Test
  public void clear_removesAllContantInstancesFromMemory() {
    Contact testContact = new Contact("Archana", "Bongale", "01/02/3333");
    Contact.clear();
    assertEquals(Contact.all().size(), 0);
  }
  
  @Test
  public void find_returnsContactWithSameId() {
    Contact testContact = new Contact("Archana", "Bongale", "01/02/3333");
    assertEquals(Contact.find(testContact.getId()), testContact);
  }

}

