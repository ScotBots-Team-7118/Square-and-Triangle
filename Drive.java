package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team3070.robot.Robot;

public class Drive {

	TalonSRX TalRM = new TalonSRX(Pronstants.PORT_RM); // Right master Talon
	TalonSRX TalRF = new TalonSRX(Pronstants.PORT_RF); // Right follower Talon
	TalonSRX TalLM = new TalonSRX(Pronstants.PORT_LM); // Left master Talon
	TalonSRX TalLF = new TalonSRX(Pronstants.PORT_LF); // Left follower Talon
	Encoder encR = new Encoder(Pronstants.PORT_ENC_R1, Pronstants.PORT_ENC_R2, false); // Right encoder
	Encoder encL = new Encoder(Pronstants.PORT_ENC_L1, Pronstants.PORT_ENC_L2, false); // Left encoder

	// open variables:
	/**
	 * Sets right side motors to a certain amount, given by arg
	 */

	void setRight(double amountR) {
		TalRM.set(ControlMode.PercentOutput, amountR);
		TalRF.set(ControlMode.Follower, Pronstants.PORT_RF);
	}

	/**
	 * Sets left side motors to a certain amount, given by arg
	 */
	void setLeft(double amountL) {
		TalLM.set(ControlMode.PercentOutput, amountL);
		TalLF.set(ControlMode.Follower, Pronstants.PORT_LF);
	}

	void stop(boolean stopping) {
		setRight(0);
		setLeft(0);
	}

	/**
	 * Constructor for Drive
	 * 
	 * @param rm
	 *            right master
	 * @param rf
	 *            right follower
	 * @param lm
	 *            left master
	 * @param lf
	 *            left follower
	 */
	
	

	boolean move1(double moving, int rotations) {
	

			if (encR.getDistance() < rotations && encL.getDistance() < rotations) {
				setRight(moving);
				setLeft(moving);
				return false;
			}else {
				encR.reset();
				encL.reset();
				stop();
				return true;
			}
	}

	/**
	 * Sets both sides to a certain value
	 * 
	 * @param amount
	 *            speed for motors
	 */

	void move(double moving) {
		setLeft(Pronstants.STANDARD_SPEED);
		setRight(Pronstants.STANDARD_SPEED);
	}

	void stop() {
		setLeft(0);
		setRight(0);
	}

}
