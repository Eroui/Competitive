import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Part1 {
    
    private static final String INPUT_FILE = "input.in";
    private static final Pattern pattern = Pattern.compile("#([0-9]+) @ ([0-9]+),([0-9]+): ([0-9]+)x([0-9]+)");
    public static void main(String[] args) throws Exception {
        Long starTime = System.currentTimeMillis();

        try {
            solveFast();
            solveBruteForce();
        } catch (Exception e) {
            System.out.println("Failed Solving Problem Due to Exception : ");
            System.out.println(e);
        }

        Long endTime =  System.currentTimeMillis();
        System.out.println("\n________________________");
        System.out.printf("Finished Execution : %d ms", (endTime - starTime));
    }

    private static void solveFast() throws Exception{
        Scanner in = new Scanner(new File(INPUT_FILE));
        ArrayList<Square> squares = new ArrayList<>();

        int maxW = 0;
        int maxH = 0;
        while (in.hasNext()) {
            Square square = new Square(in.nextLine()); 
            squares.add(square);
            maxH = Math.max(maxH, square.h + square.x + 1);
            maxW = Math.max(maxW, square.w + square.y + 1);
        }

        int[][] grid = new int[maxH + 2][maxW + 2]; 

        for (Square square : squares) {
            grid[square.x][square.y] += 1;
            grid[square.x][square.y + square.w] -= 1;
            grid[square.x + square.h][square.y] -= 1;
            grid[square.x + square.h][square.y + square.w] += 1;
        }


        int[][] pref = new int[maxH + 2] [maxW + 2];
        int ans = 0;
        for (int i = 0; i <= maxH; ++i) {
            int rowPrefix = 0;
            for (int j = 0; j <= maxW; ++j) {
                pref[i][j] = grid[i][j] + rowPrefix;
                rowPrefix += grid[i][j];
                
                if (i > 0) {
                    pref[i][j] += pref[i - 1][j];
                }
                if (pref[i][j] >= 2) ++ans;
            }
        }
        
        System.out.println(ans);

        in.close();
    }

    private static void solveBruteForce() throws Exception {
        Scanner in = new Scanner(new File(INPUT_FILE));
        ArrayList<Square> squares = new ArrayList<>();

        int maxW = 0;
        int maxH = 0;
        while (in.hasNext()) {
            Square square = new Square(in.nextLine()); 
            squares.add(square);
            maxH = Math.max(maxH, square.h + square.x + 1);
            maxW = Math.max(maxW, square.w + square.y + 1);
        }

        int[][] grid = new int[maxH + 1][maxW + 1];
        for (Square square: squares) {
            for (int i = square.x; i < square.x + square.h; ++i) {
                for (int j = square.y; j < square.y + square.w; ++j) {
                    ++grid[i][j];
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= maxH; ++i) {
            for (int j = 0; j <= maxW; ++j) {
                if (grid[i][j] >= 2) 
                    ++ans;
            }
        }

        System.out.println(ans);
        in.close();
    }

    private static class Square {
        public int x, y, w, h;
        
        public Square(String claim) {
            Matcher m = pattern.matcher(claim);
            if (m.matches()) {
                this.x = Integer.parseInt(m.group(2));
                this.y = Integer.parseInt(m.group(3));
                
                this.h = Integer.parseInt(m.group(4));
                this.w = Integer.parseInt(m.group(5));
            }
        }

        @Override
        public String toString() {
            return this.x + " " + this.y + " " + this.w +  " " + this. h;
        }
    }

}