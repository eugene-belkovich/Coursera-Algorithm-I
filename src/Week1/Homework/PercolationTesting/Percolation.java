package Week1.Homework.PercolationTesting;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    private boolean[][] opened;
    private int top;
    private int bottom;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF uf2;
    private int N;
    private int countOpen;

    public Percolation(int n){
        if (n <= 0) {
            throw new IllegalArgumentException("Given n <= 0");
        }
        opened = new boolean[n][n];
        uf = new WeightedQuickUnionUF(n*n + 2);
        uf2 = new WeightedQuickUnionUF(n*n + 1);
        top = n*n;
        bottom = n*n + 1;
        N = n;
        countOpen=0;
    }

    public void open(int row, int col) {
        validate(row, col);
        if (!isOpen(row, col)) {
            opened[row-1][col-1] = true;
            countOpen++;
        }
        if (row == 1) {
            uf.union(col-1, top);
            uf2.union(col-1, top);
        }
        if (row == N) uf.union(getCurrentSite(row, col), bottom);
        if (row > 1   && isOpen(row-1, col)) {
            uf.union(getCurrentSite(row, col), getRightSite(row, col));
            uf2.union(getCurrentSite(row, col), getRightSite(row, col));
        }
        if (row < N && isOpen(row+1, col)) {
            uf.union(getCurrentSite(row, col), getLeftSite(row, col));
            uf2.union(getCurrentSite(row, col), getLeftSite(row, col));
        }
        if (col > 1   && isOpen(row, col-1)) {
            uf.union(getCurrentSite(row, col), getTopSite(row, col));
            uf2.union(getCurrentSite(row, col), getTopSite(row, col));
        }
        if (col < N && isOpen(row, col+1)) {
            uf.union(getCurrentSite(row, col), getBottomSite(row, col));
            uf2.union(getCurrentSite(row, col), getBottomSite(row, col));
        }
    }

    private int getCurrentSite(int row,int col){
        return (row-1)* N +col-1;
    }

    private int getLeftSite(int row,int col){
        return row* N +col-1;
    }

    private int getTopSite(int row,int col){
        return (row-1)* N +col-2;
    }

    private int getBottomSite(int row,int col){
        return (row-1)* N +col;
    }

    private int getRightSite(int row,int col){
        return (row-2)* N +col-1;
    }

    public boolean isOpen(int i, int j){
        validate(i, j);
        return opened[i-1][j-1];
    }

    public boolean isFull(int i, int j){
        validate(i, j);
        return uf2.connected((i-1)* N +j-1, top);
    }

    public boolean percolates()
    {
        return uf.connected(top, bottom);
    }

    private void validate(int row, int col) {
        if (row <= 0 || row > N ||  col <= 0 || col > N) {
            throw new IllegalArgumentException("Your indices outside the range");
        }
    }

    public int numberOfOpenSites(){
        return countOpen;
    }
}