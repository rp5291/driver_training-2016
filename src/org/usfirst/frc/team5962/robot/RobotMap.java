package org.usfirst.frc.team5962.robot;

import org.usfirst.frc.team5962.robot.sensors.RobotAccelerometer;
import org.usfirst.frc.team5962.robot.sensors.RobotGyro;
import org.usfirst.frc.team5962.robot.sensors.RobotUltrasonicAnalog;
import org.usfirst.frc.team5962.robot.sensors.RobotUltrasonicDigital;
import org.usfirst.frc.team5962.robot.sensors.RobotEncoder;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static Victor conveyorBeltVictor;
	public static Victor InTakeVictor;

	public static Victor Victor1;
	public static Victor Victor2;

	public static Servo axisCameraServoViewHorizontal;
	public static Servo axisCameraServoViewVertical;

	public static CANTalon CANTalon1;
	public static CANTalon CANTalon2;
	public static CANTalon CANTalon3;
	public static CANTalon CANTalon4;

	
	 // sensors
	public static DigitalInput ManualSwitch;
	public static RobotAccelerometer accelerometer;
	public static RobotUltrasonicDigital fieldRangeFinder;
	public static RobotUltrasonicAnalog intakeRangeFinder;
	public static RobotGyro gyro;
	public static RobotEncoder encoder;

	public static void init() {
		// JoystickThrottle.Speed();
		ManualSwitch = new DigitalInput(9); // switch this to a ultrasonic

		// this code has 4 victors. 2 victors are used for our testing board.
		// comment out the two testing victors when you deploy to final robot
		// the other two victors are used for the manipulator
		// uncomment and comment based on what you need

		// testing board has 2 victors and the old robot also has 2 victors
		// so make sure if you want to drive the old robot you change RobotDrive
		// Victor1 = new Victor(0);
		// Victor2 = new Victor(1);

		//
		conveyorBeltVictor = new Victor(0);
		InTakeVictor = new Victor(1);

		axisCameraServoViewHorizontal = new Servo(2);
		axisCameraServoViewVertical = new Servo(3);

		//
		CANTalon1 = new CANTalon(10);
		CANTalon2 = new CANTalon(11);
		CANTalon3 = new CANTalon(12);
		CANTalon4 = new CANTalon(13);

		// CANTalon1.setInverted(true);
		// CANTalon2.setInverted(true);
		// CANTalon3.setInverted(true);
		// CANTalon4.setInverted(true);

		accelerometer = new RobotAccelerometer();
		fieldRangeFinder = new RobotUltrasonicDigital();
		gyro = new RobotGyro();
		encoder = new RobotEncoder();
		
	}

}
