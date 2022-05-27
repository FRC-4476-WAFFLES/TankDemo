// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Victor;

/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive myRobot;
  private Joystick leftStick;

  private final Victor left1 = new Victor(0);
  private final Victor left2 = new Victor(1);

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. 

    MotorControllerGroup leftMotors = new MotorControllerGroup(left1, left2);

    myRobot = new DifferentialDrive(leftMotors, rightMotors);
    leftStick = new Joystick(0);
  }

  @Override
  public void teleopPeriodic() {
    myRobot.tankDrive(leftStick.getY(), rightStick);
  }
}
