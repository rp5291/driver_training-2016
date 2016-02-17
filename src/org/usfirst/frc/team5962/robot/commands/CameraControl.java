package org.usfirst.frc.team5962.robot.commands;

import org.usfirst.frc.team5962.robot.OI;
import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;
import org.usfirst.frc.team5962.robot.subsystems.Camera;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CameraControl extends Command {

	public static boolean left;
	public static boolean right;
	public static boolean up;
	public static boolean down;
	
	public static double valueX;
	public static double valueY;
	
    public CameraControl() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.camera1);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	valueX = RobotMap.axisCameraServoViewHorizontal.get();
    	valueY = RobotMap.axisCameraServoViewVertical.get();
    	 
    	
    	if (OI.joystickRight.getPOV()== 0)
    	{
    		up = true;
    	}
    	
    	if (OI.joystickRight.getPOV()== 45)
    	{
    		right = true;
    		up = true;
    	}
    	
    	if (OI.joystickRight.getPOV()== 90)
    	{
    		right = true;
    	}
    	
    	if (OI.joystickRight.getPOV()== 135)
    	{
    		right = true;
    		down = true;
    	}
    	
    	if (OI.joystickRight.getPOV()== 180)
    	{
    		down = true;
    	}
    	
    	if (OI.joystickRight.getPOV()== 225)
    	{
    		left = true;
    		down = true;
    	}
    	
    	if (OI.joystickRight.getPOV()== 270)
    	{
    		left = true;
    	}
    	
    	if (OI.joystickRight.getPOV()== 315)
    	{
    		left = true;
    		up = true;
    	}
    	
    	
    	//if POV is not being pressed the camera will not move
    	if (OI.joystickRight.getPOV()== -1)
    	{
    		left = false;
    		right = false;
    		up = false;
    		down = false;
    	}
    	
    	
    	
    	
    	
    	if (left == true && valueX >= 0)
    	{
    		
    		Robot.camera1.moveX(valueX-0.025);
    	}
    	if (right == true && valueX <= 1)
    	{
    		
    		Robot.camera1.moveX(valueX+0.025);
    	}
    	
    	if (down == true && valueY >= 0)
    	{
    		
    		Robot.camera1.moveY(valueY-0.025);
    	}
    	if (up == true && valueY <= 1)
    	{
    		
    		Robot.camera1.moveY(valueY+0.025);
    	}
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
