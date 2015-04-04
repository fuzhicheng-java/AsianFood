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
        <title>JSP Page</title>
        <link href="../css/Mine.css" rel="stylesheet" />

        <script>
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

        <div id='addCategory'>
            <label><h2>添加餐馆操作</h2></label><br/>
            <form id="canguanform" method='POST' action="../HandleAddRestaurant"  enctype="multipart/form-data">

                <div class="addFCDIV">
                    <table class="centertable">
                        <tr><td>ID:</td><td><input type="text" name="id" required></td></tr>
                        <tr><td>Name:</td><td><input type="text" name="name" required></td></tr>
                        <tr><td>Address:</td><td><input type="text" name="address" required></td></tr>
                        <tr><td>City:</td><td><input type="text" name="city" required></td></tr>
                        <tr><td>State:</td><td><select name="state">
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
                                </select>	</td></tr>
                        <tr><td>Zip:</td><td><input type="text" name="zipcode" required></td></tr>
                        <tr><td>Email:</td><td><input type="email" name="email" required></td></tr>
                        <tr><td>Phone:</td><td><input type="text" name="phone" required></td></tr>
                        <tr><td>Mon-Sat Hours:</td><td><input type="text" name="monh" required></td></tr>
                        <tr><td>Sun Hours:</td><td><input type="text" name="sunh" required></td></tr>
                        <tr><td>Min Price:</td><td><input type="text" name="minprice" required></td></tr>
                        <tr><td>Fee:</td><td><input type="text" name="fee" required></td></tr>
                        <tr><td>Type:</td>
                            <td><select id="restType" name='type' class="selectBox">
                                    <option value="1">Chinese</option>
                                    <option value="2">Thai</option>
                                    <option value="3">Japanese</option>
                                    <option value="4">Indian</option>
                                </select></td></tr>
                        <tr><td>Logo Image:</td><td><input type="file" name="file" required></td></tr>
                        <tr><td><input type="submit" value="Submit"></td></tr>
                    </table>
                </div>
                <br/>
            </form>
        </div>
    </body>
</html>
