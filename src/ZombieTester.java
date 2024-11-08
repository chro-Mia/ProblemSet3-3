public class ZombieTester
{
    public static void main(String[] args){

        double sum = 0;

        Zombie zombie = new Zombie();
        for(int i = 0; i < 1; i++) {
            zombie.walk();
        }

        System.out.println(zombie);

        for (int i = 0; i < 100000; i++) {
            sum += Zombie.stepsToGoToDistance(100);
        }
        System.out.print(sum/100000);

    }
}
