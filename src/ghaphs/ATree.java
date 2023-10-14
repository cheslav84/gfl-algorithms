package ghaphs;

import ghaphs.utils.GraphScanner;

import java.util.Arrays;
import java.util.Scanner;

public class ATree {
    private static int[][] graph;
    private static int[] parents;
    private static boolean[] visited;
    private static boolean noCycles = true;

    public static void main(String[] args) {
        graph = GraphScanner.getGraph(new Scanner(System.in));
        parents = new int[graph.length];
        Arrays.fill(parents, -1);
        visited = new boolean[graph.length];
        int root = 0;
        checkForCycles(root);
        System.out.println(noCycles && allVertexConnected() ? "YES" : "NO");
    }

    private static void checkForCycles(int vertex) {
        visited[vertex] = true;
        for (int j = 0; j < graph.length; j++) {
            if (graph[vertex][j] == 1 && !visited[j]) {
                parents[j] = vertex;
                checkForCycles(j);
            } else if (graph[vertex][j] == 1 && visited[j] && (parents[vertex] != j)) {
                    noCycles = false;
            }
        }
    }


    private static boolean allVertexConnected() {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

}