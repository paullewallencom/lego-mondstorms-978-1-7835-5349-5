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

        while (narrow_seek())
        {
            naive_move();
        }

        end();
    }

    private void naive_move()
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

    private boolean narrow_seek()
    {
        log("Seeking Path in Narrow Arc.");

        return sweepClockwise(SMALL_ROT) || sweepCounterClockwise(2 * SMALL_ROT) || sweepClockwise(SMALL_ROT);
    }

    private boolean sweepClockwise(int rot_limit)
    {
        log("Sweeping clockwise. Limit: " + rot_limit + " degrees.");

        drive.rotateClockwise();

        return sweep(rot_limit);
    }

    private boolean sweepCounterClockwise(int rot_limit)
    {
        log("Sweeping counter-clockwise. Limit: " +  rot_limit + " degress");

        drive.rotateCounterClockwise();

        return sweep(rot_limit);
    }

    private boolean sweep(int rot_limit)
    {
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
