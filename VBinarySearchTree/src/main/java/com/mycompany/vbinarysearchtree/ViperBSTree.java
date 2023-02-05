/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vbinarysearchtree;

/**
 *
 * @author skyla
 */
//public class ViperBSTree {
//    
//    private VTreeNode root;
//    
//    
//    public ViperBSTree(){
//        root = null;
//    }
//    
//    
//    public void add(Integer val){
//        root = add(val, root);
//    }
//    
//    private VTreeNode add(Integer val, VTreeNode tree)
//    {
//
//    if (tree == null)
//
//        return new VTreeNode(val, null, null);
//
//    int dirTest = val.compareTo(tree.getValue());
//
//    if(dirTest<0)
//
//        tree.setVNodeLeft(add(val, tree.getVNodeLeft()));
//
//    else if(dirTest>0)
//
//        tree.setVNodeRight(add(val, tree.getVNodeRight()));
//
//    return tree;
//
//    }
//    
//    public String inOrder(){
//        
//        return inOrder(root);
//    }
//    
//    private String inOrder(VTreeNode tree)
//    {
//        String output = "";
//        if (tree != null){
//            output +=tree.getVNodeLeft() + " ";
//            output += tree.getValue() + " ";
//            output +=tree.getVNodeRight() + " ";
//            
//            return output;
//        }
//        return "12";
//    }
//
//    @Override
//    public String toString() {
//        //return root + "";
//        return inOrder() + ""; //something is wrong HEREEEEE!
//    }
//    
//    
//}

class Node {
  int data;
  Node left;
  Node right;
  
  public Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

public class ViperBSTree {
  Node root;
  int numLeaves;
  int numNodes;
  int height;
  int levels;
  boolean isFull;
  boolean isComplete;
  
  public ViperBSTree() {
    root = null;
    numLeaves = 0;
    numNodes = 0;
    height = 0;
    levels = 0;
    isFull = true;
    isComplete = true;
  }
  
  public void add(int data) {
    root = addRecursive(root, data);
  }
  
  private Node addRecursive(Node current, int data) {
    if (current == null) {
      return new Node(data);
    }
    
    if (data < current.data) {
      current.left = addRecursive(current.left, data);
    } else if (data > current.data) {
      current.right = addRecursive(current.right, data);
    }
    
    return current;
  }
  
  public void preOrder() {
    preOrderRecursive(root);
    System.out.println();
  }
  
  private void preOrderRecursive(Node current) {
    if (current != null) {
      System.out.print(current.data + " ");
      preOrderRecursive(current.left);
      preOrderRecursive(current.right);
    }
  }
  
  public void postOrder() {
    postOrderRecursive(root);
    System.out.println();
  }
  
  private void postOrderRecursive(Node current) {
    if (current != null) {
      postOrderRecursive(current.left);
      postOrderRecursive(current.right);
      System.out.print(current.data + " ");
    }
  }
  
  public void inOrder() {
    inOrderRecursive(root);
    System.out.println();
  }
  
  private void inOrderRecursive(Node current) {
    if (current != null) {
      inOrderRecursive(current.left);
      System.out.print(current.data + " ");
      inOrderRecursive(current.right);
    }
  }
  
  public int getNumLeaves() {
    numLeaves = 0;
    getNumLeavesRecursive(root);
    return numLeaves;
  }
  
  private void getNumLeavesRecursive(Node current) {
    if (current == null) {
      return;
    }
    
    if (current.left == null && current.right == null) {
      numLeaves++;
    }
    
    getNumLeavesRecursive(current.left);
    getNumLeavesRecursive(current.right);
  }
  
  public int getNumNodes() {
    numNodes = 0;
getNumNodesRecursive(root);
return numNodes;
}

private void getNumNodesRecursive(Node current) {
if (current == null) {
return;
}
numNodes++;
getNumNodesRecursive(current.left);
getNumNodesRecursive(current.right);
}

public int getNumLevels() {
levels = 0;
getNumLevelsRecursive(root, 1);
return levels;
}

private void getNumLevelsRecursive(Node current, int level) {
if (current == null) {
return;
}
if (level > levels) {
  levels = level;
}

getNumLevelsRecursive(current.left, level + 1);
getNumLevelsRecursive(current.right, level + 1);
}
public int getHeight() {
int height = 0;
return getHeightRecursive(root, 0);
}

private int getHeightRecursive(Node current, int currentHeight) {
if (current == null) {
return currentHeight - 1;
}
int leftHeight = getHeightRecursive(current.left, currentHeight + 1);
int rightHeight = getHeightRecursive(current.right, currentHeight + 1);

return Math.max(leftHeight, rightHeight);
}

public String toString() {
StringBuilder sb = new StringBuilder();
toStringRecursive(root, sb);
return sb.toString().trim();
}

private void toStringRecursive(Node current, StringBuilder sb) {
if (current == null) {
return;
}
toStringRecursive(current.left, sb);
sb.append(current.data + " ");
toStringRecursive(current.right, sb);
}

public boolean isFull() {
isFull = true;
isFullRecursive(root);
return isFull;
}

private void isFullRecursive(Node current) {
if (current == null) {
return;
}
if (current.left == null && current.right != null) {
  isFull = false;
  return;
}

if (current.left != null && current.right == null) {
  isFull = false;
  return;
}

isFullRecursive(current.left);
isFullRecursive(current.right);
}

public boolean isComplete() {
boolean isComplete = true;
int height = getHeight();
isCompleteRecursive(root, height, 0);
return isComplete;
}

private void isCompleteRecursive(Node current, int height, int level) {
if (current == null) {
return;
}
if (height != level + 1 && (current.left == null || current.right == null)) {
isComplete = false;
return;
}
if (current.left == null || current.right == null) {
isComplete = false;
return;
}
isCompleteRecursive(current.left, height, level + 1);
isCompleteRecursive(current.right, height, level + 1);
}

private class Node {
int data;
Node left;
Node right;
public Node(int data) {
  this.data = data;
}
}
}

