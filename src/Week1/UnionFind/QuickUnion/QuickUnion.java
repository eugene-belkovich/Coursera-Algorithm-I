package Week1.UnionFind.QuickUnion;

public class QuickUnion {

    int[] graph;

    public int[] getGraph() {
        return graph;
    }

    public void setGraph(int[] graph) {
        this.graph = graph;
    }

    public QuickUnion(int virticleNumber) {
        this.graph = new int[virticleNumber];
        for (int i = 0; i < virticleNumber; i++)
            graph[i] = i;
    }

    int root(int i) {
        while (i != graph[i]) {
            i = graph[i];
        }
        return i;
    }

    void union(int p, int q) {
        int P = root(p);
        int Q = root(q);

        graph[P] = graph[Q];
    }
    boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }
}
