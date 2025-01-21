package frc.robot.subsystems.panic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private final int kIntakeTalonID = 0;
  private final TalonFX intakeTalon = new TalonFX(kIntakeTalonID);

  public void setVoltage(double volts) {
    intakeTalon.setVoltage(volts);
  }
}
