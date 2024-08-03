package com.yurioliveira.doacoes.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static String PATH = "C:\\Users\\firey\\Documents\\GitHub\\trabalho_final_psc\\src\\main\\java\\com\\yurioliveira\\doacoes\\database\\db.properties";
    private static Connection conn = null;

    
    public static Connection getConnection() {
        if (conn == null) {
            Properties props = loadProperties();
            String dburl = props.getProperty("dburl");
            try {
                conn = DriverManager.getConnection(dburl, props);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException("Close Connection Error!");
            }
        }
    }

    // LoadProperties é responsavel por mostrar o caminho, e no Properties com o
    // sistema de HASHTABLE
    // Ele carrega as informações necessarias para abrir conexão.
    public static Properties loadProperties() {
        try (FileInputStream fis = new FileInputStream(PATH)) {
            Properties props = new Properties();
            props.load(fis);
            return props;
        } catch (IOException e) {
            throw new DbException("Error to open the properties!");
        }
    }

    public static void closeStatement(Statement st){
        if (conn != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException("Close Statement Failed!!!");
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if (conn != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException("Close ResultSet Failed!!!");
            }
        }
    }
}
