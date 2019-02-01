import java.util.Scanner;
public class Solution {

    // this method takes in the array with recorded values of position
    // and calculates which direction it is

    // For example, if the user move the finger towards right in first
    // row, then the input will be givenArr = {0, 1, 2, 3}

    // Now, we can just see if the numbers are in ascending or descending order
    // Ascending means towards the right/upwards and that returns true
    // Descending means towards the left/downwards and that returns false
    public static boolean determineDirection(int[] givenArr) {
        boolean ret = false;
        for (int i = 0; i < 4; i++) {
            if (givenArr[i] < givenArr[i + 1]) {
                ret = true;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] horiTracker = new int[4];
        int[] vertiTracker = new int[4];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            horiTracker[i] = 0;
            vertiTracker[i] = 0;
        }

        Scanner sc = new Scanner(System.in);

        do {
            while (true) {
                // input from sensors
                // always between 0 - 255
                int myArr[][] = {
                    {100, 200, 80, 50},
                    {20, 30, 50, 10},
                    {0, 60, 80, 150},
                    {100, 20, 70, 60}
                };

                int max = -100;

                // for a given moment in time, find the
                // sensor to which the finger is closest and record it
                // Since the finger is closest, the value from sensor is highest
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (max < sameArray[i][j]) {
                            max = sameArray[i][j];
                            // horiTracker keeps track of x co-ordinates of the
                            // array cell that has maximum value
                            // (ie where finger is at any instant)
                            horiTracker[index++] = i;

                            // vertiTracker keeps track of y co-ordinates of the
                            // array cell that has maximum value
                            // (ie where finger is at any instant)
                            vertiTracker[index++] =  j;
                        }
                    }
                }

                // user can pass through maximum 4 sensors in any direction
                // vertical or horizontal only
                // diagnonal is currently ignored
                if (index == 4) {
                    break;
                }
            }

            index = 0;

            if (Solution.determineDirection(horiTracker) == true) {
                System.out.println("Toward Right");

            } else System.out.println("Toward Left");

            if (Solution.determineDirection(vertiTracker) == true) {
                System.out.println("Toward Up");

            } else System.out.println("Toward Down");
        } while (sc.nextInt() == 0);
        // quit program when user enters 0
    }
}
