import java.util.*;
import java.io.*;

class Edge{

    public int cost;
    public Node firstNode;
    public Node secondNode;

    public Edge(int c, Node f, Node s){

        cost = c;
        firstNode = f;
        secondNode = s;

    }

}

class Node {

    public int height;//num of elements
    public int id;
    public Node parent;

    public Node(int h, int i, Node p){

        height = h;
        id = i;
        parent = p;

    }

}

public class scorify    {

    public static Comparator compareEdge = new Comparator<Edge>() {

        public int compare(Edge e1, Edge e2) {
            if(e1.cost < e2.cost)
                return -1;
            return 1;

        }

    };

    public static long necessaryCost;
    public static int numOfEdges, nodeCount, setCount;
    public static ArrayList<Edge> edgeList;
    public static ArrayList<Node> rootNodes;


    public static void main(String[] args) throws Exception{
        
        Scanner in = new Scanner(System.in);
        
        int tt = in.nextInt();

        while (tt-- != 0) {

            numOfEdges = in.nextInt();

            long numRoads = numOfEdges * (numOfEdges-1) / 2;

            long totalCost = 0;
            necessaryCost = nodeCount = setCount = 0;

            rootNodes = new ArrayList<Node>();
            edgeList = new ArrayList<Edge>();

            int[] ints = new int[numOfEdges];
            Arrays.fill(ints, -1);

            int[] indexes = new int[numOfEdges];

            for(int i = 0; i < numRoads; i++){

                //String[] line = in.readLine().split("\\s+");
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();

                Node node1;
                if(ints[a] == -1){
                    ints[a] = a;
                    node1 = new Node(0, rootNodes.size(), null);
                    indexes[a] = rootNodes.size();
                    rootNodes.add(node1);
                    setCount++;
                    nodeCount++;
                }
                else{
                    node1 = rootNodes.get(indexes[a]);
                }
                
                Node node2;
                if(ints[b] == -1){
                    ints[b] = b;
                    node2 = new Node(0, rootNodes.size(), null);
                    indexes[b] = rootNodes.size();
                    rootNodes.add(node2);
                    setCount++;
                    nodeCount++;
                }
                else{
                    node2 = rootNodes.get(indexes[b]);
                }

                edgeList.add(new Edge(c, node1, node2));
                
                totalCost += (long)c;

            }

            spanningTree();
            System.out.println(totalCost - necessaryCost);

        }

        //in.close();
        //out.close();
    }

    public static int find(Node node){

        Node currentNode = node;

        while(currentNode.parent != null)
            currentNode = currentNode.parent;

        //Path Compression
        Node root = currentNode;
        currentNode = node;

        while(!currentNode.equals(root)){
            Node tmpNode = currentNode.parent;
            currentNode.parent = root;
            currentNode = tmpNode;
        }

        return root.id;

    }

    public static void union(Node node1, Node node2){

        int root1id = find(node1);
        int root2id = find(node2);

        if(root1id == root2id)
            return;

        Node root1 = rootNodes.get(root1id);
        Node root2 = rootNodes.get(root2id);

        if(root1.height < root2.height)
            root1.parent = root2;
        else if(root1.height > root2.height)
            root2.parent = root1;
        else{
            root2.parent = root1;
            root1.height++;
        }

        setCount--;

    }

    public static void spanningTree(){

        Collections.sort(edgeList, compareEdge);
        int edgesCount = 0;

        for(Edge edge : edgeList){

            Node u = edge.firstNode;
            Node v = edge.secondNode;

            if(find(u) != find(v)){
                necessaryCost += edge.cost;
                edgesCount++;
                union(u, v);
            }

            if(edgesCount == numOfEdges-1)
                break;

        }

    }
}