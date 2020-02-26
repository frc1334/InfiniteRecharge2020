
package frc.robot.subsystems;

import frc.robot.utils.RobotMap;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class ClimberSubsystem extends SubsystemBase implements Subsystem {

  // The Falcon500 (TalonFX) motors used for the climber
  TalonFX ClimbUp = new TalonFX(RobotMap.ClimbUp);
  TalonFX ClimbDown = new TalonFX(RobotMap.ClimbDown);

  public ClimberSubsystem() {
  }

  // This void method sets the percentage output voltage of the ClimbUp Falcon to 100% for a 0.2 second climb
  public void setClimberUp () {
    ClimbUp.set(ControlMode.PercentOutput, 1.0);
  }

  // This void method sets the percentage output voltage of the ClimbUp Falcon to 100% for a 0.2 second climb
  public void setClimberDown () {
   ClimbDown.set(ControlMode.PercentOutput, 1.0);
  }

}
