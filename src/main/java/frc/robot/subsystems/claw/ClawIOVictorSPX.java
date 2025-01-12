// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.claw;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.constants.ElevatorConstants;

/** Add your docs here. */
public class ClawIOVictorSPX implements ClawIO {
  // Leader
  private final VictorSPX leftTalon = new VictorSPX(ElevatorConstants.kClawTalonId);

  public ClawIOVictorSPX() {}

  @Override
  public void updateInputs(ClawIOInputs inputs) {
    // inputs.leftMotorAppliedVoltage = leftTalon.getMotorVoltage().getValueAsDouble();
    // inputs.rightMotorAppliedVoltage = rightTalon.getMotorVoltage().getValueAsDouble();
    // inputs.clawMotorAppliedVoltage = leftTalon.getMotorOutputVoltage().getValueAsDouble();
  }

  @Override
  public void setPercent(double percent) {
    leftTalon.set(ControlMode.PercentOutput, percent);
    // rightTalon.setVoltage(-volts);
  }
}
