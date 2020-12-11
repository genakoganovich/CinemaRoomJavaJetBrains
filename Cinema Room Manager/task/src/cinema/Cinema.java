package cinema;

public class Cinema {
    public static final int ROWS = 7;
    public static final int SEATS = 8;
    public static void main(String[] args) {
        //==================================
        // printing the scheme
        //==================================
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= SEATS; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 1; i <= ROWS; i++) {
            System.out.print(i);
            for (int j = 1; j <= SEATS; j++) {
                System.out.print(" " + "S");
            }
            System.out.println();
        }

    }
}