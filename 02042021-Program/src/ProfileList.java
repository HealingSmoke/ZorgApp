import java.util.ArrayList;

public class ProfileList
{
   private final ArrayList<Profile> profileList = new ArrayList<>();

   public ProfileList()
   {

   }

   public void add(Profile profile) // profiel toevoegen
   {
      profileList.add(profile);
   }

   public Profile get(int i) //get index
   {
      return profileList.get(i);
   }

   public void remove(Profile profile) //profiel verwijderen
   {
      profileList.remove(profile);
   }

   public int size() //geeft de grootte van de lijst terug
   {
      return profileList.size();
   }

   public void print()  //print volledige profilelist met index
   {
      System.out.println("\nDit is uw huidige patiëntenlijst: \n");

      for (int i = 1; i < size(); i++)
      {
         System.out.printf("%d.%s%n", i, get(i));
      }

   }


   //Engels
   public void printEn()  //print volledige profilelist met index
   {
      System.out.println("\nThis is your current list of patiënts: \n");

      for (int i = 1; i < size(); i++)
      {
         System.out.printf("%d.%s%n", i, get(i));
      }

   }

   @Override
   public String toString()
   {
      return "\nPatiëntenlijst: \n" + profileList;
   }


}
