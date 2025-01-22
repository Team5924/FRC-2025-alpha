package frc.robot.subsystems.panic;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Outtake extends SubsystemBase {
  private final int kOuttakeTalonID = 57;
  private final TalonFX intakeTalon = new TalonFX(kOuttakeTalonID);

  public void setVoltage(double volts) {
    intakeTalon.setVoltage(-volts);
  }
}
