/*----------------------------------------------------------------------------

Author: Rico Zhu                Date: January 11th, 2019

CANSparkMaxPIDWrapper Class

This class is a wrapper class for a PID controlled NEO via CAN Spark Max's.
It packages  a CANSparkMax object, a CANEncoder (ones built into NEOs and NEO 550s)
and a CANPIDController.

It contains methods for setting PID values, Positional and Velocity control
and feedback capabilities.

------------------------------------------------------------------------------*/

package frc.robot.utils;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;

public class CANSparkMaxPIDWrapper {

    // Spark Max motor controller connected via a CAN bus
    CANSparkMax SparkMax;
    // Encoder that will be read off the SparkMax
    CANEncoder Encoder;
    // PID Controller that will be read off the SparkMax
    CANPIDController PIDController;

    // Default controller with an integer channel input (only with Bruhsless motors)
    public CANSparkMaxPIDWrapper (int channel) {

        // Initialize the SparkMax and all subsequent global variables
        SparkMax = new CANSparkMax(channel, MotorType.kBrushless);

        // Read the Encoder and PIDControllers off the newly initialized SparkMax
        Encoder = SparkMax.getEncoder();
        PIDController = SparkMax.getPIDController();

    }

    // This void is called to set the PID Tuning values of the SparkMax's PIDController. This includes kP, kI, kD, kFF, kMinOutput and kMaxOutput
    public void setPIDValues (double kP, double kI, double kD, double kFF, double kMinOutput, double kMaxOutput) {

        // Set the input tune values to the PIDController
        PIDController.setP(kP);
        PIDController.setI(kI);
        PIDController.setD(kD);
        PIDController.setFF(kFF);

        // Set the output range of the PID Closed Loop control feedback system
        PIDController.setOutputRange(kMinOutput, kMaxOutput);

    }

}
