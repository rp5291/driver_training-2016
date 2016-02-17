package org.usfirst.frc.team5962.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5962.robot.commands.CameraControl;
import org.usfirst.frc.team5962.robot.commands.GrabbingMechanism;
import org.usfirst.frc.team5962.robot.commands.ManualBreakGravityMotors;
import org.usfirst.frc.team5962.robot.commands.ReleaseBallTop;
import org.usfirst.frc.team5962.robot.commands.RunArcadeGame;
import org.usfirst.frc.team5962.robot.commands.RunArcadeJoystick;
import org.usfirst.frc.team5962.robot.commands.RunArcadeXGame;
import org.usfirst.frc.team5962.robot.commands.RunGameTank;
import org.usfirst.frc.team5962.robot.commands.RunGameXTank;
import org.usfirst.frc.team5962.robot.commands.RunJoystickTank;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public static Joystick gamePad1;
	public static Joystick gamePad2;
	public static Joystick joystickLeft;
	public static Joystick joystickRight;

	// Buttons added to RightJoystick
	public static JoystickButton rightJoystickButton1Index;
	public static JoystickButton rightJoystickButton2Thumb;
	public static JoystickButton RightJoystickButton3;
	public static JoystickButton RightJoystickButton4;

	public static JoystickButton joystickButton1;
	public static JoystickButton joystickButton2;

	public static JoystickButton gameArcadeMode;
	public static JoystickButton gameXArcadeMode;
	public static JoystickButton joystickArcadeMode;
	public static JoystickButton joystickTankMode;
	public static JoystickButton gameTankMode;
	public static JoystickButton gameXTankMode;

	public String currentDriveMode = "";

	public OI() {

		// add game controllers
		gamePad1 = new Joystick(0);
		gamePad2 = new Joystick(1);
		joystickLeft = new Joystick(2);
		joystickRight = new Joystick(3);

		// buttons added to the right joystick
		rightJoystickButton1Index = new JoystickButton(joystickRight, 1);
		rightJoystickButton2Thumb = new JoystickButton(joystickRight, 2);
		RightJoystickButton3 = new JoystickButton(joystickRight, 3);
		RightJoystickButton4 = new JoystickButton(joystickRight, 4);

		joystickButton1 = new JoystickButton(gamePad1, 4);
		joystickButton2 = new JoystickButton(gamePad1, 5);

		// Buttons to control mode switch
		// Currently only work on the right joystick
		gameArcadeMode = new JoystickButton(joystickRight, 11);
		gameXArcadeMode = new JoystickButton(joystickRight, 9);
		joystickArcadeMode = new JoystickButton(joystickRight, 7);
		joystickTankMode = new JoystickButton(joystickRight, 8);
		gameTankMode = new JoystickButton(joystickRight, 12);
		gameXTankMode = new JoystickButton(joystickRight, 10);

		// Driver mode Commands attached to the buttons
		gameArcadeMode.whenPressed(new RunArcadeGame());
		gameXArcadeMode.whenPressed(new RunArcadeXGame());
		joystickArcadeMode.whenPressed(new RunArcadeJoystick());
		joystickTankMode.whenPressed(new RunJoystickTank());
		gameTankMode.whenPressed(new RunGameTank());
		gameXTankMode.whenPressed(new RunGameXTank());

		// Use to control the manipulator
		// Currently only works on right Joystick
		rightJoystickButton1Index.whenPressed(new ReleaseBallTop());
		RightJoystickButton3.whenPressed(new GrabbingMechanism());
		rightJoystickButton2Thumb.whenPressed(new ManualBreakGravityMotors()); //manual break gravity motors
		RightJoystickButton4.whenPressed(new CameraControl());

	}

}
