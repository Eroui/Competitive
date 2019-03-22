import java.util.*;
import java.io.*;

public class Orientation {

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(2, 4);

        System.out.println(Point.orientation(p1, p2, p3)); // -1 counter clockwise expected
    }


    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Find the orientation of three ordered points p1, p2, p3
         * 
         * 0: if p1, p2 and p3 are colinear
         * 1: if they are clockwise
         * -1: if they are counterclockwise
         * 
         * @param p1 
         * @param p2
         * @param p3
         * @return the orientation
         */
        public static int orientation(Point p1, Point p2, Point p3) {
            int slopDiff = (p2.y - p1.y)*(p3.x - p2.x) - (p3.y - p2.y)*(p2.x - p1.x); 
            if (slopDiff == 0) 
                return 0;
            else if (slopDiff < 0)
                return -1;
            else
                return 1;
        }
    }

}