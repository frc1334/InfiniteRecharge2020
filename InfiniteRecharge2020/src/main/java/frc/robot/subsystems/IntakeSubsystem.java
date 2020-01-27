/*----------------------------------------------------------------------------

Author: Rico Zhu                Date: January 27th, 2020

IntakeSubsystem Class

This subsystem will function for an intake powered by a 775 TalonSRX Motor.

------------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.utils.RobotMap;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class IntakeSubsystem extends SubsystemBase implements Subsystem {

  // Create a new TalonSRX Motor Controller object to control the intake 775 motor
  TalonSRX Intake;
  
  public IntakeSubsystem() {
    // Instantiate new type of TalonSRX for the Intake
    Intake = new TalonSRX(RobotMap.Intake);
  }

  // This is a void method that will allow out Intake motor to spin (based on a percentage based voltage input)
  public void setPercentOutputIntake (double output) {
    // Set the Intake motor to the output parameter speed
    Intake.set(ControlMode.PercentOutput, output);
  }

}
