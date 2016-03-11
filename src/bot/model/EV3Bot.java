package bot.model;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.utility.Delay;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;


public class EV3Bot
{
	private String botMessage;
	private int xPosition;
	private int yPosition;
	private long waitTime;
	
	/*
	 *  Driving
	 */
	
	private MovePilot botPilot;
	/*
	 *  Sample section
	 */
	private EV3UltrasonicSensor distanceSensor;
	private float [] ultrasonicSamples;
	
	public EV3Bot()
	{
		this.botMessage = "Programming Lego robots with Java";
		this.xPosition = 50;
		this.yPosition = 50;
		this.waitTime = 4000;
	
		
		distanceSensor = new EV3UltrasonicSensor(LocalEV3.get().getPort("S1"));
		distanceSensor.enable();
		setupPilot();
	}
	
	private void longWay()
	{
		
	}
	
	private void shortWay()
	{
		
	}
	
	public void driveAround()
	{
		
	}
	
	public void driveRoom()
	{
		ultrasonicSamples = new float [distanceSensor.sampleSize()];
		distanceSensor.fetchSample(ultrasonicSamples,0);
		if(ultrasonicSamples[0] < 100.00)
		{
			botPilot.travel(2750.00);
			botPilot.rotate(-20.00);
			botPilot.travel(2000.00);
			botPilot.rotate(-80.00);
			botPilot.travel(6500.00);
		}
		else
		{
			botPilot.travel(2750.00);
			botPilot.rotate(-20.00);
			botPilot.travel(2000.00);
			botPilot.rotate(-80.00);
			botPilot.travel(6500.00);
		}
	}
	
	private void setupPilot()
	{
		
		Wheel leftWheel = WheeledChassis.modelWheel(Motor.A, 55.0).offset(-72);
		Wheel rightWheel = WheeledChassis.modelWheel(Motor.B, 55.0).offset(72);
		Chassis baseChassis = new WheeledChassis(new Wheel []{leftWheel, rightWheel}, WheeledChassis.TYPE_DIFFERENTIAL);
		botPilot = new MovePilot(baseChassis);
	}
		
	public void start()
	{
		LCD.drawString(botMessage, xPosition, yPosition);
		Delay.msDelay(waitTime);
		LCD.clear();
		
	}
	
	private void displayMessage(String message)
	{
		LCD.drawString(message, xPosition, yPosition);
		Delay.msDelay(waitTime);
		LCD.clear();
	}

}
