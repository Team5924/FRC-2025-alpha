// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.claw;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.constants.ClawConstants;

/** Add your docs here. */
public class ClawIOVictorSPX implements ClawIO {
  // Leader
  private final VictorSPX victor = new VictorSPX(ClawConstants.kClawVictorId);

  public ClawIOVictorSPX() {}

  @Override
  public void updateInputs(ClawIOInputs inputs) {
    inputs.clawMotorAppliedVoltage = victor.getMotorOutputVoltage();
  }

  @Override
  public void setPercent(double percent) {
    victor.set(ControlMode.PercentOutput, percent);
  }
}
