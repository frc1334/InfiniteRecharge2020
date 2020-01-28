/*----------------------------------------------------------------------------

Author: Rico Zhu and Emily DiLauro                Date: January 28th, 2020

AutoAimRoutine Command

This command is the first subroutine to be called when the launch routine is
triggered. This command auto aligns via the turret and limelight while spinning
up the flywheel on the launcher simultaneously. The command ends when both commands
are finished.

------------------------------------------------------------------------------*/

package frc.robot.commands.subroutines;

import frc.robot.commands.launcher.LauncherPIDVelocity;
import frc.robot.commands.turret.TurretAutoTracking;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html

public class AutoAimRoutine extends ParallelCommandGroup {

  public AutoAimRoutine() {
      // Add your commands in the super() call, e.g.
      // super(new FooCommand(), new BarCommand());super();
      super(new TurretAutoTracking(), new LauncherPIDVelocity(5700));
  }

}
