/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Food;
import Model.Image;
import Model.Paths;
import Model.Restaurant;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author zhichengfu
 */
public class HandleAddFoodMenu extends HttpServlet {

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
         HttpSession session=request.getSession();
         Food temp = new Food();
        try (PrintWriter out = response.getWriter()) {
            LinkedList<String> names = new LinkedList<>();
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
            
            String name;
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
                        names.add(name);
                        String FilePath = path + Paths.foodImagePath  +sepName+name;
                        item.write(new File(FilePath));
                    } else {
                        String test = item.getFieldName();
                        tempS[index++] = item.getString();
                    }
                }
                index = 0;
                temp.categoryid=Integer.parseInt(tempS[index++]);
                temp.ID = tempS[index++];
                temp.name = tempS[index++];
                temp.price = Double.parseDouble(tempS[index++]);
                temp.pieces = Integer.parseInt(tempS[index++]);
                temp.description = tempS[index++];
                temp.restid = Integer.parseInt(tempS[index++]);
                temp.resID = tempS[index++];
                temp.rename = tempS[index++];
                
            }

            if (Food.checkExisted(temp.ID, temp.name)) {
                
                response.sendRedirect("./Admin/AddMenu.jsp?index=1"+"&id="+temp.restid+"&restid="+temp.resID+"&name="+temp.rename);
            } else {
                if (Food.addNewFood(temp)) {
                    int id=Food.getFoodID(temp.ID);
                    boolean flag=true;
                    for(String s:names)
                    {
                        if(Image.addImage(s, Paths.foodImagePathStore+sepName+s, id))
                        {
                            
                        }
                        else
                        {
                            flag=false;
                            break;
                        }
                    }
                    if(flag)
                    {
                       response.sendRedirect("./Admin/AddMenu.jsp?index=2"+"&id="+temp.restid+"&restid="+temp.resID+"&name="+temp.rename); 
                    }
                    else
                    {
                        response.sendRedirect("./Admin/AddMenu.jsp?index=4"+"&id="+temp.restid+"&restid="+temp.resID+"&name="+temp.rename);
                    }
                    
                } else {
                    response.sendRedirect("./Admin/AddMenu.jsp?index=3"+"&id="+temp.restid+"&restid="+temp.resID+"&name="+temp.rename);
                }
            }

        } catch (Exception e) {
            response.sendRedirect("./Admin/AddMenu.jsp?index=0"+"&id="+temp.restid+"&restid="+temp.resID+"&name="+temp.rename);
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
