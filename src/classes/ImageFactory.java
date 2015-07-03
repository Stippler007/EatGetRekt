/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class ImageFactory {

  private static ImageFactory imageFactory;
  
  private HashMap<String,BufferedImage> looks=new HashMap<String, BufferedImage>();
  
  
  
  private ImageFactory()
  {
    try
    {
      looks.put("grass", ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/grass.png")));
      looks.put("allies", ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/allies.png")));
//      setBrightness("grass", 25, 25);
    } catch (IOException ex)
    {
      JOptionPane.showMessageDialog(null, "Image not found. Error: "+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  public void setBrightness(String str,int width,int height)
  {
    BufferedImage look=looks.get(str);
    BufferedImage help[] = new BufferedImage[5];
    int startBrightness=-100;
    for (int i = 0; i < help.length; i++)
    {
      help[i] = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
      help[i].createGraphics().drawImage(look, 0, 0, null);
      RescaleOp rescaleOp = new RescaleOp(1f, 10*i+startBrightness, null);
      rescaleOp.filter(help[i], help[i]);
//      looks.put(str+"Brightness"+i, help[i]);
    }
    BufferedImage cool=new BufferedImage(help.length*width,height,BufferedImage.TYPE_INT_ARGB);
    Graphics g=cool.getGraphics();
    for (int i = 0; i < help.length; i++)
    {
      g.drawImage(help[i],width*i, 0,null);
    }
    looks.put(str+"Brightness", cool);
  }
  
  public static ImageFactory getIF()
  {
      if(imageFactory==null)imageFactory=new ImageFactory();
      return imageFactory;
  }
  public BufferedImage getLook(String str)
  {
      return looks.get(str);
  }
}
