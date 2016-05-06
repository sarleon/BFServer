package DB;

import java.sql.Connection;

/**
 * Created by sarleon on 16-5-6.
 */
public class DBTest {
    public static void main(String[] args) {
        Connection connection=BaseConnection.getConnection();

    }
}
