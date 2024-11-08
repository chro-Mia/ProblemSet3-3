import processing.core.PApplet;

public class SeasonalZombies extends PApplet
{
    private Zombie[] zombies;
    private int zombieCount = 10;
    private double stepSizePhase = 3;

    public static void main(String[] args)
    {
        PApplet.main("SeasonalZombies");
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
        stepSizePhase += 0.01;
        Zombie.setStepSize(2 * (Math.sin(stepSizePhase)+2) );
        for (Zombie z : zombies)
        {
            fill(200);
            ellipse(z.getX(), z.getY(), 10, 10);
            z.walk();
        }
    }
}