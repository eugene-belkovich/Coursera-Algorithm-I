package Week1.UnionFind.QuickUnionImproved;

public class QuickUnionImproved {

    int[] graph;
    int[] size;

    public int[] getGraph() {
        return graph;
    }

    public void setGraph(int[] graph) {
        this.graph = graph;
    }

    public QuickUnionImproved(int virticleNumber) {
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
        int i = root(p);
        int j = root(q);

        if (i == j) { return; }
        if (size[i] < size[j]) {
            graph[i] = graph[j];
            size[j] += size[i];
        } else {
            graph[j] = graph[i];
            size[i] += size[j];
        }
    }
    boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }
}
