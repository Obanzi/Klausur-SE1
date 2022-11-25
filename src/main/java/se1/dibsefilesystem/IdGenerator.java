package se1.dibsefilesystem;

public class IdGenerator {

    private int currentId;


    private IdGenerator(){
        this.currentId = 0;
    }


    private static final class InstanceHolder {
        static final IdGenerator instance = new IdGenerator();
    }

    /**
     *
     * @return the instance of the IdGenerator
     */
    public static IdGenerator getInstance(){
        return InstanceHolder.instance;
    }

    /**
     *
     * @return the current id and increments it
     */
    public int createId(){
        synchronized (IdGenerator.class){
            this.currentId++;
            return this.currentId;
        }
    }

}

