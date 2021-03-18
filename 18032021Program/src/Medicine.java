import java.util.Scanner;

public class Medicine
{
   //attributen
   private String medicineName;
   private String soort;
   private String dosering;
   private String omschrijving;

   Scanner in = new Scanner(System.in);


   //constructors
   public Medicine()
   {

   }

   public Medicine(String medicineName, String omschriving)
   {
      this.medicineName = medicineName;
      this.omschrijving = omschriving;
   }

   public Medicine(String medicineName, String soort, String omschrijving, String dosering)
   {
      this.medicineName = medicineName;
      this.soort = soort;
      this.dosering = dosering;
      this.omschrijving = omschrijving;
   }


   //getters en setters
   public void setMedicineName(String medicineName)
   {
      this.medicineName = medicineName;
   }

   public String getMedicineName()
   {
      return medicineName;
   }

   public void setSoort(String soort)
   {
      this.soort = soort;
   }

   public String getSoort()
   {
      return soort;
   }

   public void setDosering(String dosering)
   {
      this.dosering = dosering;
   }

   public String getDosering()
   {
      return dosering;
   }

   public void setOmschrijving(String omschrijving)
   {
      this.omschrijving = omschrijving;
   }

   public String getOmschrijving()
   {
      return omschrijving;
   }


   //methodes omtrend medicijnen
   public void addNewMedicine(Medicine medicine) //Voeg een nieuw medicijn toe
   {
      System.out.print("\nWat is de naam van het nieuwe medicijn: ");
      medicine.setMedicineName(in.nextLine());
      System.out.print("Wat soort medicijn is het: ");
      medicine.setSoort(in.nextLine());
      System.out.print("Wat is de omschrijving van dit medicijn: ");
      medicine.setOmschrijving(in.nextLine());
      System.out.print("Wat is de normale dosering voor dit medicijn: ");
      medicine.setDosering(in.nextLine());
      System.out.print("\nIngevoerde medicijn: \n");
      PrintMedicine();
      return;
   }

   private void PrintMedicine() //print een medicijn
   {
      System.out.println("Medicijnnaam: " + medicineName);
      System.out.println("Soort: " + soort);
      System.out.println("Omschrijving: " + omschrijving);
      System.out.println("Dosering: " + dosering);
   }


   @Override
   public String toString()
   {
      return medicineName + " is een " + soort + ".\n" + omschrijving + "\nDosering: " + dosering;
   }



}
