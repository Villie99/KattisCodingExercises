import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FenceBowling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bounces = scanner.nextInt();
        double width = scanner.nextDouble();
        double length = scanner.nextDouble();

        double sum = 0.0;
        for (int i = 0; i <= bounces ; i++) {
            double ww;
            if (i == 0 || i == bounces) {
                ww = width / 2.0;
            } else {
                ww = width;
            }
            sum += ww * Math.pow(2.0, i);
        }
        double tanBeta = length / sum;
        double betaRadians = Math.atan(tanBeta);
        double betaDegrees = Math.toDegrees(betaRadians);

        System.out.printf("%.7f\n", betaDegrees);
    }
}