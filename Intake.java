package org.usfirst.frc.team7118.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Intake {

	TalonSRX TalR = new TalonSRX();
	TalonSRX TalL = new TalonSRX();

	public Intake(double speed) {
		TalR.set(speed);
		TalL.set(speed);
	}

	public void stop(boolean stopping) {
		TalR.set(0);
		TalL.set(0);
	}
}
