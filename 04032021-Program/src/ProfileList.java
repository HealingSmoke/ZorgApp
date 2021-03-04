import java.util.ArrayList;

public class ProfileList
{
   private Profile profile;
   private ArrayList<Profile> profileList = new ArrayList<>();

   private int index;

   public ProfileList()
   {
//arraylist van profile




   }
   public void addProfile(Profile profile)
   {
      profileList.add(profile);
   }


   public ArrayList<Profile> getProfileList(int index)
   {
      return profileList;
   }

}
