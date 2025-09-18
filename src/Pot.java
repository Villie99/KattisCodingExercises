import java.util.ArrayList;
import java.util.Scanner;

public class Pot {

    public static void main(String[] args) {
        int sumOfAll = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            numbers.add(number);
        }

        for (int i = 0; i < numbers.size(); i++) {

            if (numbers.get(i) <= 99) {
                int firstdigit = numbers.get(i);
                int lastdigit = numbers.get(i) % 10;
                while (firstdigit >= 10) {
                    firstdigit = firstdigit / 10;
                }
                int result = (int) Math.pow(firstdigit, lastdigit);
                sumOfAll += result;

            }
            if (numbers.get(i) >= 100 && numbers.get(i) <= 999) {
                int firstdigit = numbers.get(i);
                int lastdigit = numbers.get(i) % 10;
                while (firstdigit >= 100) {
                    firstdigit = firstdigit / 10;
                }
                int result = (int) Math.pow(firstdigit, lastdigit);
                sumOfAll += result;

            }
            if (numbers.get(i) >= 1000 && numbers.get(i) <= 9999) {
                int firstdigit = numbers.get(i);
                int lastdigit = numbers.get(i) % 10;
                while (firstdigit >= 1000) {
                    firstdigit = firstdigit / 10;
                }
                int result = (int) Math.pow(firstdigit, lastdigit);
                sumOfAll += result;

            }

        }
        System.out.println(sumOfAll);
    }

}