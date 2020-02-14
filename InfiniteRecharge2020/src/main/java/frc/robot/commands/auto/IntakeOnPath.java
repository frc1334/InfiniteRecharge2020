/*----------------------------------------------------------------------------

Author: Rico Zhu                                      Date: January 30th, 2020

IntakeOnPath Command

This Command group (Parallel Deadline) enables intaking during a given auto
trajectory path simultaneously until the trajectory path Ramsete Command
finishes.

------------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import frc.robot.Robot;
import frc.robot.commands.subroutines.IntakeRoutine;

import java.io.IOException;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;

public class IntakeOnPath extends ParallelDeadlineGroup {
  /**
   * @throws IOException
   */
  public IntakeOnPath(String filepath) throws IOException {
    // Add your commands in the super() call.  Add the deadline first.
    super(
        //Robot.AutoTrajectoryGenerator.generateCommand(filepath),
        new IntakeRoutine()
    );
  }
  
}
