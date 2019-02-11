import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Part1 {
    
    private static final String INPUT_FILE = "input.in";
    private static final Pattern pattern = Pattern.compile("Step ([A-Z]) must be finished before step ([A-Z]) can begin.");
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


        int[] in_degree = new int[26];
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        while (in.hasNext()) {
            Matcher m = pattern.matcher(in.nextLine());
            if (m.matches()) {
                int a = m.group(1).charAt(0) - 'A';
                int b = m.group(2).charAt(0) - 'A';

                if (adjList.get(a) == null) {
                    ArrayList<Integer> li = new ArrayList<>();
                    li.add(b);
                    adjList.put(a, li);
                } else {
                    adjList.get(a).add(b);
                }
                
                in_degree[b]++;
            }
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int task: adjList.keySet()) {
            if (in_degree[task] == 0) {
                q.offer(task);
            }
        }

        if (q.isEmpty()) {
            throw new Exception("Could not found any task to start with!!");
        }

        while (!q.isEmpty()) {
            int task = q.poll();
            System.out.print((char) ('A' + task));
            for (int v: adjList.getOrDefault(task, new ArrayList<>())) {
                --in_degree[v];
                if (in_degree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        in.close();
    }


}