package Program;

import database.DB;

public class test {
    public static void main(String[] args) {
        DB.getConnection();
        DB.closeConnection();
    }
}
