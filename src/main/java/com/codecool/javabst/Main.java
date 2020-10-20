package com.codecool.javabst;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            numbers.add(i * 2 + 5);
        }

        System.out.println(numbers);

        BinarySearchTree myTree = BinarySearchTree.build(numbers);

        myTree.add(300);
        myTree.remove(49);

        // write some test code here
        System.out.println(myTree.search(7)); // should be true
        System.out.println(myTree.search(55));// should be true
        System.out.println(myTree.search(49));// should be false, just deleted
        System.out.println(myTree.search(11));// should be true
        System.out.println(myTree.search(34535));// should be false
        System.out.println(myTree.search(9));// should be true
        System.out.println(myTree.search(75));// should be true
        System.out.println(myTree.search(300));// should be true, just added

        System.out.println("done");
    }
}