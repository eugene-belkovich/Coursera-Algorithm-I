package Week1.Homework.PercolationTesting;

public class Main {
    public static void main(String[] args) {
        Percolation perc = new Percolation(10);
        perc.print();
        System.out.println(perc.isOpen(1,1));
    }
}
