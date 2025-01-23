// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Celsius;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.Volts;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Temperature;
import edu.wpi.first.units.measure.Voltage;
import frc.robot.constants.ShooterConstants;

/** Add your docs here. */
public class ShooterIOTalonFX implements ShooterIO {
  // Leader
  private final TalonFX talon;

  private final StatusSignal<AngularVelocity> velocity;
  private final StatusSignal<Voltage> appliedVolts;
  private final StatusSignal<Current> supplyCurrent;
  private final StatusSignal<Current> torqueCurrent;
  private final StatusSignal<Temperature> tempCelsius;

  private final VoltageOut voltageControl =
      new VoltageOut(0).withUpdateFreqHz(0.0).withEnableFOC(true);

  public ShooterIOTalonFX() {
    talon = new TalonFX(ShooterConstants.kShooterTalonId);

    // General config
    final TalonFXConfiguration talonConfig = new TalonFXConfiguration();
    talonConfig.CurrentLimits.SupplyCurrentLimit = 60.0;
    talonConfig.CurrentLimits.SupplyCurrentLimitEnable = true;
    talonConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    talonConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    talonConfig.Feedback.SensorToMechanismRatio = 4;

    final Slot0Configs controllerConfig = new Slot0Configs();
    controllerConfig.kP = 0;
    controllerConfig.kI = 0;
    controllerConfig.kD = 0;
    controllerConfig.kS = 0;

    talon.getConfigurator().apply(talonConfig, 1.0);
    talon.getConfigurator().apply(controllerConfig, 1.0);

    velocity = talon.getVelocity();
    appliedVolts = talon.getMotorVoltage();
    supplyCurrent = talon.getSupplyCurrent();
    torqueCurrent = talon.getTorqueCurrent();
    tempCelsius = talon.getDeviceTemp();

    BaseStatusSignal.setUpdateFrequencyForAll(
        100.0, velocity, appliedVolts, supplyCurrent, torqueCurrent, tempCelsius);
  }

  @Override
  public void updateInputs(ShooterIOInputs inputs) {
    inputs.motorConnected =
        BaseStatusSignal.refreshAll(
                velocity, appliedVolts, supplyCurrent, torqueCurrent, tempCelsius)
            .isOK();

    inputs.velocityRadsPerSec = velocity.getValue().in(RadiansPerSecond);
    inputs.appliedVolts = appliedVolts.getValue().in(Volts);
    inputs.supplyCurrentAmps = supplyCurrent.getValue().in(Amps);
    inputs.torqueCurrentAmps = torqueCurrent.getValue().in(Amps);
    inputs.tempCelsius = tempCelsius.getValue().in(Celsius);
  }

  @Override
  public void setVoltage(double volts) {
    talon.setControl(voltageControl.withOutput(volts));
  }
}
