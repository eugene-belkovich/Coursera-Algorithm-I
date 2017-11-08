package Week1.Homework.PercolationTesting;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {

    int N;
    int top;
    boolean [][] opened;
    WeightedQuickUnionUF uf;
    WeightedQuickUnionUF uf2;

    public Percolation(int n) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalArgumentException("Check constructor parameter");
        }
        this.N = n;
        this.top = n*n;
        this.opened = new boolean[n][n];
        uf = new WeightedQuickUnionUF(n*n+2);
    }

    public void print() {
        for (int i = 0; i < opened.length; i++) {
            for (int j = 0; j < opened[i].length; j++) {
                System.out.print(opened[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isFull(int row, int col) {
        validate(row, col);

        return false;
    }

    public boolean isOpen(int row, int col) {
        validate(row, col);
        return this.opened[row-1][col-1];
    }

    public void open(int row, int col) {
        validate(row, col);
        if (!isOpen(row, col)) {
            this.opened[row-1][col-1] = true;
        }
        if (row == 1) {
            uf.union(col-1, top);
        }
        if (row > 1) {
            uf.union(getCurrentSite(row, col), getLeftAdjoinSite(row, col));
        }
        if (row < N) {
            uf.union(getCurrentSite(row, col), getRightAdjoinSite(row, col));
        }
        if (row == N) {
            //todo connect with bottom
//            uf.union(getCurrentSite(row, col), getLeftAdjoinSite(row, col));
        }
        if (col > 1) {
            uf.union(getCurrentSite(row, col), getTopAdjoinSite(row, col));
        }
        if (col < N) {
            uf.union(getCurrentSite(row, col), getBottomAdjoinSite(row, col));
        }
    }

    public boolean percolates() {
        return false;
    }

    private int getCurrentSite(int row, int col){
        // get position in flat matrix
        return (row-1)*N+(col-1);
    }
    private int getLeftAdjoinSite(int row, int col){
        return (row-2)*N+(col-1);
    }
    private int getRightAdjoinSite(int row, int col){
        return (row)*N+(col-1);
    }
    private int getTopAdjoinSite(int row, int col){
        return (row)*N+(col-2);
    }
    private int getBottomAdjoinSite(int row, int col){
        return (row)*N+(col);
    }


    private void validate(int row, int col) {
        if (row <= 0 || row > N ||  col <= 0 || col > N) {
            throw new IllegalArgumentException("Your indices outside the range");
        }
    }


}

