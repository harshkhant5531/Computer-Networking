class DVR {
    static final int INF = 9999;
    int[][] cost;
    int[][] dist;
    int nodes;

    public DVR(int[][] costMatrix) {
        nodes = costMatrix.length;
        cost = new int[nodes][nodes];
        dist = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                cost[i][j] = costMatrix[i][j];
                dist[i][j] = costMatrix[i][j];
            }
        }
    }

    public void runDVR() {
        boolean updated;
        do {
            updated = false;
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    for (int k = 0; k < nodes; k++) {
                        if (dist[i][j] > cost[i][k] + dist[k][j]) {
                            dist[i][j] = cost[i][k] + dist[k][j];
                            updated = true;
                        }
                    }
                }
            }
        } while (updated);
    }

    public void printRoutingTables() {
        for (int i = 0; i < nodes; i++) {
            System.out.println("Routing table for Router " + i + ":");
            for (int j = 0; j < nodes; j++) {
                System.out.println("To " + j + " via cost: " + dist[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] costMatrix = {
                { 0, 1, 3, INF },
                { 1, 0, 1, 4 },
                { 3, 1, 0, 1 },
                { INF, 4, 1, 0 }
        };

        DVR dvr = new DVR(costMatrix);
        dvr.runDVR();
        dvr.printRoutingTables();
    }
}
