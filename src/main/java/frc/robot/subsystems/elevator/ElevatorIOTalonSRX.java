// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.constants.ElevatorConstants;

/** Add your docs here. */
public class ElevatorIOTalonSRX implements ElevatorIO {
  // Leader
  private final WPI_TalonSRX leftTalon = new WPI_TalonSRX(ElevatorConstants.kLeftTalonId);
  // Follower
  private final WPI_TalonSRX rightTalon = new WPI_TalonSRX(ElevatorConstants.kRightTalonId);

  public ElevatorIOTalonSRX() {}

  @Override
  public void updateInputs(ElevatorIOInputs inputs) {
    // inputs.leftMotorAppliedVoltage = leftTalon.getMotorVoltage().getValueAsDouble();
    // inputs.rightMotorAppliedVoltage = rightTalon.getMotorVoltage().getValueAsDouble();
  }

  @Override
  public void setVoltage(double volts) {
    leftTalon.setVoltage(volts);
    rightTalon.setVoltage(-volts);
  }
}
