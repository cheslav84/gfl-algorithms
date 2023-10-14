package ghaphs.utils;

import java.util.Scanner;

public class GraphScanner {

    public static int[][] getGraph(Scanner in) {
        int n = in.nextInt();
        return scanGraph(new int[n][n], n, in);
    }



    public static int[][] getGraph(Scanner in, int size) {
        return scanGraph(new int[size][size], size, in);
    }

    private static int[][] scanGraph(int[][] n, int n1, Scanner in) {
        int[][] graph = n;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n1; j++) {
                graph[i][j] = in.nextInt();
            }
        }
        return graph;
    }

}

//    public static int[][] scanGraph(Scanner in) {
//        String[] dimensions = in.nextLine().split(" ");
//        int n = Integer.parseInt(dimensions[0]);
//        int m;
//        if (dimensions.length == 2) {
//            m = Integer.parseInt(dimensions[1]);
//        } else {
//            m = n;
//        }
//
//        int[][] graph = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                graph[i][j] = in.nextInt();
//            }
//        }
//        return graph;
//    }

