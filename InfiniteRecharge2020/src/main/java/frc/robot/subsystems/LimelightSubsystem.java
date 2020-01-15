/*----------------------------------------------------------------------------

Author: Rico Zhu, Emily DiLauro and Nolan Smyth              Date: January 14th, 2019

LimelightSubsystem Class

------------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightSubsystem extends SubsystemBase {

  // Network table for the Limelight camera (contains list of NetworkTableEntries, which are bits of a continuous data stream)
  NetworkTable Table = NetworkTableInstance.getDefault().getTable("limelight");

  NetworkTableEntry tx = Table.getEntry("tx");
  NetworkTableEntry ty = Table.getEntry("ty");
  NetworkTableEntry ta = Table.getEntry("ta");

  public LimelightSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
