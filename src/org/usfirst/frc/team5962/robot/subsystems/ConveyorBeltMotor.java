package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ConveyorBeltMotor extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private final static Victor Victor2 = RobotMap.conveyorBeltVictor;

	
	public static void runUpward (){
		Victor2.set(-1);
	  //Turn on Belt
	}
	
	public static void runDownward (){
		Victor2.set(1);
	  //Turn on Belt
	}
	
	public static void stop (){
		Victor2.set(0);
	  //Turn off Belt
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

