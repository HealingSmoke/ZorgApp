import java.util.ArrayList;

public class MedicineList
{
   private ArrayList<Medicine> medicineList = new ArrayList();

   public int sizeOf()
   {
      return medicineList.size();
   }

   public void addMedicine(Medicine medicine)
   {
     medicineList.add(medicine);
   }

   public Medicine get(int m)
   {
      return medicineList.get(m);
   }

   public void removeMedicine(Medicine medicine)
   {
      medicineList.remove(medicine);
   }

   public void PrintMedicineList()
   {
      System.out.println(" ");
      //print volledige profilelist met index
      for (int m = 0; m < sizeOf(); m++)
      {
         System.out.printf("%d.%s%n ", m, medicineList.get(m));
      }
   }

   public String toString()
   {
      return "\nMedicijnenlijst: " + medicineList;
   }

}