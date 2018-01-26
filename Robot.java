/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();

	Joystick JoyR = new Joystick(0);
	Joystick JoyL = new Joystick(1);
	Encoder encR = new Encoder(Pronstants.PORT_ENC_R1, Pronstants.PORT_ENC_R2, false); // Right encoder
	Encoder encL = new Encoder(Pronstants.PORT_ENC_L1, Pronstants.PORT_ENC_L2, false); // Left encoder

	// Initializing class instances
	Drive drive;
	Sensors sensors;
	Auto auto;

	boolean Turned = false;

	public enum Auto_Path { // List of all possible paths (PATH_[Left, Center, or Right starting
							// postition][sCale or sWitch][Right or Left Side])
		PATH_LCL, // Left starting position combinations
		PATH_LWL, PATH_LCR, PATH_LWR,

		PATH_CCL, // Center starting position combinations
		PATH_CWL, PATH_CCR, PATH_CWR,

		PATH_RCL, // Right starting position combinations
		PATH_RWL, PATH_RCR, PATH_RWR
	}

	// Initializing Gyros-caused crashess
	AnalogGyro gyro = new AnalogGyro(Pronstants.PORT_GYRO);
	Auto_Path impPath = Auto_Path.PATH_LCL;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_chooser.addDefault("Default Auto", kDefaultAuto);
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);
		auto = new Auto(drive, sensors);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString line to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the SendableChooser
	 * make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {

		auto.auto();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		double amountL = (-1 * (JoyL.getRawAxis(1)/* * (-1 * (JoyL.getRawAxis(2) / 2)) */));
		if (amountL >= .2 || amountL <= -.2) {
			drive.setLeft(amountL);
		} else {
			drive.stop(true);
		}
		double amountR = (-1 * (JoyR.getRawAxis(1)/* * (-1 * (JoyR.getRawAxis(2) / 2)) */));
		if (amountR >= .2 || amountR <= -.2) {
			drive.setRight(amountR);
		} else {
			drive.stop(true);
		}

		if (JoyR.getRawButton(1) || JoyL.getRawButton(1)) {
			System.out.println("pew pew");
		}

	}

	@Override
	public void testPeriodic() {
	}

}
