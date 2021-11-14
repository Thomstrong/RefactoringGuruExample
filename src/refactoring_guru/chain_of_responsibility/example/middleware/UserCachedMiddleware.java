package refactoring_guru.chain_of_responsibility.example.middleware;

import java.util.Date;
import java.util.Map;

public class UserCachedMiddleware extends Middleware {
    Map<String, Date> cache;

    public UserCachedMiddleware(Map<String, Date> cache) {
        this.cache = cache;
    }

    @Override
    public boolean check(String email, String password) {
        if (!this.cache.containsKey(email)) {
            System.out.println("This email not in cache!");
            return checkNext(email, password);
        }

        if (this.cache.get(email).before(new Date(System.currentTimeMillis()))) {
            System.out.println("This email cache expired!");
            return checkNext(email, password);
        }
        System.out.println("This email hint cache!");
        return true;
    }
}
