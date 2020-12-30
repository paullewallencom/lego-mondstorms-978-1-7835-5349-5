import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;


public class LineFollower
{
    public static void main(String[] args)
    {
        log("Program stars");

        ColorSensor sensor = new ColorSensor(SensorPort.S1);
        int color_id;

        for (int ii = 0; ii < 10; ii++)
        {
            Delay.msDelay(1500);
            color_id = sensor.getColorID();

            log("Detected Color: " + color_id);
        }

        log("Program ends");
    }


    private static void log(String msg)
    {
        System.out.println("log>\t" + msg);
    }
}