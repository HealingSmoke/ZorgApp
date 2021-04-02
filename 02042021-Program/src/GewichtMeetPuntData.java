import java.util.ArrayList;
import java.util.Comparator;

public class GewichtMeetPuntData
{

   private final ArrayList<GewichtMeetPunt> gewichtMeetPuntData = new ArrayList<>();

   public GewichtMeetPuntData()
   {

   }

   public int size()
   {
      return gewichtMeetPuntData.size();
   }

   public void add(GewichtMeetPunt gewichtMeetPunt)
   {
      gewichtMeetPuntData.add(gewichtMeetPunt);
   }

   public GewichtMeetPunt get(int m)
   {
      return gewichtMeetPuntData.get(m);
   }

   public void remove(GewichtMeetPunt gewichtMeetPunt)
   {
      gewichtMeetPuntData.remove(gewichtMeetPunt);
   }

   public String toString()
   {
      return "\nGewicht meet punten: " + gewichtMeetPuntData;
   }

   public void sort(){
      Comparator<GewichtMeetPunt> compareByName = Comparator
            .comparing(GewichtMeetPunt::getYear)
            .thenComparing(GewichtMeetPunt::getMonth)
            .thenComparing(GewichtMeetPunt::getDay);

      gewichtMeetPuntData.sort(compareByName);
   }
}
