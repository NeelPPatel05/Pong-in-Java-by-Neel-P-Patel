import javax.swing.*;
import java.awt.*;


public class drawPong extends JComponent
{
    //Creates another instance of pong to draw
    Pong p = new Pong();
    //Will Constantly Redraw Each Frame
    public void paintComponent(Graphics g){ 
        Graphics2D g2 = (Graphics2D) g; // creates graphics object
        
        //making black background around pong arena
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, 450, 300);

        g2.setColor(Color.WHITE); // changes color of tool to white

        g2.fillRect(224, 0, 3, 300); //makes line in middle
        
        //First Paddle
        g2.fillRect(10,p.getP1YPos(),20,60); 
        
        
        //Second Paddle
        g2.fillRect(420,p.getP2YPos(),20,60);
        
        
        //Ball
        g2.fillRect(p.getBallXPos(), p.getBallYPos(), 20, 20);
        
        
        //Text
        //Controls and Points
        g2.drawString("Controls P1: w (up), s(down) | Controls P2: arrow keys", 20, 320);
        g2.drawString("P1 Points: " + p.getP1Points(), 460, 60);
        g2.drawString("P2 Points: " + p.getP2Points(), 460, 120);
        
        //Drawing win
        if(p.getP1Points() == 5)
        {
           g2.drawString("P1 Wins ", 210 , 150); 
        }
        else if(p.getP2Points() == 5)
        {
            g2.drawString("P2 Wins ", 210 , 150); 
        }
        
    }


}