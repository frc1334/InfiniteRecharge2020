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

import frc.robot.commands.*;
import frc.robot.commands.turret.TurretPIDPosition;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

    // Driver XBox360Controller (WPILIB) Object, initialized with port 0
    XboxController Driver = new XboxController(0);
    // Operator XBox360Controller (WPILIB) Object, initialized with port 1
    XboxController Operator = new XboxController(1);

    // Driver Inidividual Controller Devices
    JoystickButton  DriverAButton;
    // Operator Individual Controller Devices
    JoystickButton  OperatorAButton;
    JoystickButton  OperatorBButton;
    JoystickButton  OperatorXButton;
    JoystickButton  OperatorYButton;

    // Default constructor which initializes and maps the controls (initialized above, e.g., OperatorAButton) to the correct ports on the XBox controller and the right command
    public OI () {

        // Inititalize the Driver Controls
        DriverAButton = new JoystickButton(Driver, 0);

        // Inititalize the Operator Controls
        OperatorAButton = new JoystickButton(Operator, 0);
        OperatorBButton = new JoystickButton(Operator, 1);
        OperatorXButton = new JoystickButton(Operator, 2);
        OperatorYButton = new JoystickButton(Operator, 3);

        OperatorAButton.whenPressed(new TurretPIDPosition(90));
    
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
