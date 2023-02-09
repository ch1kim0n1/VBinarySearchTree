package com.mycompany.vbinarysearchtree;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;
import javax.swing.JPanel;
import java.util.Random;

/**
 *
 * @author skyla
 */
public class GraphicsPanelTree extends JPanel {
    private int[] data;

    void processData(String valuesString) {
        String[] valuesArray = valuesString.split(" ");
        int[] values = new int[valuesArray.length];
        for (int i = 0; i < valuesArray.length; i++) {
            values[i] = Integer.parseInt(valuesArray[i]);
        }
        this.data = values;
        repaint();
}


    @Override
    protected void paintComponent(Graphics g) {  //code dosent trigger it!!!!!!!!!!!!!!!!!!!!!!!!!!     
        super.paintComponent(g);
        int x = getWidth() / 2;
        int y = getHeight() / 2;
         System.out.println(x);         
         
        drawTree(g, x, y, data, 0, data.length - 1);
    }

    private void drawTree(Graphics g, int x, int y, int[] values, int start, int end) {
        if (start > end) return;
        int mid = (start + end) / 2;
        g.drawString(Integer.toString(values[mid]), x, y);
        if (start <= mid - 1) {
            drawTree(g, x - 50, y + 50, values, start, mid - 1);
            g.drawLine(x, y, x - 50, y + 50);
        }
        if (mid + 1 <= end) {
            drawTree(g, x + 50, y + 50, values, mid + 1, end);
            g.drawLine(x, y, x + 50, y + 50);
        }
    }
}