package classes.background;

import classes.ImageFactory;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import classes.player.Player;
import java.awt.Graphics2D;

public abstract class BackgroundPart implements Serializable 
{
  protected int brightness;
  protected boolean brightnessChanged;

  protected int currentBrightness;
  protected boolean currentBrightnessChanged;

  protected boolean stepped = false;
  protected boolean solid = false;
  protected boolean heated = false;
  protected boolean frozen = false;
  protected boolean thorny = false;
  protected Rectangle bounding;

  protected transient BufferedImage look[];
  protected String imageTag = "grass";
  protected int subX = 0;
  protected int subY = 0;
  protected int width = 0;

  public BackgroundPart(String imageTag,int length)
  {
    this(imageTag, length, 0, 0);
  }
  public BackgroundPart(String imageTag, int length, int subX, int subY)
  {
    bounding = new Rectangle(0, 0, 25, 25);
    this.subX=subX;
    this.subY=subY;
    setLook(imageTag, length, subX, subY);
  }
  
  public void setLook(String imageTag, int length)
  {
    look=new BufferedImage[length];
    for (int i = 0; i < look.length; i++)
    {
      look[i]=ImageFactory.getIF().getLook(imageTag);
    }
  }
  public void setLook(String imageTag, int length, int subX, int subY)
  {
    look=new BufferedImage[length];
    System.out.println("ImageTag: "+imageTag);
    System.out.println("length: "+length);
    System.out.println("subX: "+subX);
    System.out.println("subY: "+subY);
    for (int i = 0; i < look.length; i++)
    {
      look[i]=ImageFactory.getIF().getLook(imageTag);
      System.out.println(look[i]);
    }
  }
  
  public void steppedOn(boolean stepped) 
  {
    this.stepped = stepped;
  }
  public void setSolid(boolean solid) 
  {
      this.solid = solid;
  }
  public void setThorny(boolean thorny) 
  {
      this.thorny = thorny;
  }
  public void setSubX(int subX) 
  {
      this.subX = subX;
  }
  public void setSubY(int subY) 
  {
      this.subY = subY;
  }
  public String getImageTag() 
  {
      return imageTag;
  }
  public void update(float tslf, float x, float y)
  {
    bounding.x = (int) x;
    bounding.y = (int) y;
  }
  public void playerSteppedOn(Player player)
  {

  }
  public BufferedImage getLook()
  {
    return look[0];
  }
  public void draw(Graphics2D g)
  {
    g.drawImage(getLook(), null , bounding.x, bounding.y);
  }
  public Rectangle getBounding() {
    return bounding;
  }
  public boolean isSolid()
  {
    return solid;
  }
  public boolean isStepped() {
    return stepped;
  }
  public boolean isHeated() {
    return heated;
  }
  public boolean isFrozen() {
    return frozen;
  }
  public boolean isThorny() {
    return thorny;
  }
}