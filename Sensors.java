package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;

public class Sensors implements Pronstants {
	Encoder encoderL, encoderR;
	AnalogGyro gyro;

	/**
	 * Constructor for sensors
	 */
	public Sensors() {
		// Initializing encoders
		long encR = encoderR/4096;
		long encL = encoder L/4096;
		
		encoderR = new Encoder(PORT_ENC_R1, PORT_ENC_R2, false); // Right encoder
		encoderL = new Encoder(PORT_ENC_L1, PORT_ENC_L2, false); // Left encoder

		// Initializing Gyros
		gyro = new AnalogGyro(PORT_GYRO);
	}
}