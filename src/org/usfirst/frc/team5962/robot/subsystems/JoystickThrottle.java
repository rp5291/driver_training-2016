package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.OI;
import org.usfirst.frc.team5962.robot.Robot;
import edu.wpi.first.wpilibj.command.Subsystem;

public class JoystickThrottle extends Subsystem {
	
	public static void Speed(){
		 double Throttle = ((OI.joystickRight.getThrottle() / -2) + 0.5);
		 
		 Robot.drive1.myRobot.setMaxOutput(Throttle);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}

