package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.google.gson.Gson;
import Control.Tools;
import Model.Restaurant;
import java.util.LinkedList;

public final class AllRestaurant_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>All Restaurants</title>\n");
      out.write("        <link href=\"../css/Mine.css\" rel=\"stylesheet\" />\n");
      out.write("    </head>\n");
      out.write("    ");

        Restaurant temp;
        Tools.updateRestaurants(session);
        LinkedList<Restaurant> allRests = (LinkedList<Restaurant>) session.getAttribute("allRestaurants");
        Gson gson=new Gson();
        String oob=gson.toJson(allRests);
        oob="{ \"rests\" :"+oob+"}";
    
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function goToMenu(id, restid, name)\n");
      out.write("        {\n");
      out.write("            window.location = \"ManageMenu.jsp?id=\" + id + \"&restid=\" + restid + \"&name=\" + name;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function goToDeleteRe(id, restid, name)\n");
      out.write("        {\n");
      out.write("            window.location = \"../HandleDeleteRestaurant?id=\" + id + \"&restid=\" + restid + \"&name=\" + name;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function goToModifyRe(id, restid, name)\n");
      out.write("        {\n");
      out.write("            window.location = \"../HandleModifyRestaurant?id=\" + id + \"&restid=\" + restid + \"&name=\" + name;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function searchByState(state)\n");
      out.write("        {\n");
      out.write("            var value=state.value;\n");
      out.write("           \n");
      out.write("            var oobs='");
      out.print(oob);
      out.write("';\n");
      out.write("            var temps=JSON.parse(oobs);\n");
      out.write("            \n");
      out.write("            var table = document.getElementById(\"restaurantTable\");\n");
      out.write("            var length=table.rows.length;\n");
      out.write("             //document.write(temps.length);\n");
      out.write("            var index=0;\n");
      out.write("            for(index=1;index<length;index++)\n");
      out.write("            {\n");
      out.write("                table.deleteRow(index);\n");
      out.write("            }\n");
      out.write("            for(index=0;index<temps.rests.length;index++)\n");
      out.write("            {\n");
      out.write("                //document.write(length);\n");
      out.write("                var temp=temps.rests[index];\n");
      out.write("                var tr=table.insertRow(1);\n");
      out.write("                \n");
      out.write("                var content=\n");
      out.write("                        \"<td><img src=\"+temp.logoImage+\" class='logoImage'></td>\"\n");
      out.write("                        +\"<td>\"+temp.ID+\"</td>\"\n");
      out.write("                        +\"<td>\"+temp.name+\"</td>\"\n");
      out.write("                        +\"<td>\"+temp.address+\"</td><td>\"+temp.city+\"</td><td>\"+temp.state+\"</td><td>\"+temp.zipcode+\"</td>\"\n");
      out.write("                        +\"<td><input type='submit' value='菜单管理' onclick='goToMenu(\"+temp.mainID+\",\"+temp.ID+\",\"+temp.name+\")'></td>\"\n");
      out.write("                        +\"<td><input type='submit' value='修改餐馆信息' onclick='goToModifyRe(\"+temp.mainID+\",\"+temp.ID+\",\"+temp.name+\")'></td>\"\n");
      out.write("                        +\"<td><input type='submit' value='删除餐馆' onclick='goToDeleteRe(\"+temp.mainID+\",\"+temp.ID+\",\"+temp.name+\")'></td>\";\n");
      out.write("                tr.innerHTML=content;    \n");
      out.write("            }\n");
      out.write("      \n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("    <body style=\"text-align: center\">\n");
      out.write("        <div>\n");
      out.write("            <label><h2>查看餐馆</h2></label><br/>\n");
      out.write("\n");
      out.write("            <div class=\"addFCDIV\">\n");
      out.write("                <div>\n");
      out.write("                    <label>State:</label><select onchange=\"searchByState(this);\">\n");
      out.write("                        <option value=\"null\">None</option>\n");
      out.write("                        <option value=\"AL\">Alabama</option>\n");
      out.write("                        <option value=\"AK\">Alaska</option>\n");
      out.write("                        <option value=\"AZ\">Arizona</option>\n");
      out.write("                        <option value=\"AR\">Arkansas</option>\n");
      out.write("                        <option value=\"CA\">California</option>\n");
      out.write("                        <option value=\"CO\">Colorado</option>\n");
      out.write("                        <option value=\"CT\">Connecticut</option>\n");
      out.write("                        <option value=\"DE\">Delaware</option>\n");
      out.write("                        <option value=\"DC\">District Of Columbia</option>\n");
      out.write("                        <option value=\"FL\">Florida</option>\n");
      out.write("                        <option value=\"GA\">Georgia</option>\n");
      out.write("                        <option value=\"HI\">Hawaii</option>\n");
      out.write("                        <option value=\"ID\">Idaho</option>\n");
      out.write("                        <option value=\"IL\">Illinois</option>\n");
      out.write("                        <option value=\"IN\">Indiana</option>\n");
      out.write("                        <option value=\"IA\">Iowa</option>\n");
      out.write("                        <option value=\"KS\">Kansas</option>\n");
      out.write("                        <option value=\"KY\">Kentucky</option>\n");
      out.write("                        <option value=\"LA\">Louisiana</option>\n");
      out.write("                        <option value=\"ME\">Maine</option>\n");
      out.write("                        <option value=\"MD\">Maryland</option>\n");
      out.write("                        <option value=\"MA\">Massachusetts</option>\n");
      out.write("                        <option value=\"MI\">Michigan</option>\n");
      out.write("                        <option value=\"MN\">Minnesota</option>\n");
      out.write("                        <option value=\"MS\">Mississippi</option>\n");
      out.write("                        <option value=\"MO\">Missouri</option>\n");
      out.write("                        <option value=\"MT\">Montana</option>\n");
      out.write("                        <option value=\"NE\">Nebraska</option>\n");
      out.write("                        <option value=\"NV\">Nevada</option>\n");
      out.write("                        <option value=\"NH\">New Hampshire</option>\n");
      out.write("                        <option value=\"NJ\">New Jersey</option>\n");
      out.write("                        <option value=\"NM\">New Mexico</option>\n");
      out.write("                        <option value=\"NY\">New York</option>\n");
      out.write("                        <option value=\"NC\">North Carolina</option>\n");
      out.write("                        <option value=\"ND\">North Dakota</option>\n");
      out.write("                        <option value=\"OH\">Ohio</option>\n");
      out.write("                        <option value=\"OK\">Oklahoma</option>\n");
      out.write("                        <option value=\"OR\">Oregon</option>\n");
      out.write("                        <option value=\"PA\">Pennsylvania</option>\n");
      out.write("                        <option value=\"RI\">Rhode Island</option>\n");
      out.write("                        <option value=\"SC\">South Carolina</option>\n");
      out.write("                        <option value=\"SD\">South Dakota</option>\n");
      out.write("                        <option value=\"TN\">Tennessee</option>\n");
      out.write("                        <option value=\"TX\">Texas</option>\n");
      out.write("                        <option value=\"UT\">Utah</option>\n");
      out.write("                        <option value=\"VT\">Vermont</option>\n");
      out.write("                        <option value=\"VA\">Virginia</option>\n");
      out.write("                        <option value=\"WA\">Washington</option>\n");
      out.write("                        <option value=\"WV\">West Virginia</option>\n");
      out.write("                        <option value=\"WI\">Wisconsin</option>\n");
      out.write("                        <option value=\"WY\">Wyoming</option>\n");
      out.write("                    </select>\n");
      out.write("                    <input type=\"checkbox\" name=\"isCity\" id=\"isCity\"><label>City:</label><input type=\"text\" id=\"yCity\" name=\"yCity\">\n");
      out.write("                    <input type=\"checkbox\" name=\"isID\" id=\"isID\"><label>ID:</label><input type=\"text\" id=\"yID\" name=\"yID\">\n");
      out.write("                    <input type=\"checkbox\" name=\"isName\" id=\"isName\"><label>Name:</label><input type=\"text\" id=\"yName\" name=\"yName\">\n");
      out.write("                    <input type=\"submit\" value=\"Search\" onclick=\"doSearch\"><br/>\n");
      out.write("                    <br/>\n");
      out.write("                </div>\n");
      out.write("                <table class=\"restauranttable\" id=\"restaurantTable\">\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Logo</th><th>ID</th><th>Name</th><th>Address</th><th>City</th><th>State</th>\n");
      out.write("                        <th>Zip</th><th>Manage Menu</th><th>Modify Restaurant</th><th>Delete Restaurant</th>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("            <br/>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
