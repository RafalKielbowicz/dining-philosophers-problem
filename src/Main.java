import java.util.ArrayList;

public class Main {
    static ArrayList<Fork> forks = new ArrayList<Fork>();
    static ArrayList<Philosopher> philosophers = new ArrayList<Philosopher>();
    static final int NUM_PHILOSOPHERS = 5;


    public static void main(String[] args) {

        //creating forks
        for(int i=0; i < NUM_PHILOSOPHERS; i++) {
            forks.add(new Fork(i+1));
        }

        //creating philosophers
        for(int i=0; i < NUM_PHILOSOPHERS; i++) {
            int nextFork = i+1;

            if(nextFork == NUM_PHILOSOPHERS)
                nextFork = 0;

            philosophers.add(new Philosopher(i+1, forks.get(i), forks.get(nextFork)));
        }

        for(Philosopher p : philosophers) {
            new Thread(p).start();
        }
    }
}
