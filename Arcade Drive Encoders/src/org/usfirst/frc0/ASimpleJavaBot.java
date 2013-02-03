

package org.usfirst.frc0;
import edu.wpi.first.wpilibj.*;

public class ASimpleJavaBot extends SimpleRobot {
   
	Joystick xbox = new Joystick(3);
	Encoder encoder = new Encoder(1, 2);
	RobotDrive front = new RobotDrive(1,2);
	RobotDrive back = new RobotDrive(3,4);
	
    public void autonomous() {
        
    }

    
    public void operatorControl() {
    	
    	encoder.start();
    	encoder.reset();
    	
    	while(this.isEnabled() && this.isOperatorControl()){
    		
    		int raw = encoder.getRaw();
    		double getPID = encoder.pidGet();
    		double distance = encoder.getDistance();
    		double rate = encoder.getRate();
    		if(encoder.getStopped() == true){
    			System.out.println("The encoder is stopped");
    		break;
    		}
    		
    		
    		double xaxis = xbox.getRawAxis(2);
    		double yaxis = xbox.getRawAxis(4);
    		front.arcadeDrive(yaxis,xaxis);
    		back.arcadeDrive(yaxis,xaxis);
    		
    		
    		System.out.println("The encoder's distance is: " + distance);
    		System.out.println("The encoder's raw value is: " + raw);
    		System.out.println("The encoder's PID value is: " + getPID);
    		System.out.println("The encoder's rate is: " + rate);
    		
    		
    		Timer.delay(0.01D);
    		this.getWatchdog().feed();    		
    		
    	}

    }
}
