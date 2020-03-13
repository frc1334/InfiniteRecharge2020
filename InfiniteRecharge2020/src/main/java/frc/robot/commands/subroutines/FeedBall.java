/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.subroutines;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.acceleratorwheel.AcceleratorWheelPIDVelocity;
import frc.robot.commands.indexer.FeedIndexer;
import frc.robot.commands.verticalfeeder.VerticalFeed;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class FeedBall extends ParallelCommandGroup {
  /**
   * Creates a new FeedBall.
   */
  public FeedBall() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());super();
    super(new FeedIndexer(), new VerticalFeed(), new AcceleratorWheelPIDVelocity(-600));
  }
}
