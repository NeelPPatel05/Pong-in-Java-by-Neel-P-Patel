import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class PongRunner {
    public static void main(String[] args) {
        //creating instance of JFrame to make a window on users screen
        JFrame window = new JFrame();
        window.setSize(550,380);
        window.getContentPane().setBackground(Color.GRAY);
        window.setVisible(true);
        window.setTitle("Pong in Java by Neel P Patel");
        drawPong dC = new drawPong();
        window.add(dC);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Pong p = new Pong();
        
        
        
        
        
        //Key Strokes
        window.addKeyListener(new KeyListener() {
            @Override //KeyPresses
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP && p.getP2YPos() > 0) {
                    p.setDirP2("up");
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN && p.getP2YPos() < 390) {
                    p.setDirP2("down");
                } 
                else if (e.getKeyCode() == KeyEvent.VK_W && p.getP1YPos() > 0) {
                    p.setDirP1("up");
                } else if (e.getKeyCode() == KeyEvent.VK_S && p.getP1YPos() < 390) {
                    p.setDirP1("down");
                }
            }
            
            @Override
            public void keyTyped(KeyEvent e)
            {
                
            }
            @Override //Key Releases
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP && p.getDirP2().equals("up")) {
                    p.setDirP2("");
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN && p.getDirP2().equals("down")) {
                    p.setDirP2("");
                }
                
                else if (e.getKeyCode() == KeyEvent.VK_W && p.getDirP1().equals("up")) {
                    p.setDirP1("");
                } else if (e.getKeyCode() == KeyEvent.VK_S && p.getDirP1().equals("down")) {
                    p.setDirP1("");
                }
                
            }
        });
        
        //Timer task
        // Updates 60 times per second
        Timer timer = new Timer();
        timer.schedule( new TimerTask() {
            public void run(){
                p.runGame();
                dC.repaint();
            }
        }, 0, 1000/60);
        
    }
}