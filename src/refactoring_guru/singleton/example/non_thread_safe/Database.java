package refactoring_guru.singleton.example.non_thread_safe;

/**
 * @author caiwenqiang
 */
public class Database {
    private String name;
    private static Database db;
    private Database(String name) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.name = name;
    }

    public static Database getDbInstance(String name) {
        if (db == null) {
            db = new Database(name);
        }
        return db;
    }

    public String getName() {
        return name;
    }
}
