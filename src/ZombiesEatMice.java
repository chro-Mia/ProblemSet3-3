import processing.core.PApplet;

public class ZombiesEatMice extends PApplet
{
    private Zombie[] zombies;
    private int zombieCount = 50;

    public static void main(String[] args)
    {
        Zombie.setStepSize(5);
        PApplet.main("ZombiesEatMice");

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
            zombies[i] = new Zombie((int)(Math.random() * width), (int)(Math.random() * height));
        }
    }

    public void draw()
    {
        background(0);
        for (Zombie z : zombies)
        {
            fill(200);
            ellipse(z.getX(), z.getY(), 10, 10);
            z.walkToward(mouseX, mouseY);
        }
    }
}