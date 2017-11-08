package Week1.UnionFind.QuickUnion;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(10);
        System.out.println(Arrays.toString(quickUnion.getGraph()));

        quickUnion.union(3, 5);
        System.out.println(Arrays.toString(quickUnion.getGraph()));

        quickUnion.union(3, 6);
        System.out.println(Arrays.toString(quickUnion.getGraph()));

    }
}
