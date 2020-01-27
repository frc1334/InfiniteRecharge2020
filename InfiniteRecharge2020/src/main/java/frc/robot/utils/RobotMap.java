/*----------------------------------------------------------------------------

Author: Rico Zhu                Date: January 13th, 2019

RobotMap Class

This class would act as a dictionary for all subsytems to read device
channel ports from.

------------------------------------------------------------------------------*/

package frc.robot.utils;

public class RobotMap {

    // Motors

    // The channel IDs for the 4 Drive Spark Maxs (Left1, Left2, Right1, Right2)
    public static final int Left1 = 1;
    public static final int Left2 = 2;
    public static final int Right1 = 3;
    public static final int Right2 = 4;

    // The channel ID for the Turret on the TurretSubsystem
    public static final int Turret = 5;
    
    // The channel ID for the Launcher on the LauncherSubsystem
    public static final int Launcher1 = 6;
    public static final int Launcher2 = 7;

    // The channel ID for the Intake on the IntakeSubsystem
    public static final int Intake = 8;


    // Pneumatics 

    // The channel ID for the Compressor on the PCM (Pneumatics Control Module)
    public static final int Compressor = 0;

    // The channel ID for the two double solenoids used for the pistons on the Intake
    public static final int IntakeLeft1 = 1;
    public static final int IntakeLeft2 = 2;
    public static final int IntakeRight1 = 3;
    public static final int IntakeRight2 = 4;

}
