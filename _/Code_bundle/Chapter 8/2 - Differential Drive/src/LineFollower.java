import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;


public class LineFollower
{
    public static void main(String[] args)
    {
        log("Program stars");

        DifferentialDrive drive = new DifferentialDrive(MotorPort.B, MotorPort.C);

        drive.forward();
        Delay.msDelay(1000);
        drive.stop();
        drive.rotateClockwise();
        Delay.msDelay(1000);
        drive.rotateCounterClockwise();
        Delay.msDelay(1000);
        drive.stop();

        log("Program ends");
    }


    private static void log(String msg)
    {
        System.out.println("log>\t" + msg);
    }
}