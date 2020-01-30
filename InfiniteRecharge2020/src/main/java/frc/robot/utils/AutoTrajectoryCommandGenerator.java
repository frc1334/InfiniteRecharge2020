/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.utils;

import frc.robot.Robot;

import java.io.IOException;
import java.nio.file.Path;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;

public class AutoTrajectoryCommandGenerator {

    Path trajectoryPath;
    Trajectory trajectory;

    // The default constructor takes in a string for the location of the Path Weaver generated json file (with coordinates)
    public AutoTrajectoryCommandGenerator (String AutoPathWeaverJSON) {

        try {
            trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(AutoPathWeaverJSON);
            trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);
        } catch (IOException ex) {
            DriverStation.reportError("Unable to open trajectory: " + AutoPathWeaverJSON, ex.getStackTrace());
        }

    }

    // This Command method returns a Command (RamseteCommand) from a given string path to a Path Weaver json file
    public Command generateCommand (String AutoPathWeaverJSON) {
        
        try {
            trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(AutoPathWeaverJSON);
            trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);
        } catch (IOException ex) {
            DriverStation.reportError("Unable to open trajectory: " + AutoPathWeaverJSON, ex.getStackTrace());
        }

        // Create a voltage constraint to ensure we don't accelerate too fast
        var autoVoltageConstraint =
            new DifferentialDriveVoltageConstraint(
                new SimpleMotorFeedforward(Constants.ksVolts,
                                        Constants.kvVoltSecondsPerMeter,
                                        Constants.kaVoltSecondsSquaredPerMeter),
                Constants.kDriveKinematics,
                10);

        // Create config for trajectory
        TrajectoryConfig config =
            new TrajectoryConfig(Constants.kMaxSpeedMetersPerSecond,
                                Constants.kMaxAccelerationMetersPerSecondSquared)
                // Add kinematics to ensure max speed is actually obeyed
                .setKinematics(Constants.kDriveKinematics)
                // Apply the voltage constraint
                .addConstraint(autoVoltageConstraint);

        RamseteCommand ramseteCommand = new RamseteCommand(
            trajectory,
            Robot.DriveSubsystem::getFieldPosition,
            new RamseteController(Constants.kRamseteB, Constants.kRamseteZeta),
            new SimpleMotorFeedforward(Constants.ksVolts,
                                        Constants.kvVoltSecondsPerMeter,
                                        Constants.kaVoltSecondsSquaredPerMeter),
                                        Constants.kDriveKinematics,
            Robot.DriveSubsystem::getAverageVelocity,
            new PIDController(Constants.kPDriveVel, 0, 0),
            new PIDController(Constants.kPDriveVel, 0, 0),
            // RamseteCommand passes volts to the callback
            Robot.DriveSubsystem::TankDriveVoltage,
            Robot.DriveSubsystem
        );

        // Run path following command, then stop at the end.
        return ramseteCommand.andThen(() -> Robot.DriveSubsystem.TankDriveVoltage(0, 0));

    }

}
