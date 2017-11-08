package Week1.UnionFind.QuickFind;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(10);

        System.out.println(Arrays.toString(quickFind.getGraph()));

        quickFind.union(3,5);
        System.out.println(quickFind.isConnected(3,5));
        System.out.println(quickFind.isConnected(3,6));

        System.out.println(Arrays.toString(quickFind.getGraph()));
    }
}
