
package frc.robot.subsystems;

import frc.robot.utils.RobotMap;
import frc.robot.utils.Constants;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class ClimberSubsystem extends SubsystemBase implements Subsystem {

  // The Falcon500 (TalonFX) motors used for the climber
  TalonFX ClimbUp;
  TalonFX ClimbDown;

  public ClimberSubsystem() {

    // Initialize the 2 Faclons
    ClimbUp = new TalonFX(RobotMap.ClimbUp);
    ClimbDown = new TalonFX(RobotMap.ClimbDown);

    // Set the ClimbDown Falcon to drive in reverse mode
    ClimbDown.setInverted(true);

    // Attach PID sensors and controllers
    ClimbUp.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);
    ClimbUp.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);

    // Configure PID Tuning parameters

    ClimbUp.config_kP(0, Constants.kClimberUpP);
    ClimbUp.config_kI(0, Constants.kClimberUpI);
    ClimbUp.config_kD(0, Constants.kClimberUpD);
    ClimbUp.config_kF(0, Constants.kClimberUpFF);

    ClimbDown.config_kP(0, Constants.kClimberDownP);
    ClimbDown.config_kI(0, Constants.kClimberDownI);
    ClimbDown.config_kD(0, Constants.kClimberDownD);
    ClimbDown.config_kF(0, Constants.kClimberDownFF);

    // Configure PID output ranges for the ClimbUp and ClimbDown controllers
    ClimbUp.configPeakOutputForward(Constants.kClimberUpMaxOutput);
    ClimbUp.configPeakOutputReverse(Constants.kClimberUpMinOutput);

    ClimbDown.configPeakOutputForward(Constants.kClimberDownMaxOutput);
    ClimbDown.configPeakOutputReverse(Constants.kClimberDownMinOutput);

  }

  // This void method sets the percentage output voltage of the ClimbUp Falcon to 100% for a 0.2 second climb
  public void setClimberUpPercent () {
    ClimbUp.set(ControlMode.PercentOutput, 1.0);
  }

  // This void method sets the percentage output voltage of the ClimbUp Falcon to 100% for a 0.2 second climb
  public void setClimberDownPercent () {
   ClimbDown.set(ControlMode.PercentOutput, 1.0);
  }

  // This void method that sets a positional PID setpoint for the ClimbUp Falcon
  public void setClimberUpPosition (double setpoint) {
    ClimbUp.set(ControlMode.Position, setpoint);
  }

  // This void method that sets a positional PID setpoint for the ClimbDown Falcon
  public void setClimberDownPosition (double setpoint) {
    ClimbDown.set(ControlMode.Position, setpoint);
  }

  // This boolean method will check to see whether the ClimbUp Falcon ahs reached a setpoint
  public boolean inRangeClimbUp (double setpoint) {

    if (Math.abs(ClimbUp.getSelectedSensorPosition(0) - setpoint) <= Constants.kClimbUpTolerance) {
      return true;
    }

    return false;

  }

  // This boolean method will check to see whether the ClimbUp Falcon ahs reached a setpoint
  public boolean inRangeClimbDown (double setpoint) {

    if (Math.abs(ClimbDown.getSelectedSensorPosition(0) - setpoint) <= Constants.kClimbDownTolerance) {
      return true;
    }
  
    return false;
  
  }

}
