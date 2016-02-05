
package org.usfirst.frc.team5962.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5962.robot.OI;
import org.usfirst.frc.team5962.robot.Robot;

/**
 *
 */
public class RunArcadeGame extends Command {
    public RunArcadeGame() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drive1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive1.arcadeGame();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return OI.gameXArcadeMode.get()
        || OI.gameTankMode.get()
        || OI.gameXTankMode.get()
        || OI.joystickTankMode.get()
        || OI.joystickArcadeMode.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
