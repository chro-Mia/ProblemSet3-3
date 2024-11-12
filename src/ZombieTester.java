public class ZombieTester
{
    public static void main(String[] args){

        double sum = 0;

        Zombie zombie = new Zombie();
        for(int i = 0; i < 1; i++) {
            zombie.walk();
        }

        System.out.println(zombie);

        for (int i = 0; i < 1000; i++) {
            sum += stepsToGoToDistance(100);
        }
        System.out.print(sum/1000);

    }

    public static int stepsToGoToDistance(double distance){
        Zombie zombie = new Zombie(0, 0);
        int steps = 0;
        while(Zombie.pythag(zombie.getX(), zombie.getY()) < distance){
            zombie.walk();
            steps++;
        }
        return steps;
    }
}
