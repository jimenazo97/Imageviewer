/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer.ui;
import imageviewer.model.Image;
 import java.awt.Graphics;
 import java.awt.image.BufferedImage;
 import javax.imageio.ImageIO;
 import javax.swing.JPanel;
/**
 *
 * @author Ithiel
 */
 

 public class SwingImageDisplay extends JPanel implements ImageDisplay {
 
     public Image currentImage;
 
     @Override
     public Image current() {
         return currentImage;
     }
 
     public void show(Image image) {
         this.currentImage = image;
         this.repaint();
     }
 
     @Override
     public void paint(Graphics g) {
         if (currentImage == null) {
             return;
         }
         g.drawImage(imageOf(currentImage), 0, 0, null);
     }
 
     private BufferedImage imageOf(Image currentImage) {
         try {
             return ImageIO.read(currentImage.stream());
         } catch (java.io.IOException ex) {
             ex.printStackTrace();
             return null;
         }
     }
 }
