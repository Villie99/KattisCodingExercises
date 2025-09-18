import java.util.HashMap;
import java.util.Scanner;

public class Patchwork {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArray = scanner.nextLine().split(" ");
        int numberOfRows = Integer.parseInt(inputArray[0]);
        int numberOfColumns = Integer.parseInt(inputArray[1]);

        String[][] patchArray = new String[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                patchArray[i][j] = ".";
            }
        }

        int nbrofDiffPatches = Integer.parseInt(scanner.nextLine());

        HashMap<Integer, String[][]> mapForAllPatches = new HashMap<>();

        for (int i = 0; i < nbrofDiffPatches; i++) {
            String[] r_iAndc_iArray = scanner.nextLine().split(" ");
            int r_i = Integer.parseInt(r_iAndc_iArray[0]);
            int c_i = Integer.parseInt(r_iAndc_iArray[1]);

            String[][] patchCreation = new String[r_i][c_i];

            for (int j = 0; j < r_i; j++) {
                String patchCreationLine = scanner.nextLine();
                for (int k = 0; k < c_i; k++) {
                    patchCreation[j][k] = patchCreationLine.substring(k, k + 1);
                }
            }
            mapForAllPatches.put(i + 1, patchCreation);
        }

        int patchesToSewIn = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < patchesToSewIn; i++) {
            String[] coordinates = scanner.nextLine().split(" ");
            int row = Integer.parseInt(coordinates[0]);
            int column = Integer.parseInt(coordinates[1]);
            int patchType = Integer.parseInt(coordinates[2]);

            String[][] getThePatch = mapForAllPatches.get(patchType);

            for (int j = 0; j < getThePatch.length; j++) {
                for (int k = 0; k < getThePatch[0].length; k++) {
                    if (row + j < numberOfRows && column + k < numberOfColumns) {
                        patchArray[row + j][column + k] = getThePatch[j][k];
                    }
                }
            }
        }

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                System.out.print(patchArray[i][j]);
            }
            System.out.println();
        }

        scanner.close();
    }
}
