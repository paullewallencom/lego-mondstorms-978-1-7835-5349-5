import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;


public class Motor
{
    public static void main(String[] args)
    {
        log("Program Starting");

        EV3LargeRegulatedMotor motor = new EV3LargeRegulatedMotor(MotorPort.A);
        motor.setSpeed(500);

        log("Forward motion");
        motor.forward();

        Delay.msDelay(3000);

        log("Stopping motor");
        motor.stop();

        log("Program Ending");
    }


    private static void log(String msg) 
    { 
        System.out.println("log>\t" + msg); 
    }
}
