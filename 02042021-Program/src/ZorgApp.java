import java.util.Locale;
import java.util.Scanner;
public class ZorgApp
{
   //attributen
   private Profile profile;
   private Profile patient;
   private ProfileList profileList = new ProfileList();
   private GewichtMeetPunt gewichtMeetPuntData;
   private MedicineList medicineList;

   private String menu;
   private int number;
   private String input;
   private boolean isValid = false;
   private boolean quit;
   Scanner in = new Scanner(System.in);
   Scanner string = new Scanner(System.in);

   //cconstructor
   public ZorgApp()
   {

      Profile profile = new Profile('z', "z1", "1234", "Zorgverlener", "Adriaan");
      profileList.add(profile);
      profile = new Profile('p', "p1", "4567", "Amanda", "Schoonhoven", 29, 51.4, 1.68, 18.21);
      profileList.add(profile);
      profile = new Profile('p', "p2", "7899", "Anna", "Moonlight", 44, 68.4, 1.72, 23.12);
      profileList.add(profile);
      profile = new Profile('p', "p3", "1123", "Bernard", "Houten", 58, 85.8, 1.78, 27.08);
      profileList.add(profile);
      profile = new Profile('p', "p4", "2254", "Chris", "Penrose", 32, 68.4, 1.72, 23.12);
      profileList.add(profile);
      profile = new Profile('p', "p5", "4545", "Niels", "Schoonhoven", 33, 82.4, 1.85, 24.08);
      profileList.add(profile);
      profile = new Profile('p', "p6", "8445", "Rick", "Schuiten", 24, 78.4, 1.72, 26.5);
      profileList.add(profile);

      medicineList = new MedicineList();
      Medicine medicine = new Medicine("Diclofenac", "niet-steroïde anti-inflammatoire (ontstekingswerende) geneesmiddelen (NSAID's)", "Diclofenac wordt gebruikt voor de bestrijding van pijn en de vermindering van koorts. Het pijnstillende effect van diclofenac start een half uur tot een uur na inname. Dit effect houdt ongeveer zes uur aan.", "100-200 mg per dag.", "");
      medicineList.add(medicine);
      medicine = new Medicine("Amoxicilline", "antibioticum", "Amoxicilline is een bacteriedodend middel, het wordt toegepast bij de behandeling van infecties veroorzaakt door grampositieve en negatieve bacteriën. Hierdoor is het een antibioticum dat kan worden ingezet tegen een zeer breed spectrum van verschillende bacteriën.", "Twee maal daags 500 tot 750 mg of drie maal daags 375-500mg per dag", "");
      medicineList.add(medicine);
      medicine = new Medicine("Omeprazol", "niet-steroïde anti-inflammatoire (ontstekingswerende) geneesmiddelen (NSAID's)", "Omeprazol beschermt het slijmvlies tegen een te zuur maagmilieu. Omeprazol is overigens niet geschikt voor de snelle verlichting van de gevolgen van brandend maagzuur. Omeprazol dient meestal kort voor de maaltijd te worden ingenomen. De maagsapresistente tablet dient in zijn geheel ingeslikt te worden, zonder te kauwen. Om het inslikken te vergemakkelijken kan de pil samen met een lepel appelmoes worden ingeslikt. Verbetering van de symptomen na het starten met omeprazol treedt meestal na ongeveer 2 tot 3 dagen op. De meeste patiënten zijn na ongeveer 7 dagen verlost van hun brandend maagzuur. Men dient de behandeling te stoppen wanneer de symptomen volledig zijn verdwenen.", "20 tot 40 mg gedurende 14 dagen.", "");
      medicineList.add(medicine);
      medicine = new Medicine("Doxycycline", "antibioticum", "Doxycycline is een antibioticum met een lange halfwaardetijd (ongeveer 16 tot 22 uur). Wanneer de doxycycline oraal wordt ingenomen dient dit te gebeuren in een staande of zittende houding met een ruime hoeveelheid melk of water. Bij voorkeur niet vlak voor de nachtrust. Oplosbare tabletten kunnen worden opgelost water door middel van goed roeren. Na inname het glas nogmaals aanvullen om zo het achtergebleven medicijn weer op te lossen en vervolgens ook deze oplossing opdrinken.", "Bij orale toepassing moet worden begonnen met 200mg in 1 gift op de eerste dag. Dit zijn dus twee tabletten van 100mg. Dit geldt voor volwassenen en kinderen vanaf 50 kg. Voor kinderen vanaf 8 jaar die lichter dan 50 kilo zijn, de eerste dag 4 mg/kg gevolgd door 2 mg/kg per dag. Toediening dient altijd eenmaal per dag plaats te vinden. Voor volwassenen geldt bij ernstige infecties: 200mg p/d en voor kinderen 4 mg/kg p/d. De typische duur van een kuur is zeven tot tien dagen, afhankelijk van wat uw arts u voorschrijft.", "");
      medicineList.add(medicine);
      medicine = new Medicine("Ibuprofen", "niet-steroïde anti-inflammatoire (ontstekingswerende) geneesmiddelen (NSAID's)", "In lagere doses (200-400 mg voor volwassenen) verlicht Ibuprofen de pijn en vermindert het koorts, in hogere doseringen (800 mg voor volwassenen) heeft het ook ook anti-inflammatoire. Uitscheiding en afbraak van ibuprofen gebeurd voor ongeveer tweederde door de nieren en voor eenderde door afbraak door de lever. ", "Maximaal 1200 mg per dag.", "");
      medicineList.add(medicine);
      medicine = new Medicine("Oxazepam", "benzodiazepinen", "Oxazepam wordt voorgeschreven om gevoelens van angst, zenuwen en spanning te behandelen. Het middel wordt ook gebruikt bij de behandeling van patiënten die afkicken van overmatig alcoholgebruik. Het vermindert namelijk de afkickverschijnselen. Oxazepam wordt oraal ingenomen en is verkrijgbaar in capsules of als tabletten. Het medicijn kan tijdens het eten worden ingenomen om de bijwerkingen op het spijsverteringsstelsel te verminderen.", "De aanbevolen startdosering voor volwassen personen varieert van 5 tot 15 mg per dag. De dosering wordt soms verhoogd door de arts, maar 80 mg is de maximale voorgeschreven dagelijkse dosering. Aangeraden wordt om twee maal daags een dosis te nemen.", "");
      medicineList.add(medicine);
      medicine = new Medicine("Naproxen", "niet-steroïde anti-inflammatoire (ontstekingswerende) geneesmiddelen (NSAID's", "Naproxen is een ontstekingsremmende pijnstiller. Het is te gebruiken bij pijn waarbij ook sprake is van een ontsteking, zoals bij gewrichtspijn. ", "375 tot 750 mg per dag verdeeld over twee doses.", "");
      medicineList.add(medicine);
      medicine = new Medicine("Diazepam", "benzodiazepinen", "Artsen schrijven het voor bij angstgevoelens en gespannenheid, paniekstoornissen, slapeloosheid, alcoholontwenning, spierkrampen, epilepsie en onrust. Het werkt rustgevend, spierontspannend, vermindert angstgevoelens en beïnvloedt de overdracht van elektrische prikkels in de hersenen.", "Tot 15 mg per dag", "");
      medicineList.add(medicine);
      medicine = new Medicine("Paracetamol", "pijnstiller", "Paracetamol werkt pijnstillend en koortsverlagend. Het is te gebruiken bij verschillende soorten pijn zoals, hoofdpijn, migraine, koorts, griep, verkoudheid, keelpijn, bijholteontsteking, middenoorontsteking, oorpijn door gehoorgangontsteking, artrose, spierpijn, gewrichtspijn en menstruatieklachten.", "Volwassenen mogen bij kortdurend gebruik 3 tot 4 keer per dag 1 tot 2 tabletten van 500 mg paracetamol gebruiken (niet langer dan 4 weken achter elkaar). Let op: Bij langdurig gebruik (langer dan 4 weken) mag u niet meer dan 5 keer per dag 1 tablet (geen 2) van 500 mg paracetamol gebruiken.", "");
      medicineList.add(medicine);
      medicine = new Medicine("Metronidazol", "antibioticum", "Metronidazol doodt bepaalde bacteriën en eencellige parasieten, zoals amoeben. Artsen schrijven het meestal voor bij infecties van het maagdarmkanaal met diarree.", "Oraal: Volwassenen: 1000 mg per dag, in 1 giften, voor 7 dagen Adolescenten: 2x 400 mg per dag voor 5-7 dagen, of 2000 mg als enkele dosis. Gynaecologische ingrepen: 1 g Metronidazol Aurobindo als eenmalige gift, gevolgd door 500 mg 3 maal daags tot voor de operatie niet meer mag worden gegeten.", "");
      medicineList.add(medicine);


   }

