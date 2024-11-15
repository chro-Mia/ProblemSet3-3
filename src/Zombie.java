public class Zombie
{
    private double x;
    private double y;

    // The maximum length of a step a zombie could take
    private static double stepSize = 3;

    // Must be a positive double, higher values decrease the probability the zombie will take a biased step
    private static double biasCoefficient = 2;

    // Controls how large biased steps are
    private static double biasedStepSize = 100;

    // The radius of a circle centered on the cursor in which zombies will not be biased at all
    private static double noBiasRadius = 2;

    public Zombie(){
        x = 100;
        y = 100;
    }

    public Zombie(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return (int)x;
    }

    public int getY(){
        return (int)y;
    }

    public void walk(){
        x += Math.random() * stepSize * 2 - stepSize;
        y += Math.random() * stepSize * 2 - stepSize;
    }

    // Uses a probability function to determine if a biased step should be taken
    // Biased steps are multiplied by a random factor, and also by the probability function
    // This means that the farther away a zombie is from the mouse, the smaller its biased steps will be
    public void walkToward(int x, int y){
        this.walk();
        if(biasFunction(x, y) >= Math.random()){
            this.x += Math.random() * biasedStepSize * biasFunction(x, y) * directionality(x - this.x);
            this.y += Math.random() * biasedStepSize * biasFunction(x, y) * directionality(y - this.y);
        }
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    public static void setStepSize(double max){
        stepSize = max;
    }

    public static double pythag(double a, double b){
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    // Uses the function 1 / a * sqrt(x - h) + 1 to determine the probability a zombie will take a biased step
    private double biasFunction(double x, double y){
        if(pythag(x - this.x, y - this.y) > noBiasRadius) {
            return 1 / (biasCoefficient * (Math.sqrt(pythag(x - this.x, y - this.y) - noBiasRadius)) + 1);
        }
        else{
            return 0;
        }
    }

    // Returns 1 if value is positive, otherwise, returns -1
    private static int directionality(double value){
        if(value >= 0){
            return 1;
        }
        else{
            return -1;
        }
    }
}
