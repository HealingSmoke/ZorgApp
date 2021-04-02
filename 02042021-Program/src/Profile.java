import java.util.Locale;
import java.util.Scanner;

public class Profile
{
   //attributen
   private char verification;
   private String username;
   private String password;
   private String firstname;
   private String lastname;
   private int age;
   private double weight;
   private double length;
   private double bmi;

   Scanner in = new Scanner(System.in);
   Scanner string = new Scanner(System.in);
   private String input;
   private int number;
   private double decNumber;
   private boolean isValid;

   private final GewichtMeetPuntData gewichtMeetPuntData;
   private final MedicineList medicineList;

   //constructors
   public Profile(char verification, String username, String password, String firstname, String lastname)
   {
      this.verification = verification;
      this.username = username;
      this.password = password;
      this.firstname = firstname;
      this.lastname = lastname;
      medicineList = new MedicineList();
      gewichtMeetPuntData = new GewichtMeetPuntData();
   }

   public Profile(char verification, String username, String password, String firstname, String lastname, int age, double weight, double length, double bmi)
   {
      this.verification = verification;
      this.username = username;
      this.password = password;
      this.firstname = firstname;
      this.lastname = lastname;
      this.age = age;
      this.length = length;
      this.weight = weight;
      this.bmi = bmi;
      medicineList = new MedicineList();
      gewichtMeetPuntData = new GewichtMeetPuntData();
   }

   //getters & setters
   public char getVerification()
   {
      return verification;
   }

   public void setVerification(char verification)
   {
      this.verification = verification;
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

   public String getFirstname()
   {
      return firstname;
   }

   public void setFirstname(String firstname)
   {
      this.firstname = firstname;
   }

   public String getLastname()
   {
      return lastname;
   }

   public void setLastname(String lastname)
   {
      this.lastname = lastname;
   }

   public int getAge()
   {
      return age;
   }

   public void setAge(int age)
   {
      this.age = age;
   }

   public double getWeight()
   {
      return weight;
   }

   public void setWeight(double weight)
   {
      this.weight = weight;
   }

   public double getLength()
   {
      return length;
   }

   public void setLength(double length)
   {
      this.length = length;
   }

   public double getBmi() //bmi word gelijk opnieuw gecalculeerd
   {
      bmi = getWeight() / (getLength() * getLength());
      return bmi;
   }

   /*
   Ondergewicht onder de 18,5
   Goed gewicht 18 tot 24,9
   Overgewicht 25 tot 29,9
   Obesitas 30+
    */ //BMI categorie
   public void bmiCategory()
   {
      in.useLocale(Locale.GERMANY);

      System.out.printf("%n%s's bmi is %.2f. %nDat valt in de categorie: ", getFirstname(), getBmi());
      if (bmi > 30)
      {
         System.out.print("OBESITAS\n");
      }
      else if (bmi >= 25 && bmi <= 29.9)
      {
         System.out.print("OVERGEWICHT\n");
      }
      else if (bmi >= 18 && bmi <= 24.9)
      {
         System.out.print("GOED GEWICHT\n");
      }
      else if (bmi < 18)
      {
         System.out.print("ONDERGEWICHT\n");
      }
   }

   //methodes die te maken hebben met profielbewerking
   //Patient zelf profiel bewerken en nieuw patient toevoegen
   public void editProfileAll(Profile profile)
   {
      in.useLocale(Locale.GERMANY);

      do //Gebruikersnaam controle op minimaal 3 karakters
      {
         System.out.println("\nWat wordt uw gebruikersnaam: ");
         input = string.nextLine();
         if (input.length() > 2)
         {
            profile.setUsername(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 karakters invoeren.");
            isValid = false;
         }
      }  while (!isValid);

      do //Wachtwoord controle op minimaal 3 karakters
      {
         System.out.println("Wat wordt uw wachtwoord: ");
         input = string.nextLine();
         if (input.length() > 2)
         {
            profile.setPassword(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 karakters invoeren.\n");
            isValid = false;
         }
      }  while (!isValid);

      do //Voornaam controle op minimaal 3 karakters en geen cijfers
      {
         System.out.println("Wat is uw voornaam: ");
         input = string.nextLine();
         if (input.length() > 2 && input.matches("[a-zA-Z]+$"))
         {
            String output = input.substring(0, 1).toUpperCase() + input.substring(1); //Eerste letter word een hoofdletter
            profile.setFirstname(output);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 letters invoeren en geen getallen.\n");
            isValid = false;
         }

      }while (!isValid);

      do //Achternaam controle op minimaal 3 karakters en geen cijfers
      {
         System.out.println("Wat is uw achternaam: ");
         input = string.nextLine();
         if (input.length() > 2 && input.matches("[a-zA-Z]+$"))
         {
            String output = input.substring(0, 1).toUpperCase() + input.substring(1); //Eerste letter word een hoofdletter
            profile.setLastname(output);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 letters invoeren en geen getallen.\n");
            isValid = false;
         }

      }while (!isValid);

      do //Leeftijd controle op of het een Integer is en niet negatief
      {
         System.out.println("Wat is uw leeftijd: ");
         if (!in.hasNextInt())
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in onder de 110.\n");
            isValid = false;
            in.next();

         }
         else
         {
            number = in.nextInt();
            if (number > 0 && number < 110)
            {
               profile.setAge(number);
               isValid = true;
            }
            else
            {
               System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in onder de 110.\n");
               isValid = false;

            }
         }
      }  while (!isValid);

      do //Lengte controle op of het een double is en niet negatief
      {
         System.out.println("Wat is uw lengte: ");
         if (!in.hasNextDouble())
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in, of een komma als u een punt heeft gebruikt.\n");
            isValid = false;
            in.next();

         }
         else
         {
            decNumber = in.nextDouble();
            if (0.1 < decNumber && decNumber < 2.5)
            {
               profile.setLength(decNumber);
               isValid = true;
            }
            else
            {
               System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in, of een komma als u een punt heeft gebruikt.\n");
               isValid = false;

            }
         }
      }  while (!isValid);

      do //Gewicht controle op of het een Integer is en niet negatief
      {
         System.out.println("Wat is uw gewicht: ");
         if (!in.hasNextDouble())
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in, of een komma als u een punt heeft gebruikt.\n");
            isValid = false;
            in.next();

         }
         else
         {
            decNumber = in.nextDouble();
            if (0.1 < decNumber && decNumber < 300)
            {
               profile.setWeight(decNumber);
               in.next();
               isValid = true;
            }
            else
            {
               System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in, of een komma als u een punt heeft gebruikt.\n");
               isValid = false;

            }
         }
      }  while (!isValid);

      getBmi();
      System.out.println("\nUw gegevens zijn:");
      print();
   }

