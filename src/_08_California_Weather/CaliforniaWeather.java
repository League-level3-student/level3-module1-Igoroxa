package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {
	public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();
	public JButton button1 = new JButton("Search By Name");
	public JButton button2 = new JButton("Search By Condition");
	public JButton button3 = new JButton("Search By Tempearture");
	HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
	public String cityName = Utilities.capitalizeWords("National City");
	public WeatherData datum = weatherData.get(cityName);

	void start() {

		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		frame.setVisible(true);
		frame.pack();
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);

		// All city keys have the first letter capitalized of each word

		if (datum == null) {
			System.out.println("Unable to find weather data for: " + cityName);
		} else {
			System.out.println(
					cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
		}
	}

@Override
public void actionPerformed(ActionEvent e) {
	System.out.println("work");
	// TODO Auto-generated method stub
	if (e.getSource() == button1) {
		String enteredname = JOptionPane.showInputDialog("City Name: ");
		JLabel information = new JLabel();
		if (weatherData.containsKey(enteredname)) {
		   information.setText ("The Weather for " + enteredname + " is " + weatherData.get(enteredname).temperatureF);
		   panel.add(information);
		   frame.pack();
		}
	}
	if (e.getSource() == button2) {
		String enteredcondition = JOptionPane.showInputDialog("Entered Condition: ");
		ArrayList<String> cities = new ArrayList<String>();
		for (String NewCity : weatherData.keySet()) {
			if(weatherData.get(NewCity).weatherSummary.equals(enteredcondition)) {
				cities.add(NewCity);
			}
		}
		System.out.println(cities);
	
	}
	if (e.getSource() == button3) {
		String mint = JOptionPane.showInputDialog("Minimum Temp :");
		String maxt = JOptionPane.showInputDialog("Maximum Temp :");
		int mintint = Integer.parseInt(mint);
		int maxtint = Integer.parseInt(maxt);
		
		ArrayList<String> correctcities = new ArrayList<String>();
		for (String WarmCity : weatherData.keySet()) {
			if (weatherData.get(WarmCity).temperatureF > mintint && weatherData.get(WarmCity).temperatureF < maxtint) {
				correctcities.add(WarmCity);
			}
		}
		System.out.println(correctcities);
}
}}
