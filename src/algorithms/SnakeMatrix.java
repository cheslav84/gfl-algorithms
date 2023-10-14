package algorithms;

import java.util.Scanner;

public class SnakeMatrix {
    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int matrixSize = in.nextInt();
        createMatrix(matrixSize);
        fillMatrix();
        printMatrix();
    }

    private static void createMatrix(int size) {
        matrix = new int[size][size];
    }

    private static void fillMatrix() {
        int counter = 1;
        for (int i = 0; i < matrix.length; ) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i % 2 == 0) {
                    matrix[i][j] = counter++;
                } else {
                    matrix[i][j] = matrix.length - 1 + counter--;
                }
            }
            counter = ++i * matrix.length + 1;
        }
    }

    private static void printMatrix() {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
