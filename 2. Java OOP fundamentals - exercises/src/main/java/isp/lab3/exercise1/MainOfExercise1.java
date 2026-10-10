package isp.lab3.exercise1;

/**
 * Exercise 1
 * A class Tree contains:
 *
 * One instance variable 'height' (of type int) representing the height of tree;
 * One default constructor which initialize the height to 15;
 * One grow(int meters) method which add to the current height the meters given as long as meters >= 1;
 * One toString() method which returns the height of the tree;
 * Write a class which models the class Tree.
 * Write a class TreeTest which test the Tree class. You have to write three tests:
 * for grow(int meters) method
 * for toString() method
 * Create a tree object and call all his methods and print out the values(in main)
 */
public class MainOfExercise1 {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.grow(2);
        System.out.println(tree.toString());
    }
}
