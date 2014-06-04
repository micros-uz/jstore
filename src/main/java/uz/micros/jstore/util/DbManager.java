package uz.micros.jstore.util;

import uz.micros.jstore.entity.blog.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private static Connection connect(){
        System.out.println("JDBC Connection Test");

        Connection res = null;

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
             res = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/jstore",
                    "postgres", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public static List<Post> runQuery(String query) {
        Connection conn = connect();

        List<Post> list = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);


            while(rs.next()){
                Post p = new Post();
                p.setId(rs.getInt(1));
                p.setDate(rs.getDate(2));
                p.setText(rs.getString(3));

                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
