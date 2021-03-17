public class Medicine
{
   private String medicineName;
   private String soort;
   private String dosering;
   private String omschrijving;

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




   @Override
   public String toString()
   {
      return "\n" + medicineName + " " + omschrijving + " " + soort + " " + dosering;
   }
}
