package cinema;
import java.util.Scanner;

public class Cinema {
    public static int rows = 7;
    public static int seats = 8;
    public static final int MAX_SEATS = 60;
    public static final int SMALL_ROOM_PRICE = 10;
    public static final int LARGE_ROOM_FRONT_PRICE = 10;
    public static final int LARGE_ROOM_BACK_PRICE = 8;

    public static void main(String[] args) {
        //==================================
        // printing the scheme
        //==================================
//        System.out.println("Cinema:");
//        System.out.print(" ");
//        for (int i = 1; i <= seats; i++) {
//            System.out.print(" " + i);
//        }
//        System.out.println();
//        for (int i = 1; i <= rows; i++) {
//            System.out.print(i);
//            for (int j = 1; j <= seats; j++) {
//                System.out.print(" " + "S");
//            }
//            System.out.println();
//        }

        // initialize variables commit 3
        int income = 0;
        Scanner scanner = new Scanner(System.in);

        // get number of rows and seats from a user
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();

        // calculate total income
        if (rows * seats <= MAX_SEATS) {
            income = rows * seats * SMALL_ROOM_PRICE;
        } else {
            int frontRows = rows / 2;
            int backRows = rows - frontRows;
            income = (frontRows * LARGE_ROOM_FRONT_PRICE + backRows * LARGE_ROOM_BACK_PRICE) * seats;
        }

        // print result
        System.out.println("Total income:");
        System.out.println("$" + income);
    }
}