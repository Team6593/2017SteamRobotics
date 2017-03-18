package org.usfirst.frc6593.RMHRobtics.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddleStation extends CommandGroup {

    public MiddleStation() {
        // Add Commands here:
    	 addSequential(new AutoDriveFastForward(5.5));
         addSequential(new AutoDriveBack(3));
         addSequential(new AutoRotate(3));
    	 addSequential(new AutoDriveFastForward(3));


         
         

        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
