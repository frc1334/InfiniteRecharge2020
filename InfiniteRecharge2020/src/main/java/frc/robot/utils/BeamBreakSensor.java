
/*----------------------------------------------------------------------------

Author: Rico Zhu, Emily DiLauro, Joey Wang, Krish Mishra and Ben Zu              
Date: January 11th, 2020

BeamBreakerSensor Class

This is a wrapper class that will represent Beam Break / Light Induction sensor.
The DigitalInput SensorInput is used as a template.

This class takes in an integer variable called channel which then instantiates
the previously null DigitalInput sensor (SensorInput).

------------------------------------------------------------------------------*/

package frc.robot.utils;

import edu.wpi.first.wpilibj.DigitalInput;

public class BeamBreakSensor {

    // This is the DigitalInput object used to represent a RoboRio DIO port sensor (A beam break / light induction sensor)
    DigitalInput SensorInput;

    public BeamBreakSensor (int channel) {
        // Set the previsouly null DigitalInput SensoInput object to be initialized with the new channel id
        SensorInput = new DigitalInput(channel);
    }

    // This boolean method will return the state of the BeamBreak sensor (SensorInput)
    public boolean getSensorState () {
        // The actual sensor is inverted - returns false when on and returns true when off. The not symbol (!) inverts it
        return !SensorInput.get();
    }

    // This method returns the current instantiated DigitalInput sensor
    public DigitalInput getSensor () {
        return SensorInput;
    }

}
