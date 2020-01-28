/*----------------------------------------------------------------------------

Author: Rico Zhu and Emily DiLauro                Date: January 28th, 2020

IndexerSubsystem Class

------------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.utils.RobotMap;
import frc.robot.utils.Constants;
import frc.robot.utils.CANSparkMaxPIDWrapper;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IndexerSubsystem extends SubsystemBase implements Subsystem {

  // The motor at the front of the hopper. Feeds and centers the balls via a mechanum base
  CANSparkMaxPIDWrapper Feeder;

  public IndexerSubsystem() {
    // Initialize the feeder motor on the IndexerSubsystem
    Feeder = new CANSparkMaxPIDWrapper(RobotMap.Feeder, 1);
  }

}
