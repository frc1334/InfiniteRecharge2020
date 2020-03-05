/*----------------------------------------------------------------------------

Author: Rico Zhu and Emily DiLauro                Date: January 28th, 2020

VerticalFeederSubsystem Class

------------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.utils.RobotMap;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class VerticalFeederSubsystem extends SubsystemBase implements Subsystem {

  // The motor driving the belt upwards
  VictorSPX Belt;

  public VerticalFeederSubsystem() {
    // Initialize the 2 motors on the VerticalFeederSubsystem
    Belt = new VictorSPX(RobotMap.Belt);
    Belt.setInverted(true);
  }

  // This void method would set a voltage target for the Belt motor
  public void setVerticalFeederVoltage (double voltage) {
    Belt.set(ControlMode.PercentOutput, voltage);
  }

}
