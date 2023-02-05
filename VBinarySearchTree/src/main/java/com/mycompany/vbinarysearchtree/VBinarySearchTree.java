/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.vbinarysearchtree;

/**
 *
 * @author skyla
 */
public class VBinarySearchTree {

    public static void main(String[] args) {
        ViperBSTree tree = new ViperBSTree();
        
        tree.add(90);
        tree.add(80);
        tree.add(70);
        tree.add(85);
        tree.add(100);
        tree.add(98);
        tree.add(120);

        System.out.println("IN ORDER");
        tree.inOrder();

        System.out.println("\nPRE ORDER");
        tree.preOrder();

        System.out.println("\nPOST ORDER");
        tree.postOrder();

        System.out.println("\nTree height is " + tree.getHeight());
        System.out.println("Number of leaves is " + tree.getNumLeaves());
        System.out.println("Number of nodes is " + tree.getNumNodes());
        System.out.println("Number of levels is " + tree.getNumLevels());
        System.out.println("Tree as a string " + tree.toString());

        if (tree.isFull()) {
            System.out.println("The tree is full.");
        } else {
            System.out.println("The tree is not full.");
        }

        if (tree.isComplete()) {
            System.out.println("The tree is complete.");
        } else {
            System.out.println("The tree is not complete.");
        }
    }
}
