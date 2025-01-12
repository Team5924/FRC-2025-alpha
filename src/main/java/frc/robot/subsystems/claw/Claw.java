// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.claw;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Claw extends SubsystemBase {
  /** Creates a new claw. */
  private final ClawIO io;

  private final ClawIOInputsAutoLogged inputs = new ClawIOInputsAutoLogged();

  public Claw(ClawIO io) {
    this.io = io;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    io.updateInputs(inputs);
    Logger.processInputs("Claw", inputs);
  }

  public void setPercent(double percent) {
    io.setPercent(percent);
  }
}
