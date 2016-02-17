package org.usfirst.frc.team5962.robot.sensors;

public abstract class RobotUltrasonicBase {
    int holdDistance = 12; //distance in inches the robot wants to stay from an object
    final double ultrasonicSpeedConstant = 0.05; //proportional speed constant
	
    protected abstract double getRange();
    
    /**
     * Tells the robot to drive to a set distance (in inches) from an object using proportional control.
     */
	public double getCurrentSpeed() {
		double currentDistance; //distance measured from the ultrasonic sensor values
		double currentSpeed; //speed to set the drive train motors

		currentDistance = getRange();
		currentSpeed = (holdDistance - currentDistance)*ultrasonicSpeedConstant; //convert distance error to a motor speed
		return currentSpeed;
	}

}
