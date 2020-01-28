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

  // The 2 motors driving the front and back belts of the vertical feeder, respectively
  CANSparkMaxPIDWrapper FrontBelt;
  CANSparkMaxPIDWrapper BackBelt;

  public VerticalFeederSubsystem() {

    // Initialize the 2 motors on the VerticalFeederSubsystem
    FrontBelt = new CANSparkMaxPIDWrapper(RobotMap.FrontBelt, 1);
    BackBelt = new CANSparkMaxPIDWrapper(RobotMap.BackBelt, 1);

    // Configure 2 seperate PID control loops for the front and back sides of the belt vertical feeder
    FrontBelt.setPIDValues(Constants.kVerticalFeederFrontP, Constants.kVerticalFeederFrontI, Constants.kVerticalFeederFrontD, Constants.kVerticalFeederFrontFF, 0);
    BackBelt.setPIDValues(Constants.kVerticalFeederBackP, Constants.kVerticalFeederBackI, Constants.kVerticalFeederBackD, Constants.kVerticalFeederBackFF, 0);

    // Configure the peak output voltages for the front and back belt motors
    FrontBelt.setPIDOutputRange(Constants.kVerticalFeederMinOutput, Constants.kVerticalFeederMaxOutput);
    BackBelt.setPIDOutputRange(Constants.kVerticalFeederMinOutput, Constants.kVerticalFeederMaxOutput);

  }

  // This void method would set a PID Velocity target for the FrontBelt motor
  public void setFrontBeltVelocity (double setpoint) {
    FrontBelt.setPIDVelocity(setpoint);
  }

  // This void method would set a PID Velocity target for the BackBelt motor
  public void setBackBeltVelocity (double setpoint) {
    BackBelt.setPIDVelocity(setpoint);
  }

}
