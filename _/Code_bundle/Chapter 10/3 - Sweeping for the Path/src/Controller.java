import lejos.hardware.Sound;
import lejos.hardware.port.Port;
import lejos.utility.Delay;

public class Controller
{
    private final static int DELAY = 50;

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
        log("Starting controller");

        move();
        seek();
        move();

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

        return sweepClockwise();
    }

    private boolean sweepClockwise()
    {
        log("Sweeping clockwise");

        int count = 0;

        drive.rotateClockwise();

        while (! sensor.onPath())
        {
            count++;

            delay();
        }

        log("Delay Count: " + count);

        drive.stop();

        return true;
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
