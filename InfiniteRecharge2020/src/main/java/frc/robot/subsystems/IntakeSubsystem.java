/*----------------------------------------------------------------------------

Author: Rico Zhu                Date: January 27th, 2020

IntakeSubsystem Class

This subsystem will function for an intake powered by a 775 TalonSRX Motor.

------------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.utils.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class IntakeSubsystem extends SubsystemBase implements Subsystem {

  // A new TalonSRX Motor Controller object to control the intake 775 motor
  TalonSRX Intake;
  // Double solenoids for the actuation of the intake feed in and out positions
  DoubleSolenoid IntakeLeft;
  DoubleSolenoid IntakeRight;

  public IntakeSubsystem() {
    // Instantiate new type of TalonSRX for the Intake
    Intake = new TalonSRX(RobotMap.Intake);
    // Instantiate the 2 new double solenoids for the Intake pistons, one on the left and one on the right
    IntakeLeft = new DoubleSolenoid(RobotMap.IntakeLeft1, RobotMap.IntakeLeft2);
    IntakeRight = new DoubleSolenoid(RobotMap.IntakeRight1, RobotMap.IntakeRight2);
  }

  // This is a void method that will allow out Intake motor to spin (based on a percentage based voltage input)
  public void setPercentOutputIntake (double output) {
    // Set the Intake motor to the output parameter speed
    Intake.set(ControlMode.PercentOutput, output);
  }

  // This is a void method for deploying the Intake via actuating the pistons. The parameter deploy indicates whether to deploy or retract the intake
  public void deployIntake (boolean deploy) {

    // Check for the deployment states: deploy and retract (true or false on the deploy argument)
    if (deploy) {
      // Deploy, set both double solenoids to forwards
      IntakeLeft.set(DoubleSolenoid.Value.kForward);
      IntakeRight.set(DoubleSolenoid.Value.kForward);
    } else if (!deploy) {
      // Retract, set both double solenoids to reverse
      IntakeLeft.set(DoubleSolenoid.Value.kReverse);
      IntakeRight.set(DoubleSolenoid.Value.kReverse);
    }

  }

}
