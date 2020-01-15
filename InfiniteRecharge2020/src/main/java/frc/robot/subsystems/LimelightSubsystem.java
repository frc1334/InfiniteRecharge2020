/*----------------------------------------------------------------------------

Author: Rico Zhu, Emily DiLauro and Nolan Smyth              Date: January 14th, 2020

LimelightSubsystem Class

Set up NetworkTable and varibles for xDisplacement, yDisplacement and targetArea for LimeLight. 
Creat getter methods for xDisplacement, yDisplacement and targetArea.

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

  // Variables from for storing the Limelight NetworkTable stream updates
  double xDisplacement;
  double yDisplacement;
  double targetArea;

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
    // Update the NetworkTable data stream entries periodically
    xDisplacement = tx.getDouble(0.0);
    yDisplacement = ty.getDouble(0.0);
    targetArea = ta.getDouble(0.0);
  }

  // This is a double getter method for retrieving the horizontal angle displacement
  public double getXDisplacement() {
    return xDisplacement;
  }

  // This is a double getter method for retrieving the vertical angle displacement
  public double getYDisplacement() {
    return yDisplacement;
  }

  // This is a double getter method for retrieving the target area
  public double getTargetArea() {
    return targetArea;
  }

}
