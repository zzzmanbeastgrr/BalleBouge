package ballebouge;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Thread;
import java.util.ArrayList;

/**
 * @author ZiLong Ismael
 */
public class CreateBallThread extends Thread {
  public boolean threadStarted = false;
  public MouseEvent mouseevent;
  private JPanel pan;
  private ArrayList<Balle> listeBalle;

  public CreateBallThread(JPanel pan, ArrayList<Balle> listeBalle) {
    this.pan = pan;
    this.listeBalle = listeBalle;
  }
  @Override
  public void run() {
    while (true) {
      if (threadStarted) {
        int x = 0;
        int y = 0;
        try {
          x = (int) mouseevent.getX();
          y = (int) mouseevent.getY();
        } catch (Exception e) {
        }
        Balle temp = new Balle(x, y);
        temp.setLocation(x, y);
        pan.add(temp);
        listeBalle.add(temp);
      }
      try {
        Thread.sleep(60);
      } catch (Exception e) {
      }
    }
  }
  public void addBalls(MouseEvent e) {
    this.mouseevent = e;
    this.threadStarted = true;
  }
  public void addBalls() {
    this.threadStarted = true;
  }
  public void changeMouseEvent(MouseEvent e) {
    this.mouseevent = e;
  }
  public void stopAddingBalls() {
    this.threadStarted = false;
  }
}
