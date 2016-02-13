package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Speed extends Subsystem {

	public Speed() {
	}
	
	public static void Run() {
		double Throttle = Robot.oi.joystickRight.getThrottle() * -1;

		if (Throttle >= 0.7) {
			Robot.drive1.myRobot.setMaxOutput(1);
		}

		else if (Throttle <= -0.7) {
			Robot.drive1.myRobot.setMaxOutput(0.25);
		}

		else {
			Robot.drive1.myRobot.setMaxOutput(0.5);
		}

	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
}
