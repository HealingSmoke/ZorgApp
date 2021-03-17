import java.util.Locale;
import java.util.Scanner;

public class ZorgApp
{
   //attributen
   private String userName;
   private String passWord;
   private Profile profile;
   private Profile patient;
   private Medicine medicine;

   private ProfileList profileList = new ProfileList();
   private MedicineList medicineList = new MedicineList();

   boolean quit = false; //voor alle switchmenu's
   int menuItem; // voor alle switchmenu's
   Scanner in = new Scanner(System.in); // voor alle switchmenu's

   //cconstructor
   public ZorgApp()
   {
      Locale.setDefault(Locale.ENGLISH);

      Profile profile = new Profile('z', "z1", "1234", "Zorgverlener", "Adriaan");
      profileList.addProfile(profile);
      profile = new Profile('p',"p1", "4567", "Amanda", "Schoonhoven", 29, 51.4, 1.68, 21);
      profileList.addProfile(profile);
      profile = new Profile('p', "p2", "7899", "Anna", "Moonlight", 44, 68.4, 1.72, 24);
      profileList.addProfile(profile);
      profile = new Profile('p', "p3", "1123", "Bernard", "Houten", 58, 85.8, 1.78, 21);
      profileList.addProfile(profile);
      profile = new Profile('p', "p4", "2254", "Chris", "Penrose", 32, 68.4, 1.72, 28);
      profileList.addProfile(profile);
      profile = new Profile('p', "p5", "4545", "Niels", "Schoonhoven", 33, 82.4, 1.85, 25);
      profileList.addProfile(profile);
      profile = new Profile('p', "p6", "8445", "Rick", "Schuiten", 24, 78.4, 1.72, 28);
      profileList.addProfile(profile);

      Medicine medicine = new Medicine("Diclofenac","niet-steroïde anti-inflammatoire (ontstekingswerende) geneesmiddelen (NSAID's)", "Diclofenac wordt gebruikt voor de bestrijding van pijn en de vermindering van koorts. Het pijnstillende effect van diclofenac start een half uur tot een uur na inname. Dit effect houdt ongeveer zes uur aan.","100-200 mg per dag.");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Amoxicilline","antibioticum","Amoxicilline is een bacteriedodend middel, het wordt toegepast bij de behandeling van infecties veroorzaakt door grampositieve en negatieve bacteriën. Hierdoor is het een antibioticum dat kan worden ingezet tegen een zeer breed spectrum van verschillende bacteriën.","Twee maal daags 500 tot 750 mg of drie maal daags 375-500mg per dag");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Omeprazol","niet-steroïde anti-inflammatoire (ontstekingswerende) geneesmiddelen (NSAID's)","Omeprazol beschermt het slijmvlies tegen een te zuur maagmilieu. Omeprazol is overigens niet geschikt voor de snelle verlichting van de gevolgen van brandend maagzuur. Omeprazol dient meestal kort voor de maaltijd te worden ingenomen. De maagsapresistente tablet dient in zijn geheel ingeslikt te worden, zonder te kauwen. Om het inslikken te vergemakkelijken kan de pil samen met een lepel appelmoes worden ingeslikt. Verbetering van de symptomen na het starten met omeprazol treedt meestal na ongeveer 2 tot 3 dagen op. De meeste patiënten zijn na ongeveer 7 dagen verlost van hun brandend maagzuur. Men dient de behandeling te stoppen wanneer de symptomen volledig zijn verdwenen.","20 tot 40 mg gedurende 14 dagen.");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Doxycycline","antibioticum","Doxycycline is een antibioticum met een lange halfwaardetijd (ongeveer 16 tot 22 uur). Wanneer de doxycycline oraal wordt ingenomen dient dit te gebeuren in een staande of zittende houding met een ruime hoeveelheid melk of water. Bij voorkeur niet vlak voor de nachtrust. Oplosbare tabletten kunnen worden opgelost water door middel van goed roeren. Na inname het glas nogmaals aanvullen om zo het achtergebleven medicijn weer op te lossen en vervolgens ook deze oplossing opdrinken.","Bij orale toepassing moet worden begonnen met 200mg in 1 gift op de eerste dag. Dit zijn dus twee tabletten van 100mg. Dit geldt voor volwassenen en kinderen vanaf 50 kg. Voor kinderen vanaf 8 jaar die lichter dan 50 kilo zijn, de eerste dag 4 mg/kg gevolgd door 2 mg/kg per dag. Toediening dient altijd eenmaal per dag plaats te vinden. Voor volwassenen geldt bij ernstige infecties: 200mg p/d en voor kinderen 4 mg/kg p/d. De typische duur van een kuur is zeven tot tien dagen, afhankelijk van wat uw arts u voorschrijft.");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Ibuprofen","niet-steroïde anti-inflammatoire (ontstekingswerende) geneesmiddelen (NSAID's)","In lagere doses (200-400 mg voor volwassenen) verlicht Ibuprofen de pijn en vermindert het koorts, in hogere doseringen (800 mg voor volwassenen) heeft het ook ook anti-inflammatoire. Uitscheiding en afbraak van ibuprofen gebeurd voor ongeveer tweederde door de nieren en voor eenderde door afbraak door de lever. ","Maximaal 1200 mg per dag.");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Oxazepam","benzodiazepinen","Oxazepam wordt voorgeschreven om gevoelens van angst, zenuwen en spanning te behandelen. Het middel wordt ook gebruikt bij de behandeling van patiënten die afkicken van overmatig alcoholgebruik. Het vermindert namelijk de afkickverschijnselen. Oxazepam wordt oraal ingenomen en is verkrijgbaar in capsules of als tabletten. Het medicijn kan tijdens het eten worden ingenomen om de bijwerkingen op het spijsverteringsstelsel te verminderen.","De aanbevolen startdosering voor volwassen personen varieert van 5 tot 15 mg per dag. De dosering wordt soms verhoogd door de arts, maar 80 mg is de maximale voorgeschreven dagelijkse dosering. Aangeraden wordt om twee maal daags een dosis te nemen.");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Naproxen","niet-steroïde anti-inflammatoire (ontstekingswerende) geneesmiddelen (NSAID's","Naproxen is een ontstekingsremmende pijnstiller. Het is te gebruiken bij pijn waarbij ook sprake is van een ontsteking, zoals bij gewrichtspijn. ","375 tot 750 mg per dag verdeeld over twee doses.");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Diazepam","benzodiazepinen","Artsen schrijven het voor bij angstgevoelens en gespannenheid, paniekstoornissen, slapeloosheid, alcoholontwenning, spierkrampen, epilepsie en onrust. Het werkt rustgevend, spierontspannend, vermindert angstgevoelens en beïnvloedt de overdracht van elektrische prikkels in de hersenen.","Tot 15 mg per dag");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Paracetamol","pijnstiller","Paracetamol werkt pijnstillend en koortsverlagend. Het is te gebruiken bij verschillende soorten pijn zoals, hoofdpijn, migraine, koorts, griep, verkoudheid, keelpijn, bijholteontsteking, middenoorontsteking, oorpijn door gehoorgangontsteking, artrose, spierpijn, gewrichtspijn en menstruatieklachten.","Volwassenen mogen bij kortdurend gebruik 3 tot 4 keer per dag 1 tot 2 tabletten van 500 mg paracetamol gebruiken (niet langer dan 4 weken achter elkaar). Let op: Bij langdurig gebruik (langer dan 4 weken) mag u niet meer dan 5 keer per dag 1 tablet (geen 2) van 500 mg paracetamol gebruiken.");
      medicineList.addMedicine(medicine);
      medicine = new Medicine("Metronidazol","antibioticum","Metronidazol doodt bepaalde bacteriën en eencellige parasieten, zoals amoeben. Artsen schrijven het meestal voor bij infecties van het maagdarmkanaal met diarree.","Oraal: Volwassenen: 1000 mg per dag, in 1 giften, voor 7 dagen Adolescenten: 2x 400 mg per dag voor 5-7 dagen, of 2000 mg als enkele dosis. Gynaecologische ingrepen: 1 g Metronidazol Aurobindo als eenmalige gift, gevolgd door 500 mg 3 maal daags tot voor de operatie niet meer mag worden gegeten.");
      medicineList.addMedicine(medicine);

   }

   //getters & setters
   public Profile getPatient()
   {
      return patient;
   }

   public void setPatient(Profile patient)
   {
      this.patient = patient;
   }

   public Profile Login()
      {
      Profile profile = null;

      System.out.println("Wat is uw gebruikersnaam: ");
      userName = in.nextLine();
      System.out.println("Wat is uw wachtwoord: ");
      passWord = in.nextLine();

      for (int i = 0; i < profileList.sizeOf(); i++)
      {
         if (profileList.get(i).getUsername().equals(userName))
         {
            if (profileList.get(i).getPassword().equals(passWord))
            {
               profile = profileList.get(i);

            }
         }
      }
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
         System.out.println("12. Terug naar het loginscherm");
         System.out.println(" 0. Quit");
         System.out.print("\nGeef het getal van uw keuze: ");

         menuItem = in.nextInt();
         switch (menuItem)
         {

            case 1:
               profile.PrintProfileAlles();
               break;
            case 2:
               //medicine.PrintMedicine();
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


   //Zorgverlener gedeelte alle zorgverlener onderdelen uiteindelijk in extended class?
   public boolean ZorgverlenerMenu(Profile profile)
   {
      Profile patient = new Profile();
      patient = null;

   do
      {
         System.out.println("\nWelkom " + profile.getVoorNaam() + ", wat wilt u graag doen? \n");

         System.out.println("1. Om terug te gaan");
         System.out.println("2. Patiënt bewerken uit het systeem");
         System.out.println("3. Patiënt toevoegen in het systeem");
         System.out.println("4. Patiënt verwijderen uit het systeem");
         System.out.println("5. Medicijn toevoegen in het systeem");
         System.out.println("6. Medicijn verwijderen uit het systeem");
         System.out.println("7. Alle medicijnen weergeven");
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
               //choosePatient();
               //EditPatient(patient);
               break;
            case 3:
               patient.EditPatientAlles(profile);
               profileList.addProfile(patient);
               //vragen of je er nog een wilt toevoegen en of je patiëntenlijst wilt weergeven
               break;
            case 4:
               profileList.removeProfile(patient);
               break;
            case 5:
               addMedicine();
               break;
            case 6:
               removeMedicine();
               break;
            case 7:
               medicineList.PrintMedicineList();
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


   private void removeMedicine()
   {

   }

   private void addMedicine()
   {
   }

   private void removePatient()
   {

   }


   private void choosePatient()
   {
   }


   private boolean EditPatient(Profile patient)
   {
      do
      {
         System.out.printf("\nDit zijn de gegevens van: %s %s,\n wat wilt u graag doen? \n", patient.getVoorNaam(), patient.getAchterNaam());
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
               patient.PrintProfileAlles();
               break;
            case 2:
               //patient.PrintProfileMedicine();
               break;
            case 3:
               patient.EditProfileAlles(patient);
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
               patient.addMedicine();
               break;

            case 13:
               patient.removeMedicine();
               break;

            case 14:
               patient.GewichtMeetPunt();
               break;

            case 15:
               patient.removeProfile();
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
      return quit;
   }


   @Override
   public String toString()
   {
      return "ZorgAp profiel: " + profile + "\nprofileList: " + profileList + "\n";
   }


}




