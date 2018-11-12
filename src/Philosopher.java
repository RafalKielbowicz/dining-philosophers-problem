public class Philosopher implements Runnable {

    private int philosopher;
    private Fork left;
    private Fork right;
    private int numOfEaten;

    public Philosopher(int philosopher, Fork left, Fork right) {
        this.philosopher = philosopher;
        this.left = left;
        this.right = right;
        numOfEaten = 0;
    }

    @Override
    public void run() {
        while(true) {
            boolean hasFork;

            //take left fork
            System.out.println("Philosopher " + philosopher + " is waiting for fork " + left.getFork());
            do {
                hasFork = left.takeFork(philosopher);
            } while (!hasFork);
            System.out.println("Philosopher " + philosopher + " takes fork " + left.getFork());

            System.out.println("Philosopher " + philosopher + " is waiting for fork " + right.getFork());
            do {
                hasFork = right.takeFork(philosopher);
            } while (!hasFork);
            System.out.println("Philosopher " + philosopher + " takes fork " + right.getFork());

            //eat
            System.out.println("Philosopher " + philosopher + " is eating");
            numOfEaten++;
            System.out.println("Philosopher eats schabowy for the " + numOfEaten + " time");

            //put fork on table
            System.out.println("Philosopher " +philosopher+ " put forks on table" );
            left.putOnTable();
            right.putOnTable();

            System.out.println();

        }
    }
}
