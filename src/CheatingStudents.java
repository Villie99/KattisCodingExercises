import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CheatingStudents {
    public static void main(String[] args) {
        CheatingStudents cheatingStudents = new CheatingStudents();
        cheatingStudents.cheatingStudents();
    }
    public void cheatingStudents() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] coordinates = new int [N][2];
        for (int i = 0; i < N; i++) {
            coordinates[i][0] = scanner.nextInt();
            coordinates[i][1] = scanner.nextInt();
        }
        buildGraph(coordinates);
        int total = (2*primMST(buildGraph(coordinates), N));
        System.out.println(total);

    }
    private int manhattanDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
    public List<List<Edge>> buildGraph(int[][] coordinates) {
        int N = coordinates.length;
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < N ; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N ; i++) {
            for (int j = i + 1 ; j < N ; j++) {
                int weight = manhattanDistance(coordinates[i], coordinates[j]);
                graph.get(i).add(new Edge(j, weight));
                graph.get(j).add(new Edge(i, weight));
            }
        }
        return graph;
    }
    public int primMST(List<List<Edge>> graph, int nbrOfVertices){
        boolean[] visited = new boolean[nbrOfVertices];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        int total = 0;
        pq.add(new Edge(0, 0));
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int node = current.target;

            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            total += current.weight;

            for (Edge edge : graph.get(node)) {
                if (!visited[edge.target]) {
                    pq.add(edge);
                }
            }
        }
        return total;
    }
    class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
}