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
  }

}
