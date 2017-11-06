package Week1.UnionFind.QuickFind;

public class UnionFind {
    int[] graph;

    public int[] getGraph() {
        return graph;
    }

    public void setGraph(int[] graph) {
        this.graph = graph;
    }

    public UnionFind(int virticleNumber) {
        this.graph = new int[virticleNumber];
        for (int i = 0; i < virticleNumber; i++)
            graph[i] = i;
    }

    void union(int p, int q) {
        int P = graph[q];
        int Q = graph[p];
        for (int i = 0; i < graph.length; i++) {
            if (graph[i] == P) graph[i] = Q;
        }
    }
    boolean isConnected(int p, int q) {
        return graph[p] == graph[q];
    }
}
