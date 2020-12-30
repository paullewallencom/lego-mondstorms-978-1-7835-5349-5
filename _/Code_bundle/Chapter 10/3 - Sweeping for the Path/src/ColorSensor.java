import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;

public class ColorSensor extends EV3ColorSensor
{
    private final static int PATH_COLOR = Color.RED;

    public ColorSensor(Port port)
    {
        super(port);
    }

    public boolean onPath()
    {
        return getColorID() == PATH_COLOR;
    }
}
