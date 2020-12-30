import lejos.hardware.Sound;
import lejos.hardware.port.Port;
import lejos.utility.Delay;

public class Controller
{
    private final static int DELAY = 50;

    private final static float DELAYS_PER_DEG = 100.0f / 180;

    private final static int SMALL_ROT = 10;

    private ColorSensor sensor;
    private DifferentialDrive drive;

    public Controller(Port sensor_port, Port left_port, Port right_port)
    {
        log("Initializing Controller");

        sensor = new ColorSensor(sensor_port);
        drive = new DifferentialDrive(left_port, right_port);
    }

    public void run()
    {
        log("Running controller");

        move();
        seek();

        end();
    }

    private void move()
    {
        log("Forward");
        drive.forward();

        while (sensor.onPath())
        {
            delay();
        }

        drive.stop();
        log("Stop");
    }

    private boolean seek()
    {
        log("Seeking Path.");

        return sweepClockwise(SMALL_ROT);
    }

    private boolean sweepClockwise(int rot_limit)
    {
        log("Sweeping clockwise. Limit: " + rot_limit + " degrees.");

        drive.rotateClockwise();

        for (int i = 0; i < (rot_limit * MS_PER_DEG); i++)
        {
            delay();

            if (sensor.onPath())
            {
                log("Path Detected");

                drive.stop();

                return true;
            }
        }

        log("Path not detected. Rotation limit exceeded.");

        drive.stop();

        return false;
    }

    private void end()
    {
        Sound.beepSequence();

        log("Program ends");
    }

    private void delay()
    {
        Delay.msDelay(DELAY);
    }

    private static void log(String msg)
    {
        System.out.println("log>\t" + msg);
    }
}
