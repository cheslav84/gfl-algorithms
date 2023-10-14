package ghaphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Floyd {
    static final int Q = 100000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] F = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                int a = Integer.parseInt(input[j - 1]);
                if (a >= 0) {
                    F[i][j] = a;
                } else {
                    F[i][j] = Q;
                }
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (F[i][j] > 0 && F[i][j] > F[i][k] + F[k][j]) {
                        F[i][j] = F[i][k] + F[k][j];
                    }
                }
            }
        }

        int max = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
//                if (F[i][j] > max ) {
                if (F[i][j] > max && F[i][j] != Q) {
                    max = F[i][j];
                }
            }
        }

        System.out.print(max);

    }

//    private static class Distances {
//        int min;
//        int max;
//    }
}


//            for (int i = 0; i < graph.length; i++) {
//                for (int j = 0; j < graph[i].length; j++) {
//
//
//                    graph[i][j] = in.nextInt();
//                }
//            }




//        for (int k = 1; k <= graph.length; k++) {
//            for (int i = 1; i <= graph.length; i++) {
//                for (int j = 1; j <= graph.length; j++) {
//                    if (graph[i][j] > 0 && graph[i][j] > graph[i][k] + graph[k][j]) {
//                        graph[i][j] = graph[i][k] + graph[k][j];
//                    }
//                }
//            }
//        }
//
//        int max = -1;
//        for (int i = 1; i <= graph.length; i++) {
//            for (int j = 1; j <= graph.length; j++) {
//                if (graph[i][j] > max && graph[i][j] != Q) {
//                    max = graph[i][j];
//                }
//            }
//        }
//
//        System.out.print(max);


