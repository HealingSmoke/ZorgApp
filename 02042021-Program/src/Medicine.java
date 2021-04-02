import java.util.Locale;
import java.util.Scanner;

public class Medicine
{
   //attributen
   private String medicineName;
   private String soort;
   private String dosering;
   private String omschrijving;
   private String memo;
   private String input;
   private boolean isValid;

   Scanner in = new Scanner(System.in);

   //constructors
   public Medicine(String medicineName, String soort, String omschrijving, String dosering, String memo)
   {
      this.medicineName = medicineName;
      this.soort = soort;
      this.dosering = dosering;
      this.omschrijving = omschrijving;
      this.memo = memo;
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

   public String getMemo()
   {
      return memo;
   }

   public void setMemo(String memo)
   {
      this.memo = memo;
   }

   //methodes omtrend medicijnen
   //Voeg een nieuw medicijn toe
   public void addMedicine(Medicine newMedicine)
   {
      do //Naam medicijn controle op minimaal 3 karakters
      {
         System.out.println("\nWat is de naam van dit medicijn: ");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setMedicineName(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 karakters invoeren.");
            isValid = false;
         }
      }  while (!isValid);

      do //Medicijn soort; invoer van minimaal 3 karakters
      {
         System.out.println("Wat voor soort medicijn is het: ");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setSoort(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 karakters invoeren.\n");
            isValid = false;
         }
      }  while (!isValid);

      do //Omschrijving; invoer van minimaal 3 karakters
      {
         System.out.println("Wat is de omschrijving voor dit medicijn: ");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setOmschrijving(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 karakters invoeren.\n");
            isValid = false;
         }
      }  while (!isValid);

      do //Dosering; invoer van minimaal 3 karakters
      {
         System.out.println("Wat is de dosering voor dit medicijn: ");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setDosering(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 karakters invoeren.\n");
            isValid = false;
         }
      }  while (!isValid);

      System.out.print("\nIngevoerde medicijn: \n");
      print(newMedicine);
   }

   //Memo toevoegen aan medicijn
   public void addMemo()
   {
      do //Memo toevoegen; invoer van minimaal 3 karakters
      {
         System.out.println("\nWat is de memo die u wilt toevoegen:");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setMemo(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 karakters invoeren.");
            isValid = false;
         }
      }  while (!isValid);

      System.out.println("\nOpgeslagen memo: \n" + getMemo());
   }

   //Bewerk medicijn naam en soort
   public void editName()
   {
      do //Naam medicijn controle op minimaal 3 karakters
      {
         System.out.println("\nGekozen medicijn naam: \n" + getMedicineName());
         System.out.println("\nWat is de naam van dit medicijn: ");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setMedicineName(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 karakters invoeren.");
            isValid = false;
         }
      }  while (!isValid);

      do //Medicijn soort; invoer van minimaal 3 karakters
      {
         System.out.println("\nGekozen medicijn soort: \n" + getSoort());
         System.out.println("\nWat voor soort medicijn is het: ");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setSoort(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 karakters invoeren.\n");
            isValid = false;
         }
      }  while (!isValid);

      System.out.println("\nOpgeslagen naam: " + getMedicineName());
      System.out.println("Opgeslagen soort: " + getSoort());
   }

   //Bewerk medicijn omschrijving
   public void editDescription()
   {
      do //Omschrijving; invoer van minimaal 3 karakters
      {
         System.out.println("\nGekozen medicijn omschrijving: \n" + getOmschrijving());
         System.out.println("\nWat is de omschrijving voor dit medicijn: ");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setOmschrijving(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 karakters invoeren.");
            isValid = false;
         }
      }  while (!isValid);

      System.out.println("\nOpgeslagen omschrijving: \n" + getOmschrijving());
   }

   //Bewerk medicijn dosering
   public void editDosage()
   {
      do //Dosering; invoer van minimaal 3 karakters
      {
         System.out.println("\nGekozen medicijn dosering: \n" + getDosering());
         System.out.println("\nWat is de dosering voor dit medicijn: ");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setDosering(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nMinimaal 3 karakters invoeren.");
            isValid = false;
         }
      }  while (!isValid);

      System.out.println("\nOpgeslagen dosering: " + getDosering());
   }

   //print een medicijn
   public void print(Medicine chosenMedicine)
   {
      System.out.println("Medicijnnaam:  " + chosenMedicine.medicineName);
      System.out.println("Soort:         " + chosenMedicine.soort);
      System.out.println("Omschrijving:  " + chosenMedicine.omschrijving);
      System.out.println("Dosering:      " + chosenMedicine.dosering);
   }




   //Hieronder alles in het engels

   //methodes omtrend medicijnen
   //Voeg een nieuw medicijn toe
   public void addMedicineEn(Medicine newMedicine)
   {

      do //Naam medicijn controle op minimaal 3 karakters
      {
         System.out.println("\nWhat is the name of this medicine: ");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setMedicineName(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters.");
            isValid = false;
         }
      }  while (!isValid);

      do //Medicijn soort; invoer van minimaal 3 karakters
      {
         System.out.println("What kind of medicine is this: ");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setSoort(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters.");
            isValid = false;
         }
      }  while (!isValid);

      do //Omschrijving; invoer van minimaal 3 karakters
      {
         System.out.println("What will be the description for this medicine: ");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setOmschrijving(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters.");
            isValid = false;
         }
      }  while (!isValid);

      do //Dosering; invoer van minimaal 3 karakters
      {
         System.out.println("What will be the dosage for this medicine: ");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setDosering(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters.");
            isValid = false;
         }
      }  while (!isValid);

      System.out.print("\nMedicine saved as: \n");
      print(newMedicine);
   }

   //Memo toevoegen aan medicijn
   public void addMemoEn()
   {
      do //Memo toevoegen; invoer van minimaal 3 karakters
      {
         System.out.println("\nWhat is the memo you want to add:");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setMemo(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters.");
            isValid = false;
         }
      }  while (!isValid);

      System.out.println("\nMemo saved as: \n" + getMemo());
   }

   //Bewerk medicijn naam en soort
   public void editNameEn()
   {
      do //Naam medicijn controle op minimaal 3 karakters
      {
         System.out.println("\nCurrent name of medicine: \n" + getMedicineName());
         System.out.println("\nWhat is the name of this medicine: ");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setMedicineName(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters.");
            isValid = false;
         }
      }  while (!isValid);

      do //Medicijn soort; invoer van minimaal 3 karakters
      {
         System.out.println("\nCurrent kind of medicine: \n" + getSoort());
         System.out.println("\nWhat kind of medicine is this: ");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setSoort(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters.");
            isValid = false;
         }
      }  while (!isValid);

      System.out.println("\nName of medicine saved as: " + getMedicineName());
      System.out.println("Kind of medicine saved as: " + getSoort());
   }

   //Bewerk medicijn omschrijving
   public void editDescriptionEn()
   {
      do //Omschrijving; invoer van minimaal 3 karakters
      {
         System.out.println("\nCurrent description for medicine: \n" + getOmschrijving());
         System.out.println("\nWhat will be the description for this medicine: ");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setOmschrijving(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters.");
            isValid = false;
         }
      }  while (!isValid);

      System.out.println("\nDescription saved as: \n" + getOmschrijving());
   }

   //Bewerk medicijn dosering
   public void editDosageEn()
   {
      do //Dosering; invoer van minimaal 3 karakters
      {
         System.out.println("\nCurrent dosage for medicine: \n" + getDosering());
         System.out.println("\nWhat will be the dosage for this medicine: ");
         input = in.nextLine();
         if (input.length() > 2)
         {
            setDosering(input);
            isValid = true;
         }
         else
         {
            System.out.println("\nWrong input, please try again.\nMinimal input of 3 characters.");
            isValid = false;
         }
      }  while (!isValid);

      System.out.println("\nDosage saved as: " + getDosering());
   }

   //print een medicijn
   public void printEn(Medicine chosenMedicine)
   {
      System.out.println("Medicinename:  " + chosenMedicine.medicineName);
      System.out.println("Kind:          " + chosenMedicine.soort);
      System.out.println("Description:   " + chosenMedicine.omschrijving);
      System.out.println("Dosage:        " + chosenMedicine.dosering);
   }

   @Override
   public String toString()
   {
      return  "Medicijn:    " + medicineName + " is een " + soort + ".\nOmschrijving:   " + omschrijving + "\nDosering:       " + dosering + "\nMemo:           " + memo;
   }


}