   //Veranderen van taal
   public void changeLanguage() //Nederlands of Engels
   {
      do
      {
         System.out.println("    Welkom!      /         Welcome!");
         System.out.println (" Kies uw taal    /   Choos your language\n");
         System.out.println(" 1. Nederlands   /   Dutch ");
         System.out.println(" 2. Engels       /   English");
         System.out.println(" 0. Quit");
         System.out.println("\nGeef het getal van uw keuze / Please enter the digit of your choice: ");
         try {
            menu = string.nextLine();
         } catch (NumberFormatException e)
         {
            System.out.println("\nGraag een getal invoeren, probeer opnieuw.  / Please enter a digit, try again.");
            changeLanguage();
         }
         switch (menu)
         {
            case "1":
               login();
               break;
            case "2":
               loginEn();
               break;
            case "0":
               System.out.println("Tot ziens!");
               System.exit(0);
               break;
            default:
               System.out.println("Probeer opnieuw. \n");
         }
      } while (!quit);

   }

   //Registreren bij het starten van het programma
   public void register()
   {
      while (!quit) //wil je inloggen of registreren
      {
         System.out.printf("%nWilt u zich aanmelden als nieuw patiënt?%nTyp ja of nee: ");
         input = string.nextLine().toLowerCase().trim();

         if (input.equalsIgnoreCase("ja"))
         {
            Profile patient = new Profile('p', "", "", "", "", 0, 0, 0, 0);
            patient.editProfileAll(patient);
            while (!quit) //controle ingevoerde gegevens correct?
            {
               System.out.printf("%nKloppen uw gegevens? U kunt hierna inloggen.%nTyp ja of nee: ");
               input = string.nextLine().toLowerCase().trim();

               if (input.equalsIgnoreCase("ja"))
               {
                  profileList.add(patient);
                  break;
               }
               else if (input.equalsIgnoreCase("nee"))
               {
                  login();
                  break;
               }
               else
               {
                  System.out.println("\nProbeer opnieuw. ");
               }
            }
            break;
         }
         else if (input.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.println("\nProbeer opnieuw. ");
         }
      }
   }

   //Login met verificatie patiënt of zorgverlener
   public Profile login()
   {
      in.useLocale(Locale.US);
      Profile profile = null;
      register();
      do
      {
         String userName;
         String passWord;
         System.out.println("\nWelkom in de ZorgApp, dit is het inlogscherm.\n");
         System.out.println("Wat is uw gebruikersnaam: ");
         userName = string.nextLine();
         System.out.println("Wat is uw wachtwoord: ");
         passWord = string.nextLine();

         for (int i = 0; i < profileList.size(); i++)
         {
            if ((profileList.get(i).getUsername().equals(userName) && (profileList.get(i).getPassword().equals(passWord))))
            {
               profile = profileList.get(i);
            }
         }
         if (profile == null)
         {
            System.out.print("\nGegevens onjuist, probeer opnieuw\n");
         }
      }while (profile == null);


         if (profile != null)
         {
            char Verificatie = profile.getVerification();
            switch (Verificatie)
            {
               case 'z':
                  zorgverlenerMainMenu(profile);
                  break;
               case 'p':
                  patientMainMenu(profile);
                  break;
            }
         }
         return profile;

      }

   //Patiëntmenu; hoofdmenu
   private void patientMainMenu(Profile profile)
   {
      do
      {
         System.out.printf("%nWelkom %s, dit is het hoofdmenu.%nWat wilt u graag doen?%n%n", profile.getFirstname());
         System.out.println(" 1. Gegevens inzien ");
         System.out.println(" 2. Medicijnen inzien");
         System.out.println(" 3. Gewicht meet punt");
         System.out.println(" 4. Gegevens bewerken");
         System.out.println(" 5. Taal naar Engels veranderen");
         System.out.println(" 6. Terug naar loginscherm");
         System.out.println(" 0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         try {
            menu = string.nextLine();
         } catch (NumberFormatException e)
         {
            System.out.println("\nGraag een getal invoeren, probeer opnieuw.");
            patientMainMenu(profile);
         }

         switch (menu)
         {

            case "1":
               System.out.println("\nUw huidige profielgegevens: ");
               profile.print();
               break;
            case "2":
               profile.printMedicine(profile);
               break;
            case "3":
               profile.printMeetpunt();
               break;
            case "4":
               patientEditMenu(profile);
               break;
            case "5":
               patientMainMenuEn(profile);
               break;
            case "6":
               login();
               break;

            case "0":
               System.out.println("Tot ziens!");
               System.exit(0);
               break;

            default:
               System.out.println("Probeer opnieuw. \n");
         }
      } while (!quit);
   }

