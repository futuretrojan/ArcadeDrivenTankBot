/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {

    Joystick xbox = new Joystick(1);
    RobotDrive front = new RobotDrive(1, 2);
    RobotDrive back = new RobotDrive(3, 4);

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {

        while (this.isOperatorControl() && this.isEnabled()) {

            double xaxis = xbox.getRawAxis(4);
            double yaxis = xbox.getRawAxis(2);
            front.arcadeDrive(yaxis, xaxis);
            back.arcadeDrive(yaxis, xaxis);





            Timer.delay(.01D);
            this.getWatchdog().feed();


        }



    }

    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    }
}
