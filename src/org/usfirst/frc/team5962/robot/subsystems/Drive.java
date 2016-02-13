
package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {

	//RobotDrive myRobot = new RobotDrive(RobotMap.Victor1, RobotMap.Victor2);
	public RobotDrive myRobot = new RobotDrive(RobotMap.CANTalon1,RobotMap.CANTalon2,RobotMap.CANTalon3,RobotMap.CANTalon4);

	public void gameTank() {
		myRobot.tankDrive(Robot.oi.gamePad1.getRawAxis(1), Robot.oi.gamePad1.getRawAxis(5));
	}

	public void gameXTank() {
		myRobot.tankDrive(Robot.oi.gamePad2.getRawAxis(1), Robot.oi.gamePad2.getRawAxis(5));
	}

	public void joystickTank() {
		myRobot.tankDrive(Robot.oi.joystickLeft, Robot.oi.joystickRight);
	}

	public void arcadeJoystick() {
		myRobot.arcadeDrive(Robot.oi.joystickRight);
	}

	public void arcadeGame() {
		myRobot.arcadeDrive(Robot.oi.gamePad1);
	}

	public void arcadeXGame() {
		myRobot.arcadeDrive(Robot.oi.gamePad2);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
}
