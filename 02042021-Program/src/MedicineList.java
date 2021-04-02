import java.util.ArrayList;

public class MedicineList
{
   private final ArrayList<Medicine> medicineList = new ArrayList<>();

   public MedicineList()
   {

   }

   public int size()
   {
      return medicineList.size();
   }

   public void add(Medicine medicine)
   {
     medicineList.add(medicine);
   }

   public Medicine get(int m)
   {
      return medicineList.get(m);
   }

   public void remove(Medicine medicine)
   {
      medicineList.remove(medicine);
   }

   public void printMedicine() //Print medicijnen van het systeem
   {
      if (medicineList.size() == 0)
      {
         System.out.println("Sorry u heeft nog geen medicijnen.");
      }
      else
      {
         System.out.println("\nUw medicijnen:");
         for (int m = 0; m < size(); m++)
         {
            System.out.printf("%d.%s%n", m+1, medicineList.get(m));
         }
      }
   }


   //Engels
   public void printMedicineEn() //Print medicijnen van het systeem
   {
      if (medicineList.size() == 0)
      {
         System.out.println("Sorry you don't have any medicine to show.");
      }
      else
      {
         System.out.println("\nYour medicine:");
         for (int m = 0; m < size(); m++)
         {
            System.out.printf("%d.%s%n", m+1, medicineList.get(m));
         }
      }
   }

   public String toString()
   {
      return "\nMedicijnenlijst: " + medicineList;
   }

}