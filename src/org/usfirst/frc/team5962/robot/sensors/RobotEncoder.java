package org.usfirst.frc.team5962.robot.sensors;

import edu.wpi.first.wpilibj.Encoder;

public class RobotEncoder {
	//encoders
	Encoder encoder;

	public RobotEncoder() {
		encoder = new Encoder(3, 4, false, Encoder.EncodingType.k4X);
	}
}
