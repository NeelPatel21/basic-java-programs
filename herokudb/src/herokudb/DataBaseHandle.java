/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herokudb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Neel Patel
 */
public class DataBaseHandle {
    private static Connection con = null;
    private static String msg = "";
    
    public boolean close()
    {
        try{
        con.close();
        con = null;
        return true;
        }catch(Exception e)
        {
            return false;
        }
    }
    
    public DataBaseHandle(){
        try {
            Class.forName("org.postgresql.Driver");
            DriverManager.getDriver("jdbc:postgresql://ec2-54-163-234-140.compute-1.amazonaws.com:5432/d8q49nrpkur5ji"
                      );
            String url = "jdbc:postgresql://ec2-54-163-234-140.compute-1.amazonaws.com:5432/d8q49nrpkur5ji";
            Properties props = new Properties();
            props.setProperty("user","zosaumkzqyblgt");
            props.setProperty("password","1696d15dcd5ada3650bbe904391439d55f8f060f9005c86efe068afeb9242cf6");
            props.setProperty("ssl","false");
            Connection conn = DriverManager.getConnection(url, props);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    
    }
//            DriverManager.getDriver("jdbc:postgres://zosaumkzqyblgt:1696d15dcd5ada3650bbe904391439d55f8f060f9005c86efe068afeb9242cf6@ec2-54-163-234-140.compute-1.amazonaws.com:5432/d8q49nrpkur5ji");
}
