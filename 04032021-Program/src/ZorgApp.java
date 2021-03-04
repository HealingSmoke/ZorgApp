import java.util.Scanner;

public class ZorgApp
{
   private Profile profile;
   private ProfileList profileList = new ProfileList();

   Scanner in = new Scanner(System.in); // voor alle switchmenu's
   boolean quit = false; //voor alle switchmenu's
   int menuItem; // voor alle switchmenu's

   public ZorgApp()
   {
      //constructor lijst invullen
      Profile profile = new Profile("Amanda", "Schoonhoven", 29, 52.4, 1.68, 21);
      profileList.addProfile(profile);
      profile = new Profile("Anna", "Moonlight", 31, 68.4, 1.72, 28);
      profileList.addProfile(profile);
   }

   public void Verify()
   {
      //vraag om voornaam en achternaam om in te loggen
   }

   //LoginMenu
   //methode maken om zorgverlener of patient te checken en profiel op te halen
   public boolean LoginMenu()
   {
      do
      {
         System.out.println("\nWelkom in de ZorgApp! \nDit is het loginscherm: \n");
         System.out.println("1. Zorgverlener");
         System.out.println("2. Patient");
         System.out.println("0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         menuItem = in.nextInt();

         switch (menuItem)
         {
            case 1:
               ZorgverlenerMenu();
               break;

            case 2:
               PatientMenu();
               break;

            case 0:
               quit = true;
               System.out.println("Tot ziens!");
               break;

            default:
               System.out.println("Probeer opnieuw.\n");
         }
      }
         while (!quit);
      return quit;
   }

   //Patiëntmenu -- gegevens inzien en bewerken -- medicijnen inzien
   //profile.PrintProfileAlles methode maken
   //profile.PrintProfileMedicatie methode maken
   private boolean PatientMenu()
   {
      do
      {
         System.out.println("\nWelkom " + profile + ", wat wilt u graag doen? \n"); //naam van patient invoegen
         System.out.println("1. Om terug te gaan ");
         System.out.println("2. Uw gegevens bekijken");
         System.out.println("3. Uw gegevens bewerken");
         System.out.println("4. Uw medicatie bekijken");
         System.out.println("0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");


         menuItem = in.nextInt();
         switch (menuItem)
         {

            case 1:
               LoginMenu();
               break;
            case 2:
               profile.PrintProfileAlles();
               //methode creeren om profielgegevens op te halen en deze methode te herstarten
               break;
            case 3:
               EditPatientMenu();
               break;
               
            case 4:
               //methode creeren om medicatie van patient te printen en dit menu opnieuw te starten
               profile.PrintProfileMedicatie();
               break;

            case 0:
               quit = true;
               System.out.println("Tot ziens!");
               break;

            default:
               System.out.println("Probeer opnieuw. \n");
         }
      } while (!quit);
      return quit;
   }

   //EditPatiëntMenu -- Alles of losse onderdelen bewerken
   //profile.ReCalcBMI methode maken
   private boolean EditPatientMenu()
   {
      do
      {
         System.out.print("\nWelkom, wat wilt u graag doen? \n");
         System.out.println("1. Om terug te gaan ");
         System.out.println("2. Alles opnieuw invoeren");
         System.out.println("3. Uw voornaam bewerken");
         System.out.println("4. Uw achternaam bewerken");
         System.out.println("5. Uw leeftijd bewerken");
         System.out.println("6. Uw lengte bewerken");
         System.out.println("7. Uw gewicht bewerken");
         System.out.println("8. Uw BMI opnieuw bewerken");
         System.out.println("0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         menuItem = in.nextInt();
         switch (menuItem)
         {

            case 1:
               PatientMenu();
               break;
            case 2:
               profile.EditProfileAlles();
               break;
            case 3:
               profile.EditProfileVoornaam();
               break;

            case 4:
               profile.EditProfileAchternaam();
               break;

            case 5:
               profile.EditProfileLeeftijd();
               break;

            case 6:
               profile.EditProfileLengte();
               break;

            case 7:
               profile.EditProfileGewicht();
               break;

            case 8:
               profile.ReCalcBMI();
               break;

            case 0:
               quit = true;
               System.out.println("Tot ziens!");
               System.exit(0);
               break;

            default:
               System.out.println("Probeer opnieuw. \n");
         }
      } while (!quit);
      return quit;
   }


   //ZorgverlenerMenu -- Patient of medicijn kiezen
   private boolean ZorgverlenerMenu()
   {
      do
      {
         System.out.println("\nWelkom " + "zorgverlener" + ", wat wilt u graag doen? \n");
         System.out.println("1. Om terug te gaan");
         System.out.println("2. Patiënt kiezen uit een lijst");
         System.out.println("3. Medicijn kiezen uit een lijst");
         System.out.println("0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         menuItem = in.nextInt();
         switch (menuItem)
         {

            case 1:
               LoginMenu();
               break;
            case 2:
               Patientenlijst();
               break;
            case 3:
               Medicijnenlijst();
               break;

            case 0:
               quit = true;
               System.out.println("\nTot ziens!");
               break;

            default:
               System.out.println("Probeer opnieuw. \n");
         }
      } while (!quit);
      return quit;
   }

   //alle profielen voornaam + achternaam printen met cijfer voor switch
   private boolean Patientenlijst()
   {
      do
      {
         System.out.println("\nDit zijn al uw patiënten: ");
         //alle profielen voornaam + achternaam printen met cijfer voor switch
         System.out.println("1. Om terug te gaan");
         System.out.println("0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         menuItem = in.nextInt();
         switch (menuItem)
         {

            case 1:
            ZorgverlenerMenu();
            break;

            case 0:
               quit = true;
               System.out.println("\nTot ziens!");
               break;

            default:
               System.out.println("Probeer opnieuw. \n");
         }
      } while (!quit);
      return quit;
   }

   //alle medicijnenprinten met cijfer voor switch
   private boolean Medicijnenlijst()
   {
      do
      {
         System.out.println("\nUw medicijnenlijst: ");
         //alle medicijnenprinten met cijfer voor switch
         System.out.println("1. Om terug te gaan");
         System.out.println("0. Quit");
         System.out.print("\nGeef het getal van uw keuze om verder te gaan: ");

         menuItem = in.nextInt();
         switch (menuItem)
         {

            case 1:
               ZorgverlenerMenu();
               break;

            case 0:
               quit = true;
               System.out.println("\nTot ziens!");
               break;

            default:
               System.out.println("Probeer opnieuw. \n");
         }
      } while (!quit);
      return quit;
   }

   }

