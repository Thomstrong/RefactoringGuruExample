package refactoring_guru.chain_of_responsibility.example;

import refactoring_guru.chain_of_responsibility.example.middleware.*;
import refactoring_guru.chain_of_responsibility.example.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * EN: Demo class. Everything comes together here.
 * <p>
 * RU: Демо-класс. Здесь всё сводится воедино.
 */
public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        Map<String, Date> cache = new HashMap<>();
        server = new Server(cache);

        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");
        server.register("thom@abc.com", "thom");

        // EN: All checks are linked. Client can build various chains using the
        // same components.
        //
        // RU: Проверки связаны в одну цепь. Клиент может строить различные
        // цепи, используя одни и те же компоненты.
        Middleware middleware = new UserCachedMiddleware(cache);
        middleware.linkWith(new ThrottlingMiddleware(5))
                .linkWith(new UserExistsMiddleware(server))
                .linkWith(new RoleCheckMiddleware());

        // EN: Server gets a chain from client code.
        //
        // RU: Сервер получает цепочку от клиентского кода.
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }
}
