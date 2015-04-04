<%-- 
    Document   : AddCategory
    Created on : Mar 15, 2015, 5:06:25 PM
    Author     : zhichengfu
--%>
<%@page import="Model.Image"%>
<%@page import="Model.Restaurant"%>
<%@page import="Model.Food"%>
<%@page import="Model.Category"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            
            String id = request.getParameter("fid");
            String rid=request.getParameter("rid");
            String restid=request.getParameter("restid");
            String resname=request.getParameter("resname");
            Food tempFood=Food.getFoodByRealID(Integer.parseInt(id));
            String restaurant=Restaurant.getNameByID(tempFood.restid);
            String category=Category.getNameByID(tempFood.categoryid);
            Image.getAllImagesByID(tempFood.id);
            int numberImages=Image.names.size();
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Category</title>
        <link href="../css/Mine.css" rel="stylesheet" />
        <script>
        </script>
    </head>
    <body style="text-align: center">

        <div id='addCategory'>
            <label><h2><%=resname%>的菜单详情</h2></label>
            <labe><a href="AllMenus.jsp?id=<%=rid%>&restid=<%=restid%>&name=<%=resname%>"><h2>Back</h2></a></label><br/>
                <div class="addFCDIV">
                    <table class="centertable">
                        <tr><td>Restaurant:</td><td><%=restaurant%></td></tr>
                        <tr><td>ID:</td><td><%=tempFood.ID%></td></tr>
                        <tr><td>Name:</td><td><%=tempFood.name%></td></tr>
                        <tr><td>Category:</td><td><%=category%></td></tr>
                        <tr><td>Price:</td><td><%=tempFood.price%></td></tr>
                        <tr><td>Pieces:</td><td><%=tempFood.pieces%></td></tr>
                        <tr><td>Description:</td><td><%=tempFood.description%></textarea></td></tr>                                                              
                    </table>
                    <label><h4>Images of the meal:</h4></label><br/>
                    <%
                      int i=1;
                      while(i<=numberImages)
                      {
                          if(i%3==0)
                          {
                    %>
                    <a href="<%=Image.names.get(i-1).address%>"><img src="<%=Image.names.get(i-1).address%>" class="foodImage"></a><br/>
                    <%    }
                          else
                          {
                    %>
                    <a href="<%=Image.names.get(i-1).address%>"><img src="<%=Image.names.get(i-1).address%>" class="foodImage"><a/>
                    <%
                          }
                          i++;
                      }
                      
                    %>
                </div>
                <br/>
        </div>
    </body>
</html>
