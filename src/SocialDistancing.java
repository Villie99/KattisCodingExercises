import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SocialDistancing {
    public static void main(String[] args) {
        int counterResult = 0;
        Scanner scanner = new Scanner(System.in);

        String seatsAndTaken = scanner.nextLine();
        String seatsTaken = scanner.nextLine();

        String[] arrayWithSeats = seatsAndTaken.split(" ");
        String numberOfSeatsTotal = arrayWithSeats[0];
        String numberOfTakenSeats = arrayWithSeats[1];


        int totalSeatsInt = 0;
        String[] table = new String[Integer.parseInt(numberOfSeatsTotal)];

        String[] arrayWithTakenSeats = seatsTaken.split(" ");

        for (int i = 0; i < Integer.parseInt(numberOfTakenSeats); i++) {
            String theTakenSeat = arrayWithTakenSeats[i];
            int lastSeat = Integer.parseInt(theTakenSeat) - 1;

            totalSeatsInt = Integer.parseInt(numberOfSeatsTotal);
            table[lastSeat] = "X";
            table[(lastSeat + 1) % totalSeatsInt] = "X";
            table[(lastSeat - 1 + totalSeatsInt) % totalSeatsInt] = "X";
        }
        for (int i = 0; i < totalSeatsInt ; i++) {

            if (table[i] == null) {
                counterResult++;
                table[i] = "X";
                table[(i + 1) % totalSeatsInt] = "X";
                table[(i - 1 + totalSeatsInt) % totalSeatsInt] = "X";

            }
        }
        System.out.println(counterResult);
    }
}