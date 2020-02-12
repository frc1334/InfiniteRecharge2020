
package frc.robot.subsystems;

import frc.robot.utils.RobotMap;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class ClimberSubsystem extends SubsystemBase implements Subsystem {

  // The Falcon500 (TalonFX) motors used for the climber
  TalonFX ClimbRight = new TalonFX(RobotMap.ClimbRight);
  TalonFX ClimbLeft = new TalonFX(RobotMap.ClimbLeft);

  public ClimberSubsystem() {
    // Invert the 2 Falcons so that they don't run against each other
    ClimbLeft.setInverted(false);
    ClimbRight.setInverted(true);
  }

  // This void method sets the percentage output voltage of the 2 Falcons
  public void setClimberVoltage (double voltage) {
    ClimbLeft.set(ControlMode.PercentOutput, voltage);
    ClimbRight.set(ControlMode.PercentOutput, voltage);
  }

}
