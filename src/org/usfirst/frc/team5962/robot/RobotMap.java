package org.usfirst.frc.team5962.robot;

import org.usfirst.frc.team5962.robot.subsystems.JoystickThrottle;

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
    
    
    public static void init() {
        LiveWindow.addActuator("Subsystem 1", "Victor 1", Victor1);
        LiveWindow.addActuator("Subsystem 1", "Victor 2", Victor2);
        JoystickThrottle.Speed();
        //ThrottleCode
    }

}
