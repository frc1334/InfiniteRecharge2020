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

    // Set the second Talon to follow the first Talon
    Launcher2.set(ControlMode.Follower, RobotMap.Launcher1);

    // Invert the first Talon (Left and Right can now run the same Velocity PID RPM)
    Launcher1.setInverted(true);

    // Since the second Talon is on follower mode, only the first Talon needs to be tuned for PID. (The second Talon will follow ALL voltage signals, uninverted)
    Launcher1.config_kP(0, Constants.kLauncherP);
    Launcher1.config_kI(0, Constants.kLauncherI);
    Launcher1.config_kD(0, Constants.kLauncherD);
    Launcher1.config_kF(0, Constants.kLauncherFF);

    Launcher2.config_kP(0, Constants.kLauncherP);
    Launcher2.config_kI(0, Constants.kLauncherI);
    Launcher2.config_kD(0, Constants.kLauncherD);
    Launcher2.config_kF(0, Constants.kLauncherFF);

    // Configure the peak output (max in magnitude both forwards and reverse) for the first Talon
    Launcher1.configPeakOutputForward(Constants.kLauncherMaxOutput);
    Launcher1.configPeakOutputReverse(Constants.kLauncherMinOutput);

    Launcher2.configPeakOutputForward(Constants.kLauncherMaxOutput);
    Launcher2.configPeakOutputReverse(Constants.kLauncherMinOutput);

  }

  // This void method sets a velocity PID setpoint on the Talons
  public void setLauncherVelocity (double setpoint) {
    // Set the first Talon's PID target to the setpoing (second Talon will follow)
    Launcher1.set(ControlMode.Velocity, setpoint);
    Launcher2.set(ControlMode.Velocity, setpoint);
    System.out.println("LAUNCHER: " + Launcher1.getSelectedSensorVelocity());
  }

  // This void method manually sets the percent power input to the Launcher Falcons
  public void setLauncherPercent (double percent) {
    Launcher1.set(ControlMode.PercentOutput, percent);
    Launcher2.set(ControlMode.PercentOutput, percent);
    System.out.println("LAUNCHER: " + Launcher1.getSelectedSensorVelocity());
  }

}
