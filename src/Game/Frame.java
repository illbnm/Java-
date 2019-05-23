package src.Game;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Frame extends java.awt.Frame {
    /**
     * 加载窗口
     */
    public void LauntchFrame(){
     setSize(300,300);
     setLocation(100,100);
     setVisible(true);
     addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
             System.exit(0);
         }
     });
 }

    public static void main(String[] args) {
        Frame my = new Frame();
        my.LauntchFrame();
    }
}
