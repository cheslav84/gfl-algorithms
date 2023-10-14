package ghaphs;

import java.util.Scanner;

public class ColorRain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[][] bridges = buildBridges(in, n);
        int[] colors = fillColors(in, n);
        int numberOfBridges = calculateBridges(bridges, colors);
        System.out.println(numberOfBridges);
    }



    private static int calculateBridges(int[][] cityRoads, int[] colors) {
        int numberOfBridges = 0;
        for (int i = 0; i < cityRoads.length; i++) {
            for (int j = i + 1; j < cityRoads[i].length; j++) {
                if (cityRoads[i][j] == 1 && colors[i] != colors[j]){
                    numberOfBridges++;
                }
            }
        }
        return numberOfBridges;
    }

    private static int[][] buildBridges(Scanner in, int n) {
        int[][] bridges = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bridges[i][j] = in.nextInt();
            }
        }
        return bridges;
    }

    private static int[] fillColors(Scanner in, int n) {
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = in.nextInt();
        }
        return colors;
    }
}
