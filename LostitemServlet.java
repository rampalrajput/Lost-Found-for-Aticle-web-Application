package Dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Lost.dto.Person_DTO;
import LostFound.dto.item_DTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class LostitemServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
    //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
    //InputStream fileContent = filePart.getInputStream();

//  File f = (File) request.getParameter("file"); 
RequestDispatcher rd=null;
 try
   {
   String item_name =request.getParameter("itemName");
   String item_place =request.getParameter("itemPlace");
   String item_Cat =request.getParameter("itemCat");
   String item_Date =request.getParameter("itemDate");
   String item_desc =request.getParameter("itemDesc");
    String item_Img =request.getParameter("file");
     // System.out.println(" image name "+item_Img );
   String item_reward =request.getParameter("itemReward");
   String Person_name =request.getParameter("personName");
   String person_number =request.getParameter("mobile");
 
   
  
       if(item_name!=null && item_place!=null &&item_Cat!=null && item_Date!=null && Person_name !=null&& person_number!=null  )
            {
          //   System.out.println(" person_number" +person_number);
          long number = Long.parseLong(person_number);
                     
       
          item_DTO item= new item_DTO();
          Person_DTO person =  new Person_DTO();
          item.setItem_Name(item_name);
          item.setItem_place(item_place);
          item.setItem_cat(item_Cat);
          item.setDate(item_Date);
          item.setItem_img("abb.jpg");
          item.setItem_desc(item_desc);
          item.setReport_type("L");
          item.setReward(item_reward);
          person.setP_name(Person_name);
          person.setMOb_number(number);
     //System.out.println(" item detalis"+item);
       //  System.out.println(" person details "+person);
      boolean result1 =  itemDAO.itemLostDetails(item);
        
     boolean result2=itemDAO.personDetails(person);
  
       //System.out.println(" result1 and result2 "+result1+" "+result2);
           if(result1!=false && result2!=false)
           {
               
          
                request.setAttribute("result1",result1);
                 request.setAttribute("result2",result2);
               
                 rd=request.getRequestDispatcher("Lostitemresponse.jsp");
           }
       }
    
            
   }
   
 catch(Exception th)
        {
          request.setAttribute("exception", th);
          rd=request.getRequestDispatcher("showexception.jsp");
          System.out.println("Exception from Model:"+th);
          th.printStackTrace();
        }
        finally
        {
             rd.forward(request, response);
        }
   

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
