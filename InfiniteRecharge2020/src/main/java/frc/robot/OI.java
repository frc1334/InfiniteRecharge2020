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

import edu.wpi.first.wpilibj.XboxController;
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
    
    }

}
