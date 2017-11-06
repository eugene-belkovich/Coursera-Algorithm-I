package Week1.UnionFind.QuickFind;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(10);

        System.out.println(Arrays.toString(unionFind.getGraph()));

        unionFind.union(3,5);
        System.out.println(unionFind.isConnected(3,5));
        System.out.println(unionFind.isConnected(3,6));

        System.out.println(Arrays.toString(unionFind.getGraph()));
    }
}
