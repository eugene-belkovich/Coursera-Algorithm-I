package Week1.UnionFind.QuickUnionImproved;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        QuickUnionImproved quickUnion = new QuickUnionImproved(10);
        System.out.println(Arrays.toString(quickUnion.getGraph()));

        quickUnion.union(3, 5);
        System.out.println(Arrays.toString(quickUnion.getGraph()));

        quickUnion.union(3, 6);
        System.out.println(Arrays.toString(quickUnion.getGraph()));

    }
}
