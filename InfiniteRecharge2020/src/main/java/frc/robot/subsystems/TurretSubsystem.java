/*----------------------------------------------------------------------------

Author: Rico Zhu                Date: January 13th, 2019

TurretSubsystem Class

------------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.utils.RobotMap;
import frc.robot.utils.Constants;
import frc.robot.utils.CANSparkMaxPIDWrapper;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TurretSubsystem extends SubsystemBase {

  // Global CANSparkMaxPIDWrapper object used for positional PID control over the turret
  CANSparkMaxPIDWrapper Turret;

  // Public contructor for a new TurretSubsystem
  public TurretSubsystem() {

    // Initialize the Turret CANSparkMaxPIDWrapper
    Turret = new CANSparkMaxPIDWrapper(RobotMap.Turret, Constants.kPositionMode);

    // Set the PID tune parameters and positional conversion factor
    Turret.setPIDValues(Constants.kTurretP, Constants.kTurretI, Constants.kTurretD, Constants.kTurretFF, Constants.kTurretPositionalConversionFactor);;

    // Set the output range (from -1 to 1) on the Turret
    Turret.setPIDOutputRange(Constants.kTurretMinOutput, Constants.kTurretMaxOutput);

  }

  // This void method sets a PID positional setpoint
  public void setTurretPosition (double setpoint) {
    // Make a call to the PIDController embedded into the Turret CANSparkMaxPIDWrapper for positional PID
    Turret.setPIDPosition(setpoint);
  }

}
