import processing.core.PApplet;

public class ZombieSpread extends PApplet
{
    private Zombie[] zombies;
    private int zombieCount = 10;

    public static void main(String[] args)
    {
        PApplet.main("ZombieSpread");
    }

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        zombies = new Zombie[zombieCount];
        for (int i = 0; i < zombieCount; i++)
        {
            zombies[i] = new Zombie();
        }
    }

    public void draw()
    {
        background(0);
        for (Zombie z : zombies)
        {
            fill(200);
            ellipse(z.getX(), z.getY(), 10, 10);
            z.walk();
        }
    }
}