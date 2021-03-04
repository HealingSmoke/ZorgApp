import java.util.Scanner;

public class Profile
{
   private String voorNaam;
   private String achterNaam;
   private int leeftijd;
   private double gewicht;
   private double lengte;
   private double bmi;

   Scanner in = new Scanner(System.in);

   public Profile()
   {


   }

   public Profile(String voorNaam, String achterNaam)
   {
      this.voorNaam = voorNaam;
      this.achterNaam = achterNaam;
   }

   public Profile(String voorNaam, String achterNaam, int leeftijd, double gewicht, double lengte, double bmi)
   {
      this.voorNaam = voorNaam;
      this.achterNaam = achterNaam;
      this.gewicht = gewicht;
      this.lengte = lengte;
      this.leeftijd = leeftijd;
   }

   public void setVoorNaam(String voorNaam)
   {
      this.voorNaam = voorNaam;
   }

   public String getVoorNaam()
   {
      return voorNaam;
   }

   public void setAchterNaam(String achterNaam)
   {
      this.achterNaam = achterNaam;
   }

   public String getAchterNaam()
   {
      return achterNaam;
   }

   public void setGewicht(double gewicht)
   {
      this.gewicht = gewicht;
   }

   public double getGewicht()
   {
      return gewicht;
   }

   public void setLengte(double lengte)
   {
      this.lengte = lengte;
   }

   public double getLengte()
   {
      return lengte;
   }

   public void setLeeftijd(int leeftijd)
   {
      this.leeftijd = leeftijd;
   }

   public int getLeeftijd()
   {
      return leeftijd;
   }


   public void EditProfileAlles()
   {
      System.out.println("Wat is uw voornaam? ");
      setVoorNaam(in.nextLine());
      System.out.println("Wat is uw achternaam? ");
      setAchterNaam(in.nextLine());
      System.out.println("Wat is uw leeftijd?");
      setLeeftijd(in.nextInt());
      System.out.println("Wat is uw lengte?");
      setLengte(in.nextDouble());
      System.out.println("Wat is uw gewicht?");
      setGewicht(in.nextDouble());

      System.out.println("Opgeslagen voornaam is: " + getVoorNaam());
      System.out.println("Opgeslagen achternaam is: " + getAchterNaam());
      System.out.println("Opgeslagen leeftijd is: " + getLeeftijd());
      System.out.println("Uw lengte is: " + getLengte());
      System.out.println("Opgelagen gewicht is: " + getGewicht());

   }

   public void EditProfileVoornaam()
   {
      System.out.println("Wat is uw voornaam?");
      setVoorNaam(in.nextLine());
      System.out.println("Opgeslagen voornaam is: " + getVoorNaam());
   }

   public void EditProfileAchternaam()
   {
      System.out.println("Wat is uw achternaam?");
      setAchterNaam(in.nextLine());
      System.out.println("Opgeslagen achternaam is: " + getAchterNaam());
   }

   public void EditProfileLeeftijd()
   {
      System.out.println("Wat is uw leeftijd?");
      setLeeftijd(in.nextInt());
      System.out.println("Opgeslagen leeftijd is: " + getLeeftijd());
   }

   public void EditProfileLengte()
   {
      System.out.println("Wat is uw lengte?");
      setLengte(in.nextDouble());
      System.out.println("Uw lengte is: " + getLengte());
   }

   public void EditProfileGewicht()
   {
      System.out.println("Wat is uw gewicht?");
      setGewicht(in.nextDouble());
      System.out.println("Opgelagen gewicht is: " + getGewicht());
   }

   public void ReCalcBMI()
   {

   }

   public void PrintProfileAlles()
   {
      System.out.println("Uw huidige profielgegevens: ");
      System.out.println("Voornaam: " + this.voorNaam);
      System.out.println("Achternaam: " + this.achterNaam);
      System.out.println("Leeftijd: " + this.leeftijd);
      System.out.println("Lengte in cm: " + this.lengte);
      System.out.println("Gewicht in kg: " + this.gewicht);
      //System.out.println("BMI: " + this.bmi);
   }

   public void PrintProfileMedicatie()
   {
      System.out.println("Uw huidige profielgegevens: ");
   }
}


