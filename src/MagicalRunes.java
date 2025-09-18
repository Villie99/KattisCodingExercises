import java.util.Scanner;

public class MagicalRunes {
    private static String initialArrangement = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");

        initialArrangement = inputArray[0];
        long days = Integer.parseInt(inputArray[1]);
        long[] flips = new long[initialArrangement.length()];
        long[] amountOfBA = new long[initialArrangement.length()];
        char[] startArray = initialArrangement.toCharArray();
        char[] endArray = new char[initialArrangement.length()];

        flips[0] = days;
        for (int i = 0; i < initialArrangement.length(); i++) {
            if (startArray[i] == 'B') {
                amountOfBA[i] = (flips[i] + 1) / 2;
            }else {
                amountOfBA[i] = flips[i] / 2;
            }

            if (flips[i] % 2 == 0){
                endArray[i] = startArray[i];
            } else {
                endArray[i] = swap(startArray[i]);
            }
            if (i + 1 < initialArrangement.length()) {
                flips[i + 1] = amountOfBA[i];
            }

        }

        System.out.println(new String(endArray));
    }
    static char swap(char c) {
        return c == 'A' ? 'B' : 'A';
    }
}