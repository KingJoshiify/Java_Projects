/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_try_start_stop;

import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

/**
 *
 * @author Joshu
 */

public class Mysql_try_start_stop {
  String SQL_INSTALL_DIR ="C:/Program Files/MySQL/MySQL Server 5.7";
String commandStart = "C:/Program Files/MySQL/MySQL Server 5.7/bin/mysqld.exe";
 String commandStop = SQL_INSTALL_DIR + "/bin/mysqld.exe -u root shutdown";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException, MalformedURLException {
        
        
    }
    public void startMysql() throws InterruptedException, IOException, AWTException {
        
    ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", "NET START MySQL57");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line="";
         

            while (line.equals("")) {            
           
            line = r.readLine();
                new Mysql_try_start_stop().not("MSQL",line);
                Thread.sleep(3000);
            line = r.readLine();
            new Mysql_try_start_stop().not("MSQL",line);
            
        }
            
             
          
           
            
       
         
   
}

public void stopMysql() throws IOException, AWTException, InterruptedException {
    ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", "NET STOP MySQL57");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
    
        String line="";
         

            while (line.equals("")) {            
           
            line = r.readLine();
                new Mysql_try_start_stop().not("MSQL",line);
                Thread.sleep(3000);
            line = r.readLine();
            new Mysql_try_start_stop().not("MSQL",line);
            
        }
        
       
}

public void not(String title,String msg)throws AWTException, java.net.MalformedURLException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();
       String ti = title;
       String ms = msg;
        //If the icon is a file
         Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/images/bulb.gif"));
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
