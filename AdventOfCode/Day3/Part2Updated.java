import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Part2Updated {
    
    private static final String INPUT_FILE = "input.in";
    private static final Pattern pattern = Pattern.compile("#([0-9]+) @ ([0-9]+),([0-9]+): ([0-9]+)x([0-9]+)");
    public static void main(String[] args) throws Exception {
        Long starTime = System.currentTimeMillis();

        try {
            solve();
        } catch (Exception e) {
            System.out.println("Failed Solving Problem Due to Exception : ");
            System.out.println(e);
        }

        Long endTime =  System.currentTimeMillis();
        System.out.println("\n________________________");
        System.out.printf("Finished Execution : %d ms", (endTime - starTime));
    }

    private static void solve() throws Exception {
        Scanner in = new Scanner(new File(INPUT_FILE));
        ArrayList<Square> squares = new ArrayList<>();
        while (in.hasNext()) {
            Square square = new Square(in.nextLine()); 
            squares.add(square);
        }
        UnionFind unionFind = new UnionFind(squares.size());

        for (int i = 0; i < squares.size(); ++i) {
            for (int j = i + 1; j < squares.size(); ++j) {
                if (squares.get(i).overlap(squares.get(j))) {
                    unionFind.unionSet(i, j);
                }
            }
        }

        System.out.println(unionFind.numberOfSets());

    }

    private static class Square {
        public int x, y, w, h;
        public int id;
        
        public Square(String claim) {
            Matcher m = pattern.matcher(claim);
            if (m.matches()) {
                this.id = Integer.parseInt(m.group(1));
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

        private boolean overlap(Square s) {
            int[][] points = {
                {s.x, s.y}, 
                {s.x, s.y + s.w - 1},
                {s.x + s.h - 1, s.y},
                {s.x + s.h- 1 , s.y + s.w - 1}
            };

            for (int i = 0; i < points.length; ++i) {
                if (this.x <= points[i][0] && 
                    points[i][0] <= this.x + this.h - 1&& 
                    this.y <= points[i][1] && 
                    points[i][1] <= this.y + this.w - 1) return true;
            }
            
            return false;
        }
    }

}

class UnionFind {
    private ArrayList<Integer> parent, rank, setSize;
    private int numberOfSets;

    public UnionFind(int size) {
        parent = new ArrayList<>(size);
        rank = new ArrayList<>(size);
        setSize = new ArrayList<>(size);
        
        numberOfSets = size;

        for (int i = 0; i < size; ++i) {
            parent.add(i);
            rank.add(0);
            setSize.add(1);
        }
    }

    public int findSet(int i) {
        if (parent.get(i) == i) {
            return i;
        }

        int p = findSet(parent.get(i));
        parent.set(i, p);

        return p;
    }

    public boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    public void unionSet(int i, int j) {
        if (!isSameSet(i, j)) {
            --numberOfSets;
        }

        int x = findSet(i);
        int y = findSet(j);

        if (rank.get(i)> rank.get(j)) {
            parent.set(y, x);
            setSize.set(x, setSize.get(y) + setSize.get(x));
        } else {
            parent.set(x, y);
            setSize.set(y, setSize.get(x) + setSize.get(y));

            if (rank.get(x) == rank.get(y)) {
                rank.set(y, rank.get(y) + 1);
            }
        }
    }

    public int numberOfSets() {
        return this.numberOfSets;
    }

    public int sizeOfSet(int i) {
        return setSize.get(findSet(i));
    }

}