package com.qa.utility;



import javax.swing.*;
import java.awt.*;

public class JFrameToolTip {

    public static void toolTipInfo(){

        Point location =new Point(200,200);
        JFrame frame = new JFrame("ToolTip");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JTextArea textArea = new JTextArea();
        textArea.setText("Login is current price");
        frame.getContentPane().add(textArea);
        frame.setLocation(location);
        frame.setVisible(true);

        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        frame.dispose();
    }
}
