public class EatingPhilosophersProblem {

    public static void main(String[] args) {
        Philosopher philosopher1 = new Philosopher();
        Philosopher philosopher2 = new Philosopher();
        Philosopher philosopher3 = new Philosopher();
        Philosopher philosopher4 = new Philosopher();
        Philosopher philosopher5 = new Philosopher();

        Thread f1 = new Thread(philosopher1, "philosopher 1");
        Thread f2 = new Thread(philosopher2, "philosopher 2");
        Thread f3 = new Thread(philosopher3, "philosopher 3");
        Thread f4 = new Thread(philosopher4, "philosopher 4");
        Thread f5 = new Thread(philosopher5, "philosopher 5");

        f1.start();
        f2.start();
        f3.start();
        f4.start();
        f5.start();
    }
}

