
package com.mycompany.vbinarysearchtree;

import java.util.LinkedList;

/**
 *
 * @author skyla
 */
public class ViperBST {
    
    private VTreeNode root;

    public ViperBST() {
        this.root = null;
    }
    
    public void add(Integer value) {
        root = add(value, root);
    }
    
    private VTreeNode add(Integer val, VTreeNode tree) {
        
        if (tree == null)
            return new VTreeNode(val, null, null);

        int dirTest = val.compareTo(tree.getVal());

        if(dirTest<0)
            tree.setLeft(add(val, tree.getLeft()));

        else if(dirTest>0)
            tree.setRight(add(val, tree.getRight()));

        return tree;
    }
    public VTreeNode getRootNode() {
        return root;
    }
    public String inOrder(){
        return inOrder(root);
    }
    
    public String preOrder(){
        return preOrder(root);
    }
    
    public String postOrder(){
        return postOrder(root);
    }
    
    private String inOrder(VTreeNode tree) {
        
        if (tree == null){
            return "";
        }
        
        String output = "";
        
        output += inOrder(tree.getLeft());
        output += tree.getVal() + " ";
        output += inOrder(tree.getRight());
            
        return output;
    }
    
    private String preOrder(VTreeNode tree) {
        
        if (tree == null){
            return "";
        }
        
        String output = "";
        
        output += tree.getVal() + " ";
        output += preOrder(tree.getLeft());
        output += preOrder(tree.getRight());
            
        return output;
    }
    
    private String postOrder(VTreeNode tree) {
        
        if (tree == null){
            return "";
        }
        
        String output = "";
        
        output += postOrder(tree.getLeft());
        output += postOrder(tree.getRight());
        output += tree.getVal() + " ";
            
        return output;
    }
    
    public int getHeight() {
        return (getNumLevels(root) - 1);
    }
    
    public int getNumLevels() {
        return getNumLevels(root);
    }

    private int getNumLevels(VTreeNode tree) {
        if(tree==null) 
            return 0;
        else{
            int numLeft = getNumLevels(tree.getLeft());
            int numRight = getNumLevels(tree.getRight());
            if(numLeft > numRight)
                return 1 + numLeft;
            return 1 + numRight;
        }
    }
    
    public int getNumLeaves() {
        int count = 0;
        return getNumLeaves(root, count);
    }
    
    private int getNumLeaves(VTreeNode tree, int count) {
        
        if(tree==null) 
            return 0;
            
        if (tree.getLeft() == null && tree.getRight() == null)
            count++;
        else{
            count = getNumLeaves(tree.getLeft(), count);
            count = getNumLeaves(tree.getRight(), count);
        }
        
        return count;
    }
    
    public int getNumNodes() {
        
        return getNumNodes(root);
    }
    
    private int getNumNodes(VTreeNode tree) {
        
        if(tree == null)
            return 0;
        int count = 0;
        count++;
        count += getNumNodes(tree.getLeft());
        count += getNumNodes(tree.getRight());
        return count;
    }
    
    public boolean isFull() {
        return isFullhelper();
    }
    
    private boolean isFullhelper() {
        return (Math.pow(2, getNumLevels()) - 1 == getNumNodes());
    }
    
    public boolean isComplete() {
        return isComplete(root);
    }
   

    private boolean isComplete(VTreeNode tree) {
       
        if (tree == null)
           return true;
        
        boolean isNotComplete = false;
        
        LinkedList<VTreeNode> treeList = new LinkedList<VTreeNode>();
        
        treeList.add(tree);
        
        while (!treeList.isEmpty()){
            VTreeNode node = treeList.pollFirst();
            if (node.getLeft() != null){
                if (isNotComplete)
                    return false;
                treeList.add(node.getLeft());
            }
            else
                isNotComplete = true;
            if (node.getRight() != null){
                if (isNotComplete)
                    return false;
                treeList.add(node.getRight());
            }
            else
                isNotComplete = true;
        }
        return true;
    }

     @Override
    public String toString() {
         return inOrder(root);
    }
}
