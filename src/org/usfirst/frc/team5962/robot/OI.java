package org.usfirst.frc.team5962.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public Joystick gamepad1, gamepad2, joystickleft, joystickright;

	public static JoystickButton joystickButton1;
	public static JoystickButton joystickButton2;

	public JoystickButton gameArcadeMode;
	public JoystickButton gameXArcadeMode;
	public JoystickButton joystickArcadeMode;
	public JoystickButton joystickTankMode;
	public JoystickButton gameTankMode;
	public JoystickButton gameXTankMode;

	public String currentDriveMode = "";

	public OI() {
		gamepad1 = new Joystick(0);
		gamepad2 = new Joystick(1);
		joystickleft = new Joystick(2);
		joystickright = new Joystick(3);

		joystickButton1 = new JoystickButton(gamepad1, 4);
		joystickButton2 = new JoystickButton(gamepad1, 5);

		// Buttons to control mode switch
		gameArcadeMode = new JoystickButton(joystickright, 7);
		gameXArcadeMode = new JoystickButton(joystickright, 8);
		joystickArcadeMode = new JoystickButton(joystickright, 9);
		joystickTankMode = new JoystickButton(joystickright, 10);
		gameTankMode = new JoystickButton(joystickright, 11);
		gameXTankMode = new JoystickButton(joystickright, 12);

		gameArcadeMode.whenPressed(new RunArcadeGame());
		gameXArcadeMode.whenPressed(new RunArcadeXGame());
		joystickArcadeMode.whenPressed(new RunArcadeJoystick());
		joystickTankMode.whenPressed(new RunJoystickTank());
		gameTankMode.whenPressed(new RunGameTank());
		gameXTankMode.whenPressed(new RunGameXTank());
		
	}

	public Joystick getJoystick1() {
		return gamepad1;
	}

	public Joystick getJoystick2() {
		return gamepad2;
	}

	public Joystick getJoystick3() {
		return joystickleft;
	}

	public Joystick getJoystick4() {
		return joystickright;
	}

}
