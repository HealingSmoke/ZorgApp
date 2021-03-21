import java.util.Locale;
import java.util.Scanner;
/* Nog doen
-geen foutmelding krijgen met lengte en gewicht invoeren van komma
-profiel gegevens weergeven in twee kolommen
-bij een lege medicijnenlijst dit zeggen
-Alle menu's opschonen
-Gewichtmeetpunt toevoegen
 */
public class ZorgApp
{
   //attributen
   private String userName;
   private String passWord;
   private Profile profile;
   private Profile patient;
   private Medicine medicine;
   private String antwoord;

   private ProfileList profileList = new ProfileList();
   private MedicineList medicineList;

   boolean quit = false; //voor alle switchmenu's
   int menuItem; // voor alle switchmenu's
   Scanner in = new Scanner(System.in); // voor alle switchmenu's
   Scanner string = new Scanner(System.in);

   //cconstructor
   public ZorgApp()
   {
      Locale.setDefault(Locale.ENGLISH);

      Profile profile = new Profile('z', "z1", "1234", "Zorgverlener", "Adriaan");
      profileList.addProfile(profile);
      profile = new Profile('p', "p1", "4567", "Amanda", "Schoonhoven", 29, 51.4, 1.68, 21);
      profileList.addProfile(profile);
      profile = new Profile('p', "p2", "7899", "Anna", "Moonlight", 44, 68.4, 1.72, 24 );
      profileList.addProfile(profile);
      profile = new Profile('p', "p3", "1123", "Bernard", "Houten", 58, 85.8, 1.78, 21 );
      profileList.addProfile(profile);
      profile = new Profile('p', "p4", "2254", "Chris", "Penrose", 32, 68.4, 1.72, 28);
      profileList.addProfile(profile);
      profile = new Profile('p', "p5", "4545", "Niels", "Schoonhoven", 33, 82.4, 1.85, 25);
      profileList.addProfile(profile);
      profile = new Profile('p', "p6", "8445", "Rick", "Schuiten", 24, 78.4, 1.72, 28);
      profileList.addProfile(profile);

      medicineList = new MedicineList();
      Medicine medicine = new Medicine("Diclofenac", "niet-steroïde anti-inflammatoire (ontstekingswerende) geneesmiddelen (NSAID's)", "Diclofenac wordt gebruikt voor de bestrijding van pijn en de vermindering van koorts. Het pijnstillende effect van diclofenac start een half uur tot een uur na inname. Dit effect houdt ongeveer zes uur aan.", "100-200 mg per dag.");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Amoxicilline", "antibioticum", "Amoxicilline is een bacteriedodend middel, het wordt toegepast bij de behandeling van infecties veroorzaakt door grampositieve en negatieve bacteriën. Hierdoor is het een antibioticum dat kan worden ingezet tegen een zeer breed spectrum van verschillende bacteriën.", "Twee maal daags 500 tot 750 mg of drie maal daags 375-500mg per dag");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Omeprazol", "niet-steroïde anti-inflammatoire (ontstekingswerende) geneesmiddelen (NSAID's)", "Omeprazol beschermt het slijmvlies tegen een te zuur maagmilieu. Omeprazol is overigens niet geschikt voor de snelle verlichting van de gevolgen van brandend maagzuur. Omeprazol dient meestal kort voor de maaltijd te worden ingenomen. De maagsapresistente tablet dient in zijn geheel ingeslikt te worden, zonder te kauwen. Om het inslikken te vergemakkelijken kan de pil samen met een lepel appelmoes worden ingeslikt. Verbetering van de symptomen na het starten met omeprazol treedt meestal na ongeveer 2 tot 3 dagen op. De meeste patiënten zijn na ongeveer 7 dagen verlost van hun brandend maagzuur. Men dient de behandeling te stoppen wanneer de symptomen volledig zijn verdwenen.", "20 tot 40 mg gedurende 14 dagen.");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Doxycycline", "antibioticum", "Doxycycline is een antibioticum met een lange halfwaardetijd (ongeveer 16 tot 22 uur). Wanneer de doxycycline oraal wordt ingenomen dient dit te gebeuren in een staande of zittende houding met een ruime hoeveelheid melk of water. Bij voorkeur niet vlak voor de nachtrust. Oplosbare tabletten kunnen worden opgelost water door middel van goed roeren. Na inname het glas nogmaals aanvullen om zo het achtergebleven medicijn weer op te lossen en vervolgens ook deze oplossing opdrinken.", "Bij orale toepassing moet worden begonnen met 200mg in 1 gift op de eerste dag. Dit zijn dus twee tabletten van 100mg. Dit geldt voor volwassenen en kinderen vanaf 50 kg. Voor kinderen vanaf 8 jaar die lichter dan 50 kilo zijn, de eerste dag 4 mg/kg gevolgd door 2 mg/kg per dag. Toediening dient altijd eenmaal per dag plaats te vinden. Voor volwassenen geldt bij ernstige infecties: 200mg p/d en voor kinderen 4 mg/kg p/d. De typische duur van een kuur is zeven tot tien dagen, afhankelijk van wat uw arts u voorschrijft.");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Ibuprofen", "niet-steroïde anti-inflammatoire (ontstekingswerende) geneesmiddelen (NSAID's)", "In lagere doses (200-400 mg voor volwassenen) verlicht Ibuprofen de pijn en vermindert het koorts, in hogere doseringen (800 mg voor volwassenen) heeft het ook ook anti-inflammatoire. Uitscheiding en afbraak van ibuprofen gebeurd voor ongeveer tweederde door de nieren en voor eenderde door afbraak door de lever. ", "Maximaal 1200 mg per dag.");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Oxazepam", "benzodiazepinen", "Oxazepam wordt voorgeschreven om gevoelens van angst, zenuwen en spanning te behandelen. Het middel wordt ook gebruikt bij de behandeling van patiënten die afkicken van overmatig alcoholgebruik. Het vermindert namelijk de afkickverschijnselen. Oxazepam wordt oraal ingenomen en is verkrijgbaar in capsules of als tabletten. Het medicijn kan tijdens het eten worden ingenomen om de bijwerkingen op het spijsverteringsstelsel te verminderen.", "De aanbevolen startdosering voor volwassen personen varieert van 5 tot 15 mg per dag. De dosering wordt soms verhoogd door de arts, maar 80 mg is de maximale voorgeschreven dagelijkse dosering. Aangeraden wordt om twee maal daags een dosis te nemen.");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Naproxen", "niet-steroïde anti-inflammatoire (ontstekingswerende) geneesmiddelen (NSAID's", "Naproxen is een ontstekingsremmende pijnstiller. Het is te gebruiken bij pijn waarbij ook sprake is van een ontsteking, zoals bij gewrichtspijn. ", "375 tot 750 mg per dag verdeeld over twee doses.");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Diazepam", "benzodiazepinen", "Artsen schrijven het voor bij angstgevoelens en gespannenheid, paniekstoornissen, slapeloosheid, alcoholontwenning, spierkrampen, epilepsie en onrust. Het werkt rustgevend, spierontspannend, vermindert angstgevoelens en beïnvloedt de overdracht van elektrische prikkels in de hersenen.", "Tot 15 mg per dag");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Paracetamol", "pijnstiller", "Paracetamol werkt pijnstillend en koortsverlagend. Het is te gebruiken bij verschillende soorten pijn zoals, hoofdpijn, migraine, koorts, griep, verkoudheid, keelpijn, bijholteontsteking, middenoorontsteking, oorpijn door gehoorgangontsteking, artrose, spierpijn, gewrichtspijn en menstruatieklachten.", "Volwassenen mogen bij kortdurend gebruik 3 tot 4 keer per dag 1 tot 2 tabletten van 500 mg paracetamol gebruiken (niet langer dan 4 weken achter elkaar). Let op: Bij langdurig gebruik (langer dan 4 weken) mag u niet meer dan 5 keer per dag 1 tablet (geen 2) van 500 mg paracetamol gebruiken.");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Metronidazol", "antibioticum", "Metronidazol doodt bepaalde bacteriën en eencellige parasieten, zoals amoeben. Artsen schrijven het meestal voor bij infecties van het maagdarmkanaal met diarree.", "Oraal: Volwassenen: 1000 mg per dag, in 1 giften, voor 7 dagen Adolescenten: 2x 400 mg per dag voor 5-7 dagen, of 2000 mg als enkele dosis. Gynaecologische ingrepen: 1 g Metronidazol Aurobindo als eenmalige gift, gevolgd door 500 mg 3 maal daags tot voor de operatie niet meer mag worden gegeten.");
      medicineList.addMedicine(medicine);

   }

   public Profile Login()
   {
      do
      {
         profile = null;
         patient = null;
         System.out.println("\nWelkom in de ZorgApp, dit is het inlogscherm.\n");
         System.out.println("Wat is uw gebruikersnaam: ");
         userName = string.nextLine();
         System.out.println("Wat is uw wachtwoord: ");
         passWord = string.nextLine();

         for (int i = 0; i < profileList.sizeOf(); i++)
         {
            if ((profileList.get(i).getUsername().equals(userName) && (profileList.get(i).getPassword().equals(passWord))))
            {
               profile = profileList.get(i);
            }
         }
         if (profile == null)
         {
            System.out.print("\nGegevens onjuist, probeer opnieuw\n\n");
         }
      }while (profile == null);


         if (profile != null)
         {
            char Verificatie = profile.getVerificatie();
            switch (Verificatie)
            {
               case 'z':
                  ZorgverlenerMenu(profile);
                  break;
               case 'p':
                  PatientMenu(profile);
                  break;
            }
         }
         return profile;

      }


   //Patient gedeelte
   public boolean PatientMenu(Profile profile)
   {
      do
      {
         System.out.printf("\nWelkom %s, wat wilt u graag doen? \n", profile.getVoorNaam());
         System.out.println(" 1. Gegevens inzien ");
         System.out.println(" 2. Medicijnen inzien");
         System.out.println(" 3. Alle gegevens bijwerken.");
         System.out.println(" 4. Uw voornaam bijwerken.");
         System.out.println(" 5. Uw achternaam bijwerken.");
         System.out.println(" 6. Uw leeftijd bijwerken.");
         System.out.println(" 7. Uw gewicht bijwerken.");
         System.out.println(" 8. Uw lengte bijwerken.");
         System.out.println(" 9. Uw BMI opnieuw berekenen");
         System.out.println("10. Uw gebruikersnaam veranderen");
         System.out.println("11. Uw wachtwoord veranderen");
         System.out.println("12. Gewicht meet punt");
         System.out.println("13. Terug naar het loginscherm");
         System.out.println(" 0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         menuItem = in.nextInt();
         switch (menuItem)
         {

            case 1:
               System.out.println("\nUw huidige profielgegevens: ");
               profile.PrintProfileAlles();
               break;
            case 2:
               profile.PrintProfileMedicine(profile);
               break;
            case 3:
               profile.EditProfileAlles(profile);
               break;

            case 4:
               profile.EditProfileVoornaam();
               break;

            case 5:
               profile.EditProfileAchternaam();
               break;

            case 6:
               profile.EditProfileLeeftijd();
               break;

            case 7:
               profile.EditProfileGewicht();
               break;

            case 8:
               profile.EditProfileLengte();
               break;

            case 9:
               profile.ReCalcBMI();
               System.out.printf("%nUw BMI is: %.2f%n", profile.getBmi());
               break;

            case 10:
               profile.EditProfileUsername();
               break;

            case 11:
               profile.EditProfilePassword();
               break;

            case 12:
               System.out.println("Gewicht meet punt is nog niet beschikbaar.");
               break;

            case 13:
               Login();
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


   //Zorgverlener gedeelte
   public boolean ZorgverlenerMenu(Profile profile)
   {

      do
      {
         System.out.println("\nWelkom " + profile.getVoorNaam() + ", wat wilt u graag doen? \n");

         System.out.println("1. Om terug te gaan");
         System.out.println("2. Alle patiënten weergeven");
         System.out.println("3. Patiënt bewerken in het systeem");
         System.out.println("4. Patiënt toevoegen in het systeem");
         System.out.println("5. Patiënt verwijderen uit het systeem");
         System.out.println("6. Alle medicijnen weergeven");
         System.out.println("7. Medicijn toevoegen in het systeem");
         System.out.println("8. Medicijn verwijderen uit het systeem");
         System.out.println("0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         menuItem = in.nextInt();
         switch (menuItem)
         {

            case 1:
               Login();
               break;
            case 2:
               profileList.PrintProfileList();
               break;
            case 3:
               EditPatient(patient);
               break;
            case 4:
               addPatient();
               break;
            case 5:
               removePatient();
               break;
            case 6:
               medicineList.PrintMedicineList();
               break;

            case 7:
               addMedicineToSystem();
               break;

            case 8:
               removeMedicineFromSystem();
               break;

            case 0:
               quit = true;
               System.exit(0);
               System.out.println("\nTot ziens!");
               break;

            default:
               System.out.println("Probeer opnieuw. \n");
         }
      } while (!quit);
      return quit;

   }

   //Nieuw menu om patient te bewerken
   private Profile EditPatient(Profile patient)
   {
      profileList.PrintProfileList();
      System.out.print("\nGeef het getal van uw keuze: ");
      int choice = in.nextInt();
      patient = profileList.get(choice);

      do
      {
         System.out.printf("\nDit zijn de gegevens van: %s %s, wat wilt u graag doen? \n", patient.getVoorNaam(), patient.getAchterNaam());
         System.out.println(" 1. Gegevens inzien ");
         System.out.println(" 2. Medicijnen inzien");
         System.out.println(" 3. Alle gegevens bijwerken.");
         System.out.println(" 4. Uw voornaam bijwerken.");
         System.out.println(" 5. Uw achternaam bijwerken.");
         System.out.println(" 6. Uw leeftijd bijwerken.");
         System.out.println(" 7. Uw gewicht bijwerken.");
         System.out.println(" 8. Uw lengte bijwerken.");
         System.out.println(" 9. Uw BMI opnieuw berekenen");
         System.out.println("10. Uw gebruikersnaam veranderen");
         System.out.println("11. Uw wachtwoord veranderen");
         System.out.println("12. Voeg medicijn toe bij patiënt");
         System.out.println("13. Verwijder medicijn bij patiënt");
         System.out.println("14. Gewicht meet punt");
         System.out.println("15. Verwijder patiënt");
         System.out.println("16. Terug naar de patiëntenlijst");
         System.out.println(" 0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         menuItem = in.nextInt();
         switch (menuItem)
         {

            case 1:
               System.out.printf("\nDit zijn de gegevens van: %s %s. \n", patient.getVoorNaam(), patient.getAchterNaam());
               patient.PrintProfileAlles();
               break;
            case 2:
               patient.PrintProfileMedicine(patient);
               break;
            case 3:
               patient.EditPatientAlles(patient);
               break;

            case 4:
               patient.EditProfileVoornaam();
               break;

            case 5:
               patient.EditProfileAchternaam();
               break;

            case 6:
               patient.EditProfileLeeftijd();
               break;

            case 7:
               patient.EditProfileGewicht();
               break;

            case 8:
               patient.EditProfileLengte();
               break;

            case 9:
               patient.ReCalcBMI();
               System.out.printf("%nUw BMI is: %.2f%n", patient.getBmi());
               break;

            case 10:
               patient.EditProfileUsername();
               break;

            case 11:
               patient.EditProfilePassword();
               break;

            case 12:
               addMedicinePatient(patient);
               break;

            case 13:
               removeMedicinePatient(patient);
               break;

            case 14:
               System.out.println("\nSorry werkt nog niet!\n");
               break;

            case 15:
               while (!quit)
               {
                  System.out.printf("%nWeet u zeker dat u uw profiel wilt verwijderen uit het systeem?%nDit brengt u terug naar het loginscherm.%nTyp ja of nee. ");
                  antwoord = string.nextLine().toLowerCase();

                  if (antwoord.equalsIgnoreCase("ja"))
                  {
                     profileList.removeProfile(patient);
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

               Login();
               break;

            case 16:
               ZorgverlenerMenu(profile);
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
      return patient;
   }

   /*
   Medicijn toevoegen
   Controleren of je ingevoerde medicijn wilt toevoegen
   Vragen of je de nieuwe medicijnenlisjt wilt zien
   Vragen of je nog een medicijn wilt toevoegen
   */ //Medicijn toevoegen aan medicijnlijst
   private void addMedicineToSystem()
   {
      boolean exit = false;

      do
      {
         Medicine newMedicine = new Medicine("", "", "", "");
         newMedicine.addNewMedicine(newMedicine);
         System.out.printf("%nWeet u zeker dat u dit medicijn wilt toevoegen?%nTyp: Ja / Nee%n");
         String antwoord = string.nextLine();
         if (antwoord.equals("Ja") || antwoord.equals("ja"))
         {
            medicineList.addMedicine(newMedicine);
         }
         System.out.printf("%nWilt u de nieuwe medicijnenlijst zien?%nTyp: Ja / Nee%n");
         antwoord = string.nextLine();
         if (antwoord.equals("Ja") || antwoord.equals("ja"))
         {
            medicineList.PrintMedicineList();
         }

         System.out.printf("%nWilt u nog een medicijn toevoegen?%nTyp: Ja / Nee%n");
         antwoord = string.nextLine();
         if (antwoord.equals("Nee") || antwoord.equals("nee"))
         {
            exit = true;
         }

      }while(!exit);

   }

   private Profile addMedicinePatient(Profile patient)
   {
      medicineList.PrintMedicineList();
      System.out.println("\nWelk medicijn wilt u toevoegen?\nGeef het getal van uw keuze: ");
      int m = in.nextInt();
      medicine = medicineList.get(m);

      do
      {
         System.out.printf("%nU heeft dit medicijn gekozen:%n%n%s%n%nWeet u zeker dat u dit medicijn wilt toevoegen aan de lijst van: %s %s%nTyp ja of nee.%n ", medicine, patient.getVoorNaam(), patient.getAchterNaam());
         antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            patient.addMedicineToProfile(medicine);
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
         return patient;
      } while (!quit);



      while (!quit)
      {
         System.out.printf("%nWilt u de nieuwe medicijnenlijst zien?%nTyp ja of nee.");
         antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            patient.PrintProfileMedicine(patient);
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

      while (!quit)
      {
         System.out.printf("%nWilt u nog een medicijn toevoegen?%nTyp ja of nee.");
         antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            addMedicinePatient(patient);
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
      } return patient;
   }

   /*
   Medicijn kiezen uit de lijst
   Controleren of het cijfer niet hoger is dan de lijst is
   Extra controle op gekozen medicijn om te verwijderen
   Vragen of je de nieuwe medicijnenlijst wilt zien
   Vragen of je nog een medicijn wilt verwijderen
    */ //Medicijn verwijderen van medicijnlijst
   private void removeMedicineFromSystem()
   {
      medicineList.PrintMedicineList();
      Medicine removeMedicine = new Medicine();
      do
      {
         System.out.printf("%nGeef het getal van uw keuze: ");
         int m = in.nextInt();

         if (m < medicineList.sizeOf())
         {
            removeMedicine = medicineList.get(m);
            break;
         }
         System.out.print("\nProbeer opnieuw\n");
      }while (!quit);

      while (!quit)
      {
         System.out.printf("%nU heeft dit medicijn gekozen:%n%n%s%n%nWeet u zeker dat u dit medicijn wilt verwijderen uit het systeem?%nTyp ja of nee. ", removeMedicine);
         antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            medicineList.removeMedicine(removeMedicine);
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

      while (!quit)
      {
         System.out.printf("%nWilt u de nieuwe medicijnenlijst zien?%nTyp ja of nee.");
         antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            medicineList.PrintMedicineList();
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

      while (!quit)
      {
         System.out.printf("%nWilt u nog een medicijn verwijderen?%nTyp ja of nee.");
         antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            removeMedicineFromSystem();
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

   private Profile removeMedicinePatient(Profile patient)
   {
      patient.PrintProfileMedicine(patient);
      System.out.println("\nWelk medicijn wilt u verwijderen?\nGeef het getal van uw keuze: ");
      int m = in.nextInt();
      medicine = medicineList.get(m);
      do
      {
         System.out.printf("%nU heeft dit medicijn gekozen:%n%n%s%n%nWeet u zeker dat u dit medicijn wilt verwijderen van de lijst van: %s %s%nTyp ja of nee.%n ", medicine, patient.getVoorNaam(), patient.getAchterNaam());
         antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            patient.removeMedicineFromProfile(medicine);
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
         return patient;
      } while (!quit);



      while (!quit)
      {
         System.out.printf("%nWilt u de nieuwe medicijnenlijst zien?%nTyp ja of nee.");
         antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            patient.PrintProfileMedicine(patient);
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

      while (!quit)
      {
         System.out.printf("%nWilt u nog een medicijn verwijderen?%nTyp ja of nee.");
         antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            removeMedicinePatient(patient);
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
      return patient;
   }

   /*
  Patient toevoegen
  Controleren of je ingevoerde patient wilt toevoegen
  Vragen of je de nieuwe patientenlijst wilt zien
  Vragen of je nog een patient wilt toevoegen
   */ //Patient toevoegen
   private void addPatient()
   {
      Profile patient = new Profile('p', "", "", "", "", 0, 0, 0, 0);
      patient.EditPatientAlles(patient);

      while (!quit)
      {
         System.out.printf("%nWeet u zeker dat u deze patiënt wilt toevoegen in het systeem?%nTyp ja of nee. ");
         antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            profileList.addProfile(patient);
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

      while (!quit)
      {
         System.out.printf("%nWilt u de nieuwe patiëntenlijst zien?%nTyp ja of nee.");
         antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            profileList.PrintProfileList();
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

      while (!quit)
      {
         System.out.printf("%nWilt u nog een patiënt toevoegen?%nTyp ja of nee.");
         antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            addPatient();
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

   /*
   Patient verwijderen
   Controleren of het cijfer niet hoger is dan de lijst is
   Controleren of je ingevoerde patient wilt verwijderen
   Vragen of je de nieuwe patientenlijst wilt zien
   Vragen of je nog een patient wilt toevoegen
   */ //Patient verwijderen uit patiëntenlijst
   private void removePatient()
   {
      profileList.PrintProfileList();
      System.out.println("");
      int choice = in.nextInt();
      patient = profileList.get(choice);

      while (!quit)
      {
         System.out.printf("%nWeet u zeker dat u deze patiënt wilt verwijderen uit het systeem?%nTyp ja of nee. ");
         antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            profileList.removeProfile(patient);
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

      while (!quit)
      {
         System.out.printf("%nWilt u de nieuwe patiëntenlijst zien?%nTyp ja of nee.");
         antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            profileList.PrintProfileList();
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

      while (!quit)
      {
         System.out.printf("%nWilt u nog een patiënt verwijderen?%nTyp ja of nee.");
         antwoord = string.nextLine().toLowerCase();

         if (antwoord.equalsIgnoreCase("ja"))
         {
            removePatient();
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
      return "ZorgAp profiel: " + profile + "\nprofileList: " + profileList + "\n";
   }


}




