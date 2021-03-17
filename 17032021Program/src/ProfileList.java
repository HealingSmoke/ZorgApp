import java.util.ArrayList;
import java.util.Arrays;

public class ProfileList
{
   private ArrayList<Profile> profileList = new ArrayList<>();

   public ProfileList()
   {

   }

   public void addProfile(Profile profile)
   {
      profileList.add(profile);
   }

   public Profile get(int i)
   {
      return profileList.get(i);
   }

   public void removeProfile(Profile profile)
   {
      profileList.remove(profile);
   }

   public int sizeOf()
   {
      return profileList.size();
   }

   public void PrintProfileList()
   {
      //print volledige profilelist met index
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
