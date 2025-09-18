import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SnakesAndMasters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stepsAwayFromWin = scanner.nextInt();

        int MAX = 1000000;
        int[] numberOfWaysToEnd = new int[stepsAwayFromWin + 1];

        numberOfWaysToEnd[0] = 1;
        numberOfWaysToEnd[1] = 1;

        for (int i = 2; i <= stepsAwayFromWin ; i++) {
            numberOfWaysToEnd[i] = (numberOfWaysToEnd[i - 1] + numberOfWaysToEnd[i - 2]) % MAX;
        }
        System.out.println(numberOfWaysToEnd[stepsAwayFromWin]);

}
}