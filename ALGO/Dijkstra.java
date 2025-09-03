import java.util.*;

public class Dijkstra {
    static final int V = 5;
    static final int INF = Integer.MAX_VALUE;

    static int findKey(boolean[] visited, int[] distance) {
        int min = INF;
        int key = -1;

        for (int i = 0; i < V; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                key = i;
            }
        }
        return key;
    }

    // Dijkstra’s algorithm
    static void dijkstra(int[][] graph) {
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];
        Arrays.fill(distance, INF);

        distance[0] = 0;

        for (int i = 0; i < V - 1; i++) {
            int u = findKey(visited, distance);
            if (u == -1)
                break;

            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !visited[v] && distance[u] != INF
                        && distance[v] > distance[u] + graph[u][v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        System.out.println("\nShortest distances from node 0:");
        for (int i = 0; i < V; i++) {
            if (distance[i] == INF)
                System.out.println("Node " + i + ": INF");
            else
                System.out.println("Node " + i + ": " + distance[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 9, 75, 0, 0 },
                { 0, 0, 95, 0, 42 },
                { 0, 0, 0, 51, 0 },
                { 0, 19, 0, 0, 0 },
                { 0, 0, 0, 0, 31 }
        };

        System.out.println("Graph:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(graph[i][j] + "\t");
            }
            System.out.println();
        }

        dijkstra(graph);
    }
}
