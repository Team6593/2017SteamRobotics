// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6593.RMHRobtics.subsystems;

import org.usfirst.frc6593.RMHRobtics.Robot;
import org.usfirst.frc6593.RMHRobtics.RobotMap;
import org.usfirst.frc6593.RMHRobtics.commands.*;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
	public static ADXRS450_Gyro gyro = RobotMap.Gyro;
	public static AnalogInput rangeFinder = RobotMap.driveTrainRangeFinder;
	private Timer methodTimer;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController rightSC = RobotMap.driveTrainrightSC;
    private final SpeedController leftSC = RobotMap.driveTrainleftSC;
    private final RobotDrive robotDrive21 = RobotMap.driveTrainRobotDrive21;
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	private static final double kP = 0.3; // propotional turning constant
	//private static Joystick joystick = Robot.oi.getXbox_Joystick();

	
//	public double gyroKP(){
//		return this.kp;
//	}
	
	//public double gyroRateScale = gyro.getRate();
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void setSpeed(double speed_L, double speed_R){//two input speed control
	   	leftSC.set(-speed_L);
	   	rightSC.set(speed_R);
   	}
   
   	public void setSpeed(double speed){//one input speed control
	   	setSpeed(speed, speed);
   	}
   	
	public void tankdrive(double leftSpeed, double rightSpeed){
		robotDrive21.tankDrive(leftSpeed, rightSpeed);


	}
	
	public void drivestraight(double speed){
		robotDrive21.arcadeDrive(speed, 0);
		
		
        
	}
	
	public void gyroDrive(double leftSpeed, double rightSpeed){
		
		

		robotDrive21.tankDrive(leftSpeed, rightSpeed);
		if (gyro != null)
        {
            //
            // Gyro assist is enabled.
            //
			double drivePower = (Robot.oi.getDriveLeftSpeed() + Robot.oi.getDriveRightSpeed())/2.0;
			double stickDifferential = Robot.oi.getDriveLeftSpeed() - Robot.oi.getDriveRightSpeed();
			double motorDifferential = kP*(stickDifferential - gyro.getRate());
			leftSC.set(drivePower + motorDifferential);
			rightSC.set(drivePower - motorDifferential);
        }
	}
	public void gyroDriveSecnd(double leftSpeed, double rightSpeed){

		robotDrive21.drive(leftSpeed, rightSpeed);
		if (gyro != null)
        {
            //
            // Gyro assist is enabled.
            //
			double drivePower = (leftSpeed + rightSpeed)/2.0;
			double stickDifferential = leftSpeed - rightSpeed;
			double motorDifferential = kP*(stickDifferential - gyro.getRate());
			leftSC.set(drivePower + motorDifferential);
			rightSC.set(drivePower - motorDifferential);
        }
	}
	
	
	
	public void GyroRoateDrive(double rot){
		
		robotDrive21.arcadeDrive(0, rot);
//		//gyro.reset();
//        
//		
//	           // double angle = gyro.getAngle(); // get current heading
//	            
//	           double rotationAngle = gyro.getAngle() + rot;
//	            
//	            
//	            if(rotationAngle == rotationAngle){
//	            	
//	            	robotDrive21.drive(speed, -rotationAngle*kP); // drive towards roation
//	            	robotDrive21.arcadeDrive(0, 0);
//	            }
//	            Timer.delay(0.004);
//	        
//        
//            //robotDrive21.drive(speed, speed);
	}
	
	public void gyroTurn(double angle, double timeout){
   		methodTimer = new Timer();//Timer for keeping track of time
	   	methodTimer.start();//Start timer
   		
	   	double goal = gyro.getAngle() + angle;
	   	
	   	while(gyro.getAngle() != goal && methodTimer.get() < timeout){
	   		if(gyro.getAngle() < goal){
	   			setSpeed(-0.5, 0.5);
	   		}
	   		else if(gyro.getAngle() > goal){
	   			setSpeed(0.5, -0.5);
	   		}
	   		else{
	   			setSpeed(0);
	   		}
	   	}
	   	
	   	setSpeed(0);
	   	methodTimer.stop();
   	}
	
	public void arcadeDrive(double s, double sp){
		s = 1;
		sp = 0.5;
		robotDrive21.arcadeDrive(s, sp);
		
		
	}
	public void teleopGyroRoate(double speed, double speeds){
		//gyro.reset();
        
		//double angle = gyro.getAngle();
		
	            //double angle = gyro.getAngle(); // get current heading
	            
	            //angle = rot;
	            
	            //robotDrive21.drive(joy.getX(), -angle*kP); // drive towards heading 0
	            robotDrive21.arcadeDrive(speed, -speeds);
	           //robotDrive21.arcadeDrive(speed, -speeds, true);
			//arcadeDrive(speed, speeds);
	            //Timer.delay(0.004);
	        
        
            //robotDrive21.drive(speed, speed);
	}
	
	public void teleopGyroStraight(Joystick joystick){
		/*double turningValue = (kAngleSetpoint - gyro.getAngle()) * kP;
		// Invert the direction of the turn if we are going backwards
		turningValue = Math.copySign(turningValue, joystick.getY());*/
		double angle = gyro.getAngle();
		robotDrive21.drive(joystick.getY(), -angle*kP/*turningValue*/);
		Timer.delay(0.004);
	}
	
	public void GyroReset(){
		gyro.reset();
	}

	public void utrasonicStop(){
		
	}

	public void stop(){

		robotDrive21.drive(0,0);
	}
	

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new TankDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.

    }
}

