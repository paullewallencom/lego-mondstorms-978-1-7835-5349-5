import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;


public class LineFollower
{
    public static void main(String[] args)
    {
        log("Program starts");

        ColorSensor sensor = new ColorSensor(SensorPort.S1);

        for (int ii = 0; ii < 10; ii++)
        {
            Delay.msDelay(1500);

            log("On Path: " + sensor.onPath());
        }

        log("Program ends");
    }


    private static void log(String msg)
    {
        System.out.println("log>\t" + msg);
    }
}