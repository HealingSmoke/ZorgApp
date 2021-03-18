import java.util.ArrayList;

public class ProfileList
{
   private ArrayList<Profile> profileList = new ArrayList<>();

   public ProfileList()
   {

   }

   public void addProfile(Profile profile) // profiel toevoegen
   {
      profileList.add(profile);
   }

   public Profile get(int i) //get index
   {
      return profileList.get(i);
   }

   public void removeProfile(Profile profile) //profiel verwijderen
   {
      profileList.remove(profile);
   }

   public int sizeOf() //geeft de grootte van de lijst terug
   {
      return profileList.size();
   }

   public void PrintProfileList()  //print volledige profilelist met index
   {
      System.out.println("\nDit is uw huidige patiëntenlijst: ");

      for (int i = 1; i < sizeOf(); i++)
      {
         System.out.printf("%d.%s%n", i, get(i));
      }

   }



   @Override
   public String toString()
   {
      return "\nPatiëntenlijst: " + profileList;
   }


}
