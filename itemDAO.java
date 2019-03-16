/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Lost.dto.Person_DTO;
import LostFound.dto.item_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author NSD COMPUTER04
 */
 public class itemDAO {
       private static PreparedStatement ps1,ps2;

    static
    {
        try
        {
 ps1=dbutil.getConnection().prepareStatement("insert into reports values(?,?,?,?,?,?,?,?,?)");
   ps2=dbutil.getConnection().prepareStatement("insert into personal_info values(?,?,?)");
           
            System.out.println(" run sussfully query");
        }
     catch(SQLException ex)
     {
         System.out.println(" Error in db comm"+ex);
         ex.printStackTrace();
    }
    }
    
    public static String getNewItemId() throws SQLException
    {
         Connection con = dbutil.getConnection();
          
          Statement st = con.createStatement();
          
          int id=101;
          ResultSet rs = st.executeQuery(" select count(*) from reports");
          
          if(rs.next())
          {
              id= id+rs.getInt(1);
          }
          System.out.println("itemid"+ id);
          return "ID-"+id;
    }
      public static String getNewItemIdPerson() throws SQLException
    {
         Connection con = dbutil.getConnection();
          
          Statement st = con.createStatement();
          
          int id=101;
          ResultSet rs = st.executeQuery(" select count(*) from  personal_info ");
          
          if(rs.next())
          {
              id= id+rs.getInt(1);
          }
          System.out.println("itemid"+ id);
          return "ID-"+id;
    }
      public static boolean itemLostDetails(item_DTO item) throws SQLException, ParseException
    {
    //System.out.println(" user Dao"+user.getUsername()+" password"+user.getPaswword()+" "+user.getUsername());
        System.out.println(" itemLostDetails");
        String itemid = getNewItemId();
        System.out.println(" itemid"+itemid );
        String Date= item.getDate();
        System.out.println("date "+Date);
      ps1.setString(1,itemid );
      ps1.setString(2,item.getItem_Name() );
     ps1.setString(3, item.getItem_cat());
     ps1.setString(4, item.getItem_place());
    
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
     // java.utill.date convert into java.sql.Date
     java.util.Date d1 = sdf.parse(Date);
       long ms = d1.getTime();
    java.sql.Date  d2 = new  java.sql.Date(ms);
    
       ps1.setDate(5,d2);
     ps1.setString(6, item.getItem_desc());
      ps1.setString(7, item.getItem_img());
     ps1.setString(8,item.getReport_type());
     ps1.setString(9,item.getReward());
      
    int x =ps1.executeUpdate();
    if(x>0)
        return true;
    else
        return false;
            
}
        public static boolean personDetails(Person_DTO person) throws SQLException, ParseException
    {
    //System.out.println(" user Dao"+user.getUsername()+" password"+user.getPaswword()+" "+user.getUs
        
        String itemid =getNewItemIdPerson();
      ps2.setString(1,itemid );
      ps2.setString(2,person.getP_name());
      ps2.setLong(3, person.getMOb_number());
 
      int x =ps2.executeUpdate();
     if(x>0)
         return true;
      else
          return false;
            
}
      
 }

