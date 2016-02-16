package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {
    

	public void moveX(double changeValue){
		RobotMap.axisCameraServoViewHorizontal.set(changeValue);
		
	}
	public void moveY(double changeValue){
		RobotMap.axisCameraServoViewVertical.set(changeValue);
		
	}
	
	
    //public void 

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

