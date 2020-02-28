/*----------------------------------------------------------------------------

Author: Rico Zhu                                Date: January 15th, 2020

Operator Interface (OI) Class

The Operator Interface (aka OI) class links the Driver and Operator (WPILIB Controllers Classes)
actions (e.g., button pressing, triggers, joysticks) and calls appropriate PID-based
Commands.

The OI class also provides methods that allow Commands (without PID) to access
controller data (e.g., DriveSubsystem drive operations)

------------------------------------------------------------------------------*/
package frc.robot;

import frc.robot.commands.subroutines.IntakeRoutine;
import frc.robot.commands.turret.FieldRelativeTurretPosition;
import frc.robot.commands.turret.TurretPIDPosition;
import frc.robot.commands.climber.ClimbPercentDown;
import frc.robot.commands.climber.ClimbUpPosition;
import frc.robot.commands.drive.GearShift;
import frc.robot.commands.intake.ToggleIntakeDropdown;
import frc.robot.commands.limelight.ToggleCameraMode;
import frc.robot.commands.sequences.ClimbUpSequence;
import frc.robot.commands.sequences.TurretAutoAim;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OI {

    // Driver XBox360Controller (WPILIB) Object, initialized with port 0
    public XboxController Driver = new XboxController(0);
    // Operator XBox360Controller (WPILIB) Object, initialized with port 1
    public XboxController Operator = new XboxController(1);

    // Driver Inidividual Controller Devices
    public JoystickButton DriverAButton;
    public JoystickButton DriverBButton;
    public JoystickButton DriverXButton;
    public JoystickButton DriverYButton;
    
    // Operator Individual Controller Devices
    public JoystickButton OperatorAButton;
    public JoystickButton OperatorBButton;
    public JoystickButton OperatorXButton;
    public JoystickButton OperatorYButton;

    // Default constructor which initializes and maps the controls (initialized above, e.g., OperatorAButton) to the correct ports on the XBox controller and the right command
    public OI () {

        // Inititalize the Driver Controls
        DriverAButton = new JoystickButton(Driver, 1);
        DriverBButton = new JoystickButton(Driver, 2);
        DriverXButton = new JoystickButton(Driver, 3);
        DriverYButton = new JoystickButton(Driver, 4);

        // Inititalize the Operator Controls
        OperatorAButton = new JoystickButton(Operator, 1);
        OperatorBButton = new JoystickButton(Operator, 2);
        OperatorXButton = new JoystickButton(Operator, 3);
        OperatorYButton = new JoystickButton(Operator, 4);

        //DriverAButton.whenPressed(new GearShift());
        DriverBButton.whenPressed(new TurretAutoAim());
        //DriverBButton.whenPressed(new FieldRelativeTurretPosition());
        //DriverXButton.whenPressed(new ClimbUpSequence());
        //DriverYButton.whileHeld(new ClimbPercentDown());

        // DriverAButton.whileHeld(new IntakeRoutine());
        // DriverAButton.whenPressed(new ClimbUpPosition(24000.0));
        DriverAButton.whenPressed(new ToggleCameraMode());
    
    }

    // This double (decimal number) method returns the difference between the left and right Driver triggers (How much to move forwards/backwards)
    public double getDriverSpeed () {

        if (Math.abs(Driver.getTriggerAxis(Hand.kLeft) - Driver.getTriggerAxis(Hand.kRight)) > 0.15) {
            return Driver.getTriggerAxis(Hand.kLeft) - Driver.getTriggerAxis(Hand.kRight);
        }

        return 0.0;

    }
    
    // This double method returns the x-axis of the Driver top/turn joystick. The value returned would determine how much to turn to the left or right
    public double getDriverTurn () {

        if (Math.abs(Driver.getRawAxis(0)) > 0.15) {
            return Driver.getRawAxis(0);
        }

        return 0.0;

    }

}
