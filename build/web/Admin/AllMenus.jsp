<%-- 
    Document   : AllRestaurant
    Created on : Mar 23, 2015, 5:20:18 PM
    Author     : zhichengfu
--%>

<%@page import="Control.Tools"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="Model.Food"%>
<%@page import="Model.Restaurant"%>
<%@page import="java.util.LinkedList"%>
<%-- 
    Document   : AddRestaurant
    Created on : Mar 23, 2015, 4:36:11 PM
    Author     : zhichengfu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Restaurants</title>
        <link href="../css/Mine.css" rel="stylesheet" />
    </head>
        <%
        Food temp;
        LinkedList<Food> allRests = (LinkedList<Food>) session.getAttribute("allFoods");
        Gson gson = new Gson();
        String oob = gson.toJson(allRests);
        oob = "{ \"foods\" :" + oob + "}";
    %>
    <%
        String id = request.getParameter("id");
        String restid = request.getParameter("restid");
        String name = request.getParameter("name");
    %>

    <script>
        function addMenu(id, restid, name)
        {
            window.location="AddMenu.jsp?id="+id+"&restid="+restid+"&name="+name;
        }
        function goToFood(id, rid,restid,resname)
        {
            window.location = "ShowFoodDetail.jsp?fid=" + id + "&rid=" + rid + "&restid=" + restid+"&resname="+resname;
        }

        function goToDeleteFood(id, restid, name)
        {
            window.location = "../HandleDeleteRestaurant?id=" + id + "&restid=" + restid + "&name=" + name;
        }

        function goToModifyFood(id, restid, name)
        {
            window.location = "../HandleModifyRestaurant?id=" + id + "&restid=" + restid + "&name=" + name;
        }
        
         
        function searchByCombined()
        {
            var isCity=document.getElementById("isCity").checked;
            var isName=document.getElementById("isName").checked;
            var isID=document.getElementById("isID").checked;
            if(!isCity&&!isName&&!isID)
            {
                alert("Please pick one selection");
            }
            else
            {
            var table = document.getElementById("restaurantTable");
            var length = table.rows.length;
            var index = 1;
            while (index < length)
            {
                table.deleteRow(index);
                length = table.rows.length;
            }
            for (index = 0; index < rs.rests.length; index++)
            {
                var temp = rs.rests[index];
                var flagName=true;
                var flagID=true;
               
                
                if(isName)
                {
                    if(document.getElementById("yName").value===temp.name)
                    {
                        flagName=true;
                    }
                    else
                    {
                        flagName=false;
                    }
                }
                if(isID)
                {
                    if(document.getElementById("yID").value===temp.ID)
                    {
                        flagID=true;
                    }
                    else
                    {
                        flagID=false;
                    }
                }
                
                if (flagName&&flagID)
                {
                    var tr = table.insertRow(1);
                    var content =
                            "<td><img src=" + temp.logoImage + " class='logoImage'></td>"
                            + "<td>" + temp.ID + "</td>"
                            + "<td>" + temp.name + "</td>"
                            + "<td>" + temp.address + "</td><td>" + temp.city + "</td><td>" + temp.state + "</td><td>" + temp.zipcode + "</td>"
                            + "<td><input type='submit' value='菜单管理' onclick=\"goToMenu('" + temp.mainID + "','" + temp.ID + "','" + temp.name + "')\"></td>"
                            + "<td><input type='submit' value='修改餐馆信息' onclick=\"goToModifyRe('" + temp.mainID + "','" + temp.ID + "','" + temp.name + "')\"></td>"
                            + "<td><input type='submit' value='删除餐馆' onclick=\"goToDeleteRe('" + temp.mainID + "','" + temp.ID + "','" + temp.name + "')\"></td>";
                    tr.innerHTML = content;
                }
            }
        }
        }


    </script>

    <body style="text-align: center">
            <label><h2><%=name%>的菜单浏览</h2></label>
            <label>添加菜单</label><input type='button' value='添加菜单' onclick="addMenu(<%=id%>,'<%=restid%>','<%=name%>')"><br/><br/>
<!--            <a href="ManageMenu.jsp?id=<%=id%>&restid=<%=restid%>&name=<%=name%>"><h2>Back</h2></a><br/>-->
                <div class="addFCDIV">
                    
                    <div>
                        <input type="checkbox" name="isID" id="isID"><label>ID:</label><input type="text" id="yID" name="yID">
                        <input type="checkbox" name="isName" id="isName"><label>Name:</label><input type="text" id="yName" name="yName">
                        <input type="submit" value="Search" onclick="searchByCombined()"><br/>
                    </div>
                    <br/>
                    <table class="restauranttable" id="restaurantTable">
                        <tr>
                            <th>Image</th><th>ID</th><th>Name</th><th>Pieces</th><th>Price</th>
                            <th>Full Details</th><th>Modify Restaurant</th><th>Delete Meal</th>
                        </tr>
                        <%

                            for (int i = 0; i < allRests.size(); i++) 
                            {
                                temp = allRests.get(i);

                        %>
                        <tr>
                            <td><img src="<%=temp.getOneImage(temp.id)%>" class="logoImage"></td>
                            <td><%=temp.ID%></td>
                            <td><%=temp.name%></td>
                            <td><%=temp.pieces%></td><td><%=temp.price%></td>
                            <td><input type="submit" value="菜品详情" onclick="goToFood(<%=temp.id%>, '<%=id%>', '<%=restid%>','<%=name%>')"></td>
                            <td><input type="submit" value="修改菜品" onclick="goToModifyFood(<%=temp.id%>, '<%=temp.ID%>', '<%=temp.name%>')"></td>
                            <td><input type="submit" value="删除菜品" onclick="goToDeleteFood(<%=temp.id%>, '<%=temp.ID%>', '<%=temp.name%>')"></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
    </body>
</html>

