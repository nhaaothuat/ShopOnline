package Controller;

import dao.DAO;
import entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 *
 * @author Trung Kien
 */
@WebServlet(name = "ShopControl", urlPatterns = {"/shop"})
public class ShopControl extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String indexPage = request.getParameter("index");
        if(indexPage == null || indexPage.equals("null")) indexPage = "1";
        
        DAO dao = new DAO();
        List<Product> list = dao.getAllProduct();
        List<Category> listC = dao.getAllCategory();
        List<Product> listByPaging = dao.pagingProduct(Integer.parseInt(indexPage));
        int totalP = dao.getTotalProduct();
        int numPage = totalP / 6;
        if(totalP % 6 != 0) numPage++;
        request.setAttribute("context", "shop");
        request.setAttribute("tag", Integer.parseInt(indexPage));
        //request.setAttribute("indexPage", Integer.parseInt(indexPage));
        request.setAttribute("endPage", numPage);
        request.setAttribute("listP", listByPaging);
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
        
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
