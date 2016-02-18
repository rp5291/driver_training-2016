
package org.usfirst.frc.team5962.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Ultrasonic;
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

	ADXRS450_Gyro gyro;

	final int gyroChannel = 0;
	double AngleSetPoint = 0.0;
	final double pGain = 0.006;

	public static Drive drive1;
	public static ConveyorBeltMotor ConveyorBelt;
	public static InTakeMotor InTake;
	public static Camera camera1;
	public static JoystickThrottle Thottle;
	public static OI oi;

	Command autonomousCommand;
	SendableChooser chooser;
	
	CameraServer server;
	//Ultrasonic ultra;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
    public Robot() {
        server = CameraServer.getInstance();
        server.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
        server.startAutomaticCapture("cam0");
    }
	
	public void robotInit() {
		RobotMap.init();
		ConveyorBelt = new ConveyorBeltMotor();
		InTake = new InTakeMotor();
		camera1 = new Camera();
		drive1 = new Drive();
		gyro = new ADXRS450_Gyro();
		Thottle = new JoystickThrottle();
		
		oi = new OI();

		Encoder enc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
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

		gyro.reset();
		gyro.calibrate();
		//autonomousCommand = (Command) chooser.getSelected();

		int angleInt= (int) gyro.getAngle();
		double turningValue = (AngleSetPoint - gyro.getAngle()) * pGain;

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
		int angleInt= (int) gyro.getAngle();
		double turningValue = (AngleSetPoint - gyro.getAngle()) * pGain;

		SmartDashboard.putString("Gyro Angle", "" + angleInt);

		RobotMap.myRobot.drive(-0.25, -angleInt * 0.03);

	}

	public void teleopInit() {
		gyro.reset();
		gyro.calibrate();

		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		int angleInt = (int) gyro.getAngle();
		double turningValue = (AngleSetPoint - gyro.getAngle()) * pGain;
		
		SmartDashboard.putString("Gyro Angle", "" + angleInt);
		SmartDashboard.putString("Right Joystick POV", "" + OI.joystickRight.getPOV(0));
		//SmartDashboard.putString("Victor1", "" + RobotMap.InTakeVictor.getSpeed());
		//SmartDashboard.putString("Victor2", "" + RobotMap.conveyorBeltVictor.getSpeed());
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
