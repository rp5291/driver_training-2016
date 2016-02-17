package org.usfirst.frc.team5962.robot;

import org.usfirst.frc.team5962.robot.subsystems.JoystickThrottle;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	
	
	
	public static Victor conveyorBeltVictor;
	public static Victor InTakeVictor;
	
    public static Victor Victor1;
    public static Victor Victor2;
    
    public static Servo axisCameraServoViewHorizontal;
	public static Servo axisCameraServoViewVertical;

	public static CANTalon CANTalon1;
	public static CANTalon CANTalon2;
	public static CANTalon CANTalon3;
	public static CANTalon CANTalon4;
	
	
	public static DigitalInput ManualSwitch;
	
	public static RobotDrive myRobot;
	
	
	
	
    public static void init() {
        //JoystickThrottle.Speed();
        ManualSwitch	  = new DigitalInput(9); //switch this to a ultrasonic
        
        
        
        //this code has 4 victors. 2 victors are used for our testing board.
        //comment out the two testing victors when you deploy to final robot
    	//the other two victors are used for the manipulator
    	//uncomment and comment based on what you need
        
        
        //testing board has 2 victors and the old robot also has 2 victors
        // so make sure if you want to drive the old robot you change RobotDrive 
        //Victor1 = new Victor(0);
        //Victor2 = new Victor(1);
        
        
        //
        conveyorBeltVictor = new Victor(0);
        InTakeVictor = new Victor(1);
    	
        InTakeVictor.setInverted(true);
        
        axisCameraServoViewHorizontal   = new Servo(2);
    	axisCameraServoViewVertical  	= new Servo(3);

    	
    	//
    	CANTalon1 = new CANTalon(10);
    	CANTalon2 = new CANTalon(11);
    	CANTalon3 = new CANTalon(12);
    	CANTalon4 = new CANTalon(13);
    	
    	
    	
   	
    	//CANTalon1.setInverted(true);
    	//CANTalon2.setInverted(true);
    	//CANTalon3.setInverted(true);
    	//CANTalon4.setInverted(true);

    	
    	//myRobot = new RobotDrive(RobotMap.Victor1,RobotMap.Victor2);
    	myRobot = new RobotDrive(RobotMap.CANTalon1,RobotMap.CANTalon2,RobotMap.CANTalon3,RobotMap.CANTalon4);
        
    }

}
