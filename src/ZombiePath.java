import processing.core.PApplet;

public class ZombiePath extends PApplet
{
    private Zombie zombie;

    public static void main(String[] args)
    {
        PApplet.main("ZombiePath");
    }

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        zombie = new Zombie();
        background(0);
    }

    public void draw()
    {
        stroke(200);
        fill(200);
        point(zombie.getX(), zombie.getY());
        zombie.walk();
    }
}