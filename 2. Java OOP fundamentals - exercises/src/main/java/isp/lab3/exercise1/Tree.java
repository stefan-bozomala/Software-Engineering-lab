package isp.lab3.exercise1;

public class Tree {
    private int height;

    public Tree() { // constructor implicit - instantiem clasele - suprascriem - exista doar daca nu e definit niciun alt constructor
        System.out.println("Tree created - height 15");
        height=15;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void grow(int meter){
        if (meter>=1) setHeight(height+meter);
        System.out.println("Tree size increased");
    }

    @Override
    public String toString() {
        return "Tree height is " + height;
    }
}
