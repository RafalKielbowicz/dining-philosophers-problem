
class Philosopher implements Runnable {
    Cutlery knife=new Cutlery();
    Cutlery fork=new Cutlery();
    static int amountOfForks=3;
    static int amountOfKnifes=2;

    private  void think() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() +"  thinking");
        Thread.sleep(((int) (Math.random() * 1000)));
    }
    private void takeKnife() throws InterruptedException {
        amountOfKnifes--;
        System.out.println(Thread.currentThread().getName() +"  take Knife-eating, left: "+amountOfKnifes);
        Thread.sleep(((int) (Math.random() * 1000)));
    }
    private void takeFork() throws InterruptedException {
        amountOfForks--;
        System.out.println(Thread.currentThread().getName() + "  take Fork, left: "+amountOfForks);
        Thread.sleep(((int) (Math.random() * 1000)));
    }
    private  void dropKnife() throws InterruptedException {
        amountOfKnifes++;
        System.out.println(Thread.currentThread().getName() + "  drop Knife, left: "+amountOfKnifes);
        Thread.sleep(((int) (Math.random() * 1000)));
    }
    private  void dropFork() throws InterruptedException {
        amountOfForks++;
        System.out.println(Thread.currentThread().getName() +  " drop Fork, left: "+amountOfForks);
        Thread.sleep(((int) (Math.random() * 1000)));
    }


    @Override
    public void run() {
        try {
            while (true) {
                think();
                synchronized (Cutlery.class) {
                    if(amountOfForks>0){
                        takeFork();
                    }

                    synchronized (Cutlery.class) {
                        if(amountOfKnifes>0){
                            takeKnife();
                            dropKnife();
                        }
                    }
                    dropFork();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