   //Zorgverlener patient bewerken of toevoegen
   public void addPatient(Profile patient)
   {
      in.useLocale(Locale.GERMANY);

      setVerification('p');
      do //Gebruikersnaam controle op minimaal 3 karakters
      {
         System.out.println("\nWat wordt de gebruikersnaam van uw patiënt: ");
         input = string.nextLine();
         if (input.length() > 2)
         {
            patient.setUsername(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 karakters invoeren.");
            isValid = false;
         }
      }  while (!isValid);

      do //Wachtwoord controle op minimaal 3 karakters
      {
         System.out.println("Wat wordt het wachtwoord van uw patiënt: ");
         input = string.nextLine();
         if (input.length() > 2)
         {
            patient.setPassword(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 karakters invoeren.\n");
            isValid = false;
         }
      }  while (!isValid);

      do //Voornaam controle op minimaal 3 karakters en geen cijfers
      {
         System.out.println("Wat is de voornaam van uw patiënt: ");
         input = string.nextLine();
         if (input.length() > 2 && input.matches("[a-zA-Z]+$"))
         {
            String output = input.substring(0, 1).toUpperCase() + input.substring(1); //Eerste letter word een hoofdletter
            patient.setFirstname(output);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 letters invoeren en geen getallen.\n");
            isValid = false;
         }

      }while (!(isValid));

      do //Achternaam controle op minimaal 3 karakters en geen cijfers
      {
         System.out.println("Wat is de achternaam van uw patiënt: ");
         input = string.nextLine();
         if (input.length() > 2 && input.matches("[a-zA-Z]+$"))
         {
            String output = input.substring(0, 1).toUpperCase() + input.substring(1); //Eerste letter word een hoofdletter
            patient.setLastname(output);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 letters invoeren en geen getallen.\n");
            isValid = false;
         }

      }while (!(isValid));

      do //Leeftijd controle op of het een Integer is en niet negatief
      {
         System.out.println("Wat is de leeftijd van uw patiënt: ");
         if (!in.hasNextInt())
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in onder de 110.\n");
            isValid = false;
            in.next();

         }
         else
         {
            number = in.nextInt();
            if (number > 0 && number < 110)
            {
               patient.setAge(number);
               isValid = true;
            }
            else
            {
               System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in onder de 110.\n");
               isValid = false;
            }
         }
      }  while (!isValid);

      do //Lengte controle op of het een double is en niet negatief
      {
         System.out.println("Wat is de lengte van uw patiënt: ");
         if (!in.hasNextDouble())
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in, of een komma als u een punt heeft gebruikt.\n");
            isValid = false;
            in.next();

         }
         else
         {
            decNumber = in.nextDouble();
            if (0.1 < decNumber && decNumber < 2.5)
            {
               patient.setLength(decNumber);
               isValid = true;
            }
            else
            {
               System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in, of een komma als u een punt heeft gebruikt.\n");
               isValid = false;
            }
         }
      }  while (!isValid);

      do //Gewicht controle op of het een Integer is en niet negatief
      {
         System.out.println("Wat is het gewicht van uw patiënt: ");
         if (!in.hasNextDouble())
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in, of een komma als u een punt heeft gebruikt.\n");
            isValid = false;
            in.next();
         }
         else
         {
            decNumber = in.nextDouble();
            if (decNumber > 0.1 && decNumber < 300)
            {
               patient.setWeight(decNumber);
               isValid = true;
            }
            else
            {
               System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in, of een komma als u een punt heeft gebruikt.");
               isValid = false;
               in.next();
            }
         }
      }  while (!isValid);
      in.next();
      getBmi();
      System.out.println("\nUw ingevoerde patiënt is:");
      print();
      }

   //Voornaam bewerken; Geen invoer van getallen en minimaal 3 characters
   public void editFirstname(Profile profile)
   {
      do //Voornaam controle op minimaal 3 karakters en geen cijfers
      {
         System.out.print("\nNieuwe voornaam: ");
         input = string.nextLine();
         if (input.length() > 2 && input.matches("[a-zA-Z]+$"))
         {
            String output = input.substring(0, 1).toUpperCase() + input.substring(1); //Eerste letter word een hoofdletter
            profile.setFirstname(output);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 letters invoeren en geen getallen.");
            isValid = false;
         }

      }while (!(isValid));
      System.out.print("Opgeslagen voornaam is: " + getFirstname() + "\n");
   }

   //Achternaam bewerken; Geen invoer van getallen en minimaal 3 characters
   public void editLastname(Profile profile)
   {
      do //Achternaam controle op minimaal 3 karakters en geen cijfers
      {
         System.out.print("\nNieuwe achternaam: ");
         input = string.nextLine();
         if (input.length() > 2 && input.matches("[a-zA-Z]+$"))
         {
            String output = input.substring(0, 1).toUpperCase() + input.substring(1); //Eerste letter word een hoofdletter
            profile.setLastname(output);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 letters invoeren en geen getallen.");
            isValid = false;
         }

      }while (!(isValid));
      System.out.print("Opgeslagen achternaam is: " + getLastname() + "\n");


   }

   //Leeftijd bewerken; geen invoer van letters of negatieve getallen
   public void editAge(Profile profile)
   {
      in.useLocale(Locale.GERMANY);

      do //Leeftijd controle op of het een Integer is en niet negatief
      {
         System.out.print("\nNieuwe leeftijd: ");
         if (!in.hasNextInt())
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in onder de 110.");
            isValid = false;
            in.next();
         }
         else
         {
            number = in.nextInt();
            if (number > 0 && number < 110)
            {
               profile.setAge(number);
               isValid = true;
            }
            else
            {
               System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in onder de 110.");
               isValid = false;

            }
         }
      }  while (!isValid);
      System.out.print("Opgeslagen leeftijd is: " + getAge() + "\n");

   }

   //Lengte bewerken; geen invoer van letters of negatieve getallen
   public void editLength(Profile profile)
   {
      in.useLocale(Locale.GERMANY);

      do //Lengte controle op of het een double is en niet negatief
      {
         System.out.print("\nNieuwe lengte: ");
         if (!in.hasNextDouble())
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in, of een komma als u een punt heeft gebruikt..");
            isValid = false;
            in.next();
         }
         else
         {
            decNumber = in.nextDouble();
            if (0.1 < decNumber && decNumber < 2.5)
            {
               profile.setLength(decNumber);
               isValid = true;
            }
            else
            {
               System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in.");
               isValid = false;
            }
         }
      }  while (!isValid);
      getBmi();
      System.out.printf("Uw lengte is: %.2f%n", getLength());
   }

   //Gewicht bewerken; geen invoer van letters of negatieve getallen
   public void editWeight(Profile profile)
   {
      in.useLocale(Locale.GERMANY);

      do //Gewicht controle op of het een Integer is en niet negatief
      {
         System.out.print("\nNieuw gewicht: ");
         if (!in.hasNextDouble())
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in, of een komma als u een punt heeft gebruikt..");
            in.next();
            isValid = false;
         }
         else
         {
            decNumber = in.nextDouble();
            if (decNumber > 0.1 && decNumber < 300)
            {
               profile.setWeight(decNumber);
               in.reset();
               isValid = true;
            }
            else
            {
               System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in.");
               isValid = false;
            }
         }
      }  while (!isValid);
      getBmi();
      System.out.printf("Opgelagen gewicht is: %.2f%n", getWeight());
   }

   //Login gegevens bewerken; minimaal 3 characters
   public void editLogin(Profile profile)
   {
      do //Gebruikersnaam controle op minimaal 3 karakters
      {
         System.out.println("\nNieuwe gebruikersnaam: ");
         input = string.nextLine();
         if (input.length() > 2)
         {
            profile.setUsername(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 karakters invoeren.");
            isValid = false;
         }
      }  while (!isValid);

      do //Wachtwoord controle op minimaal 3 karakters
      {
         System.out.println("Nieuw wachtwoord: ");
         input = string.nextLine();
         if (input.length() > 2)
         {
            setPassword(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 karakters invoeren.\n");
            isValid = false;
         }
      }  while (!isValid);

      System.out.printf("%nOpgeslagen gebruikersnaam is: %s", getUsername());
      System.out.printf("%nOpgeslagen wachtwoord is: %s%n", getPassword());
   }

   //print profielgegevens
   public void print()
   {
      System.out.println("\nGebruikersnaam: " + username);
      System.out.println("Wachtwoord: " + password);
      System.out.println("Voornaam: " + firstname);
      System.out.println("Achternaam: " + lastname);
      System.out.println("Leeftijd: " + age);
      System.out.printf("Lengte in: %.2f m%n", length);
      System.out.printf("Gewicht: %.2f kg%n", weight);
      bmiCategory();
   }



   //Methodes om dingen in de persoonlijke medicijnenlijst te bewerken
   //Medicijn toevoegen aan patiënt
   public void addMedicine(Profile patient, Medicine chosenMedicine)
   {
      Medicine newMedicine = new Medicine(chosenMedicine.getMedicineName(), chosenMedicine.getSoort(), chosenMedicine.getOmschrijving(), chosenMedicine.getDosering(), chosenMedicine.getMemo());

      while (!isValid) //Of je de dosering wilt aanpassen
      {
         System.out.printf("%nWilt u de dosering aanpassen van %s.%nTyp ja of nee: ", newMedicine.getMedicineName());
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("ja"))
         {
            newMedicine.editDosage();
            break;
         }
         else if (input.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.print("\nProbeer opnieuw\n");
         }
      }

      while (!isValid) //Of je een memo wilt toevoegen
      {
         System.out.printf("%nWilt u een memo toevoegen aan %s%nTyp ja of nee: ", newMedicine.getMedicineName());
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("ja"))
         {
            newMedicine.addMemo();
            break;
         }
         else if (input.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.print("\nProbeer opnieuw\n");
         }
      }

      while (!isValid) //Vragem of je dit medicijn definitief wilt toevoegen
      {
         System.out.println("\nU wilt dit medicijn toevoegen: ");
         newMedicine.print(newMedicine);
         System.out.printf("%nWeet u zeker dat u dit medicijn wilt toevoegen?%nTyp ja of nee: ");
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("ja"))
         {
            medicineList.add(newMedicine);
            break;
         }
         else if (input.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.print("\nProbeer opnieuw\n");
         }
      }

      while (!isValid) //Of je de medicijnenlijst van patiënt wilt zien
      {
         System.out.printf("%nWilt u de nieuwe medicijnenlijst zien van %s %s?%nTyp ja of nee: ", getFirstname(), getLastname());
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("ja"))
         {
            printMedicine(patient);
            break;
         }
         else if (input.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.print("\nProbeer opnieuw\n");
         }
      }



   }

   //Medicijn kiezen van patiënt
   public Medicine chooseMedicine(Profile patient)
   {
      Medicine chosenMedicine = null;
      printMedicine(patient);
      System.out.println("\nWelk medicijn wilt u kiezen?\nGeef het getal van uw keuze: ");
      do
      {
         if (!in.hasNextInt())
         {
            printMedicine(patient);
            System.out.print("\nVerkeerde invoer, probeer opnieuw\n");
            System.out.println("\nWelk medicijn wilt u kiezen?\nGeef het getal van uw keuze: ");
            in.reset();
         }
         else
         {
            number = in.nextInt();
            if (((number - 1) >= 0) && ((number - 1) <= medicineList.size()))
            {
               chosenMedicine = medicineList.get(number - 1);
            }
            else
            {
               printMedicine(patient);
               System.out.print("\nVerkeerde invoer, probeer opnieuw\n");
               System.out.println("\nWelk medicijn wilt u kiezen?\nGeef het getal van uw keuze: ");
               in.reset();
            }
         }
      }  while (chosenMedicine == null);

      return chosenMedicine;
   }

   //Medicijn verwijderen bij patiënt
   public void removeMedicine(Profile patient)
   {
      while (!(medicineList.size() == 0)) //Vragem of je dit medicijn echt wilt verwijderen
      {
         Medicine chosenMedicine = chooseMedicine(patient);
         System.out.println("\nU heeft dit medicijn gekozen: ");
         chosenMedicine.print(chosenMedicine);
         System.out.printf("%nWeet u zeker dat u dit medicijn wilt verwijderen van de lijst van: %s %s%nTyp ja of nee: ", patient.getFirstname(), patient.getLastname());
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("ja"))
         {
            medicineList.remove(chosenMedicine);
            break;
         }
         else if (input.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.print("\nProbeer opnieuw\n");
         }
      }

      while (!(medicineList.size() == 0)) //Of je de nieuwe medicijnenlijst wilt zien
      {
         System.out.printf("%nWilt u de nieuwe medicijnenlijst zien?%nTyp ja of nee: ");
         input = in.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("ja"))
         {
            printMedicine(patient);
            break;
         }
         else if (input.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.print("\nProbeer opnieuw\n");
         }
      }

   }

   //Medicijn naam bewerken bij patiënt
   public void editMedicineName(Profile patient)
   {
      if (medicineList.size() == 0)
      {
         System.out.println("\nSorry nog geen medicijnen beschikbaar.");
      }
      else
      {
         Medicine chosenMedicine = chooseMedicine(patient);
         chosenMedicine.editName();
      }
   }

   //Medicijn dosering bewerken bij patiënt
   public void editMedicineDosage(Profile patient)
   {

      if (medicineList.size() == 0)
      {
         System.out.println("\nSorry nog geen medicijnen beschikbaar.");
      }
      else
      {
         Medicine chosenMedicine = chooseMedicine(patient);
         chosenMedicine.editDosage();
      }
   }

   //Medicijn memo bewerken bij patiënt
   public void editMedicineMemo(Profile patient)
   {

      if (medicineList.size() == 0)
      {
         System.out.println("\nSorry nog geen medicijnen beschikbaar.");
      }
      else
      {
         Medicine chosenMedicine = chooseMedicine(patient);
         chosenMedicine.addMemo();
      }
   }



   //Methodes omtrend gewicht meet punt
   //Zorgverlenermenu; patiënt gewicht meet punt toevoegen
   public void addMeetpunt(Profile patient)
   {
      GewichtMeetPunt newGewichtMeetpunt = new GewichtMeetPunt(0, 0, 0, "", 0);
      newGewichtMeetpunt.editDate();
      newGewichtMeetpunt.editTime();
      newGewichtMeetpunt.editWeight();

      while (!isValid) //Vragem of je dit meetpunt definitief wilt toevoegen
      {
         System.out.printf("%nU wilt dit gewicht meetpunt toevoegen:%n%s%n%nWeet u zeker dat u dit gewicht meetpunt wilt toevoegen?%nTyp ja of nee: ", newGewichtMeetpunt);
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("ja"))
         {
            gewichtMeetPuntData.add(newGewichtMeetpunt);
            break;
         }
         else if (input.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.print("\nProbeer opnieuw\n");

         }
      }

      while (!isValid) //Of je de meet punten van patiënt wilt zien
      {
         System.out.printf("%nWilt u alle gewicht meetpunten zien van %s %s?%nTyp ja of nee: ", patient.getFirstname(), patient.getLastname());
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("ja"))
         {
            printMeetpunt();
            break;
         }
         else if (input.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.print("\nProbeer opnieuw\n");
         }
      }
      while (!isValid) //Of no een meet punt wilt toevoegen
      {
         System.out.printf("%nWilt nog een meetpunt toevoegen aan de lijst van: %s %s?%nTyp ja of nee: ", patient.getFirstname(), patient.getLastname());
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("ja"))
         {
            addMeetpunt(patient);
            break;
         }
         else if (input.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.print("\nProbeer opnieuw\n");
         }
      }
   }
   //Zorgverlenermenu; patiënt gewicht meet punt kiezen
   public GewichtMeetPunt chooseMeetpunt(Profile patient)
   {
      GewichtMeetPunt chosenMeetpunt = null;
      printMeetpunt();
      while(!(gewichtMeetPuntData.size() == 0))
      {
         System.out.println("\nWelk meetpunt wilt u kiezen?\nGeef het getal van uw keuze: ");
         if (!in.hasNextInt())
         {
            printMeetpunt();
            System.out.print("\nVerkeerde invoer, probeer opnieuw\n");
            System.out.println("\nWelk meetpunt wilt u kiezen?\nGeef het getal van uw keuze: ");
            in.next();
         }
         else
         {
            number = in.nextInt();
            if (number >= 0 && number <= gewichtMeetPuntData.size())
            {
               chosenMeetpunt = patient.gewichtMeetPuntData.get(number - 1);
               break;
            }
            else
            {
               printMeetpunt();
               System.out.print("\nVerkeerde invoer, probeer opnieuw\n");
               System.out.println("\nWelk meetpunt wilt u kiezen?\nGeef het getal van uw keuze: ");
               in.next();
            }
         }
      }

      return chosenMeetpunt;
   }

   //Zorgverlenermenu; patiënt gewicht meet punt verwijderen
   public void removeMeetpunt(Profile patient)
   {
      GewichtMeetPunt chosenMeetpunt = chooseMeetpunt(patient);
      while (!(gewichtMeetPuntData.size() == 0)) //Vragem of je dit meetpunt definitief wilt verwijderen
      {
         System.out.printf("%n%s%n%nWeet u zeker dat u dit gewicht meetpunt wilt verwijderen?%nTyp ja of nee: ", chosenMeetpunt);
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("ja"))
         {
            gewichtMeetPuntData.remove(chosenMeetpunt);
            break;
         }
         else if (input.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.print("\nProbeer opnieuw\n");
         }
      }

      while (!(gewichtMeetPuntData.size() == 0)) //Of je de meet punten van patiënt wilt zien
      {
         System.out.printf("%nWilt u alle gewicht meetpunten zien van %s %s?%nTyp ja of nee: ", patient.getFirstname(), patient.getLastname());
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("ja"))
         {
           printMeetpunt();
            break;
         }
         else if (input.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.print("\nProbeer opnieuw\n");
         }
      }

      while (!(gewichtMeetPuntData.size() == 0)) //Of je nog een gewicht meetpunt wilt verwijderen
      {
         System.out.printf("%nWilt u nog een gewicht meetpunt verwijderen?%nTyp ja of nee: ");
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("ja"))
         {
            removeMeetpunt(patient);
            break;
         }
         else if (input.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.print("\nProbeer opnieuw\n");
         }
      }
   }

   //Zorgverlenermenu; patiënt gewicht meet punt bewerken; datum, tijd of gewicht
   public void editMeetpunt(Profile patient)
   {
      while (!(gewichtMeetPuntData.size() == 0)) //Vragen wat je wilt bewerken
      {
         GewichtMeetPunt chosenMeetpunt = chooseMeetpunt(patient);
         System.out.printf("%nWat wilt u bewerken?%nTyp 'datum', 'tijd', 'gewicht' of 'alles': ");
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("datum"))
         {
            chosenMeetpunt.editDate();
            break;
         }
         else if (input.equalsIgnoreCase("tijd"))
         {
            chosenMeetpunt.editTime();
            break;
         }
         else if (input.equalsIgnoreCase("gewicht"))
         {
            chosenMeetpunt.editWeight();
            break;
         }
         else if (input.equalsIgnoreCase("alles"))
         {
            chosenMeetpunt.editDate();
            chosenMeetpunt.editTime();
            chosenMeetpunt.editWeight();
            break;
         }
         else
         {
            System.out.print("\nProbeer opnieuw\n");
         }
      }
   }

   public void printMeetpunt()
   {
      if (gewichtMeetPuntData.size() == 0)
      {
         System.out.println("\nSorry u heeft nog geen gewicht meet punten.");
      }
      else
      {
         gewichtMeetPuntData.sort();
         System.out.println("\nUw gewicht meet punten:\n");
         System.out.println("Index     " + "Tijd      " + "Gewicht   " + "Datum      ");
         for (int m = 0; m < gewichtMeetPuntData.size(); m++)
         {
            System.out.printf("%d.    %s%n", m+1, gewichtMeetPuntData.get(m));
         }
      }
   }

   public void printMedicine(Profile profile) //Print medicijnen van patiënt
   {
      if (medicineList.size() == 0)
      {
         System.out.println("\nSorry nog geen medicijnen beschikbaar.");
      }
      else
      {
         System.out.printf("%nDit is de medicijnenlijst van: %s %s.%n%n", profile.getFirstname(), profile.getLastname());
         for (int m = 0; m < medicineList.size(); m++)
         {
            if (m > 9)
            {
               System.out.printf("%d.%s%n   ", m + 1, medicineList.get(m));
            }
            else
            {
               System.out.printf(" %d.%s%n  ", m + 1, medicineList.get(m));
            }
         }
      }
   }




   //Hieronder alles in het engels

   /*
   Ondergewicht onder de 18,5
   Goed gewicht 18 tot 24,9
   Overgewicht 25 tot 29,9
   Obesitas 30+
    */ //BMI categorie
   public void bmiCategoryEn()
   {
      in.useLocale(Locale.US);

      System.out.printf("%n%s's bmi is %.2f. %nCategory: ", getFirstname(), getBmi());
      if (bmi > 30)
      {
         System.out.print("OBESITAS\n");
      }
      else if (bmi >= 25 && bmi <= 29.9)
      {
         System.out.print("OVERWEIGHT\n");
      }
      else if (bmi >= 18 && bmi <= 24.9)
      {
         System.out.print("NORMAL\n");
      }
      else if (bmi < 18)
      {
         System.out.print("UNDERWEIGHT\n");
      }
   }

   //methodes die te maken hebben met profielbewerking
   //Patient zelf profiel bewerken en nieuw patient toevoegen
   public void editProfileAllEn(Profile profile)
   {
      in.useLocale(Locale.US);

      do //Gebruikersnaam controle op minimaal 3 karakters
      {
         System.out.println("\nWhat will be your username: ");
         input = string.nextLine();
         if (input.length() > 2)
         {
            profile.setUsername(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters.");
            isValid = false;
         }
      }  while (!isValid);

      do //Wachtwoord controle op minimaal 3 karakters
      {
         System.out.println("What will be your password: ");
         input = string.nextLine();
         if (input.length() > 2)
         {
            profile.setPassword(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters.");
            isValid = false;
         }
      }  while (!isValid);

      do //Voornaam controle op minimaal 3 karakters en geen cijfers
      {
         System.out.println("What will be your firstname: ");
         input = string.nextLine();
         if (input.length() > 2 && input.matches("[a-zA-Z]+$"))
         {
            String output = input.substring(0, 1).toUpperCase() + input.substring(1); //Eerste letter word een hoofdletter
            profile.setFirstname(output);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters and no numbers.");
            isValid = false;
         }

      }while (!isValid);

      do //Achternaam controle op minimaal 3 karakters en geen cijfers
      {
         System.out.println("What will be your lastname: ");
         input = string.nextLine();
         if (input.length() > 2 && input.matches("[a-zA-Z]+$"))
         {
            String output = input.substring(0, 1).toUpperCase() + input.substring(1); //Eerste letter word een hoofdletter
            profile.setLastname(output);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters and no numbers.");
            isValid = false;
         }

      }while (!isValid);

      do //Leeftijd controle op of het een Integer is en niet negatief
      {
         System.out.println("What will be your age: ");
         if (!in.hasNextInt())
         {
            System.out.println("\nWrong input, please try again.\nPlease enter a positive number under 110.");
            isValid = false;
            in.next();
         }
         else
         {
            number = in.nextInt();
            if (number > 0 && number < 110)
            {
               profile.setAge(number);
               isValid = true;
            }
            else
            {
               System.out.println("\nWrong input, please try again.\nPlease enter a positive number under 110.");
               isValid = false;
            }
         }
      }  while (!isValid);

      do //Lengte controle op of het een double is en niet negatief
      {
         System.out.println("What is your height: ");
         if (!in.hasNextDouble())
         {
            System.out.println("\nWrong input, please try again.\nPlease enter a positive number, or use a dot instead of comma.");
            isValid = false;
            in.next();
         }
         else
         {
            decNumber = in.nextDouble();
            if (0.1 < decNumber && decNumber < 2.5)
            {
               profile.setLength(decNumber);
               isValid = true;
            }
            else
            {
               System.out.println("\nWrong input, please try again.\nPlease enter a positive number, or use a dot instead of comma.");
               isValid = false;
            }
         }
      }  while (!isValid);

      do //Gewicht controle op of het een Integer is en niet negatief
      {
         System.out.println("What is your weight: ");
         if (!in.hasNextDouble())
         {
            System.out.println("\nWrong input, please try again.\nPlease enter a positive number, or use a dot instead of comma.");
            isValid = false;
            in.next();
         }
         else
         {
            decNumber = in.nextDouble();
            if (0.1 < decNumber && decNumber < 300)
            {
               profile.setWeight(decNumber);
               in.next();
               isValid = true;
            }
            else
            {
               System.out.println("\nWrong input, please try again.\nPlease enter a positive number, or use a dot instead of comma.");
               isValid = false;
            }
         }
      }  while (!isValid);

      getBmi();
      System.out.println("\nYour details are saved as:");
      print();
   }

   //Zorgverlener patient bewerken of toevoegen
   public void addPatientEn(Profile patient)
   {
      in.useLocale(Locale.US);

      setVerification('p');
      do //Gebruikersnaam controle op minimaal 3 karakters
      {
         System.out.println("\nWhat will be the username for your patient: ");
         input = string.nextLine();
         if (input.length() > 2)
         {
            patient.setUsername(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters.");
            isValid = false;
         }
      }  while (!isValid);

      do //Wachtwoord controle op minimaal 3 karakters
      {
         System.out.println("What will be the password for your patient: ");
         input = string.nextLine();
         if (input.length() > 2)
         {
            patient.setPassword(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters.");
            isValid = false;
         }
      }  while (!isValid);

      do //Voornaam controle op minimaal 3 karakters en geen cijfers
      {
         System.out.println("What is the firstname of your patient: ");
         input = string.nextLine();
         if (input.length() > 2 && input.matches("[a-zA-Z]+$"))
         {
            String output = input.substring(0, 1).toUpperCase() + input.substring(1); //Eerste letter word een hoofdletter
            patient.setFirstname(output);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters and no numbers.");
            isValid = false;
         }

      }while (!(isValid));

      do //Achternaam controle op minimaal 3 karakters en geen cijfers
      {
         System.out.println("What is the lastname of your patient: ");
         input = string.nextLine();
         if (input.length() > 2 && input.matches("[a-zA-Z]+$"))
         {
            String output = input.substring(0, 1).toUpperCase() + input.substring(1); //Eerste letter word een hoofdletter
            patient.setLastname(output);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters and no numbers.");
            isValid = false;
         }

      }while (!(isValid));

      do //Leeftijd controle op of het een Integer is en niet negatief
      {
         System.out.println("What is the age of your patient: ");
         if (!in.hasNextInt())
         {
            System.out.println("\nWrong input, please try again.\nPlease enter a positive number under 110.");
            isValid = false;
            in.next();
         }
         else
         {
            number = in.nextInt();
            if (number > 0 && number < 110)
            {
               patient.setAge(number);
               isValid = true;
            }
            else
            {
               System.out.println("\nWrong input, please try again.\nPlease enter a positive number under 110.");
               isValid = false;
            }
         }
      }  while (!isValid);

      do //Lengte controle op of het een double is en niet negatief
      {
         System.out.println("What is the height of your patient: ");
         if (!in.hasNextDouble())
         {
            System.out.println("\nWrong input, please try again.\nPlease enter a positive number, or use a dot instead of comma.");
            isValid = false;
            in.next();
         }
         else
         {
            decNumber = in.nextDouble();
            if (0.1 < decNumber && decNumber < 2.5)
            {
               patient.setLength(decNumber);
               isValid = true;
            }
            else
            {
               System.out.println("\nWrong input, please try again.\nPlease enter a positive number, or use a dot instead of comma.");
               isValid = false;
            }
         }
      }  while (!isValid);

      do //Gewicht controle op of het een Integer is en niet negatief
      {
         System.out.println("What is the weight of your patient: ");
         if (!in.hasNextDouble())
         {
            System.out.println("\nWrong input, please try again.\nPlease enter a positive number, or use a dot instead of comma.");
            isValid = false;
            in.next();
         }
         else
         {
            decNumber = in.nextDouble();
            if (decNumber > 0.1 && decNumber < 300)
            {
               patient.setWeight(decNumber);
               isValid = true;
            }
            else
            {
               System.out.println("\nWrong input, please try again.\nPlease enter a positive number, or use a dot instead of comma.");
               isValid = false;
            }
         }
      }  while (!isValid);
      in.next();
      getBmi();
      System.out.println("\nYour patient is saved as:");
      print();
   }

   //Voornaam bewerken; Geen invoer van getallen en minimaal 3 characters
   public void editFirstnameEn(Profile profile)
   {
      do //Voornaam controle op minimaal 3 karakters en geen cijfers
      {
         System.out.print("\nNew firstname: ");
         input = string.nextLine();
         if (input.length() > 2 && input.matches("[a-zA-Z]+$"))
         {
            String output = input.substring(0, 1).toUpperCase() + input.substring(1); //Eerste letter word een hoofdletter
            profile.setFirstname(output);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters and no numbers.");
            isValid = false;
         }

      }while (!(isValid));
      System.out.print("Firstname saved as: " + getFirstname() + "\n");
   }

   //Achternaam bewerken; Geen invoer van getallen en minimaal 3 characters
   public void editLastnameEn(Profile profile)
   {
      do //Achternaam controle op minimaal 3 karakters en geen cijfers
      {
         System.out.print("\nNew lastname: ");
         input = string.nextLine();
         if (input.length() > 2 && input.matches("[a-zA-Z]+$"))
         {
            String output = input.substring(0, 1).toUpperCase() + input.substring(1); //Eerste letter word een hoofdletter
            profile.setLastname(output);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters and no numbers.");
            isValid = false;
         }

      }while (!(isValid));
      System.out.print("Lastname saved as: " + getLastname() + "\n");


   }

   //Leeftijd bewerken; geen invoer van letters of negatieve getallen
   public void editAgeEn(Profile profile)
   {
      in.useLocale(Locale.US);

      do //Leeftijd controle op of het een Integer is en niet negatief
      {
         System.out.print("\nNew age: ");
         if (!in.hasNextInt())
         {
            System.out.println("\nWrong input, please try again.\nPlease enter a positive number under 110.");
            isValid = false;
            in.next();
         }
         else
         {
            number = in.nextInt();
            if (number > 0 && number < 110)
            {
               profile.setAge(number);
               isValid = true;
            }
            else
            {
               System.out.println("\nWrong input, please try again.\nPlease enter a positive number under 110.");
               isValid = false;

            }
         }
      }  while (!isValid);
      System.out.print("Age saved as: " + getAge() + "\n");

   }

   //Lengte bewerken; geen invoer van letters of negatieve getallen
   public void editLengthEn(Profile profile)
   {
      in.useLocale(Locale.US);

      do //Lengte controle op of het een double is en niet negatief
      {
         System.out.print("\nNew height: ");
         if (!in.hasNextDouble())
         {
            System.out.println("\nWrong input, please try again.\nPlease enter a positive number, or use a dot instead of comma.");
            isValid = false;
            in.next();
         }
         else
         {
            decNumber = in.nextDouble();
            if (0.1 < decNumber && decNumber < 2.5)
            {
               profile.setLength(decNumber);
               isValid = true;
            }
            else
            {
               System.out.println("\nWrong input, please try again.\nPlease enter a positive number, or use a dot instead of comma.");
               isValid = false;
            }
         }
      }  while (!isValid);
      getBmi();
      System.out.printf("Height saved in meter as: %.2f%n", getLength());
   }

   //Gewicht bewerken; geen invoer van letters of negatieve getallen
   public void editWeightEn(Profile profile)
   {
      in.useLocale(Locale.US);

      do //Gewicht controle op of het een Integer is en niet negatief
      {
         System.out.print("\nNew weight: ");
         if (!in.hasNextDouble())
         {
            System.out.println("\nWrong input, please try again.\nPlease enter a positive number, or use a dot instead of comma.");
            in.next();
            isValid = false;
         }
         else
         {
            decNumber = in.nextDouble();
            if (decNumber > 0.1 && decNumber < 300)
            {
               profile.setWeight(decNumber);
               in.reset();
               isValid = true;
            }
            else
            {
               System.out.println("\nWrong input, please try again.\nPlease enter a positive number, or use a dot instead of comma.");
               isValid = false;
            }
         }
      }  while (!isValid);
      getBmi();
      System.out.printf("Weight saved in kilogram as: %.2f%n", getWeight());
   }

   //Login gegevens bewerken; minimaal 3 characters
   public void editLoginEn(Profile profile)
   {
      do //Gebruikersnaam controle op minimaal 3 karakters
      {
         System.out.println("\nNew username: ");
         input = string.nextLine();
         if (input.length() > 2)
         {
            profile.setUsername(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters.");
            isValid = false;
         }
      }  while (!isValid);

      do //Wachtwoord controle op minimaal 3 karakters
      {
         System.out.println("New password: ");
         input = string.nextLine();
         if (input.length() > 2)
         {
            setPassword(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters.");
            isValid = false;
         }
      }  while (!isValid);

      System.out.printf("%nUsername saved as: %s", getUsername());
      System.out.printf("%nPassword saved as: %s%n", getPassword());
   }

   //print profielgegevens
   public void printEn()
   {
      System.out.println("\nUsername: " + username);
      System.out.println("Password: " + password);
      System.out.println("Firstname: " + firstname);
      System.out.println("Lastname: " + lastname);
      System.out.println("Age: " + age);
      System.out.printf("Height in: %.2f m%n", length);
      System.out.printf("Weight: %.2f kg%n", weight);
      bmiCategoryEn();
   }



   //Methodes om dingen in de persoonlijke medicijnenlijst te bewerken
   //Medicijn toevoegen aan patiënt
   public void addMedicineEn(Profile patient, Medicine chosenMedicine)
   {
      Medicine newMedicine = new Medicine(chosenMedicine.getMedicineName(), chosenMedicine.getSoort(), chosenMedicine.getOmschrijving(), chosenMedicine.getDosering(), chosenMedicine.getMemo());

      while (!isValid) //Of je de dosering wilt aanpassen
      {
         System.out.printf("%nDo you want to edit the dosage of: %s.%nType yes or no: ", newMedicine.getMedicineName());
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("yes"))
         {
            newMedicine.editDosage();
            break;
         }
         else if (input.equalsIgnoreCase("no"))
         {
            break;
         }
         else
         {
            System.out.print("\nPlease try again\n");
         }
      }

      while (!isValid) //Of je een memo wilt toevoegen
      {
         System.out.printf("%nDo you want to add a memo to: %s%nType yes or no: ", newMedicine.getMedicineName());
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("yes"))
         {
            newMedicine.addMemo();
            break;
         }
         else if (input.equalsIgnoreCase("no"))
         {
            break;
         }
         else
         {
            System.out.print("\nPlease try again\n");
         }
      }

      while (!isValid) //Vragem of je dit medicijn definitief wilt toevoegen
      {
         System.out.println("\nCurrently set as: ");
         newMedicine.print(newMedicine);
         System.out.printf("%nAre you sure you want to add this medicine?%nType yes or no: ");
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("yes"))
         {
            medicineList.add(newMedicine);
            break;
         }
         else if (input.equalsIgnoreCase("no"))
         {
            break;
         }
         else
         {
            System.out.print("\nPlease try again\n");
         }
      }

      while (!isValid) //Of je de medicijnenlijst van patiënt wilt zien
      {
         System.out.printf("%nDo you want to see the new medicine list of %s %s?%nType yes or no: ", getFirstname(), getLastname());
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("yes"))
         {
            printMedicine(patient);
            break;
         }
         else if (input.equalsIgnoreCase("no"))
         {
            break;
         }
         else
         {
            System.out.print("\nPlease try again\n");
         }
      }



   }

   //Medicijn kiezen van patiënt
   public Medicine chooseMedicineEn(Profile patient)
   {
      Medicine chosenMedicine = null;
      printMedicine(patient);
      System.out.println("\nWhat medicine do you want to choose?\nPlease enter a number: ");
      do
      {
         if (!in.hasNextInt())
         {
            printMedicine(patient);
            System.out.print("\nWrong input, please try again.\n");
            System.out.println("\nWhat medicine do you want to choose?\nPlease enter a number: ");
            in.reset();
         }
         else
         {
            number = in.nextInt();
            if (((number - 1) >= 0) && ((number - 1) <= medicineList.size()))
            {
               chosenMedicine = medicineList.get(number - 1);
            }
            else
            {
               printMedicine(patient);
               System.out.print("\nWrong input, please try again.\n");
               System.out.println("\nWhat medicine do you want to choose?\nPlease enter a number: ");
               in.reset();
            }
         }
      }  while (chosenMedicine == null);

      return chosenMedicine;
   }

   //Medicijn verwijderen bij patiënt
   public void removeMedicineEn(Profile patient)
   {
      while (!(medicineList.size() == 0)) //Vragem of je dit medicijn echt wilt verwijderen
      {
         Medicine chosenMedicine = chooseMedicineEn(patient);
         System.out.println("\nYou have chosen this medicine: ");
         chosenMedicine.print(chosenMedicine);
         System.out.printf("%nAre you sure you want to remove this from the list of: %s %s%nType yes or no: ", patient.getFirstname(), patient.getLastname());
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("yes"))
         {
            medicineList.remove(chosenMedicine);
            break;
         }
         else if (input.equalsIgnoreCase("no"))
         {
            break;
         }
         else
         {
            System.out.print("\nPlease try again\n");
         }
      }

      while (!(medicineList.size() == 0)) //Of je de nieuwe medicijnenlijst wilt zien
      {
         System.out.printf("%nDo you want to see the new medicine list?%nType yes or no: ");
         input = in.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("yes"))
         {
            printMedicine(patient);
            break;
         }
         else if (input.equalsIgnoreCase("no"))
         {
            break;
         }
         else
         {
            System.out.print("\nPlease try again\n");
         }
      }

   }

   //Medicijn naam bewerken bij patiënt
   public void editMedicineNameEn(Profile patient)
   {
      if (medicineList.size() == 0)
      {
         System.out.println("\nSorry no medicine available.");
      }
      else
      {
         Medicine chosenMedicine = chooseMedicineEn(patient);
         chosenMedicine.editName();
      }
   }

   //Medicijn dosering bewerken bij patiënt
   public void editMedicineDosageEn(Profile patient)
   {

      if (medicineList.size() == 0)
      {
         System.out.println("\nSorry no medicine available.");
      }
      else
      {
         Medicine chosenMedicine = chooseMedicineEn(patient);
         chosenMedicine.editDosage();
      }
   }

   //Medicijn memo bewerken bij patiënt
   public void editMedicineMemoEn(Profile patient)
   {

      if (medicineList.size() == 0)
      {
         System.out.println("\nSorry no medicine available.");
      }
      else
      {
         Medicine chosenMedicine = chooseMedicineEn(patient);
         chosenMedicine.addMemo();
      }
   }



   //Methodes omtrend gewicht meet punt
   //Zorgverlenermenu; patiënt gewicht meet punt toevoegen
   public void addMeetpuntEn(Profile patient)
   {
      GewichtMeetPunt newGewichtMeetpunt = new GewichtMeetPunt(0, 0, 0, "", 0);
      newGewichtMeetpunt.editDate();
      newGewichtMeetpunt.editTime();
      newGewichtMeetpunt.editWeight();

      while (!isValid) //Vragem of je dit meetpunt definitief wilt toevoegen
      {
         System.out.printf("%nYou want to add this measurement:%n%s%n%nAre you sure you want to add this?%nType yes or no: ", newGewichtMeetpunt);
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("yes"))
         {
            gewichtMeetPuntData.add(newGewichtMeetpunt);
            break;
         }
         else if (input.equalsIgnoreCase("no"))
         {
            break;
         }
         else
         {
            System.out.print("\nPlease try again\n");

         }
      }

      while (!isValid) //Of je de meet punten van patiënt wilt zien
      {
         System.out.printf("%nDo you want to see all measurements of: %s %s?%nType yes or no: ", patient.getFirstname(), patient.getLastname());
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("yes"))
         {
            printMeetpunt();
            break;
         }
         else if (input.equalsIgnoreCase("no"))
         {
            break;
         }
         else
         {
            System.out.print("\nPlease try again\n");
         }
      }
      while (!isValid) //Of no een meet punt wilt toevoegen
      {
         System.out.printf("%nDo you want to add another measurement to the list of: %s %s?%nType yes or no: ", patient.getFirstname(), patient.getLastname());
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("yes"))
         {
            addMeetpunt(patient);
            break;
         }
         else if (input.equalsIgnoreCase("no"))
         {
            break;
         }
         else
         {
            System.out.print("\nPlease try again\n");
         }
      }
   }
   //Zorgverlenermenu; patiënt gewicht meet punt kiezen
   public GewichtMeetPunt chooseMeetpuntEn(Profile patient)
   {
      GewichtMeetPunt chosenMeetpunt = null;
      printMeetpuntEn();
      while(!(gewichtMeetPuntData.size() == 0))
      {
         System.out.println("\nWhich measurement do you want to choose?\nPlease enter a number: ");
         if (!in.hasNextInt())
         {
            printMeetpuntEn();
            System.out.print("\nWrong input, please try again.\n");
            System.out.println("\nWhich measurement do you want to choose?\nPlease enter a number: ");
            in.next();
         }
         else
         {
            number = in.nextInt();
            if (number >= 0 && number <= gewichtMeetPuntData.size())
            {
               chosenMeetpunt = patient.gewichtMeetPuntData.get(number - 1);
               break;
            }
            else
            {
               printMeetpuntEn();
               System.out.print("\nWrong input, please try again.\n");
               System.out.println("\nWhich measurement do you want to choose?\nPlease enter a number: ");
               in.next();
            }
         }
      }

      return chosenMeetpunt;
   }

   //Zorgverlenermenu; patiënt gewicht meet punt verwijderen
   public void removeMeetpuntEn(Profile patient)
   {
      GewichtMeetPunt chosenMeetpunt = chooseMeetpuntEn(patient);
      while (!(gewichtMeetPuntData.size() == 0)) //Vragem of je dit meetpunt definitief wilt verwijderen
      {
         System.out.printf("%n%s%n%nAre you sure you want to remove this measurement?%nType yes or no: ", chosenMeetpunt);
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("yes"))
         {
            gewichtMeetPuntData.remove(chosenMeetpunt);
            break;
         }
         else if (input.equalsIgnoreCase("no"))
         {
            break;
         }
         else
         {
            System.out.print("\nPlease try again\n");
         }
      }

      while (!(gewichtMeetPuntData.size() == 0)) //Of je de meet punten van patiënt wilt zien
      {
         System.out.printf("%nDo you want to see all measurements of: %s %s?%nType yes or no: ", patient.getFirstname(), patient.getLastname());
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("yes"))
         {
            printMeetpunt();
            break;
         }
         else if (input.equalsIgnoreCase("no"))
         {
            break;
         }
         else
         {
            System.out.print("\nPlease try again\n");
         }
      }

      while (!(gewichtMeetPuntData.size() == 0)) //Of je nog een gewicht meetpunt wilt verwijderen
      {
         System.out.printf("%nDo you want to remove another measurement?%nType yes or no: ");
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("yes"))
         {
            removeMeetpunt(patient);
            break;
         }
         else if (input.equalsIgnoreCase("no"))
         {
            break;
         }
         else
         {
            System.out.print("\nPlease try again\n");
         }
      }
   }

   //Zorgverlenermenu; patiënt gewicht meet punt bewerken; datum, tijd of gewicht
   public void editMeetpuntEn(Profile patient)
   {
      while (!(gewichtMeetPuntData.size() == 0)) //Vragen wat je wilt bewerken
      {
         GewichtMeetPunt chosenMeetpunt = chooseMeetpuntEn(patient);
         System.out.printf("%nWhat od you want to edit?%nType 'date', 'time', 'weight' or 'all': ");
         input = string.nextLine().toLowerCase();

         if (input.equalsIgnoreCase("date"))
         {
            chosenMeetpunt.editDate();
            break;
         }
         else if (input.equalsIgnoreCase("time"))
         {
            chosenMeetpunt.editTime();
            break;
         }
         else if (input.equalsIgnoreCase("weight"))
         {
            chosenMeetpunt.editWeight();
            break;
         }
         else if (input.equalsIgnoreCase("all"))
         {
            chosenMeetpunt.editDate();
            chosenMeetpunt.editTime();
            chosenMeetpunt.editWeight();
            break;
         }
         else
         {
            System.out.print("\nPlease try again\n");
         }
      }
   }

   public void printMeetpuntEn()
   {
      if (gewichtMeetPuntData.size() == 0)
      {
         System.out.println("\nSorry no measurements available.");
      }
      else
      {
         gewichtMeetPuntData.sort();
         System.out.println("\nYour measurements:\n");
         System.out.println("Index     " + "Time      " + "Weight    " + "Date       ");
         for (int m = 0; m < gewichtMeetPuntData.size(); m++)
         {
            System.out.printf("%d.    %s%n", m+1, gewichtMeetPuntData.get(m));
         }
      }
   }

   public void printMedicineEn(Profile profile) //Print medicijnen van patiënt
   {
      if (medicineList.size() == 0)
      {
         System.out.println("\nSorry Medicine available.");
      }
      else
      {
         System.out.printf("%nThis is the medicine list of: %s %s.%n%n", profile.getFirstname(), profile.getLastname());
         for (int m = 0; m < medicineList.size(); m++)
         {
            if (m > 9)
            {
               System.out.printf("%d.%s%n   ", m + 1, medicineList.get(m));
            }
            else
            {
               System.out.printf(" %d.%s%n  ", m + 1, medicineList.get(m));
            }
         }
      }
   }

   @Override
   public String toString()
   {

      return firstname + " " + lastname;
   }
}


