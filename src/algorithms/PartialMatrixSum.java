package algorithms;

import java.io.*;

public class PartialMatrixSum {
    private static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        initMatrix(reader);
        sumMatrix();
        printMatrix();
    }

    private static void sumMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 && j > 0) {
                    matrix[i][j] = matrix[i][j] + matrix[i][j - 1];
                } else if (i > 0 && j == 0) {
                    matrix[i][j] = matrix[i][j] + matrix[i - 1][j];
                } else if (i > 0 && j > 0) {
                    matrix[i][j] = + matrix[i][j] + matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1];
                }
            }
        }
    }


    private static void initMatrix(BufferedReader reader) throws IOException {
        String[] size = reader.readLine().split(" ");

        int rows = Integer.parseInt(size[0]);
        int columns = Integer.parseInt(size[1]);
        matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            String[] row = reader.readLine().split(" ");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
    }

    private static void printMatrix() throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                writer.write(matrix[i][j] + " ");
            }
            writer.write("\n");
        }
        writer.flush();
    }
}
