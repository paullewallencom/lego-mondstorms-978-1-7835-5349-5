import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class Touch
{
    public static void main(String[] args)
    {
        log("Program Starting");

        TouchSensor uTouch = new TouchSensor(SensorPort.S1);
        waitForTouch(uTouch);

        log("Program Ending");
    }
   

    private static void waitForTouch(TouchSensor uTouch)
    {
        log("Waiting for press on Touch Sensor");

        while (! uTouch.isPressed())
        {
            Delay.msDelay(100);
        }

        log("Touch Sensor pressed.");
    }


    private static void log(String msg)
    {
        System.out.println("log>\t" + msg);
    }
}
