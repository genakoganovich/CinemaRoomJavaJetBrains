package cinema;
import java.util.Scanner;
import java.util.Arrays;

public class Cinema {
    public static final char ZERO = '0';
    public static final char EMPTY_SEAT = 'S';
    public static final char CHOSEN_SEAT = 'B';
    public static final int MAX_SEATS = 60;
    public static final int SMALL_ROOM_PRICE = 10;
    public static final int LARGE_ROOM_FRONT_PRICE = 10;
    public static final int LARGE_ROOM_BACK_PRICE = 8;
    public static int income = 0;
    public static int rows = 0;
    public static int seats = 0;
    public static int purchasedTickets = 0;
    public static char[][] scheme;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rows = getUserAnswer(scanner, "Enter the number of rows:");
        seats = getUserAnswer(scanner, "Enter the number of seats in each row:");
        scheme = createScheme(rows, seats);

        int choice = 0;
        do {
            printMenu();
            choice = scanner.nextInt();
            if (choice == 1) {
                printScheme(scheme);
            } else if (choice == 2) {
                buyTicket(scanner);
            } else if (choice == 3) {
                printStatistics();
            }
        } while (choice != 0);
    }

    public static char[][] createScheme(int rows, int seats) {
        char[][] scheme = new char[rows + 1][seats + 1];
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
        return scheme;
    }

    public static void printScheme(char[][] scheme) {
        System.out.println("Cinema:");
        for (char[] row : scheme) {
            for (char seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int getUserAnswer(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public static int calculateTicketPrice(int rows, int seats, int rowNumber) {
        int lastFrontRow = rows / 2;
        if (rows * seats <= MAX_SEATS) {
            return SMALL_ROOM_PRICE;
        } else if (rowNumber <= lastFrontRow){
            return LARGE_ROOM_FRONT_PRICE;
        } else {
            return LARGE_ROOM_BACK_PRICE;
        }
    }

    public static int calculateTotalIncome(int rows, int seats) {
        if (rows * seats <= MAX_SEATS) {
            return rows * seats * SMALL_ROOM_PRICE;
        } else {
            int frontRows = rows / 2;
            int backRows = rows - frontRows;
            return  (frontRows * LARGE_ROOM_FRONT_PRICE + backRows * LARGE_ROOM_BACK_PRICE) * seats;
        }
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void printTicketPrice(int ticketPrice) {
        System.out.println(String.format("Ticket price: $%d", ticketPrice));
    }

    public static void printTotalIncome(int income) {
        System.out.println("Total income:");
        System.out.println(String.format("$%d", income));
    }

    public static void buyTicket(Scanner scanner) {
        System.out.println();
        boolean invalidInput = true;
        int rowNumber = 0;
        int seatNumber = 0;
        while (invalidInput) {
            rowNumber = getUserAnswer(scanner, "Enter a row number:");
            seatNumber = getUserAnswer(scanner, "Enter a seat number in that row:");
            if (rowNumber < 1 || rowNumber > rows || seatNumber < 1 || seatNumber > seats) {
                System.out.println("Wrong input!");
                System.out.println();
            } else if (scheme[rowNumber][seatNumber] == CHOSEN_SEAT) {
                System.out.println("That ticket has already been purchased!");
                System.out.println();
            } else {
                invalidInput = false;
            }
        }
        scheme[rowNumber][seatNumber] = CHOSEN_SEAT;
        purchasedTickets++;
        income += calculateTicketPrice(rows, seats, rowNumber);
        printTicketPrice(calculateTicketPrice(rows, seats, rowNumber));
    }

    public static void printStatistics() {
        System.out.println();
        System.out.println(String.format("Number of purchased tickets: %d", purchasedTickets));
        System.out.println(String.format("Percentage: %.2f%%", ((double)purchasedTickets / (rows * seats)) * 100));
        System.out.println(String.format("Current income: $%d", income));
        System.out.println(String.format("Total income: $%d", calculateTotalIncome(rows, seats)));
    }
}