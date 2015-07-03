/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.player;

import classes.GameObject;
import classes.listener.MML;

/**
 *
 * @author Stippler
 */
public class Player extends GameObject
{

  public Player(float x, float y, int speed, int length)
  {
    super(x, y, speed, "allies", length, 50, 50);
  }

  @Override
  public void update(float tslf)
  {
    speedX=0;
    speedY=0;
    moveToTarget(MML.x, MML.y);
    super.update(tslf);
  }
  
}
