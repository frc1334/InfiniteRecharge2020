
package frc.robot.subsystems;

import frc.robot.utils.RobotMap;
import frc.robot.utils.Constants;
import frc.robot.utils.CANSparkMaxPIDWrapper;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AcceleratorWheelSubsystem extends SubsystemBase implements Subsystem {

  // Create a new CANSParkMaxPIDWrapper Object for the NEO running the accelerator wheel
  CANSparkMaxPIDWrapper AcceleratorWheel;

  public AcceleratorWheelSubsystem () {

    // Initialize the AcceleratorWheel object with the RobotMap port
    AcceleratorWheel = new CANSparkMaxPIDWrapper(RobotMap.AcceleratorWheel, Constants.kVelocityMode);

    // Configure the PID control loop for the belt vertical feeder
    AcceleratorWheel.setPIDValues(Constants.kAcceleratorWheelP, Constants.kAcceleratorWheelI, Constants.kAcceleratorWheelD, Constants.kAcceleratorWheelFF, 0);

    // Configure the peak output voltages for the belt motor
    AcceleratorWheel.setPIDOutputRange(Constants.kAcceleratorWheelMinOutput, Constants.kAcceleratorWheelMaxOutput);

  }

  // This method oeprates velocity PID on the accelerator wheel NEO
  public void setAcceleratorWheelVelocity (double setpoint) {
    AcceleratorWheel.setPIDVelocity(setpoint);
    System.out.println("AW: " + AcceleratorWheel.getVelocity());
  }

  // This void method manually sets the percent input for the Accelerator Wheel Subsystem
  public void setAcceleratorWheelPercent (double percent) {
    AcceleratorWheel.setPercentOutput(percent);
    System.out.println("AW: " + AcceleratorWheel.getVelocity());
  }

}
