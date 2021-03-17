import java.util.Scanner;

public class Profile
{
   //attributen
   private char Verificatie;
   private String username;
   private String password;
   private String VoorNaam;
   private String AchterNaam;
   private int leeftijd;
   private double gewicht;
   private double lengte;
   private double bmi;

   Scanner in = new Scanner(System.in);

   //constructors
   public Profile() {

   }

   public Profile(char Verificatie,String username, String password, String VoorNaam, String AchterNaam)
   {
      this.Verificatie = Verificatie;
      this.username = username;
      this.password = password;
      this.VoorNaam = VoorNaam;
      this.AchterNaam = AchterNaam;
   }

   public Profile(char Verificatie, String username, String password, String VoorNaam, String AchterNaam, int leeftijd, double gewicht, double lengte, double bmi)
   {
      this.Verificatie = Verificatie;
      this.username = username;
      this.password = password;
      this.VoorNaam = VoorNaam;
      this.AchterNaam = AchterNaam;
      this.leeftijd = leeftijd;
      this.lengte = lengte;
      this.gewicht = gewicht;
      this.bmi = bmi;
   }

   //getters & setters
   public char getVerificatie()
   {
      return Verificatie;
   }

   public void setVerificatie(char verificatie)
   {
      Verificatie = verificatie;
   }

   public String getUsername()
   {
      return username;
   }

   public void setUsername(String username)
   {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password)
   {
      this.password = password;
   }

   public String getVoorNaam()
   {
      return VoorNaam;
   }

   public void setVoorNaam(String VoorNaam)
   {
      this.VoorNaam = VoorNaam;
   }

   public String getAchterNaam()
   {
      return AchterNaam;
   }

   public void setAchterNaam(String AchterNaam)
   {
      this.AchterNaam = AchterNaam;
   }

   public int getLeeftijd()
   {
      return leeftijd;
   }

   public void setLeeftijd(int leeftijd)
   {
      this.leeftijd = leeftijd;
   }

   public double getGewicht()
   {
      return gewicht;
   }

   public void setGewicht(double gewicht)
   {
      this.gewicht = gewicht;
   }

   public double getLengte()
   {
      return lengte;
   }

   public void setLengte(double lengte)
   {
      this.lengte = lengte;
   }

   public double getBmi()
   {
      return bmi;
   }

   public void setBmi(double bmi)
   {
      this.bmi = bmi;
   }


   //methodes die te maken hebben met profielbewerking
   public void ReCalcBMI() {
      bmi = getGewicht() / (getLengte() * getLengte());
      setBmi(bmi);
   }


   public Profile EditProfileAlles(Profile profile) {
      System.out.print("\nWat is uw voornaam: ");
      setVoorNaam(in.nextLine());
      System.out.print("\nWat is uw achternaam? ");
      setAchterNaam(in.nextLine());
      System.out.print("\nWat is uw leeftijd?");
      setLeeftijd(Integer.parseInt(in.nextLine()));
      System.out.print("\nWat is uw lengte?");
      setLengte(Double.parseDouble(in.nextLine()));
      System.out.print("\nWat is uw gewicht?");
      setGewicht(Double.parseDouble(in.nextLine()));
      ReCalcBMI();

      System.out.println("\nUw nieuwe gegevens zijn:");
      System.out.println("Uw voornaam is: " + getVoorNaam());
      System.out.println("Uw achternaam is: " + getAchterNaam());
      System.out.println("Uw leeftijd is: " + getLeeftijd());
      System.out.printf("Uw lengte is: %.2f%n", getLengte());
      System.out.printf("Uw gewicht is: %.2f%n", getGewicht());
      System.out.printf("Uw BMI is: %.2f%n", getBmi());
      return profile;
   }

   public Profile EditPatientAlles(Profile patient)
   {
      System.out.print("\nWat is uw voornaam: ");
      setVoorNaam(in.nextLine());
      System.out.print("\nWat is uw achternaam? ");
      setAchterNaam(in.nextLine());
      System.out.print("\nWat is uw leeftijd?");
      setLeeftijd(Integer.parseInt(in.nextLine()));
      System.out.print("\nWat is uw lengte?");
      setLengte(Double.parseDouble(in.nextLine()));
      System.out.print("\nWat is uw gewicht?");
      setGewicht(Double.parseDouble(in.nextLine()));
      ReCalcBMI();

      System.out.println("\nUw nieuwe gegevens zijn:");
      System.out.println("Uw voornaam is: " + getVoorNaam());
      System.out.println("Uw achternaam is: " + getAchterNaam());
      System.out.println("Uw leeftijd is: " + getLeeftijd());
      System.out.printf("Uw lengte is: %.2f%n", getLengte());
      System.out.printf("Uw gewicht is: %.2f%n", getGewicht());
      System.out.printf("Uw BMI is: %.2f%n", getBmi());
      return patient;
   }

   public void EditProfileVoornaam() {
      System.out.print("\nWat is uw voornaam: ");
      setVoorNaam(in.nextLine());
      System.out.print("Opgeslagen voornaam is: " + getVoorNaam() + "\n");
   }

   public void EditProfileAchternaam() {
      System.out.print("\nWat is uw achternaam: ");
      setAchterNaam(in.nextLine());
      System.out.print("Opgeslagen achternaam is: " + getAchterNaam() + "\n");
   }

   public void EditProfileLeeftijd() {
      System.out.print("\nWat is uw leeftijd: ");
      setLeeftijd(in.nextInt());
      System.out.print("Opgeslagen leeftijd is: " + getLeeftijd() + "\n");
   }

   public void EditProfileLengte() {
      System.out.print("\nWat is uw lengte: ");
      setLengte(in.nextDouble());
      System.out.printf("Uw lengte is: %.2f%n", getLengte());
   }

   public void EditProfileGewicht() {
      System.out.print("\nWat is uw gewicht: ");
      setGewicht(in.nextDouble());
      System.out.printf("Opgelagen gewicht is: %.2f%n", getGewicht());
   }

   public void EditProfileUsername()
   {
      System.out.print("\nKies een gebruikersnaam: ");
      setUsername(in.nextLine());
      System.out.printf("Opgeslagen gebruikersnaam is: ", getUsername());
   }

   public void EditProfilePassword()
   {
      System.out.print("\nKies een nieuw wachtwoord: ");
      setPassword(in.nextLine());
      System.out.printf("Opgeslagen wachtwoord is: ", getPassword());
   }


   public void addMedicine()
   {

   }

   public void removeMedicine()
   {
   }

   public void removeProfile()
   {
   }

   public void GewichtMeetPunt()
   {
   }

   //print profielgegevens
   public void PrintProfileAlles() {
      System.out.println("\nUw huidige profielgegevens: \n");
      System.out.println("Gebruikersnaam: " + username);
      System.out.println("Wachtwoord: " + password);
      System.out.println("Voornaam: " + VoorNaam);
      System.out.println("Achternaam: " + AchterNaam);
      System.out.println("Leeftijd: " + leeftijd);
      System.out.printf("Lengte in: %.2f%n", lengte, " m");
      System.out.printf("Gewicht: %.2f%n", gewicht, " kg");
      System.out.printf("BMI: %.2f%n", bmi);
   }

   public void PrintProfileMedicine()
   {

   }




   @Override
   public String toString()
   {

      return VoorNaam + " " + AchterNaam;
   }

}


