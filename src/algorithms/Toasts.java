package algorithms;

import java.util.Scanner;

public class Toasts {
    private static final int FRYING_TIME = 2;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int toasts = in.nextInt();
        int panCapacity = in.nextInt();

        int time = getTime(toasts, panCapacity);
        System.out.println(time);
    }

    private static int getTime(int toasts, int panCapacity) {
        int time;
        if (toasts == 0) {
            time = 0;
        } else if (toasts <= panCapacity) {
            time = 4;
        } else {
            time = FRYING_TIME * toasts / panCapacity;
            if (FRYING_TIME * toasts % panCapacity > 0) {
                time++;
            }
            time *= FRYING_TIME;
        }
        return time;
    }
}
