
package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {

	RobotDrive myRobot = new RobotDrive(RobotMap.subsystem1Victor1, RobotMap.subsystem1Victor2);

	public void gameTank() {
		myRobot.tankDrive(Robot.oi.gamepad1.getRawAxis(1), Robot.oi.gamepad1.getRawAxis(5));
	}

	public void gameXTank() {
		myRobot.tankDrive(Robot.oi.gamepad2.getRawAxis(1), Robot.oi.gamepad2.getRawAxis(5));
	}

	public void joystickTank() {
		myRobot.tankDrive(Robot.oi.joystickleft, Robot.oi.joystickright);
	}

	public void arcadeJoystick() {
		myRobot.arcadeDrive(Robot.oi.joystickright);
	}

	public void arcadeGame() {
		myRobot.arcadeDrive(Robot.oi.gamepad1);
	}

	public void arcadeXGame() {
		myRobot.arcadeDrive(Robot.oi.gamepad2);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
}
