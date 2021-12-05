package refactoring_guru.singleton.example.thread_safe;

/**
 * @author thomstrong
 */
public class Database {
    private static Database db;
    public String name;

    private Database(String name) {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.name = name;
    }

    public static Database getDbInstance(String name) {
        if (db == null) {
            synchronized (Database.class) {
                if (db == null) {
                    db = new Database(name);
                }
            }
        }
        return db;
    }
}
