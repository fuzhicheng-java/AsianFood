<%-- 
    Document   : ManageMenu
    Created on : Mar 23, 2015, 10:18:08 PM
    Author     : zhichengfu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link href="../css/Mine.css" rel="stylesheet" />
    </head>
    <script>
        function addMenu(id, restid, name)
        {
            window.location="AddMenu.jsp?id="+id+"&restid="+restid+"&name="+name;
        }
        
        function seeMenu(id, restid, name)
        {
            window.location="../HandleGetAllFoods?id="+id+"&restid="+restid+"&name="+name;
        }
    </script>
    <%
        String id = request.getParameter("id");
        String restid = request.getParameter("restid");
        String name = request.getParameter("name");
    %>
    <body style="text-align: center">
        <label><h2><%=name%>的菜单操作</h2></label><br/>
        <form style="text-align: center">
            <div class="addFCDIV">
                <label>查看菜单</label><input type='button' value='查看菜单' onclick="seeMenu(<%=id%>,'<%=restid%>','<%=name%>')">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label>添加菜单</label><input type='button' value='添加菜单' onclick="addMenu(<%=id%>,'<%=restid%>','<%=name%>')"><br/>
            </div>
            <br/>
        </form>
    </div>
</body>
</html>
