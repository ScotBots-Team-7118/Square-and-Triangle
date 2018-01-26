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

	Sensors sensors;

	// open variables:
	/**
	 * Sets right side motors to a certain amount, given by arg
	 */
	public Drive(Sensors sense) {
		sensors = sense;
	}

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

	/**
	 * Sets both sides to a certain value
	 * 
	 * @param amount
	 *            speed for motors
	 */

	void move(double moving) {
		setLeft(moving);
		setRight(moving);
	}

	void stop() {
		setLeft(0);
		setRight(0);
	}

}
