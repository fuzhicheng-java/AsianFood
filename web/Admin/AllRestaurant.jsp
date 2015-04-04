<%-- 
    Document   : AllRestaurant
    Created on : Mar 23, 2015, 5:20:18 PM
    Author     : zhichengfu
--%>

<%@page import="com.google.gson.Gson"%>
<%@page import="Control.Tools"%>
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
        Restaurant temp;
        Tools.updateRestaurants(session);
        LinkedList<Restaurant> allRests = (LinkedList<Restaurant>) session.getAttribute("allRestaurants");
        Gson gson = new Gson();
        String oob = gson.toJson(allRests);
        oob = "{ \"rests\" :" + oob + "}";
    %>
    <script>

        var restaurants = '<%=oob%>';
        var rs = JSON.parse(restaurants);
        function goToMenu(id, restid, name)
        {
            window.location = "../HandleGetAllFoods?id="+id+"&restid="+restid+"&name="+name;
        }

        function goToDeleteRe(id, restid, name)
        {
            window.location = "../HandleDeleteRestaurant?id=" + id + "&restid=" + restid + "&name=" + name;
        }

        function goToModifyRe(id, restid, name)
        {
            window.location = "../HandleModifyRestaurant?id=" + id + "&restid=" + restid + "&name=" + name;
        }

        function searchByState(state)
        {
            var value = state.value;
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
                if (value === temp.state)
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
                var flagCity=true;
                var flagName=true;
                var flagID=true;
                var flagState=true;
                if(isCity)
                {
                    if(document.getElementById("yCity").value===temp.city)
                    {
                        flagCity=true;
                    }
                    else
                    {
                        flagCity=false;
                    }
                }
                
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
                var value=document.getElementById("stateValue").value;
                if(value!=="null")
                {
                   if(value===temp.state)
                   {
                       flagState=true;
                   }
                   else
                   {
                       flagState=false;
                   }
                }
                if (flagCity&&flagName&&flagID&&flagState)
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
        
        function onloadCheck()
        {
            var table = document.getElementById("restaurantTable");
            var value=document.getElementById("stateValue").value;
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
                if (value === temp.state)
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


    </script>

    <body style="text-align: center" onload="onloadCheck()">
        <div>
            <label><h2>查看餐馆</h2></label><br/>

            <div class="addFCDIV">
                <label></label>
                <div>
                    <label>State:</label><select id="stateValue" onchange="searchByState(this);">
                        <option value="null">None</option>
                        <option value="AL">Alabama</option>
                        <option value="AK">Alaska</option>
                        <option value="AZ">Arizona</option>
                        <option value="AR">Arkansas</option>
                        <option value="CA">California</option>
                        <option value="CO">Colorado</option>
                        <option value="CT">Connecticut</option>
                        <option value="DE">Delaware</option>
                        <option value="DC">District Of Columbia</option>
                        <option value="FL">Florida</option>
                        <option value="GA">Georgia</option>
                        <option value="HI">Hawaii</option>
                        <option value="ID">Idaho</option>
                        <option value="IL">Illinois</option>
                        <option value="IN">Indiana</option>
                        <option value="IA">Iowa</option>
                        <option value="KS">Kansas</option>
                        <option value="KY">Kentucky</option>
                        <option value="LA">Louisiana</option>
                        <option value="ME">Maine</option>
                        <option value="MD">Maryland</option>
                        <option value="MA">Massachusetts</option>
                        <option value="MI">Michigan</option>
                        <option value="MN">Minnesota</option>
                        <option value="MS">Mississippi</option>
                        <option value="MO">Missouri</option>
                        <option value="MT">Montana</option>
                        <option value="NE">Nebraska</option>
                        <option value="NV">Nevada</option>
                        <option value="NH">New Hampshire</option>
                        <option value="NJ">New Jersey</option>
                        <option value="NM">New Mexico</option>
                        <option value="NY">New York</option>
                        <option value="NC">North Carolina</option>
                        <option value="ND">North Dakota</option>
                        <option value="OH">Ohio</option>
                        <option value="OK">Oklahoma</option>
                        <option value="OR">Oregon</option>
                        <option value="PA">Pennsylvania</option>
                        <option value="RI">Rhode Island</option>
                        <option value="SC">South Carolina</option>
                        <option value="SD">South Dakota</option>
                        <option value="TN">Tennessee</option>
                        <option value="TX">Texas</option>
                        <option value="UT">Utah</option>
                        <option value="VT">Vermont</option>
                        <option value="VA">Virginia</option>
                        <option value="WA">Washington</option>
                        <option value="WV">West Virginia</option>
                        <option value="WI">Wisconsin</option>
                        <option value="WY">Wyoming</option>
                    </select>
                    <input type="checkbox" name="isCity" id="isCity"><label>City:</label><input type="text" id="yCity" name="yCity">
                    <input type="checkbox" name="isID" id="isID"><label>ID:</label><input type="text" id="yID" name="yID">
                    <input type="checkbox" name="isName" id="isName"><label>Name:</label><input type="text" id="yName" name="yName">
                    <input type="submit" value="Search" onclick="searchByCombined()"><br/>
                    <br/>
                </div>
                <table class="restauranttable" id="restaurantTable">

                    <tr>
                        <th>Logo</th><th>ID</th><th>Name</th><th>Address</th><th>City</th><th>State</th>
                        <th>Zip</th><th>Manage Menu</th><th>Modify Restaurant</th><th>Delete Restaurant</th>
                    </tr>

                </table>
            </div>
            <br/>

        </div>
    </body>
</html>

