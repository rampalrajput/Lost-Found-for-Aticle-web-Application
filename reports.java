package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class reports {
    public static Set getReports(reportspojo rp) throws Exception
    {
        System.out.println("in");
          Connection con;
         Class.forName("oracle.jdbc.driver.OracleDriver");
   con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","majorproject","test");    
        System.out.println(con);
      
        PreparedStatement ps;
        String qry = "";
       
        ps = con.prepareStatement(qry);
        ps.setString(1,rp.getItem_cat());
        ps.setDate(2,new java.sql.Date(rp.getItem_date().getTime()));
        String reportype="";
        if(rp.getReport_type().equalsIgnoreCase("F")){
            qry = "select * from reports where ITEM_CAT=? AND ITEM_DATE >= ? AND REPORT_TYPE=?";
            reportype="L";
        }
        else
        {
            qry = "select * from reports where ITEM_CAT=? AND ITEM_DATE <= ? AND REPORT_TYPE=?";
            reportype="F";
        }
        ps.setString(3, reportype);
        ResultSet rs = ps.executeQuery();
        ArrayList<reportspojo> al = new ArrayList<>();
        while(rs.next())
        {
            reportspojo obj = new reportspojo();
            obj.setItem_id(rs.getString(1));
            obj.setItem_name(rs.getString(2));
            obj.setItem_cat(rs.getString(3));
            obj.setItem_palce(rs.getString(4));
            obj.setItem_date(rs.getDate(5));
            obj.setItem_desc(rs.getString(6));
            obj.setItem_img(rs.getString(7));
          
            al.add(obj);
            
        }
       HashSet<reportspojo> hm = new HashSet<>();
        for(reportspojo ob:al)
        {
            if(ob.getItem_name().contains(rp.getItem_name()))
            {
            hm.add(ob);
            }
            String []ar = rp.getItem_desc().split(" ");
            for(String ch:ar)
            {
                if(ob.getItem_desc().contains(ch))
                    hm.add(ob);
            }
            
              ar = rp.getItem_palce().split(" ");
            for(String ch:ar)
            {
                if(ob.getItem_palce().contains(ch))
                    hm.add(ob);
            }
            
            
        }
        
          return hm;
    }
    
    public static ArrayList<reportspojo> getall() throws Exception
    {
        ArrayList<reportspojo> alrp = new ArrayList<>();
        
        
         System.out.println("in");
          Connection con;
         Class.forName("oracle.jdbc.driver.OracleDriver");
   con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","majorproject","test");    
        System.out.println(con);
      
        PreparedStatement ps;
        String qry = "";
        ps = con.prepareStatement("select * from reports");
        ResultSet rs = ps.executeQuery();
         while(rs.next())
        {
            reportspojo obj = new reportspojo();
            obj.setItem_id(rs.getString(1).toUpperCase());
            obj.setItem_name(rs.getString(2).toUpperCase());
            obj.setItem_cat(rs.getString(3).toUpperCase());
            obj.setItem_palce(rs.getString(4).toUpperCase());
            obj.setItem_date(rs.getDate(5));
            obj.setItem_desc(rs.getString(6).toUpperCase());
            obj.setItem_img(rs.getString(7));
            obj.setReport_type(rs.getString(8).toUpperCase());
            obj.setReward(rs.getString(9).toUpperCase());
          
            alrp.add(obj);
            
        }
       return alrp ; 
    }
    
    
    
    
}
