import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

public class HelloWorld
{
    public static void main(String[] args)
    {
        LCD.drawString("Hello, World", 2, 3);

        Button.waitForAnyPress();
    }
}
