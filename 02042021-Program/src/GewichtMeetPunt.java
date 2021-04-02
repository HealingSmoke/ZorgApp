import java.util.Locale;
import java.util.Scanner;

public class GewichtMeetPunt
{
   //attributen
   private int day;
   private int month;
   private int year;
   private String time;
   private int hour;
   private int minute;
   private double weight;
   private boolean isValid;

   Scanner in = new Scanner(System.in);

   //constructor
   GewichtMeetPunt(int day, int month, int year, String time, double weight)
   {
      this.day = day;
      this.month = month;
      this.year = year;
      this.time = time;
      this.weight = weight;
   }

   //getters & setters
   public void setTime(String time)
   {
      this.time = time;
   }

   public void setWeight(double weight)
   {
      this.weight = weight;
   }

   public int getDay()
   {
      return day;
   }

   public void setDay(int day)
   {
      this.day = day;
   }

   public int getMonth()
   {
      return month;
   }

   public void setMonth(int month)
   {
      this.month = month;
   }

   public int getYear()
   {
      return year;
   }

   public void setYear(int year)
   {
      this.year = year;
   }

   public void editDate()
   {
      isValid = false;
      System.out.println("\nWat is de datum voor dit meet punt?\nGeef het weer als JJJJ MM DD, druk enter om een getal te bevestigen.");
      System.out.print("\nWat is het jaar voor dit meet punt: ");
      while (!isValid)//jaar invoer met controle op cijfer invoer van 4 cijfers
      {
         if (!in.hasNextInt())
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in van 4 cijfers.");
            System.out.print("\nWat is het jaar voor dit meet punt: ");
            in.next();

         }
         else
         {
            year = in.nextInt();
            if (year > 1900 && year < 2100)
            {
               setYear(year);
               break;
            }
            else
            {
               System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in van 4 cijfers.");
               System.out.print("\nWat is het jaar voor dit meet punt: ");
               in.next();

            }
         }
      }

