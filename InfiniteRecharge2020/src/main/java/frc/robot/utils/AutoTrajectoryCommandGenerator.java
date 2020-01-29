/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.utils;

import java.io.IOException;
import java.nio.file.Path;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryUtil;

public class AutoTrajectoryCommandGenerator {

    // The default constructor takes in a string for the location of the Path Weaver generated json file (with coordinates)
    public AutoTrajectoryCommandGenerator (String AutoPathWeaverJSON) {

        try {
            Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(AutoPathWeaverJSON);
            Trajectory trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);
        } catch (IOException ex) {
            DriverStation.reportError("Unable to open trajectory: " + AutoPathWeaverJSON, ex.getStackTrace());
        }

    }

}
