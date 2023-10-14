package ghaphs;

import java.util.Scanner;

public class CityAndRoads {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[][] cityRoads = buildCityRoads(in, n);
        int numberOfRoads = calculateRoads(cityRoads);
        System.out.println(numberOfRoads);
    }

    private static int calculateRoads(int[][] cityRoads) {
        int numberOfRoads = 0;
        for (int i = 0; i < cityRoads.length; i++) {
            for (int j = i + 1; j < cityRoads[i].length; j++) {
                if (cityRoads[i][j] == 1){
                    numberOfRoads++;
                }
            }
        }
        return numberOfRoads;
    }

    private static int[][] buildCityRoads(Scanner in, int n) {
        int[][] cityRoads = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cityRoads[i][j] = in.nextInt();
            }
        }
        return cityRoads;
    }
}
