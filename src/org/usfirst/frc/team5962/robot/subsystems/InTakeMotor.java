package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.RobotMap;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class InTakeMotor extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private final static Victor Victor1 = RobotMap.InTakeVictor;
	
	public static void runUpward (){
		Victor1.set(-1);
	  //Turn on Belt
	}
	
	public static void runUpwardSlow (){
		Victor1.set(-0.25);
	  //Turn on Belt
	}
	
	public static void runDownward (){
		Victor1.set(1);
	  //Turn on Belt
	}
	
	public static void stop (){
		Victor1.set(0);
	  //Turn off Belt
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

