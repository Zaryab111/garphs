import java.util.*;

class Graph {
    ArrayList<String>[] adjList;
    int N;
    int n;
    ArrayList<String> vertexList;

    Graph() {
        N = 20;
        n = 0;
        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<String>();
        }
        vertexList = new ArrayList<>();
    }

    private int indexOf(String label) {
        return vertexList.indexOf(label);
    }

    boolean addNode(String label) {
        if (n == N) {
            N *= 2;
            adjList = Arrays.copyOf(adjList, N);
            for (int i = n; i < N; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        adjList[n].add(label);
        vertexList.add(label);
        n++;

        return true;
    }

    boolean addDirectedEdge(String source, String destination) {
        int sourceIndex = indexOf(source);
        int destIndex = indexOf(destination);

        if (sourceIndex == -1 || destIndex == -1) {
            return false;
        }

        adjList[sourceIndex].add(destination);

        return true;
    }

    void display() {
        for (int i = 0; i < n; i++) {
            System.out.print(vertexList.get(i) + " -> ");
            for (String neighbor : adjList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    ArrayList<String> bfs(String source, String destination) {
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        int[] parent = new int[N];

        int sourceIndex = indexOf(source);
        int destIndex = indexOf(destination);

        if (sourceIndex == -1 || destIndex == -1) {
            System.out.println("Vertex doesn't exist.");
            return new ArrayList<>();
        }

        queue.add(source);
        visited[sourceIndex] = true;

        while (!queue.isEmpty()) {
            String current = queue.poll();

            for (String neighbor : adjList[indexOf(current)]) {
                int neighborIndex = indexOf(neighbor);
                if (!visited[neighborIndex]) {
                    queue.add(neighbor);
                    visited[neighborIndex] = true;
                    parent[neighborIndex] = indexOf(current);
                }
            }
        }

        return buildPath(sourceIndex, destIndex, parent);
    }

    private ArrayList<String> buildPath(int source, int destination, int[] parent) {
        ArrayList<String> path = new ArrayList<>();
        int current = destination;

        while (current != source) {
            path.add(vertexList.get(current));
            current = parent[current];
        }

        path.add(vertexList.get(source));
        Collections.reverse(path);

        return path;
    }
}

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
            graph.addNode("A");
            graph.addNode("B");
            graph.addNode("C");
            graph.addNode("D");
            graph.addNode("E");
            graph.addNode("F");
            graph.addNode("G");
            graph.addNode("H");
            graph.addNode("I");
            graph.addNode("J");
            graph.addNode("K");
            graph.addNode("L");
            graph.addNode("M");
            graph.addNode("N");
            graph.addNode("O");
            graph.addNode("P");
            graph.addNode("Q");
            graph.addNode("R");
            graph.addNode("S");
            graph.addNode("T");
        

        graph.addDirectedEdge("A", "B");
        graph.addDirectedEdge("B", "C");
        graph.addDirectedEdge("C", "D");
        graph.addDirectedEdge("D", "A");
        graph.addDirectedEdge("E", "F");
        graph.addDirectedEdge("F", "G");
        graph.addDirectedEdge("A", "E");
        graph.addDirectedEdge("B", "F");
        graph.addDirectedEdge("C", "G");
        graph.addDirectedEdge("D", "H");
        graph.addDirectedEdge("E", "I");
        graph.addDirectedEdge("F", "J");
        graph.addDirectedEdge("G", "K");
        graph.addDirectedEdge("H", "L");
        graph.addDirectedEdge("I", "M");
        graph.addDirectedEdge("J", "N");
        graph.addDirectedEdge("K", "O");
        graph.addDirectedEdge("L", "P");
        graph.addDirectedEdge("M", "Q");
        graph.addDirectedEdge("N", "R");
        graph.addDirectedEdge("O", "S");
        graph.addDirectedEdge("P", "T");
        graph.addDirectedEdge("Q", "A");
        graph.addDirectedEdge("R", "B");
        graph.addDirectedEdge("S", "C");
        graph.addDirectedEdge("T", "D");

        graph.display();

        Scanner scanner = new Scanner(System.in);
        System.out.print("source: ");
        String source = scanner.next();
        System.out.print("Enter destination: ");
        String destination = scanner.next();
        ArrayList<String> path = graph.bfs(source, destination);
        if (!path.isEmpty()) {
            System.out.println("Path: " + String.join(" --> ", path));
            System.out.println("Length of the path: " + (path.size() - 1));
        } else {
            System.out.println("no Path.");
        }
    }
}
