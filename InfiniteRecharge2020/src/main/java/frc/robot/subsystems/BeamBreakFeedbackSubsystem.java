/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.utils.BeamBreakSensor;
import frc.robot.utils.RobotMap;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BeamBreakFeedbackSubsystem extends SubsystemBase implements Subsystem {

  // The Beam Break Sensor used to track balls entering the indexer
  BeamBreakSensor Indexer;
  // The Beam Break Sensor used to track balls entering the vertical feeder
  BeamBreakSensor VerticalFeeder;
  // The Beam Break Sensor used to track balls entering the accelerator wheel
  BeamBreakSensor AcceleratorWheel;

  public BeamBreakFeedbackSubsystem () {
    // Initialize the new BeamBreak Sensors to their respective RoboRio DIO ports
    Indexer = new BeamBreakSensor(RobotMap.IndexerBB);
    VerticalFeeder = new BeamBreakSensor(RobotMap.VerticalFeederBB);
    AcceleratorWheel = new BeamBreakSensor(RobotMap.AcceleratorWheelBB);
  }

  @Override
  public void periodic () {
    // This method will be called once per scheduler run
    
  }

}
