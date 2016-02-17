package org.usfirst.frc.team5962.robot.commands;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.subsystems.ConveyorBeltMotor;
import org.usfirst.frc.team5962.robot.subsystems.InTakeMotor;
import org.usfirst.frc.team5962.robot.subsystems.ManualSwitch;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabbingMechanism extends Command {

    public GrabbingMechanism() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.InTake);
        
        setTimeout(0.5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	InTakeMotor.runUpwardSlow();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return (ManualSwitch.sensor() || isTimedOut());
    	return isTimedOut();
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	InTakeMotor.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
