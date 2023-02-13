/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vbinarysearchtree;

/**
 *
 * @author skyla
 */
public class VTreeNode {
    
    private int val;
    private VTreeNode left;
    private VTreeNode right;

    public VTreeNode(int val, VTreeNode left, VTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public VTreeNode getLeft() {
        return left;
    }

    public void setLeft(VTreeNode left) {
        this.left = left;
    }

    public VTreeNode getRight() {
        return right;
    }

    public void setRight(VTreeNode right) {
        this.right = right;
    }
    
}
