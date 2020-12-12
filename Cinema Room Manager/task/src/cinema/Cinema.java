package cinema;
import java.util.Scanner;
import java.util.Arrays;

public class Cinema {
    public static final char ZERO = '0';
    public static final char EMPTY_SEAT = 'S';
    public static final char CHOSEN_SEAT = 'B';
    public static int rows = 7;
    public static int seats = 8;
    public static final int MAX_SEATS = 60;
    public static final int SMALL_ROOM_PRICE = 10;
    public static final int LARGE_ROOM_FRONT_PRICE = 10;
    public static final int LARGE_ROOM_BACK_PRICE = 8;

    public static void main(String[] args) {
        // initialize variables
        int income = 0;
        int rowNumber = 0;
        int seatNumber = 0;
        int ticketPrice = 0;
        int lastFrontRow = 0;
        char[][] scheme;
        Scanner scanner = new Scanner(System.in);

        // get number of rows and seats from a user
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();

        //==================================
        // initialize the seating arrangement
        //==================================
        scheme = new char[rows + 1][seats + 1];
        scheme[0][0] = ' ';
        for (int j = 1; j <= seats; j++) {
            scheme[0][j] = (char)(j + ZERO);
        }
        for (int i = 1; i <= rows; i++) {
            scheme[i][0] = (char)(i + ZERO);
        }
        for (int i = 1; i <= rows; i++) {
            Arrays.fill( scheme[i],1, seats + 1, EMPTY_SEAT);
        }
        //==================================
        // print the seating arrangement
        //==================================
        System.out.println();
        System.out.println("Cinema:");
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                System.out.print(scheme[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        //==================================
        // get a row number and a seat number
        //==================================
        System.out.println("Enter a row number:");
        rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        seatNumber = scanner.nextInt();

        scheme[rowNumber][seatNumber] = CHOSEN_SEAT;

        //==================================
        // calculate ticket price
        //==================================
        lastFrontRow = rows / 2;
        if (rows * seats <= MAX_SEATS) {
            ticketPrice = SMALL_ROOM_PRICE;
        } else if (rowNumber <= lastFrontRow){
            ticketPrice = LARGE_ROOM_FRONT_PRICE;
        } else {
            ticketPrice = LARGE_ROOM_BACK_PRICE;
        }
        System.out.println();
        System.out.println("Ticket price: $" + ticketPrice);

        //==================================
        // print the seating arrangement again
        //==================================
        System.out.println();
        System.out.println("Cinema:");
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                System.out.print(scheme[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // calculate total income
//        if (rows * seats <= MAX_SEATS) {
//            income = rows * seats * SMALL_ROOM_PRICE;
//        } else {
//            int frontRows = rows / 2;
//            int backRows = rows - frontRows;
//            income = (frontRows * LARGE_ROOM_FRONT_PRICE + backRows * LARGE_ROOM_BACK_PRICE) * seats;
//        }

        // print result
//        System.out.println("Total income:");
//        System.out.println("$" + income);
    }
}