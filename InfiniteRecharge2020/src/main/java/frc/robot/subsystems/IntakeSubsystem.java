/*----------------------------------------------------------------------------

Author: Rico Zhu                Date: January 27th, 2020

IntakeSubsystem Class

This subsystem will function for an intake powered by a 775 TalonSRX Motor. The
Subsystem also contains 2 DoubleSolenoids for the actuation of the Intake (i.e.,
deployment and retraction).

------------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.utils.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class IntakeSubsystem extends SubsystemBase implements Subsystem {

  // A new TalonSRX Motor Controller object to control the intake 775 motor
  VictorSPX Intake;
  // Double solenoids for the actuation of the intake feed in and out positions
  DoubleSolenoid IntakeSol;

  // This boolean indicates the toggle state of the Intake
  boolean toggle = false;

  public IntakeSubsystem() {
    // Instantiate new type of TalonSRX for the Intake
    Intake = new VictorSPX(RobotMap.Intake);
    // Instantiate the new double solenoid for the Intake pistons
    IntakeSol = new DoubleSolenoid(RobotMap.IntakeSol1, RobotMap.IntakeSol2);
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
      // Deploy, set solenoid to forwards
      IntakeSol.set(DoubleSolenoid.Value.kForward);
    } else if (!deploy) {
      // Retract, set solenoid to reverse
      IntakeSol.set(DoubleSolenoid.Value.kReverse);
    }

  }

  // This void method toggles the intake deployment
  public void toggleIntake () {
    // Deploy the current state of the intake
    deployIntake(toggle);
    // Toggle the toggle boolean
    toggle = !toggle;
  }

}
