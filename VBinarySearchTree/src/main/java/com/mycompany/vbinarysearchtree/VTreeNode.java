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
    
    private int value;
    private VTreeNode VNodeLeft;
    private VTreeNode VNodeRight;

    public VTreeNode(int value, VTreeNode VNodeLeft, VTreeNode VNodeRight) {
        this.value = value;
        this.VNodeLeft = VNodeLeft;
        this.VNodeRight = VNodeRight;
    }

    
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public VTreeNode getVNodeLeft() {
        return VNodeLeft;
    }

    public void setVNodeLeft(VTreeNode VNodeLeft) {
        this.VNodeLeft = VNodeLeft;
    }

    public VTreeNode getVNodeRight() {
        return VNodeRight;
    }

    public void setVNodeRight(VTreeNode VNodeRight) {
        this.VNodeRight = VNodeRight;
    }
    
    
    
}
