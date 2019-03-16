/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class testdriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        reportspojo rp = new reportspojo();
        rp.setItem_id("6");
        System.out.println(rp.getItem_id() + "name");
        rp.setItem_name(sc.nextLine().toUpperCase());
        System.out.println(rp.getItem_name()+"cat");
        rp.setItem_cat(sc.next().toUpperCase());
        System.out.println(rp.getItem_cat()+"place");
        sc.nextLine();
        rp.setItem_palce(sc.nextLine().toUpperCase());
        System.out.println(rp.getItem_palce()+"date");
        try{
        rp.setItem_date(new SimpleDateFormat("dd-MM-YYYY").parse(sc.next()));
            System.out.println(rp.getItem_date()+"desc");
            sc.nextLine();
          rp.setItem_desc(sc.nextLine().toUpperCase());
            System.out.println(rp.getItem_desc());
        rp.setItem_img("qes.jpg");
            System.out.println(rp.getItem_img());
        System.out.println(reports.getReports(rp));
        }
catch(Exception ex)
{
    System.out.println("error"+ ex);
}
     
        
        
    }
    
}
