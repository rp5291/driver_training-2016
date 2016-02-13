package org.usfirst.frc.team5962.robot;

import org.usfirst.frc.team5962.robot.subsystems.Speed;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
    public static Victor Victor1 = new Victor(0);
    public static Victor Victor2 = new Victor(1);

	public static CANTalon CANTalon1 = new CANTalon(10);
	public static CANTalon CANTalon2 = new CANTalon(11);
	public static CANTalon CANTalon3 = new CANTalon(12);
	public static CANTalon CANTalon4 = new CANTalon(13);
	
	
	
	
    public static void init() {
        LiveWindow.addActuator("Subsystem 1", "Victor 1", Victor1);
        LiveWindow.addActuator("Subsystem 1", "Victor 2", Victor2);
   	
    	//CANTalon1.setInverted(true);
    	//CANTalon2.setInverted(true);
    	//CANTalon3.setInverted(true);
    	//CANTalon4.setInverted(true);
        Speed.Run();
        
        
        
    }

}