   //Patiëntmenu; menukeuze gegevens te bewerken
   private void patientEditMenu(Profile profile)
   {
      do
      {
         System.out.printf("%nWelkom %s.%nWat wilt u graag doen?%n%n", profile.getFirstname());
         System.out.println(" 1. Voornaam bewerken ");
         System.out.println(" 2. Achternaam bewerken");
         System.out.println(" 3. Leeftijd bewerken");
         System.out.println(" 4. Lengte bewerken");
         System.out.println(" 5. Gewicht bewerken");
         System.out.println(" 6. Inlog gegevens bewerken");
         System.out.println(" 7. Alles bewerken");
         System.out.println(" 8. Gegevens inzien");
         System.out.println(" 9. Terug naar hoofdmenu");
         System.out.println(" 0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         try {
            menu = string.nextLine();
         } catch (NumberFormatException e)
         {
            System.out.println("\nGraag een getal invoeren, probeer opnieuw.");
            patientEditMenu(profile);
         }
         switch (menu)
         {
            case "1":
               profile.editFirstname(profile);
               break;
            case "2":
               profile.editLastname(profile);
               break;
            case "3":
               profile.editAge(profile);
               break;
            case "4":
               profile.editLength(profile);
               break;
            case "5":
               profile.editWeight(profile);
               break;
            case "6":
               profile.editLogin(profile);
               break;
            case "7":
               profile.editProfileAll(profile);
               break;
            case "8":
               profile.print();
            case "9":
               patientMainMenu(profile);
               break;
            case "0":
               System.out.println("Tot ziens!");
               System.exit(0);
               break;
            default:
               System.out.println("Probeer opnieuw. \n");
         }
      } while (!quit);

   }

   //Zorgverlenermenu; hoofdmenu
   private void zorgverlenerMainMenu(Profile profile)
   {
      do
      {
         System.out.println("\nWelkom " + profile.getFirstname() + ", wat wilt u graag doen? \n");
         
         System.out.println("1. Alle patiënten weergeven");
         System.out.println("2. Patiënt toevoegen in het systeem");
         System.out.println("3. Patiënt bewerken in het systeem");
         System.out.println("4. Alle medicijnen weergeven in het systeem");
         System.out.println("5. Medicijn toevoegen in het systeem");
         System.out.println("6. Medicijn bewerken in het systeem");
         System.out.println("7. Taal naar Engels veranderen");
         System.out.println("8. Terug naar loginscherm");
         System.out.println("0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         try {
            menu = string.nextLine();
         } catch (NumberFormatException e)
         {
            System.out.println("\nGraag een getal invoeren, probeer opnieuw.");
            zorgverlenerMainMenu(profile);
         }

         switch (menu)
         {
            case "1":
               profileList.print();
               break;
            case "2":
               addPatient(profile);
               break;
            case "3":
               Profile patient = choosePatient();
               chooseEditPatient(profile, patient);
               break;
            case "4":
               medicineList.printMedicine();
               break;
            case "5":
               addMedicineSystem(profile);
               break;
            case "6":
               editMedicineSystem(profile);
               break;
            case "7":
               zorgverlenerMainMenuEn(profile);
               break;
            case "8":
               login();
               break;
            case "0":
               System.exit(0);
               System.out.println("\nTot ziens!");
               break;

            default:
               System.out.println("\nGraag een getal invoeren, probeer opnieuw.");
         }
      } while (!quit);
   }

