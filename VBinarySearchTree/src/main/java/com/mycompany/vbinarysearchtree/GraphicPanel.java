/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vbinarysearchtree;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author skyla
 */
public class GraphicPanel extends JPanel{
    
    private ViperBST tree;
    
    
    public void processData(ViperBST tree) {
        this.tree = tree;
        
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int center = getWidth()/2;
        int nodeX = center, yNode = 0;
        
        if (tree != null)
            drawTree(tree.getRootNode(), nodeX, yNode, center/2, g);
    }

    private void drawNode(int xNode, int yNode, int delta, String value, Graphics g) {
        int height = 40; 
        int levelHeight = height * 2;
        g.drawString(value, xNode + 5,yNode + 25);
        

        int xLine = xNode;
        int yLine = yNode + height;
        int nextY = yNode + levelHeight;
        int nextLeftX = xLine - delta;
        int nextRightX = xLine + delta;

        g.drawLine(xLine, yLine, nextLeftX, nextY);
        g.drawLine(xLine, yLine, nextRightX, nextY);
        
    }
    
    private void drawTree(VTreeNode root, int xNode, int yNode, int delta, Graphics g){
        if (root != null){
            drawNode(xNode, yNode, delta, root.getVal() + "", g);
            int childrenDelta = delta / 2;
            drawTree(root.getLeft(), xNode - delta, yNode + 80, childrenDelta, g);
            drawTree(root.getRight(), xNode + delta, yNode + 80, childrenDelta, g);
        }
    }
}
