package frc.robot.subsystems.panic;

import com.ctre.phoenix6.hardware.TalonFX;

public class Outtake {
  private final int kOuttakeTalonID = 0;
  private final TalonFX intakeTalon = new TalonFX(kOuttakeTalonID);

  public void setVoltage(double volts) {
    intakeTalon.setVoltage(volts);
  }
}
