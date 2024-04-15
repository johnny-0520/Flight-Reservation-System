
import java.util.Scanner;
public class FlightReservationSystem {
    private static int seatQtys = 10;
    private static boolean[] seats = new boolean[seatQtys];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\n\t+------------------CIT AIRLLINES------------------+");
            System.out.println("\t|\t PLEASE SELECT OPERATION TO PROCEED\t  |");
            System.out.println("\t|-------------------------------------------------|");
            System.out.println("\t|\tENTER [1] TO RESERVE SEAT\t\t  |");
            System.out.println("\t|\tENTER [2] TO CANCEL RESERVATION\t\t  |");
            System.out.println("\t|\tENTER [3] TO VIEW AVAILABLE SEATS\t  |");
            System.out.println("\t|\tENTER [4] TO EXIT\t\t\t  |");
            System.out.println("\t+-------------------------------------------------+");
            System.out.print("\t \t SELECT OPERATION >>>  "+"\t  |    ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    reserveSeat();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    displaySeats();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
            }
        }
    }

    public static void reserveSeat() {
        Scanner input = new Scanner(System.in);
        displaySeats();
        System.out.println("\t+-------------------------------------------------+");
        System.out.print("\t|  SELECT SEAT NUMBER TO RESERVE >>>  "+"\t      ");
        int seatNumber = input.nextInt();
        if (seatNumber < 1 || seatNumber > seatQtys) {
            System.out.println("\t|  INVALID SEAT NUMBER, PLEASE TRY AGAIN.\t  ");
            return;
        }
        if (seats[seatNumber - 1]) {
            System.out.println("\t|  SEAT IS ALREADY RESERVED, PLEASE TRY AGAIN.\t  ");
        } else {
            seats[seatNumber - 1] = true;
            System.out.println("\t|  SEAT NUMBER ["+seatNumber+"] RESERVED SUCESSFULLY\t  ");
        }
    }

    public static void cancelReservation() {
        Scanner input = new Scanner(System.in);
        displaySeats();
        System.out.print("\t|  SELECT SEAT NUMBER TO CANCEL RESERVATION >>>  ");
        int seatNumber = input.nextInt();
        if (seatNumber < 1 || seatNumber > seatQtys) {
            System.out.println("\t+-------------------------------------------------+");
            System.out.println("\t|  INVALID SEAT NUMBER, PLEASE TRY AGAIN.\t  ");
            return;
        }
        if (!seats[seatNumber - 1]) {
            System.out.println("\t+-------------------------------------------------+");
            System.out.println("\t|  SEAT NOT RESERVED, PLEASE TRY ANOTHER SEAT.\t  ");
        } else {
            seats[seatNumber - 1] = false;
            System.out.println("\t+-------------------------------------------------+");
            System.out.println("\n\t|  CANCELATION OF RESERVATION FOR SEAT NUMBER ["+seatNumber+"] SUCESSFUL.\t  ");
        }
    }
    public static void displaySeats() {
        System.out.println("\n\t+-------------------------------------------------+");
        System.out.println("\t|\t   CURRENT AVAILABLE SEAT   \t\t  |");
        System.out.println("\t+-------------------------------------------------+");
        for (int i = 0; i < seatQtys; i++) {
            if (seats[i]) {
                System.out.println("\t|  "+(i+1) + "\t  RESERVED\t|");
            } else {
                System.out.println("\t|  "+(i+1) + "\t  AVAILABLE\t|");
            }
            if ((i+1) % 10 == 0) {
                System.out.println();
            }
        }
    }

}
