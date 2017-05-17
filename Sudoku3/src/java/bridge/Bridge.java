/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;

import sudoku.Sudoku;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "bridge", urlPatterns = {"/API/*"})
public class Bridge extends HttpServlet {

        private JsonObject compute(String x, String y, String nr, String mode){
        if ("HINT".equals(mode))
        {
            return compute(mode);
            
        }
        else if( x == null || y == null || nr == null || mode == null){
                return Json.createObjectBuilder()
                    .add("error","missing data")
                    .add("x", ""+x)
                    .add("y", ""+y)
                    .add("nr", ""+nr)
                    .add("mode", ""+mode)
                    .build();
        
        } else {
            
        int Xpos = Integer.parseInt(x);
        int Ypos = Integer.parseInt(y);
        int nummer = Integer.parseInt(nr);
        return compute(Xpos,Ypos,nummer,mode);
        }
        
        }
        
    private Sudoku theActualSudoku = new Sudoku();
    private JsonObject compute(int Xpos, int Ypos, int nummer, String mode){
        int res = 0;
        switch (mode){
            case "INPUT":
                if (theActualSudoku.setNumber(Xpos, Ypos, nummer)> 0)
                {
                   res = theActualSudoku.setNumber(Xpos, Ypos, nummer);
                }
                else
                {
                    
                    return Json.createObjectBuilder()
                            .add("error", "Invalid Number")
                            .add ("mode", ""+mode)
                            .build();
                }
                break;
            default:
                return Json.createObjectBuilder()
                        .add("error","unknown mode")
                        .add("mode" , ""+mode)
                        .build();
        }
         
    return Json.createObjectBuilder()
            .add("msg","succes")
            .add("x", Xpos)
            .add("y",Ypos)
            .add("nr",nummer)
            .add("mode",mode)
            .add("res",res)
            .build();
    };
    
    private JsonObject compute(String mode)
    {
        int[] res = theActualSudoku.getHint();
        return Json.createObjectBuilder()
            .add("msg","succes")
            .add("x", res[1])
            .add("y",res[2])
            .add("nr",res[0])
            .add("mode",mode)
            .build();
    };
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
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String mode = request.getParameter("mode");
            String x = request.getParameter("x");
            String y = request.getParameter("y");
            String nr = request.getParameter("nr");
            
            
            JsonObject json = compute(x,y,nr,mode);
            out.println(json);
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
