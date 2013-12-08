/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package birds.graphics;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Lukas
 */
public class TextArea extends javax.swing.JTextArea {
    
    public TextArea(){
        super();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        Image bg = new ImageIcon("lib\\text.png").getImage();
        g.drawImage(bg, 0, 0, null);
        super.paintComponent(g);
    }
}
