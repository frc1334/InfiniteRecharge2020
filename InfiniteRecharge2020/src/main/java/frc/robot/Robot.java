/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.subsystems.AcceleratorWheelSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.PneumaticsSubsytem;
import frc.robot.subsystems.TurretSubsystem;
import frc.robot.subsystems.VerticalFeederSubsystem;
import frc.robot.utils.AutoTrajectoryCommandGenerator;
import frc.robot.commands.auto.InitiationShot;
import frc.robot.commands.drive.DriveCommand;

import java.io.IOException;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  // The subsystems called used in OI
  public static DriveSubsystem DriveSubsystem = new DriveSubsystem();
  public static TurretSubsystem TurretSubsystem = new TurretSubsystem();
  public static LimelightSubsystem LimelightSubsystem = new LimelightSubsystem();
  public static LauncherSubsystem LauncherSubsystem = new LauncherSubsystem();
  // public static PneumaticsSubsytem PneumaticsSubsystem = new PneumaticsSubsytem();
  public static IntakeSubsystem IntakeSubsystem = new IntakeSubsystem();
  public static IndexerSubsystem IndexerSubsystem = new IndexerSubsystem();
  public static VerticalFeederSubsystem VerticalFeederSubsystem = new VerticalFeederSubsystem();
  public static AcceleratorWheelSubsystem AcceleratorWheelSubsystem = new AcceleratorWheelSubsystem();
  public static ClimberSubsystem ClimberSubsystem = new ClimberSubsystem();

  // Initialize a new Operator Interface (OI) object
  public static OI OI = new OI();

  // Initialize a new AutoTrajectoryCommandGenerator for global use
  public static AutoTrajectoryCommandGenerator AutoTrajectoryGenerator = new AutoTrajectoryCommandGenerator();

  // Initialize the commands
  DriveCommand DriveCommand = new DriveCommand();

  CommandScheduler commandScheduler = CommandScheduler.getInstance();

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {

    m_chooser.addOption("Drive Auto", "Drive Auto");
    m_chooser.addOption("3 Ball Auto", "3 Ball Auto");

    SmartDashboard.putData("Auto choices", m_chooser);

  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      
      case "Drive Auto":

        // try {
        //   Command DriveAuto = AutoTrajectoryGenerator.generateCommand("");
        //   commandScheduler.schedule(DriveAuto);
        // } catch (IOException e) {
        //   // TODO Auto-generated catch block
        //   System.out.println("DRIVE AUTO NOT SELECTED");
        //   e.printStackTrace();
        // }

        break;

      case "3 Ball Auto":

          commandScheduler.schedule(new InitiationShot());

          break;
      
      default:
        // Put default auto code here
        break;
    }

    //commandScheduler.run();

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

    // Start the CommandScheduler to add Command calls to the current running stack
    commandScheduler.run();
    DriveCommand.schedule();
    
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

}
