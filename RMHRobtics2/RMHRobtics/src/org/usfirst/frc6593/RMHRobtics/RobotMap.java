// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6593.RMHRobtics;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveTrainrightSC;
    public static SpeedController driveTrainleftSC;
    public static RobotDrive driveTrainRobotDrive21;
    public static AnalogInput driveTrainRangeFinder;
    public static SpeedController climbingrollingSC;
    public static SpeedController shootingshootSC;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainrightSC = new Spark(0);
        LiveWindow.addActuator("DriveTrain", "rightSC", (Spark) driveTrainrightSC);
        
        driveTrainleftSC = new Spark(1);
        LiveWindow.addActuator("DriveTrain", "leftSC", (Spark) driveTrainleftSC);
        
        driveTrainRobotDrive21 = new RobotDrive(driveTrainleftSC, driveTrainrightSC);
        
        driveTrainRobotDrive21.setSafetyEnabled(true);
        driveTrainRobotDrive21.setExpiration(0.1);
        driveTrainRobotDrive21.setSensitivity(0.5);
        driveTrainRobotDrive21.setMaxOutput(1.0);

        driveTrainRangeFinder = new AnalogInput(0);
        LiveWindow.addSensor("DriveTrain", "RangeFinder", driveTrainRangeFinder);
        
        climbingrollingSC = new Spark(2);
        LiveWindow.addActuator("Climbing", "rollingSC", (Spark) climbingrollingSC);
        
        shootingshootSC = new Spark(3);
        LiveWindow.addActuator("Shooting", "shootSC", (Spark) shootingshootSC);
        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
