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
import java.util.List;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;

public class AutoTrajectoryCommandGenerator {

    // This Command method returns a Command (RamseteCommand) from a given string path to a Path Weaver json file
    public Command generateCommand (String AutoPathWeaverJSON) throws IOException {

        // Read the current trajectory json path from the Roborio file system and generate the trajectory from that
        Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(AutoPathWeaverJSON);
        Trajectory trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);

        // Create a voltage constraint to ensure we don't accelerate too fast. 10 refers to the 10V max limit
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

        // An example trajectory to follow.  All units in meters.
        Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
            // Start at the origin facing the +X direction
            new Pose2d(0, 0, new Rotation2d(0)),
            // Pass through these two interior waypoints, making an 's' curve path
            List.of(
                new Translation2d(1, 1),
                new Translation2d(2, -1)
            ),
            // End 3 meters straight ahead of where we started, facing forward
            new Pose2d(3, 0, new Rotation2d(0)),
            // Pass config
            config
        );

        // var transform = Robot.DriveSubsystem.getFieldPosition().minus(trajectory.getInitialPose());
        // trajectory = trajectory.transformBy(transform);

        // Create a new RamseteCommand with the newly buffered trajectory
        RamseteCommand ramseteCommand = new RamseteCommand(
            exampleTrajectory,
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
