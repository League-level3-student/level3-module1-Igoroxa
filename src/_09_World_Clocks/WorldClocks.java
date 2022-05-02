package _09_World_Clocks;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/*
 * You task is to create a java program that:
 * 1. Displays the time for multiple cities around the world on one display.
 * 2. Gives the user the ability to add a city to the display. One possible
 *    way to do this is to create a HashMap of city names and their
 *    corresponding time zones, e.g. HashMap<String, TimeZone>, then use each
 *    city's TimeZone to get the current date/time every second using a
 *    Timer object (see example code below).
 * 
 * The code below is an example of how to print out a clock for San Diego.
 * Use the ClockUtilities class to find the time zone of each city, then use
 * Calendar.getInstance to return a Calendar object to get the current time for
 * that city. Example:
 *   TimeZone timeZone = clockUtil.getTimeZoneFromCityName("San Diego, US");
 *   Calendar c = Calendar.getInstance(timeZone);
 *   System.out.println("Full date and time: " + calendar.getTime());
 * 
 * NOTE: The program may take a second or two to execute
 * 
 * Calendar class:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
 */

public class WorldClocks implements ActionListener {
    ClockUtilities clockUtil;
    Timer timer;
    TimeZone timeZone;
JButton button = new JButton("Add City");
    
    JFrame frame;
    JPanel panel = new JPanel();
    JTextArea textArea;
   ArrayList<JTextArea> texts = new ArrayList<JTextArea>();
    
 
    String dateStr;
    String timeStr;
    String additionalCity;
    
    HashMap<String, TimeZone> gettedCity = new HashMap<String, TimeZone>();
    
    void requestedCity() {
    String input = JOptionPane.showInputDialog("City's name for TIMEZONE: ");
    String city1 = input;
    timeZone = clockUtil.getTimeZoneFromCityName(city1);
    gettedCity.put(city1, timeZone);
    JTextArea timearea = new JTextArea();
    texts.add(timearea);
    panel.add(timearea);
    }
    public WorldClocks() {
        clockUtil = new ClockUtilities();

        // The format for the city must be: city, country (all caps)
      requestedCity();
    
        
        frame = new JFrame();
  
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(100, 100);
        frame.add(panel);
       panel.add(button);
       button.addActionListener(this);
        
        timer = new Timer(1000, this);
        timer.start();
        int index = 0;
      for (String city : gettedCity.keySet()) {
    	 JTextArea textarea = texts.get(index);
		
	
        System.out.println(gettedCity);
        
      
        Calendar calendar = Calendar.getInstance(gettedCity.get(city));
        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        String dayOfWeek = calendar.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
        
        textarea.setText(city + "\n" + dateStr);
	index++;
        System.out.println(dateStr);
      }
      
        // Sample starter program
        
        // This Timer object is set to call the actionPerformed() method every
        // 1000 milliseconds
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
    	int index = 0;
    	for (String city : gettedCity.keySet()) {
			textArea = texts.get(index);
		
    
        Calendar c = Calendar.getInstance(gettedCity.get(city));
        String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
        String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "]";
        timeStr = militaryTime + twelveHourTime;
        
        System.out.println(timeStr);
        textArea.setText(city + "\n" + dateStr + "\n" + timeStr);
        index++;
        frame.pack();
    }
    	if(arg0.getSource() == button) {
    		 requestedCity();
    	}
    }
}
