package org.usfirst.frc6593.RMHRobtics.commands;

import org.usfirst.frc6593.RMHRobtics.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SlowInvertC extends Command {

    public SlowInvertC() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.climbing);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
		Robot.climbing.invertRolling(.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
