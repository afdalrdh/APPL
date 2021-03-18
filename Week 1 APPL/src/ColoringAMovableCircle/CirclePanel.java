/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColoringAMovableCircle;

/**
 *
 * @author afdalrdh
 */

// ****************************************************************** 
// CirclePanel.java 
// 
// A panel with a circle drawn in the center and buttons on the 
// bottom that move the circle. 
// ****************************************************************** 
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
public class CirclePanel extends JPanel 
{ 
    private final int CIRCLE_SIZE = 50; 
    private int x,y; 
    private Color c; 
    JButton choose = new JButton("Please Choose Color ");
    
    //--------------------------------------------------------------- 
    // Set up circle and buttons to move it. 
    //--------------------------------------------------------------- 
    public CirclePanel(int width, int height) 
    { 
        // Set coordinates so circle starts in middle 
        x = (width/2)-(CIRCLE_SIZE/2); 
        y = (height/2)-(CIRCLE_SIZE/2); 
        c = Color.green; 
        // Need a border layout to get the buttons on the bottom 
        this.setLayout(new BorderLayout()); 
        // Create buttons to move the circle 
        JButton left = new JButton("Left"); 
        JButton right = new JButton("Right"); 
        JButton up = new JButton("Up"); 
        JButton down = new JButton("Down");
        // Add listeners to the buttons 
        left.addActionListener(new MoveListener(-20,0)); 
        right.addActionListener(new MoveListener(20,0)); 
        up.addActionListener(new MoveListener(0,-20)); 
        down.addActionListener(new MoveListener(0,20)); 
        // Need a panel to put the buttons on or they'll be on 
        // top of each other. 
        JPanel buttonPanel = new JPanel(); 
        buttonPanel.add(left); 
        buttonPanel.add(right); 
        buttonPanel.add(up); 
        buttonPanel.add(down); 
        // Add the button panel to the bottom of the main panel 
        this.add(buttonPanel, "South"); 
        
        // Tambah Warna
        JButton yellow = new JButton("Yellow");
        JButton red = new JButton("Red");
        JButton green = new JButton("Green");
        JButton blue = new JButton("Blue");
        red.setForeground(Color.RED);
        yellow.setForeground(Color.YELLOW);
        green.setForeground(Color.GREEN);
        blue.setForeground(Color.BLUE);
        //color listener
        red.addActionListener(new ColorListener(Color.RED));
        yellow.addActionListener(new ColorListener(Color.YELLOW));
        choose.addActionListener(new ColorListener(null));
        green.addActionListener(new ColorListener(Color.GREEN));
        blue.addActionListener(new ColorListener(Color.BLUE));
        JPanel colorButtonPanel = new JPanel(); 
        colorButtonPanel.add(red);
        colorButtonPanel.add(yellow);
        colorButtonPanel.add(choose);
        colorButtonPanel.add(green);
        colorButtonPanel.add(blue);
        // Add the button panel to the top of the main panel 
        this.add(colorButtonPanel, "North");
    }
    
    //--------------------------------------------------------------- 
    // Draw circle on CirclePanel 
    //--------------------------------------------------------------- 
    public void paintComponent(Graphics page) 
    { 
        super.paintComponent(page); 
        page.setColor(c); 
        page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE); 
    } 
    
    //--------------------------------------------------------------- 
    // Class to listen for button clicks that move circle. 
    //--------------------------------------------------------------- 
    private class MoveListener implements ActionListener 
    { 
        private int dx; 
        private int dy; 
        //--------------------------------------------------------------- 
        // Parameters tell how to move circle at click. 
        //--------------------------------------------------------------- 
        public MoveListener(int dx, int dy) 
        { 
            this.dx = dx; 
            this.dy = dy; 
        } 
        //--------------------------------------------------------------- 
        // Change x and y coordinates and repaint. 
        //--------------------------------------------------------------- 
        public void actionPerformed(ActionEvent e) 
        { 
            x += dx; 
            y += dy; 
            repaint(); 
        } 
    }
    
    private class ColorListener implements ActionListener{
        private Color color;
        public ColorListener(Color color){
            this.color=color;
        }
        public void actionPerformed(ActionEvent e){
            if(this.color==null){
                c=JColorChooser.showDialog(choose,"Choose Color ", c);

            }else{
                c=this.color;
            }
            repaint();
        }
    }
} 