import java.util.ArrayList;

public class MedicineList
{
   private Medicine medicine;
   private ArrayList<Medicine> medicineList = new ArrayList();


   public MedicineList()
   {
      //print volledige profilelist met index
      for (int i = 0; i < sizeOf(); i++)
      {
         System.out.printf("%d.%s%n", i, medicineList.get(i));
      }
   }

   private int sizeOf()
   {
      return medicineList.size();
   }

   public void addMedicine(Medicine medicine)
   {
      medicineList.add(medicine);
   }



   public String toString()
   {
      return "\nMedicijnenlijst: " + medicineList;
   }

   public void PrintMedicineList()
   {
   }
}