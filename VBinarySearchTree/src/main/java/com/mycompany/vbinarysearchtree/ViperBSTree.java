/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vbinarysearchtree;

/**
 *
 * @author skyla
 */
public class ViperBSTree {
    
    private VTreeNode root;
    
    
    public ViperBSTree(){
        root = null;
    }
    
    
    public void add(Integer val){
        root = add(val, root);
    }
    
    private VTreeNode add(Integer val, VTreeNode tree)
    {

    if (tree == null)

        return new VTreeNode(val, null, null);

    int dirTest = val.compareTo(tree.getValue());

    if(dirTest<0)

        tree.setVNodeLeft(add(val, tree.getVNodeLeft()));

    else if(dirTest>0)

        tree.setVNodeRight(add(val, tree.getVNodeRight()));

    return tree;

    }
    
    public String inOrder(){
        return inOrder(root);
    }
    
    private String inOrder(VTreeNode tree)
    {
        String output = "";
        if (tree != null){
            output +=tree.getVNodeLeft() + " ";
            output += tree.getValue() + " ";
            output +=tree.getVNodeRight() + " ";
            
            return output;
        }
        return "";
    }

    @Override
    public String toString() {
        return inOrder(); //something is wrong HEREEEEE!
    }
    
    
}
