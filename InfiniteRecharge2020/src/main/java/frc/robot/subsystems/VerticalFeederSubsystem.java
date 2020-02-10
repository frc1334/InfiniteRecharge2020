/*----------------------------------------------------------------------------

Author: Rico Zhu and Emily DiLauro                Date: January 28th, 2020

VerticalFeederSubsystem Class

------------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.utils.RobotMap;
import frc.robot.utils.Constants;
import frc.robot.utils.CANSparkMaxPIDWrapper;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VerticalFeederSubsystem extends SubsystemBase implements Subsystem {

  // The motor driving the belt upwards (assumed to be NEO)
  CANSparkMaxPIDWrapper Belt;

  public VerticalFeederSubsystem() {

    // Initialize the 2 motors on the VerticalFeederSubsystem
    Belt = new CANSparkMaxPIDWrapper(RobotMap.Belt, 1);
  
    // Configure the PID control loop for the belt vertical feeder
    Belt.setPIDValues(Constants.kVerticalFeederP, Constants.kVerticalFeederI, Constants.kVerticalFeederD, Constants.kVerticalFeederFF, 0);

    // Configure the peak output voltages for the belt motor
    Belt.setPIDOutputRange(Constants.kVerticalFeederMinOutput, Constants.kVerticalFeederMaxOutput);
  
  }

  // This void method would set a PID Velocity target for the Belt motor
  public void setVerticalFeederVelocity (double setpoint) {
    Belt.setPIDVelocity(setpoint);
  }

}
