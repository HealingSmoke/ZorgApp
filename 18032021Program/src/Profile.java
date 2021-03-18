import java.util.ArrayList;
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
   Scanner string = new Scanner(System.in);
   private MedicineList medicineList = new MedicineList();

   //constructors
   public Profile() {}

   public Profile(char Verificatie,String username, String password, String VoorNaam, String AchterNaam)
   {
      this.Verificatie = Verificatie;
      this.username = username;
      this.password = password;
      this.VoorNaam = VoorNaam;
      this.AchterNaam = AchterNaam;
      this.medicineList = (MedicineList) medicineList;
   }

   public Profile(char Verificatie, String username, String password, String VoorNaam, String AchterNaam, int leeftijd, double gewicht, double lengte, double bmi, Object medicineList)
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

   //Persoonlijke medicijnenlijst
   public void addMedicineToProfile(Medicine medicine)
   {
      medicineList.addMedicine(medicine);
   }

   public void removeMedicineFromProfile(Medicine medicine)
   {
      medicineList.removeMedicine(medicine);
   }

   public void PrintProfileMedicine(Profile patient)
   {
      System.out.println("\nDit is de medicijnenlijst van: " + getVoorNaam() + " " + getAchterNaam());
      for (int m = 0; m < ProfileMedicineSizeOf(); m++)
      {
         System.out.printf("%d.%s%n ", m, medicineList.get(m));
      }
   }



   public int ProfileMedicineSizeOf()
   {
      return medicineList.sizeOf();
   }



   //methodes die te maken hebben met profielbewerking
   public void ReCalcBMI() {
      bmi = getGewicht() / (getLengte() * getLengte());
      setBmi(bmi);
   }


   public void EditProfileAlles() //Patient zelf profiel bewerken
   {
      boolean exit = false;
      while (!exit)
      {
         System.out.println("\nWilt de gebruikersnaam en wachtwoord ook bewerken?\nTyp ja of nee: ");
         String antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            System.out.print("\nWat wordt uw nieuwe gebruikersnaam: ");
            setUsername(string.nextLine());
            System.out.print("Wat wordt uw nieuwe wachtwoord: ");
            setPassword(string.nextLine());
            break;
         }
         else if (antwoord.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.print("\nProbeer opnieuw\n");
         }
      }
      System.out.print("\nWat is uw voornaam: ");
      setVoorNaam(string.nextLine());
      System.out.print("Wat is uw achternaam? ");
      setAchterNaam(string.nextLine());
      System.out.print("Wat is uw leeftijd?");
      setLeeftijd(in.nextInt());
      System.out.print("Wat is uw lengte?");
      setLengte(Double.parseDouble(in.nextLine()));
      System.out.print("Wat is uw gewicht?");
      setGewicht(Double.parseDouble(in.nextLine()));
      ReCalcBMI();

      System.out.println("\nUw nieuwe gegevens zijn:\n");
      PrintProfileAlles();
   }

   public void EditPatientAlles() //Zorgverlener die patient profiel bewerkt
   {
      setVerificatie('p');
      boolean exit = false;
      while (!exit)
      {
         System.out.println("\nWilt de gebruikersnaam en wachtwoord ook bewerken?\nTyp ja of nee: ");
         String antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            System.out.print("\nWat wordt de nieuwe gebruikersnaam van uw patiënt: ");
            setUsername(string.nextLine());
            System.out.print("Wat wordt het nieuwe wachtwoord van uw patiënt: ");
            setPassword(string.nextLine());
            break;
         }
         else if (antwoord.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.print("\nProbeer opnieuw\n");
         }
      }
      System.out.print("Wat is de voornaam van uw patiënt: ");
      setVoorNaam(string.nextLine());
      System.out.print("Wat is de achternaam van uw patiënt: ");
      setAchterNaam(string.nextLine());
      System.out.print("Wat is de leeftijd van uw patiënt: ");
      setLeeftijd(Integer.parseInt(string.nextLine()));
      System.out.print("Wat is de lengte van uw patiënt: ");
      setLengte(Double.parseDouble(string.nextLine()));
      System.out.print("Wat is het gewicht van uw patiënt: ");
      setGewicht(Double.parseDouble(string.nextLine()));
      ReCalcBMI();
      System.out.println("\nDe ingevoerde gegevens van uw patiënt zijn:\n");
      setVerificatie('p');
      PrintProfileAlles();

   }

   public void EditProfileVoornaam() //Voornaam bewerken
   {
      System.out.print("\nNieuwe voornaam: ");
      setVoorNaam(string.nextLine());
      System.out.print("Opgeslagen voornaam is: " + getVoorNaam() + "\n");
   }

   public void EditProfileAchternaam() //Achternaam bewerken
   {
      System.out.print("\nNieuwe achternaam: ");
      setAchterNaam(string.nextLine());
      System.out.print("Opgeslagen achternaam is: " + getAchterNaam() + "\n");
   }

   public void EditProfileLeeftijd() //Leeftijd bewerken
   {
      System.out.print("\nNieuwe leeftijd: ");
      setLeeftijd(in.nextInt());
      System.out.print("Opgeslagen leeftijd is: " + getLeeftijd() + "\n");
   }

   public void EditProfileLengte() //Lengte bewerken
   {
      System.out.print("\nNieuwe lengte: ");
      setLengte(in.nextDouble());
      System.out.printf("Uw lengte is: %.2f%n", getLengte());
   }

   public void EditProfileGewicht() //Gewicht bewerken
   {
      System.out.print("\nNieuw gewicht: ");
      setGewicht(in.nextDouble());
      System.out.printf("Opgelagen gewicht is: %.2f%n", getGewicht());
   }

   public void EditProfileUsername() //Username bewerken
   {
      System.out.print("\nNieuwe gebruikersnaam: ");
      setUsername(string.nextLine());
      System.out.printf("Opgeslagen gebruikersnaam is: ", getUsername());
   }

   public void EditProfilePassword() //Password bewerken
   {
      System.out.print("\nNieuwe wachtwoord: ");
      setPassword(string.nextLine());
      System.out.printf("Opgeslagen wachtwoord is: ", getPassword());
   }


   public void PrintProfileAlles() //print profielgegevens
   {
      System.out.println("Voornaam: " + VoorNaam);
      System.out.println("Achternaam: " + AchterNaam);
      System.out.println("Leeftijd: " + leeftijd);
      System.out.printf("Lengte in: %.2f%n", lengte, " m");
      System.out.printf("Gewicht: %.2f%n", gewicht, " kg");
      System.out.printf("BMI: %.2f%n", bmi);

      boolean exit = false;
      while (!exit)
      {
         System.out.println("\nWilt de gebruikersnaam en wachtwoord ook zien?\nTyp ja of nee: ");
         String antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            System.out.println("\nGebruikersnaam: " + username);
            System.out.println("Wachtwoord: " + password);
            break;
         }
         else if (antwoord.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.print("\nProbeer opnieuw\n");
         }
      }
   }

   @Override
   public String toString()
   {

      return VoorNaam + " " + AchterNaam;
   }


   public Medicine ProfileMedicineIndex(int m)
   {
         return medicineList.get(m);
   }
}


