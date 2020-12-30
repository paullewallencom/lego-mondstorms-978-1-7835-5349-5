import lejos.hardware.Sound;
import lejos.hardware.port.Port;

public class Controller
{
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

        end();
    }

    private void end()
    {
        Sound.beepSequence();

        log("Program ends");
    }

    private static void log(String msg)
    {
        System.out.println("log>\t" + msg);
    }
}
