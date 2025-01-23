// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Elevator extends SubsystemBase {
  /** Creates a new elevator. */
  private final ElevatorIO io;

  private final ElevatorIOInputsAutoLogged inputs = new ElevatorIOInputsAutoLogged();

  public enum ElevatorState {
    INTAKE,
    L1,
    L2,
    L3,
    L4,
    MOVING_TO_SETPOINT
  }

  private ElevatorState goalState;
  private ElevatorState state;

  public Elevator(ElevatorIO io) {
    this.io = io;
    this.goalState = ElevatorState.INTAKE;
    this.state = ElevatorState.INTAKE;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    io.updateInputs(inputs);
    Logger.processInputs("Elevator", inputs);
  }

  public void setGoalState(ElevatorState goalState) {}
}
