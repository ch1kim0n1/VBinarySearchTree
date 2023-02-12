package com.mycompany.vbinarysearchtree;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GraphicsPanelTree extends JPanel {
    private int[] data;
    ViperBSTree tree = new ViperBSTree();

    
    public void processData(int value) {
        if (data == null || data.length == 0) {
            this.data = new int[]{value};
            
            repaint();
            return;
        }

        int[] newData = new int[data.length + 1];
        System.arraycopy(data, 0, newData, 0, data.length);
        newData[data.length] = value;
        this.data = newData;

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = getWidth() / 2;
        int y = 30;
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        
        if(data == null){
            data = new int[0];
        }
        
        
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        
        int height = tree.getHeight();
        int numLeaves = tree.getNumLevels();
        int numLevels = tree.getNumLevels();
        int numNodes = tree.getNumNodes();
        Boolean isFullTree = tree.isFull();
        
        drawTree(g2d, x, y, data, 0, data.length - 1);
    }

private void drawTree(Graphics2D g, int x, int y, int[] values, int start, int end) {
        if (start > end) return;
        
        int mid = (start + end) / 2;
        int diameter = 20;
        int currentHeight = 0;
        int currentNumLeaves = 0;
        int currentNumLevels = 0;
        int currentNumNodes = 0;
        boolean currentIsFullTree = false;
        
        g.drawOval(x - diameter / 2, y - diameter / 2, diameter, diameter);
        g.drawString(Integer.toString(values[mid]), x - g.getFontMetrics().stringWidth(Integer.toString(values[mid])) / 2, y + g.getFontMetrics().getHeight() / 4);
        
        if (start <= mid - 1) {
            int x1 = x - 75;
            int y1 = y + 50;
            drawTree(g, x1, y1, values, start, mid - 1);
            g.drawLine(x + diameter / 2, y + diameter / 2, x1 + diameter / 2, y1 + diameter / 2);
            
            currentNumNodes++;
        } else {
            g.drawLine(x, y + diameter / 2, x, y + diameter / 2 + 50);
            g.drawLine(x + diameter, y + diameter / 2, x + diameter, y + diameter / 2 + 50);
        }
        
        if (mid + 1 <= end) {
            int x2 = x + 75;
            int y2 = y + 50;
            drawTree(g, x2, y2, values, mid + 1, end);
            g.drawLine(x + diameter / 2, y + diameter / 2, x2 + diameter / 2, y2 + diameter / 2);
            
            currentNumNodes++;
        } else {
            g.drawLine(x, y + diameter / 2, x, y + diameter / 2 + 50);
            g.drawLine(x + diameter, y + diameter / 2, x + diameter, y + diameter / 2 + 50);
        }
        
        if (end - start + 1 <= 2) {
            currentNumLeaves++;
            currentHeight = 1;
        }
        if (end - start + 1 > 2) {
            currentNumLevels = (int) (Math.log(end - start + 1) / Math.log(2)) + 1;
            currentHeight = currentNumLevels;
        }
        if (end - start + 1 > 2 && (end - start + 1 & (end - start + 1 - 1)) == 0) {
            currentIsFullTree = true;
        }
        
        g.drawString("Height: " + currentHeight, 10, 20);
        g.drawString("Num Leaves: " + currentNumLeaves, 10, 40);
        g.drawString("Num Levels: " + currentNumLevels, 10, 60);
        g.drawString("Num Nodes: " + currentNumNodes, 10, 80);
        g.drawString("Is Full Tree: " + currentIsFullTree, 10, 100);
    }

}
