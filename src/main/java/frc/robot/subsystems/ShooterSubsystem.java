// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new Shooter. */
  TalonFX shooterMotor;
  
  RobotContainer robotContainer = new RobotContainer();

  public ShooterSubsystem() {
    shooterMotor = new TalonFX(Constants.SHOOTER_CHANNEL);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void spinShooter() { //double speed
    double r_joyStickY = robotContainer.r_joystick.getY();
    double speed= 0;

    if (r_joyStickY > 0.5) {
      speed = 0.5;
    }
    if (0.5 > r_joyStickY & r_joyStickY > 0) {
      speed = 0.2;
    }
    if (r_joyStickY < -0.5) {
      speed = -0.5;
    }
    if (-0.5 < r_joyStickY & r_joyStickY < 0) {
      speed = -0.2;
    }
    shooterMotor.set(ControlMode.PercentOutput, speed);
  }
}
