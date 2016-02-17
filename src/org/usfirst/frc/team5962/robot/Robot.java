
package org.usfirst.frc.team5962.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team5962.robot.commands.RunArcadeGame;
import org.usfirst.frc.team5962.robot.subsystems.Camera;
import org.usfirst.frc.team5962.robot.subsystems.ConveyorBeltMotor;
import org.usfirst.frc.team5962.robot.subsystems.Drive;
import org.usfirst.frc.team5962.robot.subsystems.InTakeMotor;
import org.usfirst.frc.team5962.robot.subsystems.JoystickThrottle;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static Drive drive1;
	public static ConveyorBeltMotor ConveyorBelt;
	public static InTakeMotor InTake;
	public static Camera camera1;
	public static JoystickThrottle Thottle;
	public static OI oi;

	Command autonomousCommand;
	SendableChooser chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		RobotMap.init();
		ConveyorBelt = new ConveyorBeltMotor();
		InTake = new InTakeMotor();
		camera1 = new Camera();
		drive1 = new Drive();
		Thottle = new JoystickThrottle();
		oi = new OI();

		chooser = new SendableChooser();
		chooser.addDefault("Default Auto", new RunArcadeGame());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {

		RobotMap.gyro.resetGyro();
		autonomousCommand = (Command) chooser.getSelected();

		int angleInt= RobotMap.gyro.getGyroAngle();
		//double turningValue = RobotMap.gyro.getTurningValue();
		SmartDashboard.putString("Gyro Angle", "" + angleInt);

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		int angleInt= RobotMap.gyro.getGyroAngle();
		//double turningValue = RobotMap.gyro.getTurningValue();
		SmartDashboard.putString("Gyro Angle", "" + angleInt);
		
		double currentSpeed = RobotMap.fieldRangeFinder.getCurrentSpeed();		
		//double currentSpeed = 1.0;		
		SmartDashboard.putString("Field Ultrasonic - Current Speed", "" + currentSpeed);

		drive1.myRobot.drive(-currentSpeed, -angleInt * 0.03);

	}

	public void teleopInit() {
		RobotMap.gyro.resetGyro();

		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		int angleInt= RobotMap.gyro.getGyroAngle();
		//double turningValue = RobotMap.gyro.getTurningValue();
		
		SmartDashboard.putString("Gyro Angle", "" + angleInt);
		SmartDashboard.putString("Right Joystick POV", "" + OI.joystickRight.getPOV(0));
		SmartDashboard.putString("Victor1", "" + RobotMap.Victor1.getSpeed());
		SmartDashboard.putString("Victor2", "" + RobotMap.Victor2.getSpeed());
		SmartDashboard.putString("Throttle", "" + OI.joystickRight.getThrottle());
		SmartDashboard.putString("Driver Mode Choose", oi.currentDriveMode);

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
