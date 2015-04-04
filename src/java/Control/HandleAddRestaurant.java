/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Paths;
import Model.Restaurant;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author zhichengfu
 */
public class HandleAddRestaurant extends HttpServlet {

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
            throws ServletException, IOException, FileUploadException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String path = getClass().getResource("/").getPath();
            String[] tempS = null;
            if (Paths.path == null) {
                File file = new File(path + "test.html");
                path = file.getParent();
                File file1 = new File(path + "test1.html");
                path = file1.getParent();
                File file2 = new File(path + "test1.html");
                path = file2.getParent();
                Paths.path = path;
            } else {
                path = Paths.path;
            }
            path=Paths.tempPath;
            Restaurant temp = new Restaurant();
            String name = null;
            String sepName=Tools.CurrentTime();
            if (ServletFileUpload.isMultipartContent(request)) {
                List<?> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                Iterator iter = multiparts.iterator();
                int index = 0;
                tempS = new String[multiparts.size() - 1];
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();
                    if (!item.isFormField()) {
                        name = new File(item.getName()).getName();
                        
                        String FilePath = path + Paths.logoPathStore +sepName+ name;
                        item.write(new File(FilePath));
                    } else {
                        String test = item.getFieldName();
                        tempS[index++] = item.getString();
                    }
                }
                index = 0;
                temp.ID = tempS[index++];
                temp.name = tempS[index++];
                temp.address = tempS[index++];
                temp.city = tempS[index++];
                temp.state = tempS[index++];
                temp.zipcode = tempS[index++];
                temp.email = tempS[index++];
                temp.phone = tempS[index++];
                temp.monHours = tempS[index++];
                temp.sunHours = tempS[index++];
                temp.minPrice = Double.parseDouble(tempS[index++]);
                temp.fee = Double.parseDouble(tempS[index++]);
                temp.type = Integer.parseInt(tempS[index++]);
                temp.logoImage = Paths.logoPath +sepName+ name;
            }

            if (Restaurant.checkExisted(temp.ID, temp.name)) {
                
                response.sendRedirect("./Admin/AddRestaurant.jsp?index=1");
            } else {
                if (Restaurant.addNewRestaurant(temp)) {
                    Tools.updateRestaurants(session);
                    response.sendRedirect("./Admin/AddRestaurant.jsp?index=2");
                } else {
                    response.sendRedirect("./Admin/AddRestaurant.jsp?index=3");
                }
            }

        } catch (Exception e) {
            response.sendRedirect("./Admin/AddRestaurant.jsp?index=0");
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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(HandleAddRestaurant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(HandleAddRestaurant.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(HandleAddRestaurant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(HandleAddRestaurant.class.getName()).log(Level.SEVERE, null, ex);
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
