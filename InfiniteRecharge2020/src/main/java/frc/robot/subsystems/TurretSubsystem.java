/*----------------------------------------------------------------------------

Author: Rico Zhu, Emily DiLauro and Nolan Smyth                 Date: January 13th, 2020

TurretSubsystem Class

This is a subsytem that uses Positional PID called TurretSubsytem for the Turret. 

It packages frc.robot.subsystems

It contaions methods for setting positional PID control over the turret, initalizes 
the CANSparkMaxPIDWrapper, sets the parameters for the positional conversion factor, 
sets the min and max output range and calls the controller for the positional setpoint.

------------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.utils.RobotMap;
import frc.robot.utils.Constants;
import frc.robot.utils.CANSparkMaxPIDWrapper;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TurretSubsystem extends SubsystemBase implements Subsystem {

  // Global CANSparkMaxPIDWrapper object used for positional PID control over the turret
  CANSparkMaxPIDWrapper Turret;

  // Public contructor for a new TurretSubsystem
  public TurretSubsystem() {

    // Initialize the Turret CANSparkMaxPIDWrapper
    Turret = new CANSparkMaxPIDWrapper(RobotMap.Turret, Constants.kPositionMode);

    // Set the PID tune parameters and positional conversion factor
    Turret.setPIDValues(Constants.kTurretP, Constants.kTurretI,
     Constants.kTurretD, Constants.kTurretFF, Constants.kTurretPositionalConversionFactor);;

    // Set the output range (from -1 to 1) on the Turret
    Turret.setPIDOutputRange(Constants.kTurretMinOutput, Constants.kTurretMaxOutput);

  }

  // This void method sets a PID positional setpoint
  public void setTurretPosition (double setpoint) {
    // Make a call to the PIDController embedded into the Turret CANSparkMaxPIDWrapper for positional PID
    Turret.setPIDPosition(setpoint);
  }

  // This double method returns the current turret position
  public double getTurretPosition () {
    return Turret.getPosition();
  }

  // This void method runs percent input into the Turret SparkMax
  public void turretPercentOutput (double output) {
    Turret.setPercentOutput(output);
  }

  // This boolean method returns whether the current position is within range of an argument setpoint
  public boolean inRange (double setpoint) {

    // See if the current position is within 
    if (Math.abs(setpoint - getTurretPosition()) <= Constants.kTurretTolerance) {
      return true;
    }

    // Otherwise, return false
    return false;

  }

}
