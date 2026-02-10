package repository;

import config.DBConnection;
import java.sql.Statement;

public class CategoryRepository {

    public void add(String name) {
        try (Statement st = DBConnection.getInstance()
                .getConnection().createStatement()) {
            st.execute("INSERT INTO categories(name) VALUES('" + name + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
