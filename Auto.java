,jc// Welcome to the Auto class here we have all the auto code in an easy!
package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogGyro;
import org.usfirst.frc.team3070.robot.Drive;

public class Auto implements Pronstants {
	Drive drive;
	Sensors sensors;

	/**
	 * Constructor for auto
	 * 
	 * @param d
	 *            Drive
	 * @param 
	 *            Sensors
	 */
	public Auto(Drive d, Sensors s) {
		drive = d;
		sensors = s;
	
	}
	

	// Variables used in subcodes-need to change later
	boolean turned = false;
	int case_number = 1;
	boolean square = false;
	boolean triangle = false;
	boolean forward = false;
	

	/**
	 * Runs state machine to select which auto to run
	 */
	public void auto() {
			for(int i =0; i<=3; i=i) {
				if (square){//do this code if the goal is a square, sequence will repeat 4 times
					if(sensors.encR.get() <= 15 && sensors.encL.get() <= 15) {
						drive.move(STANDARD_SPEED);
				}// if the rotations are less than 15 move at standard speed
					if (sensors.encR.get() >= 15 && sensors.encL.get() >= 15) {
						drive.stop();
						forward = true;
				}// if the rotations are more than 15 stop and forward = true
					if (forward && sensors.gyro.getAngle() <= 90) {
						drive.setRight(STRONG_SPEED);
						drive.setLeft(WEAK_SPEED);//if turned is true and you haven't turned 90 degrees start turning
						if(sensors.gyro.getAngle() >= 90) {
							drive.stop();
							turned = true;// when robot turns 90 degrees true and sequence is over
				}
							if (turned) {
								sensors.encR.reset();
								sensors.encL.reset();
								forward = false;
								turned = false;
								i++;// reset all things and increase i by 1
							}
						}
					}
				}
			for(int i = 0; i<=2; i=i) {
				if (triangle){// do this is the goal is a triangle, sequence will repeat 3 times
					if(sensors.encR.get() <= 15 && sensors.encL.get() <= 15) {
						drive.move(STANDARD_SPEED);
				}// if there is less than 15 robot will srive forward
					if (sensors.encR.get() >= 15 && sensors.encL.get() >= 15) {
						drive.stop();
						forward = true;
				}// when the rotations are more than 15 robot stops and forward = true
					if (forward && sensors.gyro.getAngle() <= 120) {
						drive.setRight(STRONG_SPEED);
						drive.setLeft(WEAK_SPEED);// if forward is true and it has gone forward robot will turn 
						if(sensors.gyro.getAngle() >= 120) {
							drive.stop();
							turned = true;// when the robot turns 60 degrees stop and the sequence is over
				}
							if (turned) {
								sensors.encR.reset();
								sensors.encL.reset();
								forward = false;
								turned = false;
								i++;//reset all the things and increase i by 1
							}
						}
					}
				}
			}
		}