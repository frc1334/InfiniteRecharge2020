/*----------------------------------------------------------------------------

Author: Rico Zhu, Emily DiLauro and Nolan Smyth              Date: January 14th, 2020

LimelightSubsystem Class

------------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightSubsystem extends SubsystemBase {

  // NetworkTable for the Limelight camera (contains list of NetworkTableEntries, which are bits of a continuous data stream)
  NetworkTable Table;
  // NetworkTable data stream (aka an entry) for horizontal angle displacement, vertical angle displacement, and target area
  NetworkTableEntry tx;
  NetworkTableEntry ty;
  NetworkTableEntry ta;

  public LimelightSubsystem() {

    // Initialize the NetworkTable for the limelight
    Table = NetworkTableInstance.getDefault().getTable("limelight");

    // Read the data stream for horizontal angle displacement, vertical angle displacement, and target area
    tx = Table.getEntry("tx");
    ty = Table.getEntry("ty");
    ta = Table.getEntry("ta");

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
