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
import java.util.ArrayList;
import java.util.List;
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

    
        private Sudoku theActualSudoku = new Sudoku();
        
        private JsonObject compute(String mode){

            String[] hint = theActualSudoku.getHint();
            if ( hint[0].equals("Solved"))
                {
                    return Json.createObjectBuilder()
                            .add("msg","Error! Puzzle already solved!")
                            .add("mode", "HINT")
                            .build();
                }
        
                    return Json.createObjectBuilder()
                            .add("msg","Hint Added")
                            .add("x",hint[1])
                            .add("y",hint[2])
                            .add("nr",hint[0])
                            .add(mode,"HINT")
                            .build();
            
        };
       
        private JsonObject compute(String coordx, String coordy)
        {
            int x = Integer.parseInt(coordx);
            int y = Integer.parseInt(coordy);
            
            int number = theActualSudoku.getNumberFromSudoku(x, y);
            
            return Json.createObjectBuilder()
                    .add("msg","Number gotten")
                    .add("x", x)
                    .add("y", y)
                    .add("nr", number)
                    .build();
        };
        
        private JsonObject compute(String coordx, String coordy, String number)
        {
            int x = Integer.parseInt(coordx);
            int y = Integer.parseInt(coordy);
            int nr = Integer.parseInt(number);
            
            int res = theActualSudoku.setNumber(x, y, nr);
            
            return Json.createObjectBuilder()
                    .add("msg","Number gotten")
                    .add("x", x)
                    .add("y", y)
                    .add("nr", res)
                    .build();
        };
        
        private JsonObject compute(String coordx, String coordy, int placeholder)
        {
            int x = Integer.parseInt(coordx);
            int y = Integer.parseInt(coordy);
            
            int nr = theActualSudoku.getNumberFromSolution(x, y);
            
            return Json.createObjectBuilder()
                    .add("msg","Number gotten")
                    .add("x", x)
                    .add("y", y)
                    .add("nr", nr)
                    .build();
        };
      
        private JsonObject Invalid()
        {
            return Json.createObjectBuilder()
                    .add("msg", "Error! Mode does not exist!")
                    .build();
        }
        
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
            
            int placeholder = 0;
            
            switch (mode)
                {
                case ("HINT"):
                    JsonObject jsonHint = compute(mode);
                    out.println(jsonHint);
                    break;
                    
                case ("GET"):
                    JsonObject jsonGet = compute(x,y);
                    out.println(jsonGet);
                    break;
                    
                case ("SET"):
                    JsonObject JsonSet = compute(x,y,nr);
                    out.println(JsonSet);
                    break;
                    
                case ("CHECK"):
                    JsonObject JsonCheck = compute(x,y,placeholder);
                    out.println(JsonCheck);
                    break;
                    
                default:
                    JsonObject JsonInvalid = Invalid();
                    out.println(JsonInvalid);
                    break;
                }

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