      while (!isValid)//maand invoer met controle op cijfer invoer van 1 tot 12
      {
         System.out.print("Wat is de maand voor dit meet punt: ");
         if (!in.hasNextInt())
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in tussen de 1 en 12.\n");
            System.out.print("Wat is de maand voor dit meet punt: ");
            in.next();
         }
         else
         {
            month = in.nextInt();
            if (month > 0 && month <= 12)
            {
               setMonth(month);
               break;
            }
            else
            {
               System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in tussen de 1 en 12.\n");
               System.out.print("Wat is de maand voor dit meet punt: ");
               in.next();
            }
         }
      }

      while (!isValid)//dag invoeren met controle op cijfer invoer van 1 tot 31
      {
         System.out.print("Wat is de dag voor dit meet punt: ");
         if (!in.hasNextInt())
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in tussen de 1 en 31.\n");
            System.out.print("Wat is de dag voor dit meet punt: ");
            in.next();
         }
         else
         {
            day = in.nextInt();
            if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12))
            {
               if (day > 0 && day <= 31)
               {
                  setDay(day);
                  break;
               }
               else
               {
                  System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in tussen de 1 en 31.\n");
                  System.out.print("Wat is de dag voor dit meet punt: ");
                  in.next();
               }
            }
            else if (month == 2)
            {
               if (day > 0 && day <= 28)
               {
                  setDay(day);
                  break;
               }
               else
               {
                  System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in tussen de 1 en 28.\n");
                  System.out.print("Wat is de dag voor dit meet punt: ");
                  in.next();
               }
            }
            else if ((month == 4) || (month == 6) || (month == 9) || (month == 11))
            {
               if (day > 0 && day <= 30)
               {
                  setDay(day);
                  break;
               }
               else
               {
                  System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in tussen de 1 en 30.\n");
                  System.out.print("Wat is de dag voor dit meet punt: ");
                  in.next();
               }
            }
         }
      }

      System.out.printf("%nOpgeslagen datum: %d-%d-%d%n", day, month, year);
   }

   public void editTime()
   {
      isValid = false;
      System.out.println("\nWat is het tijdstip voor dit meet punt?\nGeef weer als HH MM, druk enter om een getal te bevestigen.");

      while (!isValid)//uur invoeren met controle op cijfer invoer van 0 tot 23
      {
         if (!in.hasNextInt())
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in tussen de 0 en 23.");
            System.out.println("\nWat is het tijdstip voor dit meet punt?\n Geef weer als HH MM, druk enter om een getal te bevestigen.");
            isValid = false;
            in.next();
         }
         else
         {
            hour = in.nextInt();
            if (hour >= 0 && hour <= 23)
            {
               System.out.print(hour + ":");
               isValid = true;
            }
            else
            {
               System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in tussen de 0 en 23.");
               System.out.println("\nWat is het tijdstip voor dit meet punt?\n Geef weer als HH MM, druk enter om een getal te bevestigen.");
               isValid = false;
            }
         }
      }

      while (isValid)//minuten invoeren met controle op cijfer invoer van 0 tot 59
      {
         if (!in.hasNextInt())
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in tussen de 1 en 60.\n");
            System.out.println("\nWat is het tijdstip voor dit meet punt?\n Geef weer als HH MM, druk enter om een getal te bevestigen.");
            isValid = true;
            System.out.print(hour + ":");
            in.next();
         }
         else
         {
            minute = in.nextInt();
            if (minute >= 0 && minute <= 59)
            {
               System.out.print("Opgeslagen tijdstip: " + hour + ":" + minute + "\n");
               isValid = false;
            }
            else
            {
               System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in tussen de 1 en 60.\n");
               System.out.println("\nWat is het tijdstip voor dit meet punt?\n Geef weer als HH MM, druk enter om een getal te bevestigen.");
               System.out.print(hour + ":");
               isValid = true;
            }
         }
      }

      if (hour >= 0 && hour <= 9)
      {
         if (minute >= 0 && minute <=9)
         {
            setTime("0" + hour + ":0" + minute);
         }
         else
         {
            setTime("0" + hour + ":" + minute);
         }
      }
      else
      {
         if (minute >= 0 && minute <=9)
         {
            setTime(hour + ":0" + minute);
         }
         else
         {
            setTime(hour + ":" + minute);
         }
      }
   }

   public void editWeight()
   {
      in.useLocale(Locale.GERMANY);

      while (!isValid)
      {
         System.out.print("\nWelk gewicht wilt u invoeren: ");
         if (!in.hasNextDouble())
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in.");
            isValid = false;
            in.next();
         }
         else
         {
            weight = in.nextDouble();
            if (weight > 0.1 && weight < 300)
            {
               setWeight(weight);
               isValid = true;
            }
            else
            {
               System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een positief getal in.");
               isValid = false;
            }
         }
      }
   }

   //Hieronder in het engels
   public void editDateEn()
   {
      isValid = false;
      System.out.println("\nWhat is the date for this measurement?\nGive your input like JJJJ MM DD, press enter to continue.");
      System.out.print("\nWhat is the year for this measurement: ");
      while (!isValid)//jaar invoer met controle op cijfer invoer van 4 cijfers
      {
         if (!in.hasNextInt())
         {
            System.out.println("\nWrong input, please try again.\nGive a input of 4 digits (YYYY).");
            System.out.print("\nWhat is the year for this measurement: ");
            in.next();

         }
         else
         {
            year = in.nextInt();
            if (year > 1900 && year < 2100)
            {
               setYear(year);
               break;
            }
            else
            {
               System.out.println("\nWrong input, please try again.\nGive a input of 4 digits (YYYY).");
               System.out.print("\nWhat is the year for this measurement: ");
               in.next();

            }
         }
      }

      while (!isValid)//maand invoer met controle op cijfer invoer van 1 tot 12
      {
         System.out.print("Wat is de maand voor dit meet punt: ");
         if (!in.hasNextInt())
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in tussen de 1 en 12.\n");
            System.out.print("Wat is de maand voor dit meet punt: ");
            in.next();
         }
         else
         {
            month = in.nextInt();
            if (month > 0 && month <= 12)
            {
               setMonth(month);
               break;
            }
            else
            {
               System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in tussen de 1 en 12.\n");
               System.out.print("Wat is de maand voor dit meet punt: ");
               in.next();
            }
         }
      }

      while (!isValid)//dag invoeren met controle op cijfer invoer van 1 tot 31
      {
         System.out.print("Wat is de dag voor dit meet punt: ");
         if (!in.hasNextInt())
         {
            System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in tussen de 1 en 31.\n");
            System.out.print("Wat is de dag voor dit meet punt: ");
            in.next();
         }
         else
         {
            day = in.nextInt();
            if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12))
            {
               if (day > 0 && day <= 31)
               {
                  setDay(day);
                  break;
               }
               else
               {
                  System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in tussen de 1 en 31.\n");
                  System.out.print("Wat is de dag voor dit meet punt: ");
                  in.next();
               }
            }
            else if (month == 2)
            {
               if (day > 0 && day <= 28)
               {
                  setDay(day);
                  break;
               }
               else
               {
                  System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in tussen de 1 en 28.\n");
                  System.out.print("Wat is de dag voor dit meet punt: ");
                  in.next();
               }
            }
            else if ((month == 4) || (month == 6) || (month == 9) || (month == 11))
            {
               if (day > 0 && day <= 30)
               {
                  setDay(day);
                  break;
               }
               else
               {
                  System.out.println("\nU heeft een verkeerde invoer gedaan, probeer opnieuw.\nVoer een getal in tussen de 1 en 30.\n");
                  System.out.print("Wat is de dag voor dit meet punt: ");
                  in.next();
               }
            }
         }
      }

      System.out.printf("%nOpgeslagen datum: %d-%d-%d%n", day, month, year);
   }

   public void editTimeEn()
   {
      isValid = false;
      System.out.println("\nWhat is the time for this measurement?\n Give a input like: HH MM, press enter to continue.");

      while (!isValid)//uur invoeren met controle op cijfer invoer van 0 tot 23
      {
         if (!in.hasNextInt())
         {
            System.out.println("\nWrong input, please try again.\nGive a input between 0 en 23.");
            System.out.println("\nWhat is the time for this measurement?\n Give a input like: HH MM, press enter to continue.");
            isValid = false;
            in.next();
         }
         else
         {
            hour = in.nextInt();
            if (hour >= 0 && hour <= 23)
            {
               System.out.print(hour + ":");
               isValid = true;
            }
            else
            {
               System.out.println("\nWrong input, please try again.\nGive a input between 0 en 23.");
               System.out.println("\nWhat is the time for this measurement?\n Give a input like: HH MM, press enter to continue.");
               isValid = false;
            }
         }
      }

      while (isValid)//minuten invoeren met controle op cijfer invoer van 0 tot 59
      {
         if (!in.hasNextInt())
         {
            System.out.println("\nWrong input, please try again.\nGive a input between 0 en 59.");
            System.out.println("\nWhat is the time for this measurement?\n Give a input like: HH MM, press enter to continue.");
            isValid = true;
            System.out.print(hour + ":");
            in.next();
         }
         else
         {
            minute = in.nextInt();
            if (minute >= 0 && minute <= 59)
            {
               isValid = false;
            }
            else
            {
               System.out.println("\nWrong input, please try again.\nGive a input between 0 en 59.");
               System.out.println("\nWhat is the time for this measurement?\n Give a input like: HH MM, press enter to continue.");
               System.out.print(hour + ":");
               isValid = true;
            }
         }
      }

      if (hour >= 0 && hour <= 9)
      {
         if (minute >= 0 && minute <=9)
         {
            setTime("0" + hour + ":0" + minute);
         }
         else
         {
            setTime("0" + hour + ":" + minute);
         }
      }
      else
      {
         if (minute >= 0 && minute <=9)
         {
            setTime(hour + ":0" + minute);
         }
         else
         {
            setTime(hour + ":" + minute);
         }
      }
   }

   public void editWeightEn()
   {
      in.useLocale(Locale.US);

      while (!isValid)
      {
         System.out.print("\nWhat is the weight: ");
         if (!in.hasNextDouble())
         {
            System.out.println("\nWrong input, please try again.\nFill in a positive number.");
            isValid = false;
            in.next();
         }
         else
         {
            weight = in.nextDouble();
            if (weight > 0.1 && weight < 300)
            {
               setWeight(weight);
               isValid = true;
            }
            else
            {
               System.out.println("\nWrong input, please try again.\nFill in a positive number.");
               isValid = false;
            }
         }
      }
   }




   @Override
   public String toString()
   {
      return time + "     " + weight + "     " + day + "-" + month + "-" + year ;
   }





}
