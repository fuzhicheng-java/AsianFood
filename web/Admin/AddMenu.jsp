<%-- 
    Document   : AddCategory
    Created on : Mar 15, 2015, 5:06:25 PM
    Author     : zhichengfu
--%>
<%@page import="Model.Category"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            LinkedList<Category> firstCategory = (LinkedList<Category>) session.getAttribute("firstCategory");
            String id = request.getParameter("id");
            String restid = request.getParameter("restid");
            String name = request.getParameter("name");
            

        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Category</title>
        <link href="../css/Mine.css" rel="stylesheet" />
        <script>
            var id = 0;
            var total1 = 0;
            var total2 = 0;
            var total3 = 0;
            var xmlhttp = new XMLHttpRequest();

            function addCategory(value)
            {
                var div = document.createElement("div");
                var link = document.createElement("a");
                var label = document.createElement("label");
                var input = document.createElement("input");

                link.setAttribute("href", "javascript:void(0);");

                input.setAttribute("required", "required");
                input.setAttribute("type", "text");
                input.setAttribute("placeholder", "新类别");

                label.setAttribute("for", "facatetory-" + id);
                input.setAttribute("id", "fcategory-" + id);
                if (value === 1)
                {
                    input.setAttribute("name", "fcategory1");
                }


                id++;

                link.onclick = function () {
                    div.parentNode.removeChild(div);
                    if (value === 1)
                    {
                        total1 = total1 - 1;
                    }

                };

                div.appendChild(label);
                div.appendChild(input);
                div.appendChild(link);

                link.appendChild(document.createTextNode("[-]"));
                label.appendChild(document.createTextNode("新类别："));

                if (value === 1)
                {
                    total1 = total1 + 1;
                    document.getElementById("addFCD").insertBefore(div, document.getElementById("submitFC"));
                }

            }

            function checkSubmit()
            {
                xmlhttp = new XMLHttpRequest();
                if (total1 > 0)
                    {
                        var inputs = document.getElementsByName("fcategory1");
                        var i;
                        var params = "";
                        var name = "fcategory";
                        var flag = 1;
                        for (i = 0; i < inputs.length; i++)
                        {
                            if (inputs[i].value.length === 0)
                            {
                                alert("Please make sure the value is not empty");
                                flag = 0;
                                break;
                            }

                            if (i === 0)
                            {
                                params += "?" + name + "=" + inputs[i].value;
                            }
                            else
                            {
                                params += "&" + name + "=" + inputs[i].value;
                            }
                        }
                        if (flag === 1)
                        {
                            xmlhttp.onreadystatechange = function ()
                            {
                                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                                {
                                    if (xmlhttp.responseText === "1")
                                    {
                                        alert("添加成功！");
                                        window.location = "../HandleRedirectAddCategory?"+"id=" + <%=id%> + "&restid="+'<%=restid%>'+"&name="+'<%=name%>';
                                    }
                                    else
                                    {
                                        alert("添加失败！");
                                    }
                                }
                            }
                            params += "&id=" + <%=id%> + "&restid="+'<%=restid%>'+"&name="+'<%=name%>';
                            xmlhttp.open("GET", "../HandleAddCategory" + params, true);
                            xmlhttp.send();
                        }
                    }
                    else
                    {
                        alert("Please add new category");
                    }
                }
            
            function checkStatus(value)
            {
                if (value === 0)
                {
                    alert("Some exception occured!");
                }
                if (value === 1)
                {
                    alert("The name or ID have already existed!");
                }

                if (value === 2)
                {
                    alert("Adding Successfully");
                }

                if (value === 3)
                {
                    alert("Adding Failed");
                }
                if(value===4)
                {
                    alert("Adding Images Failed");
                }
            }
        </script>
    </head>
    <%
        int index = -1;
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
    %>
    <body style="text-align: center" onload="checkStatus(<%=index%>)">
        <%} else {
        %>
    <body style="text-align: center" onload="checkStatus(-1)">
        <%}
        %>
            <label><h2>餐厅&nbsp;<%=name%>:&nbsp;添加菜系操作</h2></label>
            <labe><a href="ManageMenu.jsp?id=<%=id%>&restid=<%=restid%>&name=<%=name%>"><h2>Back</h2></a></label><br/>
            <form id="form" method='POST' action="../HandleAddFoodMenu" style="text-align: center" enctype="multipart/form-data">

                <div class="addFCDIV" id="addFCD">
                    <label>菜系类别操作</label><br/><br/>
                    <label>已有菜系类别</label>
                    <select id="firstCategory" name='firstcategory' class="selectBox" required="required">
                        <%
                            if (firstCategory != null) {
                                for (Category fc : firstCategory) {
                        %>
                        <option value='<%=fc.ID%>'><%=fc.name%></option>
                        <%
                                }
                            }
                        %>
                    </select>
                    <input id='addFC' type='button' value='添加菜系类别' onclick="addCategory(1)"><br/>
                    <br/><label id="submitFC"></label>
                    <br/><input type="button" value="提交" onclick="checkSubmit()"><br/>
                </div>
                <br/>
                <div class="addFCDIV" id="addSCD">
                    <table class="centertable">
                        <tr><td>ID:</td><td><input type="text" name="id" required></td></tr>
                        <tr><td>Name:</td><td><input type="text" name="name" required></td></tr>
                        <tr><td>Price:</td><td><input type="text" name="price" required></td></tr>
                        <tr><td>Pieces:</td><td><input type="text" name="pieces" required></td></tr>
                        <tr><td>Description:</td><td><textarea name="description" rows="10" cols="50" required></textarea></td></tr>                  
                        <tr><td>Images:</td><td><input type="file" name="file" multiple required></td></tr>
                       
                    </table>
                    <input type="submit" value="提交">
                    <input type="hidden" name="rid" value="<%=id%>">
                    <input type="hidden" name="restid" value="<%=restid%>">
                    <input type="hidden" name="rename" value="<%=name%>">
                </div>
                <br/>

            </form>
    </body>
</html>
