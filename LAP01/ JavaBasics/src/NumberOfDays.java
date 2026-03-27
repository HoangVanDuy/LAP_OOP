
import java.util.Scanner;

public class NumberOfDays {
    public static void numberofday(String month, int year) {
        switch (month) {
            case "1":
            case "January":
            case "Jan.":
            case "Jan":
            case "3":
            case "March":
            case "Mar.":
            case "Mar":
            case "5":
            case "May":
            case "7":
            case "July":
            case "Jul":
            case "8":
            case "August":
            case "Aug.":
            case "Aug":
            case "10":
            case "October":
            case "Oct.":
            case "Oct":
            case "12":
            case "December":
            case "Dec.":
            case "Dec":
                System.out.println("31 day");
                break;
            case "4":
            case "April":
            case "Apr.":
            case "Apr":
            case "6":
            case "June":
            case "Jun":
            case "9":
            case "September":
            case "Sept.":
            case "Sep":
            case "11":
            case "November":
            case "Nov.":
            case "Nov":
                System.out.println("30 day");
                break;
            case "2":
            case "February":
            case "Feb.":
            case "Feb":
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    System.out.println("29 day");
                    break;
                } else
                    System.out.println("28 day");
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String month;
        int year;
        int option;
        do {
            do {
                System.out.println("Enter both month :");
                month = sc.nextLine();
                System.out.println("Enter both year :");
                year = sc.nextInt();
                sc.nextLine();
                if (year <= 0) {
                    System.out.println("Your year is invalid !");
                }
            } while (year <= 0);
            numberofday(month, year);
            System.out.println("Do you want to continue ? ( Enter 1 to continue)");
            option = sc.nextInt();

            sc.nextLine();
        } while (option == 1);
        System.exit(0);
        sc.close();
    }
}
