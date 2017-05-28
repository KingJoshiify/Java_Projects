/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_try_start_stop;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.net.MalformedURLException;

/**
 *
 * @author Joshu
 */
public class notification {

      public static void main(String[] args) throws AWTException, MalformedURLException {
        notification inst = new notification();
        inst.supported();
    }
          public void supported()throws AWTException, java.net.MalformedURLException{
         if (SystemTray.isSupported()) {
            displayTray();
        } else {
            System.err.println("System tray not supported!");
        }
    }
      public void displayTray() throws AWTException, java.net.MalformedURLException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();
       String title = "Searchiify";
       String msg = "Searchiify Is Still Running\nIn Systemtray.";
        //If the icon is a file
         Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/img/Mine.png"));
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getToolkit().createImage(getClass().getResource("icon.png"));
        TrayIcon trayIcon = new TrayIcon(image, "Searchiify");
        //Let the system resizes the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("Searchiify");
        tray.add(trayIcon);
        trayIcon.displayMessage(title, msg, TrayIcon.MessageType.INFO);
    }
}
