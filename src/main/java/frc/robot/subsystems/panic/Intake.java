package frc.robot.subsystems.panic;

import com.ctre.phoenix6.hardware.TalonFX;

public class Intake {
  private final int kIntakeTalonID = 0;
  private final TalonFX intakeTalon = new TalonFX(kIntakeTalonID);

  public void setVoltage(double volts) {
    intakeTalon.setVoltage(volts);
  }
}
