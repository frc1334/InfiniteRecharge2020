/*----------------------------------------------------------------------------

Author: Rico Zhu                Date: January 27th, 2020

PneumaticsSubsystem Class

This subsystem will support the Compressor, for which the Robot's Pneumatics will
run off of.

------------------------------------------------------------------------------*/
package frc.robot.subsystems;

import frc.robot.utils.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticsSubsytem extends SubsystemBase {

  // Create a new Compressor that will be created during the constructor
  Compressor Compressor;  

  public PneumaticsSubsytem() {
    // Instantiate a new Compressor object
    Compressor = new Compressor(RobotMap.Compressor);
    // Start the Compressor control loop
    Compressor.setClosedLoopControl(true);
  }

  // This method manually enables/disables the Compressor close loop control call depending on an input argument
  public void setCompressorState (boolean state) {
    // Set the state of the Compressor close loop control (on/off) based on the input parameter
    Compressor.setClosedLoopControl(state);
  }

}
