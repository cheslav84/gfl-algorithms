package ghaphs;

import ghaphs.utils.GraphScanner;

import java.util.Arrays;
import java.util.Scanner;

public class ATree2 {
    private static int[][] graph;
    private static int[] parents;
    private static boolean[] visited;



    public static void main(String[] args) {
        graph = GraphScanner.getGraph(new Scanner(System.in));
        parents = new int[graph.length];
        Arrays.fill(parents, -1);
        visited = new boolean[graph.length];


        System.out.println(isTree());

//        checkForCycles(0, -1);
//        System.out.println(noCycles && allVertexConnected() ? "YES" : "NO");
    }



    private static boolean isTree() {
        if (checkForCycles(0, -1)) {
            return false;
        }
        return !checkForCycles(0, -1) && allVertexConnected();
    }

    private static boolean checkForCycles(int vertex, int parent) {
        visited[vertex] = true;
        for (int j = 0; j < graph.length; j++) {

//            i = it.next();

            // If an adjacent is not visited, then recur for
            // that adjacent
            if (!visited[j]) {
                if (checkForCycles(j, vertex))
                    return true;
            }

            // If an adjacent is visited and not parent of
            // current vertex, then there is a cycle.
            else if (j != parent)
                return true;

//            if (graph[vertex][j] == 1 && !visited[j]) {
//                parents[j] = vertex;
//                checkForCycles(j, vertex);
//            } else
//            if (graph[vertex][j] == 1 && visited[j] && parents[vertex] != parent) {
//                    noCycles = false;
//            }

        }
        return false;

    }

//    private static void checkForCycles(int vertex, int parent) {
//        visited[vertex] = true;
//        for (int j = 0; j < graph.length; j++) {
//            if (graph[vertex][j] == 1 && !visited[j]) {
//                parents[j] = vertex;
//                checkForCycles(j, vertex);
//            } else
//            if (graph[vertex][j] == 1 && visited[j] && parents[vertex] != parent) {
//                noCycles = false;
//            }
//        }
//
//    }



    private static boolean allVertexConnected() {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }


}