package org.usfirst.frc.team5962.robot.sensors;

import edu.wpi.first.wpilibj.Encoder;

public class RobotEncoder {
	//encoders
	Encoder encoder;

	public RobotEncoder() {
		encoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	}
}
