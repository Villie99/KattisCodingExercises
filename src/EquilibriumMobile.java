import java.util.*;

public class EquilibriumMobile {

    public static void main(String[] args) {
        EquilibriumMobile em = new EquilibriumMobile();
        em.equilibriumMobile();
    }

    public void equilibriumMobile() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String parse = scanner.nextLine();
            HashMap<Long, Long> similarNumbers = new HashMap<>();
            StringBuilder number = new StringBuilder();
            int depth = 0;
            int nodes = 0;
            long numberFrequency = 0;

            for (int j = 0; j < parse.length(); j++) {
                char character = parse.charAt(j);

                if (Character.isDigit(character)) {
                    number.append(character);
                } else if (number.length() > 0) {
                    long temp = Long.parseLong(number.toString());
                    long key = temp * (1L << depth);
                    similarNumbers.put(key, similarNumbers.getOrDefault(key, 0L) + 1);
                    nodes++;
                    number.setLength(0);
                }

                if (character == '[') {
                    depth++;
                } else if (character == ']') {
                    depth--;
                }
            }

            if (number.length() > 0) {
                long temp = Long.parseLong(number.toString());
                long key = temp * (1L << depth);
                similarNumbers.put(key, similarNumbers.getOrDefault(key, 0L) + 1);
                nodes++;
            }

            for (long freq : similarNumbers.values()) {
                if (freq > numberFrequency) {
                    numberFrequency = freq;
                }
            }

            System.out.println(nodes - numberFrequency);
        }

        scanner.close();
    }
}
