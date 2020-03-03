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

  // This boolean variable determines which camera mode the limelight should be on. True means turret tracking, false means regular camera
  boolean toggle = false;

  public LimelightSubsystem() {

    // Initialize the NetworkTable for the limelight
    Table = NetworkTableInstance.getDefault().getTable("limelight");

    // Read the data stream for horizontal angle displacement, vertical angle displacement, and target area
    tx = Table.getEntry("tx");
    ty = Table.getEntry("ty");
    ta = Table.getEntry("ta");

    // Set the default camera mode
    if (!toggle) {
      NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(1);
    } else {
      NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0);
    }

  }

  @Override
  public void periodic() {
    // Update the NetworkTable data stream entries periodically
    xDisplacement = tx.getDouble(0.0);
    yDisplacement = ty.getDouble(0.0);
    targetArea = ta.getDouble(0.0);
  }

  // This is a void method that automatically updates all the limelight network table values
  public void updateLimelightValues () {
    xDisplacement = tx.getDouble(0.0);
    yDisplacement = ty.getDouble(0.0);
    targetArea = ta.getDouble(0.0);
  }

  // This is a double getter method for retrieving the horizontal angle displacement
  public double getXDisplacement() {
    xDisplacement = tx.getDouble(0.0);
    return xDisplacement;
  }

  // This is a double getter method for retrieving the vertical angle displacement
  public double getYDisplacement() {
    yDisplacement = ty.getDouble(0.0);
    return yDisplacement;
  }

  // This is a double getter method for retrieving the target area
  public double getTargetArea() {
    targetArea = ta.getDouble(0.0);
    return targetArea;
  }

  // This void method enables the regular camera mode
  public void enableRegCamMode () {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(1);
    // Update toggle to the correct mode; used for enabling instant toggle afterwards
    toggle = false;
  }

  // This void method enables the turret tracking camera mode
  public void enableTurretTrackCamMode () {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0);
    // Update toggle to the correct mode; used for enabling instant toggle afterwards
    toggle = true;
  }

  // This void method toggles the camera modes between regular camera to turret tracking mode
  public void toggleCameraMode () {

    // Swap the camera modes by toggling the toggle boolean variable
    toggle = !toggle;

    // Update the camera mode
    if (!toggle) {
      enableRegCamMode();
    } else {
      enableTurretTrackCamMode();
    }

  }

}
