/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author user
 */
public class Exchange extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    
    
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final double usdR = 16452;
    private static final double eurR = 25170.38;
    private static final double jpyR = 151.23;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String vnd = request.getParameter("vnd");
    double v = Double.parseDouble(vnd);
    double ex;    
    String cur = request.getParameter("currency");
    DecimalFormat df = new DecimalFormat("0.00");    
    PrintWriter out = response.getWriter();
    if ("usd".equals(cur))
    {
        ex=v/usdR;
        out.println("<HTML>\n" +
                "<HEAD><TITLE></TITLE></HEAD>\n" +
                "<BODY>\n" +
                "<H1 ALIGN=CENTER>Currency</H1> \n"+ 
                "<h2>" + request.getParameter("vnd") + "VND equals " + df.format(ex) +"USD</h2>\n" +
                "</BODY></HTML>");
    } 
    else if("eur".equals(cur))
    {
        ex=v/eurR;
        out.println("<HTML>\n" +
                "<HEAD><TITLE></TITLE></HEAD>\n" +
                "<BODY>\n" +
                "<H1 ALIGN=CENTER>Currency</H1> \n"+ 
                "<h2>" + request.getParameter("vnd") + "VND equals " + df.format(ex) +"EUR</h2>\n" +
                "</BODY></HTML>");
    } 
    else if ("jpy".equals(cur))
    {
        ex=v/jpyR;
        out.println("<HTML>\n" +
                "<HEAD><TITLE></TITLE></HEAD>\n" +
                "<BODY>\n" +
                "<H1 ALIGN=CENTER>Currency</H1> \n"+ 
                "<h2>" + request.getParameter("vnd") + "VND equals " + df.format(ex) +"JPY</h2>\n" +
                "</BODY></HTML>");
    }
    

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
