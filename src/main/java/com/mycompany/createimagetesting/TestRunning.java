package com.mycompany.createimagetesting;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oFNo's PC
 */
public class TestRunning {
    
    private static final int PORT_GAP = 50;
    private static final int PORT_WIDTH = 50;
    private static final int PORT_HEIGHT = 50;
    private static final int IMAGE_WIDTH = 500;
    private static final int IMAGE_HEIGHT = 300;
    private static final int TEXT_WIDTH = 40;
    private static final int TEXT_HEIGHT = 40;
    
    
    public static void main(String[] args) {
        BufferedImage bufferedImage = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        
        Graphics2D g2 = bufferedImage.createGraphics();
        
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 500, 300);
        
        for(int i=0; i<5; i++){
            
            int gap_width = PORT_GAP + ( i * PORT_WIDTH );
            int gap_height = PORT_GAP;
            
            g2.setColor(Color.GREEN);
            g2.fillRect( gap_width, gap_height, PORT_WIDTH, PORT_HEIGHT);
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(5));
            g2.drawRect( gap_width, gap_height, PORT_WIDTH, PORT_HEIGHT);
            g2.drawString("GE", gap_width + 10, gap_height + 20);
            g2.drawString("1/0/" + i, gap_width + 10, gap_height + 40);
            
        }
        
        
        
        
        
        File f = new File("testImage.png");
        
        try {
            
            ImageIO.write(bufferedImage, "png", f);
            
        } catch (IOException ex) {
            Logger.getLogger(TestRunning.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