   //Zorgverlener; extra handelingen met patiënt toevoegen
   private void addPatient(Profile profile)
   {
      Profile patient = new Profile('p', "", "", "", "", 0, 0, 0, 0);
      patient.addPatient(patient);

      while (!isValid) //controle ingevoerde gegevens correct?
      {
         System.out.printf("%nWeet u zeker dat u deze patiënt wilt toevoegen in het systeem?%nTyp ja of nee: ");
         input = string.nextLine().toLowerCase().trim();

         if (input.equalsIgnoreCase("ja"))
         {
            profileList.add(patient);
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

      while (!isValid) //wil je nieuwe patiëntenlijst zien?
      {
         System.out.printf("%nWilt u de nieuwe patiëntenlijst zien?%nTyp ja of nee: ");
         input = string.nextLine().toLowerCase().trim();

         if (input.equalsIgnoreCase("ja"))
         {
            profileList.print();
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

      while (!isValid) //wil je nog een patiënt toevoegen?
      {
         System.out.printf("%nWilt u nog een patiënt toevoegen?%nTyp ja of nee: ");
         input = string.nextLine().toLowerCase().trim();

         if (input.equalsIgnoreCase("ja"))
         {
            addPatient(profile);
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

   //Zorgverlener; menukeuze patiënt kiezen
   private Profile choosePatient()
   {
      Profile patient = null;
      profileList.print();
      System.out.print("\nKies een patiënt, geef het getal van uw keuze: ");
      do
      {
         if (!in.hasNextInt())
         {
            profileList.print();
            System.out.println("\nVerkeerde invoer, probeer opnieuw.");
            System.out.print("\nKies een patiënt, geef het getal van uw keuze: ");
            in.next();
         }
         else
         {
            number = in.nextInt();
            if (number > 0 && number <= profileList.size())
            {
               try
               {
                  patient = profileList.get(number);

               } catch (IndexOutOfBoundsException e)
               {
                  profileList.print();
                  System.out.print("\nVerkeerde invoer, probeer opnieuw\n");
                  System.out.print("\nKies een patiënt, geef het getal van uw keuze: ");
               }
            }
            else
            {
               profileList.print();
               System.out.print("\nVerkeerde invoer, probeer opnieuw\n");
               System.out.print("\nKies een patiënt: \nGeef het getal van uw keuze: ");
            }
         }
      }while (patient == null);
      return patient;
   }

   //Zorgverlenermenu; menukeuze kiezen wat je wilt doen
   private Profile chooseEditPatient(Profile profile, Profile patient)
   {
      do
      {
         System.out.printf("%nDit zijn de gegevens van: %s %s. Wat wilt u doen? %n%n", patient.getFirstname(), patient.getLastname());
         System.out.println("1. Gegevens van patiënt bewerken ");
         System.out.println("2. Medicijnen van patiënt bewerken");
         System.out.println("3. Gewicht meet punt van patiënt");
         System.out.println("4. Laat alle gegevens van patiënt zien");
         System.out.println("5. Verwijder patiënt");
         System.out.println("6. Terug naar hoofdmenu");
         System.out.println("0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         try {
            menu = string.nextLine();
         } catch (NumberFormatException e)
         {
            System.out.println("\nGraag een getal invoeren, probeer opnieuw.");
            chooseEditPatient(profile, patient);
         }

         switch (menu)
         {
            case "1":
            editPatientData(profile, patient);
            break;
         case "2":
            editPatientMedicine(profile, patient);
            break;
         case "3":
            editPatientWeightMeasure(profile, patient);
            break;
         case "4":
            System.out.println("\nDit zijn de gegevens van: \n");
             patient.print();
            patient.printMedicine(patient);
            patient.printMeetpunt();
            break;
         case "5":
            while (!isValid) //Wil je deze patiënt echt verwijderen
            {
               System.out.println("\nGekozen patiënt: \n");
               patient.print();
               System.out.printf("%nWeet u zeker dat u deze patiënt wilt verwijderen uit het systeem?%nDit brengt u terug naar het hoofdmenu.%n%nTyp ja of nee: ");
               input = string.nextLine().toLowerCase().trim();

               if (input.equalsIgnoreCase("ja"))
               {
                  profileList.remove(patient);
                  zorgverlenerMainMenu(profile);
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
            break;
         case "6":
            zorgverlenerMainMenu(profile);
            break;
         case "0":
            System.out.println("Tot ziens!");
            System.exit(0);
            break;

         default:
            System.out.println("\nGraag een getal invoeren, probeer opnieuw.");
         }
      } while (!quit);
      return profile;
   }

   //Zorgverlenermenu; menukeuze patiënt gegevens bewerken
   private Profile editPatientData(Profile profile, Profile patient)
   {
      do
      {
         System.out.printf("%nDit zijn de gegevens van: %s %s, wat wilt u graag doen? %n%n", patient.getFirstname(), patient.getLastname());
         System.out.println(" 1. Voornaam bewerken ");
         System.out.println(" 2. Achternaam bewerken");
         System.out.println(" 3. Leeftijd bewerken");
         System.out.println(" 4. Lengte bewerken");
         System.out.println(" 5. Gewicht bewerken");
         System.out.println(" 6. Inlog gegevens bewerken");
         System.out.println(" 7. Alles bewerken");
         System.out.println(" 8. Gegevens inzien");
         System.out.println(" 9. Terug naar vorig menu");
         System.out.println(" 0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         try {
            menu = string.nextLine();

         } catch (NumberFormatException e)
         {
            System.out.println("\nGraag een getal invoeren, probeer opnieuw.");
            patientEditMenu(patient);
         }
         switch (menu)
         {
            case "1":
               patient.editFirstname(patient);
               break;
            case "2":
               patient.editLastname(patient);
               break;
            case "3":
               patient.editAge(patient);
               break;
            case "4":
               patient.editLength(patient);
               break;
            case "5":
               patient.editWeight(patient);
               break;
            case "6":
               patient.editLogin(patient);
               break;
            case "7":
               patient.addPatient(patient);
               break;
            case "8":
               System.out.println("\nAlle opgeslagen gegevens: ");
               patient.print();
               break;
            case "9":
               chooseEditPatient(profile, patient);
               break;
            case "0":
               System.out.println("Tot ziens!");
               System.exit(0);
               break;
            default:
               System.out.println("\nGraag een getal invoeren, probeer opnieuw.");
         }
      } while (!quit);

      return profile;
   }

   //Zorgverlenermenu; menukeuze patiënt medicijnen bewerken
   private Profile editPatientMedicine(Profile profile, Profile patient)
   {
      do
      {
         System.out.printf("%nDit zijn de gegevens van: %s %s, wat wilt u graag doen? %n%n", patient.getFirstname(), patient.getLastname());
         System.out.println("1. Medicijn toevoegen ");
         System.out.println("2. Medicijn verwijderen");
         System.out.println("3. Medicijnen inzien van patiënt");
         System.out.println("4. Medicijn naam en soort bewerken");
         System.out.println("5. Medicijn dosering bewerken");
         System.out.println("6. Medicijn memo bewerken");
         System.out.println("7. Terug naar vorig menu");
         System.out.println("0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         try {
            menu = string.nextLine();
         } catch (NumberFormatException e)
         {
            System.out.println("\nGraag een getal invoeren, probeer opnieuw.");
            editPatientMedicine(profile, patient);
         }

         switch (menu)
         {
            case "1":
               Medicine chosenMedicine = chooseMedicine();
               patient.addMedicine(patient, chosenMedicine);
               break;
            case "2":
               patient.removeMedicine(patient);
               break;
            case "3":
               patient.printMedicine(patient);
               break;
            case "4":
               patient.editMedicineName(patient);
               break;
            case "5":
               patient.editMedicineDosage(patient);
               break;
            case "6":
               patient.editMedicineMemo(patient);
               break;
            case "7":
               chooseEditPatient(profile, patient);
               break;
            case "0":
               System.out.println("Tot ziens!");
               System.exit(0);
               break;

            default:
               System.out.println("\nGraag een getal invoeren, probeer opnieuw.");
         }
      } while (!quit);
      return patient;
   }

   //Zorgverlenermenu; menukeuze patiënt gewicht meet punt bewerken
   private Profile editPatientWeightMeasure(Profile profile, Profile patient)
   {
      do
      {
         System.out.printf("%nDit zijn de gegevens van: %s %s, wat wilt u graag doen? %n%n", patient.getFirstname(), patient.getLastname());
         System.out.println("1. Gewicht meet punt inzien van patiënt");
         System.out.println("2. Gewicht meet punt toevoegen ");
         System.out.println("3. Gewicht meet punt bewerken");
         System.out.println("4. Gewicht meet punt verwijderen");
         System.out.println("5. Terug naar vorig menu");
         System.out.println("0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         try {
            menu = string.nextLine();
         } catch (NumberFormatException e)
         {
            System.out.println("\nGraag een getal invoeren, probeer opnieuw.");
            editPatientWeightMeasure(profile, patient);
         }

         switch (menu)
         {
            case "1":
               patient.printMeetpunt();
               break;
            case "2":
               patient.addMeetpunt(patient);
               break;
            case "3":
               patient.editMeetpunt(patient);
               break;
            case "4":
               patient.removeMeetpunt(patient);
               break;
            case "5":
               chooseEditPatient(profile, patient);
               break;
            case "0":
               System.out.println("Tot ziens!");
               System.exit(0);
               break;

            default:
               System.out.println("\nGraag een getal invoeren, probeer opnieuw.");
         }
      } while (!quit);
      return patient;
   }

   //Methodes omtrend de grote medicijnenlijst
   private void addMedicineSystem(Profile profile) //Zorgverlener; extra handelingen met medicijn toevoegen
   {
      Medicine newMedicine = new Medicine("", "", "", "", "");
      newMedicine.addMedicine(newMedicine);

      while (!isValid) //controle ingevoerde gegevens correct?
      {
         System.out.printf("%nWeet u zeker dat u dit medicijn wilt toevoegen aan het systeem?%nTyp ja of nee: ");
         input = string.nextLine().toLowerCase().trim();

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
            System.out.print("\nVerkeerde invoer. Probeer opnieuw\n");
         }
      }

      while (!isValid) //wil je nieuwe medicijnenlijst zien?
      {
         System.out.printf("%nWilt u de nieuwe medicijnenlijst zien?%nTyp ja of nee: ");
         input = string.nextLine().toLowerCase().trim();

         if (input.equalsIgnoreCase("ja"))
         {
            medicineList.printMedicine();
            break;
         }
         else if (input.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.print("\nVerkeerde invoer. Probeer opnieuw\n");
         }
      }

      while (!isValid) //wil je nog een medicijn toevoegen?
      {
         System.out.printf("%nWilt u nog een medicijn toevoegen?%nTyp ja of nee: ");
         input = string.nextLine().toLowerCase().trim();

         if (input.equalsIgnoreCase("ja"))
         {
            addMedicineSystem(profile);
            break;
         }
         else if (input.equalsIgnoreCase("nee"))
         {
            break;
         }
         else
         {
            System.out.print("\nVerkeerde invoer. Probeer opnieuw\n");
         }
      }

   }

   private Medicine chooseMedicine() //Medicijn kiezen van systeem
   {
      Medicine chosenMedicine = null;
      medicineList.printMedicine();
      System.out.print("\nKies een medicijn, geef het getal van uw keuze: ");
      do
      {
         if (!in.hasNextInt())
         {
            medicineList.printMedicine();
            System.out.print("\nVerkeerde invoer, probeer opnieuw\n");
            System.out.print("\nKies een medicijn, geef het getal van uw keuze: ");
            in.next();
         }
         else
         {
            number = in.nextInt();
            if (number >= 0 && number <= medicineList.size())
            {
               try
               {
                  chosenMedicine = medicineList.get(number -1);

               } catch (IndexOutOfBoundsException e)
               {
                  medicineList.printMedicine();
                  System.out.print("\nVerkeerde invoer, probeer opnieuw\n");
                  System.out.print("\nKies een medicijn, geef het getal van uw keuze: ");
               }
            }
            else
            {
               medicineList.printMedicine();
               System.out.print("\nVerkeerde invoer, probeer opnieuw\n");
               System.out.print("\nKies een medicijn, geef het getal van uw keuze: ");
            }
         }
      }  while (chosenMedicine == null);

     return chosenMedicine;
   }

   private void editMedicineSystem(Profile profile) //Medicijn bewerken van systeem
   {
      Medicine chosenMedicine = chooseMedicine();
      do
      {
         System.out.println("\nWat wilt u bewerken aan: " + chosenMedicine.getMedicineName());
         System.out.println("1. Naam en soort bewerken");
         System.out.println("2. Omschrijving");
         System.out.println("3. Dosering");
         System.out.println("4. Verwijderen");
         System.out.println("5. Terug naar hoofdmenu");
         System.out.println("0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         try
         {
            menu = string.nextLine();
         } catch (NumberFormatException e)
         {
            System.out.println("\nGraag een getal invoeren, probeer opnieuw.");
            editMedicineSystem(profile);
         }

         switch (menu)
         {
            case "1":
               chosenMedicine.editName();
               break;
            case "2":
               chosenMedicine.editDescription();
               break;
            case "3":
               chosenMedicine.editDosage();
               break;
            case "4":
               removeMedicine(chosenMedicine);
               zorgverlenerMainMenu(profile);
               break;
            case "5":
               zorgverlenerMainMenu(profile);
               break;
            case "0":
               System.exit(0);
               System.out.println("\nTot ziens!");
               break;
            default:
               System.out.println("\nGraag een getal invoeren, probeer opnieuw.");
         }
      } while (!quit);

   }

   private void removeMedicine(Medicine chosenMedicine) //Medicijn verwijderen van systeem
   {
      do //Vragem of je dit medicijn echt wilt verwijderen
      {
         System.out.printf("%nU heeft dit medicijn gekozen:%n%s%n%nWeet u zeker dat u dit medicijn wilt verwijderen?%nTyp ja of nee: ", chosenMedicine);
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
      } while (!quit);
   }


   //Hieronder alles in het engels
   //Registreren bij het starten van het programma
   public void registerEn()
   {
      while (!quit) //wil je inloggen of registreren
      {
         System.out.printf("%nDo you want to register as patient?%nType yes or no: ");
         input = string.nextLine().toLowerCase().trim();

         if (input.equalsIgnoreCase("yes"))
         {
            Profile patient = new Profile('p', "", "", "", "", 0, 0, 0, 0);
            patient.editProfileAllEn(patient);
            while (!quit) //controle ingevoerde gegevens correct?
            {
               System.out.printf("%nAre these details correct? You will be redirected to the login screen after this.%nType yes or no: ");
               input = string.nextLine().toLowerCase().trim();

               if (input.equalsIgnoreCase("yes"))
               {
                  profileList.add(patient);
                  break;
               }
               else if (input.equalsIgnoreCase("no"))
               {
                  loginEn();
                  break;
               }
               else
               {
                  System.out.println("\nPlease try again. ");
               }
            }
            break;
         }
         else if (input.equalsIgnoreCase("no"))
         {
            break;
         }
         else
         {
            System.out.println("\nPlease try again. ");
         }
      }
   }

   //Login met verificatie patiënt of zorgverlener
   public Profile loginEn()
   {
      in.useLocale(Locale.US);
      Profile profile = null;
      registerEn();
      do
      {
         String userName;
         String passWord;
         System.out.println("\nWelcome to the Healthcare App, this is the login screen.\n");
         System.out.println("What is your username: ");
         userName = string.nextLine();
         System.out.println("What is your password: ");
         passWord = string.nextLine();

         for (int i = 0; i < profileList.size(); i++)
         {
            if ((profileList.get(i).getUsername().equals(userName) && (profileList.get(i).getPassword().equals(passWord))))
            {
               profile = profileList.get(i);
            }
         }
         if (profile == null)
         {
            System.out.print("\nInput not valid, please try again\n");
         }
      }while (profile == null);


      if (profile != null)
      {
         char Verificatie = profile.getVerification();
         switch (Verificatie)
         {
            case 'z':
               zorgverlenerMainMenuEn(profile);
               break;
            case 'p':
               patientMainMenuEn(profile);
               break;
         }
      }
      return profile;

   }

   //Patiëntmenu; hoofdmenu
   private void patientMainMenuEn(Profile profile)
   {
      do
      {
         System.out.printf("%Welcome %s, this is the mainmenu.%nWhat would you like to do?%n%n", profile.getFirstname());
         System.out.println(" 1. Profile details ");
         System.out.println(" 2. Medicine details");
         System.out.println(" 3. Measurement details");
         System.out.println(" 4. Edit profile details");
         System.out.println(" 5. Switch to Dutch");
         System.out.println(" 6. Back to login screen");
         System.out.println(" 0. Quit");
         System.out.print("\nPlease enter a number: ");

         try {
            menu = string.nextLine();
         } catch (NumberFormatException e)
         {
            System.out.println("\nPlease enter a number, try again.");
            patientMainMenuEn(profile);
         }

         switch (menu)
         {

            case "1":
               System.out.println("\nYour current profile details: ");
               profile.printEn();
               break;
            case "2":
               profile.printMedicineEn(profile);
               break;
            case "3":
               profile.printMeetpuntEn();
               break;
            case "4":
               patientEditMenuEn(profile);
               break;
            case "5":
               patientMainMenuEn(profile);
               break;
            case "6":
               login();
               break;

            case "0":
               System.out.println("Goodbye!");
               System.exit(0);
               break;

            default:
               System.out.println("\nPlease enter a number, try again.");
         }
      } while (!quit);
   }

   //Patiëntmenu; menukeuze gegevens te bewerken
   private void patientEditMenuEn(Profile profile)
   {
      do
      {
         System.out.printf("%Welcome %s.%nWhat would you like to do?%n%n", profile.getFirstname());
         System.out.println(" 1. Edit firstname");
         System.out.println(" 2. Edit lastname");
         System.out.println(" 3. Edit age");
         System.out.println(" 4. Edit height");
         System.out.println(" 5. Edit weight");
         System.out.println(" 6. Edit login details");
         System.out.println(" 7. Edit all details");
         System.out.println(" 8. See profile details ");
         System.out.println(" 9. Back to mainmenu");
         System.out.println(" 0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         try {
            menu = string.nextLine();
         } catch (NumberFormatException e)
         {
            System.out.println("\nPlease enter a number, try again.");
            patientEditMenuEn(profile);
         }
         switch (menu)
         {
            case "1":
               profile.editFirstnameEn(profile);
               break;
            case "2":
               profile.editLastnameEn(profile);
               break;
            case "3":
               profile.editAgeEn(profile);
               break;
            case "4":
               profile.editLengthEn(profile);
               break;
            case "5":
               profile.editWeightEn(profile);
               break;
            case "6":
               profile.editLoginEn(profile);
               break;
            case "7":
               profile.editProfileAllEn(profile);
               break;
            case "8":
               profile.printEn();
            case "9":
               patientMainMenuEn(profile);
               break;
            case "0":
               System.out.println("Goodbye!");
               System.exit(0);
               break;
            default:
               System.out.println("\nPlease enter a number, try again.");
         }
      } while (!quit);

   }

   //Zorgverlenermenu; hoofdmenu
   private void zorgverlenerMainMenuEn(Profile profile)
   {
      do
      {
         System.out.println("\nWelcome " + profile.getFirstname() + ", what would you like to do? \n");

         System.out.println("1. Show a list of patients");
         System.out.println("2. Add patient to system");
         System.out.println("3. Edit patient from system");
         System.out.println("4. Show a list of medicine available");
         System.out.println("5. Add mediccine to system");
         System.out.println("6. Edit medicine from system");
         System.out.println("7. Change language to Dutch");
         System.out.println("8. Back to login screen");
         System.out.println("0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         try {
            menu = string.nextLine();
         } catch (NumberFormatException e)
         {
            System.out.println("\nPlease enter a number, try again.");
            zorgverlenerMainMenuEn(profile);
         }

         switch (menu)
         {
            case "1":
               profileList.printEn();
               break;
            case "2":
               addPatientEn(profile);
               break;
            case "3":
               Profile patient = choosePatient();
               chooseEditPatientEn(profile, patient);
               break;
            case "4":
               medicineList.printMedicineEn();
               break;
            case "5":
               addMedicineSystemEn(profile);
               break;
            case "6":
               editMedicineSystemEn(profile);
               break;
            case "7":
               zorgverlenerMainMenu(profile);
               break;
            case "8":
               login();
               break;
            case "0":
               System.exit(0);
               System.out.println("\nGoodbye!");
               break;

            default:
               System.out.println("\nPlease enter a number, try again.");
         }
      } while (!quit);
   }

   //Zorgverlener; extra handelingen met patiënt toevoegen
   private void addPatientEn(Profile profile)
   {
      Profile patient = new Profile('p', "", "", "", "", 0, 0, 0, 0);
      patient.addPatient(patient);

      while (!isValid) //controle ingevoerde gegevens correct?
      {
         System.out.printf("%nAre you sure you want to add this patient to the system?%nType yes or no: ");
         input = string.nextLine().toLowerCase().trim();

         if (input.equalsIgnoreCase("yes"))
         {
            profileList.add(patient);
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

      while (!isValid) //wil je nieuwe patiëntenlijst zien?
      {
         System.out.printf("%nWould you like to see a new list of patients?%nType yes or no: ");
         input = string.nextLine().toLowerCase().trim();

         if (input.equalsIgnoreCase("yes"))
         {
            profileList.print();
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

      while (!isValid) //wil je nog een patiënt toevoegen?
      {
         System.out.printf("%nWould you like to add another patient?%nType yes or no: ");
         input = string.nextLine().toLowerCase().trim();

         if (input.equalsIgnoreCase("yes"))
         {
            addPatient(profile);
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

   //Zorgverlener; menukeuze patiënt kiezen
   private Profile choosePatientEn()
   {
      Profile patient = null;
      profileList.print();
      System.out.print("\nEnter the number of a patient: ");
      do
      {
         if (!in.hasNextInt())
         {
            profileList.print();
            System.out.println("\nWrong input, please try again.");
            System.out.print("\nEnter the number of a patient: ");
            in.next();
         }
         else
         {
            number = in.nextInt();
            if (number > 0 && number <= profileList.size())
            {
               try
               {
                  patient = profileList.get(number);

               } catch (IndexOutOfBoundsException e)
               {
                  profileList.print();
                  System.out.println("\nWrong input, please try again.");
                  System.out.print("\nEnter the number of a patient: ");
               }
            }
            else
            {
               profileList.print();
               System.out.println("\nWrong input, please try again.");
               System.out.print("\nEnter the number of a patient: ");
            }
         }
      }while (patient == null);
      return patient;
   }

   //Zorgverlenermenu; menukeuze kiezen wat je wilt doen
   private Profile chooseEditPatientEn(Profile profile, Profile patient)
   {
      do
      {
         System.out.printf("%nThese are the details of: %s %s. What would you like to do? %n%n", patient.getFirstname(), patient.getLastname());
         System.out.println("1. Edit patient profile details ");
         System.out.println("2. Edit patient medicine details");
         System.out.println("3. Edit patient measurement details");
         System.out.println("4. Show all details");
         System.out.println("5. Remove this patient");
         System.out.println("6. Back to mainmenu");
         System.out.println("0. Quit");
         System.out.print("\nPlease enter a number: ");

         try {
            menu = string.nextLine();
         } catch (NumberFormatException e)
         {
            System.out.println("\nPlease enter a number, try again.");
            chooseEditPatientEn(profile, patient);
         }

         switch (menu)
         {
            case "1":
               editPatientDataEn(profile, patient);
               break;
            case "2":
               editPatientMedicineEn(profile, patient);
               break;
            case "3":
               editPatientWeightMeasureEn(profile, patient);
               break;
            case "4":
               System.out.println("\nThese are the details of: \n");
               patient.printEn();
               patient.printMedicineEn(patient);
               patient.printMeetpuntEn();
               break;
            case "5":
               while (!isValid) //Wil je deze patiënt echt verwijderen
               {
                  System.out.println("\nPatient: \n");
                  patient.print();
                  System.out.printf("%nAre you sure you want to remove this patient from the system?%nThis will bring you back to mainmenu.%n%nType yes or no: ");
                  input = string.nextLine().toLowerCase().trim();

                  if (input.equalsIgnoreCase("yes"))
                  {
                     profileList.remove(patient);
                     zorgverlenerMainMenuEn(profile);
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
               break;
            case "6":
               zorgverlenerMainMenuEn(profile);
               break;
            case "0":
               System.out.println("Goodbye!");
               System.exit(0);
               break;

            default:
               System.out.println("\nPlease enter a number, try again.");
         }
      } while (!quit);
      return profile;
   }

   //Zorgverlenermenu; menukeuze patiënt gegevens bewerken
   private Profile editPatientDataEn(Profile profile, Profile patient)
   {
      do
      {
         System.out.printf("%nThese are the details from: %s %s, what would you like to do? %n%n", patient.getFirstname(), patient.getLastname());
         System.out.println(" 1. Edit firstname ");
         System.out.println(" 2. Edit lastname ");
         System.out.println(" 3. Edit age ");
         System.out.println(" 4. Edit height ");
         System.out.println(" 5. Edit weight ");
         System.out.println(" 6. Edit login details");
         System.out.println(" 7. Edit all");
         System.out.println(" 8. See patient details");
         System.out.println(" 9. Go back");
         System.out.println(" 0. Quit");
         System.out.print("\nPlease enter a number: ");

         try {
            menu = string.nextLine();

         } catch (NumberFormatException e)
         {
            System.out.println("\nPlease enter a number, try again.");
            patientEditMenuEn(patient);
         }
         switch (menu)
         {
            case "1":
               patient.editFirstnameEn(patient);
               break;
            case "2":
               patient.editLastnameEn(patient);
               break;
            case "3":
               patient.editAgeEn(patient);
               break;
            case "4":
               patient.editLengthEn(patient);
               break;
            case "5":
               patient.editWeightEn(patient);
               break;
            case "6":
               patient.editLoginEn(patient);
               break;
            case "7":
               patient.addPatientEn(patient);
               break;
            case "8":
               System.out.println("\nPatient details: ");
               patient.printEn();
               break;
            case "9":
               chooseEditPatientEn(profile, patient);
               break;
            case "0":
               System.out.println("Goodbye!");
               System.exit(0);
               break;
            default:
               System.out.println("\nPlease enter a number, try again.");
         }
      } while (!quit);

      return profile;
   }

   //Zorgverlenermenu; menukeuze patiënt medicijnen bewerken
   private Profile editPatientMedicineEn(Profile profile, Profile patient)
   {
      do
      {
         System.out.printf("%nThese are the medicines of: %s %s, what would you like to do? %n%n", patient.getFirstname(), patient.getLastname());
         System.out.println("1. Add medicine ");
         System.out.println("2. Remove medicine");
         System.out.println("3. See all medicine of patient");
         System.out.println("4. Edit medicine name and kind");
         System.out.println("5. Edit medicine dosage");
         System.out.println("6. Edit medicine memo");
         System.out.println("7. Go back");
         System.out.println("0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         try {
            menu = string.nextLine();
         } catch (NumberFormatException e)
         {
            System.out.println("\nPlease enter a number, try again.");
            editPatientMedicineEn(profile, patient);
         }

         switch (menu)
         {
            case "1":
               Medicine chosenMedicine = chooseMedicine();
               patient.addMedicineEn(patient, chosenMedicine);
               break;
            case "2":
               patient.removeMedicineEn(patient);
               break;
            case "3":
               patient.printMedicineEn(patient);
               break;
            case "4":
               patient.editMedicineNameEn(patient);
               break;
            case "5":
               patient.editMedicineDosageEn(patient);
               break;
            case "6":
               patient.editMedicineMemoEn(patient);
               break;
            case "7":
               chooseEditPatientEn(profile, patient);
               break;
            case "0":
               System.out.println("Goodbye!");
               System.exit(0);
               break;

            default:
               System.out.println("\nPlease enter a number, try again.");
         }
      } while (!quit);
      return patient;
   }

   //Zorgverlenermenu; menukeuze patiënt gewicht meet punt bewerken
   private Profile editPatientWeightMeasureEn(Profile profile, Profile patient)
   {
      do
      {
         System.out.printf("%nThese are the measurements of: %s %s, what would you like to do? %n%n", patient.getFirstname(), patient.getLastname());
         System.out.println("1. List of measurements");
         System.out.println("2. Add measurement ");
         System.out.println("3. Edit measurement");
         System.out.println("4. Remove measurement");
         System.out.println("5. Go back");
         System.out.println("0. Quit");
         System.out.print("\nPlease enter a number: ");

         try {
            menu = string.nextLine();
         } catch (NumberFormatException e)
         {
            System.out.println("\nPlease enter a number, try again.");
            editPatientWeightMeasureEn(profile, patient);
         }

         switch (menu)
         {
            case "1":
               patient.printMeetpuntEn();
               break;
            case "2":
               patient.addMeetpuntEn(patient);
               break;
            case "3":
               patient.editMeetpuntEn(patient);
               break;
            case "4":
               patient.removeMeetpuntEn(patient);
               break;
            case "5":
               chooseEditPatientEn(profile, patient);
               break;
            case "0":
               System.out.println("Goodbye!");
               System.exit(0);
               break;

            default:
               System.out.println("\nPlease enter a number, try again.");
         }
      } while (!quit);
      return patient;
   }

   //Methodes omtrend de grote medicijnenlijst
   private void addMedicineSystemEn(Profile profile) //Zorgverlener; extra handelingen met medicijn toevoegen
   {
      Medicine newMedicine = new Medicine("", "", "", "", "");
      newMedicine.addMedicine(newMedicine);

      while (!isValid) //controle ingevoerde gegevens correct?
      {
         System.out.printf("%nAre you sure you want to add this medicine to the system?%nType yes or no: ");
         input = string.nextLine().toLowerCase().trim();

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
            System.out.print("\nWrong input, please try again.\n");
         }
      }

      while (!isValid) //wil je nieuwe medicijnenlijst zien?
      {
         System.out.printf("%nDo you want to see a new list of all medicines?%nType yes or no: ");
         input = string.nextLine().toLowerCase().trim();

         if (input.equalsIgnoreCase("yes"))
         {
            medicineList.printMedicineEn();
            break;
         }
         else if (input.equalsIgnoreCase("no"))
         {
            break;
         }
         else
         {
            System.out.print("\nWrong input, please try again.\n");
         }
      }

      while (!isValid) //wil je nog een medicijn toevoegen?
      {
         System.out.printf("%nDo you want to add another medicine?%nType yes or no: ");
         input = string.nextLine().toLowerCase().trim();

         if (input.equalsIgnoreCase("yes"))
         {
            addMedicineSystemEn(profile);
            break;
         }
         else if (input.equalsIgnoreCase("no"))
         {
            break;
         }
         else
         {
            System.out.print("\nWrong input, please try again.\n");
         }
      }

   }

   private Medicine chooseMedicineEn() //Medicijn kiezen van systeem
   {
      Medicine chosenMedicine = null;
      medicineList.printMedicineEn();
      System.out.print("\nPlease enter the number of the medicine of your choice: ");
      do
      {
         if (!in.hasNextInt())
         {
            medicineList.printMedicineEn();
            System.out.print("\nWrong input, please try again.\n");
            System.out.print("\nPlease enter the number of the medicine of your choice: ");
            in.next();
         }
         else
         {
            number = in.nextInt();
            if (number >= 0 && number <= medicineList.size())
            {
               try
               {
                  chosenMedicine = medicineList.get(number -1);

               } catch (IndexOutOfBoundsException e)
               {
                  medicineList.printMedicineEn();
                  System.out.print("\nWrong input, please try again.\n");
                  System.out.print("\nPlease enter the number of the medicine of your choice: ");
               }
            }
            else
            {
               medicineList.printMedicineEn();
               System.out.print("\nWrong input, please try again.\n");
               System.out.print("\nPlease enter the number of the medicine of your choice: ");
            }
         }
      }  while (chosenMedicine == null);

      return chosenMedicine;
   }

   private void editMedicineSystemEn(Profile profile) //Medicijn bewerken van systeem
   {
      Medicine chosenMedicine = chooseMedicine();
      do
      {
         System.out.println("\nWhat would you like to edit of: " + chosenMedicine.getMedicineName());
         System.out.println("1. Name and kind");
         System.out.println("2. Description");
         System.out.println("3. Dosage");
         System.out.println("4. Remove");
         System.out.println("5. Go back");
         System.out.println("0. Quit");
         System.out.print("\nPlease enter a number: ");

         try
         {
            menu = string.nextLine();
         } catch (NumberFormatException e)
         {
            System.out.println("\nPlease enter a number, try again.");
            editMedicineSystemEn(profile);
         }

         switch (menu)
         {
            case "1":
               chosenMedicine.editNameEn();
               break;
            case "2":
               chosenMedicine.editDescriptionEn();
               break;
            case "3":
               chosenMedicine.editDosageEn();
               break;
            case "4":
               removeMedicine(chosenMedicine);
               zorgverlenerMainMenuEn(profile);
               break;
            case "5":
               zorgverlenerMainMenuEn(profile);
               break;
            case "0":
               System.exit(0);
               System.out.println("\nGoodbye!");
               break;
            default:
               System.out.println("\nPlease enter a number, try again.");
         }
      } while (!quit);

   }

   private void removeMedicineEn(Medicine chosenMedicine) //Medicijn verwijderen van systeem
   {
      do //Vragem of je dit medicijn echt wilt verwijderen
      {
         System.out.printf("%nYou have chosen this medicine:%n%s%n%nAre you sure you want to remove this medicine from the system?%nType yes or no: ", chosenMedicine);
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
            System.out.println("\nPlease try again.");
         }
      } while (!quit);
   }
}




