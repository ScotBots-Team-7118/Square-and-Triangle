package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;

public class Sensors implements Pronstants {
	Encoder encL, encR;
	AnalogGyro gyro;

	/**
	 * Constructor for sensors
	 */ 
	public Sensors() {
		// Initializing encoders
		encR = new Encoder(PORT_ENC_R1, PORT_ENC_R2, false); // Right encoder
		encL = new Encoder(PORT_ENC_L1, PORT_ENC_L2, false); // Left encoder

		// Initializing Gyros
		gyro = new AnalogGyro(PORT_GYRO);
	}
}