import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;


public class LineFollower
{
    public static void main(String[] args)
    {
        log("Program starts");

        ColorSensor sensor = new ColorSensor(SensorPort.S1);
        DifferentialDrive drive = new DifferentialDrive(MotorPort.B, MotorPort.C);

        log("Forward");
        drive.forward();

        while (sensor.onPath())
        {
            Delay.msDelay(100);
        }

        drive.stop();

        log("Program ends");
    }


    private static void log(String msg)
    {
        System.out.println("log>\t" + msg);
    }
}