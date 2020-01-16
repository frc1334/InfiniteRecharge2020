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

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LauncherSubsystem extends SubsystemBase {

  TalonFX Launcher1 = new TalonFX(RobotMap.Launcher1);
  TalonFX Launcher2 = new TalonFX(RobotMap.Launcher2);

  public LauncherSubsystem() {

  }

}
