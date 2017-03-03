package org.usfirst.frc6593.RMHRobtics.commands;

import org.usfirst.frc6593.RMHRobtics.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopClimb extends Command {

    public StopClimb() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.climbing);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.climbing.stopRolling();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
