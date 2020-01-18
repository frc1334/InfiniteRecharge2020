/*----------------------------------------------------------------------------

Author: Rico Zhu, Emily DiLauro and Nolan Smyth              Date: January 13th, 2020

LauncherSubsystem Class

This is a launcher subsytem called the LancherSubsystem.
It packages the frc.robot.subsystems and imports the RobotMap, Constants and TalonFX
SubsystemBase.

It initializes Launcher1 and Launcher2 and will run velocity PID on it.

------------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.utils.RobotMap; 
import frc.robot.utils.Constants;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LauncherSubsystem extends SubsystemBase {

  // The Launcher Talons; 1 is left and 2 is right.
  TalonFX Launcher1 = new TalonFX(RobotMap.Launcher1);
  TalonFX Launcher2 = new TalonFX(RobotMap.Launcher2);

  public LauncherSubsystem() {

    // Configure the default Integrated Sensors for the Talons
    Launcher1.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);
    Launcher2.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);

    // Invert the first Talon (Left and Right can now run the same Velocity PID RPM)
    Launcher1.setInverted(true);

  }

}
