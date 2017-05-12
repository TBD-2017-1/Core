package PoliTweetsCL.Core.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MySQLController {

    private Connection conn = null;

    public MySQLController() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/PoliTweets?user=root&password=x");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public MySQLController(boolean remote) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            if (remote){
                conn = DriverManager.getConnection("jdbc:mysql://107.170.99.162/PoliTweets?user=root&password=DigitalOceanServer");
            }else{
                conn = DriverManager.getConnection("jdbc:mysql://localhost/PoliTweets?user=root&password=x");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public MySQLController(String user,String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/PoliTweets?user="+user+"&password="+pass);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Set<String> getKeywords(){
        try {

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery("SELECT * FROM keyword");

            Set<String> keywords = new HashSet<>();

            // get keyword value
            while (rs.next())
            {
                keywords.add(rs.getString("value"));
            }
            st.close();

            return keywords;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

}
