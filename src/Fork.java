public class Fork {

    private int fork;
    private boolean isAvailable;
    private int lastPhilosopher;

    public Fork(int fork) {
        this.fork = fork;
        isAvailable = true;
        lastPhilosopher = -1;
    }

    public boolean takeFork(int philosopher) {
        if(lastPhilosopher == philosopher) {
            return false;
        } else {
            if(isAvailable) {
                lastPhilosopher = philosopher;
                this.isAvailable = false;
                return  true;
            } else {
                return false;
            }
        }
    }

    public void putOnTable() {
        this.isAvailable = true;
    }

    public int getFork() {
        return fork;
    }
}
