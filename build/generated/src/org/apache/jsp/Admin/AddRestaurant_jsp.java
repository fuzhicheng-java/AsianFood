package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddRestaurant_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"../css/Mine.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function checkStatus(value)\n");
      out.write("            {\n");
      out.write("                if (value === 0)\n");
      out.write("                {\n");
      out.write("                    alert(\"Some exception occured!\");\n");
      out.write("                }\n");
      out.write("                if (value === 1)\n");
      out.write("                {\n");
      out.write("                    alert(\"The name or ID have already existed!\");\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                if (value === 2)\n");
      out.write("                {\n");
      out.write("                    alert(\"Adding Successfully\");\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                if (value === 3)\n");
      out.write("                {\n");
      out.write("                    alert(\"Adding Failed\");\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    ");

        int index = -1;
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
    
      out.write("\n");
      out.write("    <body style=\"text-align: center\" onload=\"checkStatus(");
      out.print(index);
      out.write(")\">\n");
      out.write("        ");
} else {
        
      out.write("\n");
      out.write("    <body style=\"text-align: center\" onload=\"checkStatus(-1)\">\n");
      out.write("        ");
}
        
      out.write("\n");
      out.write("\n");
      out.write("        <div id='addCategory'>\n");
      out.write("            <label><h2>添加餐馆操作</h2></label><br/>\n");
      out.write("            <form id=\"canguanform\" method='POST' action=\"../HandleAddRestaurant\"  enctype=\"multipart/form-data\">\n");
      out.write("\n");
      out.write("                <div class=\"addFCDIV\">\n");
      out.write("                    <table class=\"centertable\">\n");
      out.write("                        <tr><td>ID:</td><td><input type=\"text\" name=\"id\" required></td></tr>\n");
      out.write("                        <tr><td>Name:</td><td><input type=\"text\" name=\"name\" required></td></tr>\n");
      out.write("                        <tr><td>Address:</td><td><input type=\"text\" name=\"address\" required></td></tr>\n");
      out.write("                        <tr><td>City:</td><td><input type=\"text\" name=\"city\" required></td></tr>\n");
      out.write("                        <tr><td>State:</td><td><input type=\"text\" name=\"state\" required></td></tr>\n");
      out.write("                        <tr><td>Zip:</td><td><input type=\"text\" name=\"zipcode\" required></td></tr>\n");
      out.write("                        <tr><td>Email:</td><td><input type=\"email\" name=\"email\" required></td></tr>\n");
      out.write("                        <tr><td>Phone:</td><td><input type=\"text\" name=\"phone\" required></td></tr>\n");
      out.write("                        <tr><td>Mon-Sat Hours:</td><td><input type=\"text\" name=\"monh\" required></td></tr>\n");
      out.write("                        <tr><td>Sun Hours:</td><td><input type=\"text\" name=\"sunh\" required></td></tr>\n");
      out.write("                        <tr><td>Min Price:</td><td><input type=\"text\" name=\"minprice\" required></td></tr>\n");
      out.write("                        <tr><td>Fee:</td><td><input type=\"text\" name=\"fee\" required></td></tr>\n");
      out.write("                        <tr><td>Type:</td>\n");
      out.write("                            <td><select id=\"restType\" name='type' class=\"selectBox\">\n");
      out.write("                                    <option value=\"1\">Chinese</option>\n");
      out.write("                                    <option value=\"2\">Thai</option>\n");
      out.write("                                    <option value=\"3\">Japanese</option>\n");
      out.write("                                    <option value=\"4\">Indian</option>\n");
      out.write("                                </select></td></tr>\n");
      out.write("                        <tr><td>Logo Image:</td><td><input type=\"file\" name=\"file\" required></td></tr>\n");
      out.write("                        <tr><td><input type=\"submit\" value=\"Submit\"></td></tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                <br/>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
