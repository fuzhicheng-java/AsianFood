/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import SqlOperation.SQLHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Collator;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author zhichengfu
 */
public class Restaurant {
    
    public int mainID;
    
    public String ID, name;
    
    public int type; // 0 spring ,1 summer, 2 fall, 3 winter;
    
    public double minPrice, fee;
    
    public String monHours, sunHours;
    
    public String logoImage;
    
    public String address, city, state, phone,email;
    
    public String zipcode;
    
    public static LinkedList<Restaurant> allRestaurants=new LinkedList<>();
    
    public static boolean addNewRestaurant(Restaurant res) {

        String sql = "insert into restaurant "
                + "(restid,name,address,city,state,zipcode, phone,email,hourmon,hoursun,minprice,fee,logo,type)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int out = SQLHelper.ExecSql(sql, res.ID, res.name,res.address, res.city, res.state, res.zipcode,
                res.phone, res.email, res.monHours, res.sunHours, res.minPrice, res.fee, res.logoImage, res.type);
        return out > 0;

    }
    
    public static boolean checkExisted(String name, String ID)
    {
        String query="select * from restaurant where name= ? and restid=?";
        int out=SQLHelper.ExecSqlQuery(query, name,ID);
        return out>0;
    }
    
    public static boolean deleteRestaurant(int id)
    {
        String sql="delete from restaurant where id=?";
        int out=SQLHelper.ExecSql(sql, id);
        return out>0;
    }
    
    public static boolean modifyRestaurant(Restaurant res)
    {
        String sql="UPDATE restaurant SET "
                + "restid=?,name=?,address=?,city=?,state=?,zipcode=?, phone=?,"
                + "email=?,hourmon=?,hoursun=?,minprice=?,fee=?,logo=?, type=?"
                + " where id=?";
        int out=SQLHelper.ExecSql(sql, res.ID,res.address,res.city,res.state,
                res.zipcode,res.phone,res.email,res.monHours,res.sunHours,res.minPrice,
                res.fee,res.logoImage,res.type);
        return out>0;
    }
    
    
    public static void getAllRestaurants() throws SQLException
    {
        allRestaurants.clear();
        String query="select * from restaurant";
        ResultSet re=SQLHelper.getResultSet(query);
        while(re.next())
        {
            Restaurant temp=new Restaurant();
            temp.mainID=re.getInt("id");
            temp.ID=re.getString("restid");
            temp.name=re.getString("name");
            temp.address=re.getString("address");
            temp.city=re.getString("city");
            temp.state=re.getString("state");
            temp.zipcode=re.getString("zipcode");
            temp.phone=re.getString("phone");
            temp.email=re.getString("email");
            temp.monHours=re.getString("hourmon");
            temp.sunHours=re.getString("hoursun");
            temp.minPrice=re.getDouble("minprice");
            temp.fee=re.getDouble("fee");
            temp.logoImage=re.getString("logo");
            temp.type=re.getInt("type");
            Restaurant.allRestaurants.add(temp);
        }
        
        
        Collections.sort(allRestaurants, new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant o1, Restaurant o2) {
                return Collator.getInstance().compare(o2.ID, o1.ID); //To change body of generated methods, choose Tools | Templates.
            }
     });
    }
    
    public static Restaurant getRestaurantsByID(String ID)
    {
        
        for(Restaurant re:allRestaurants)
        {
            if(re.ID.equals(ID))
            {
                return re;
            }
        }
        return null;
    }
    
    public static LinkedList<Restaurant> getRestaurantsByName(String name)
    {
        LinkedList<Restaurant> temp=new LinkedList<>();
        for(Restaurant re:allRestaurants)
        {
            if(re.name.toLowerCase().contains(name.toLowerCase()))
            {
                temp.add(re);
            }
        }
        return temp;
    }
    
    public static Restaurant getRestaurantsByZip(String  zip)
    {
        
        for(Restaurant re:allRestaurants)
        {
            if(re.zipcode.equals(zip))
            {
                return re;
            }
        }
        return null;
    }
    
    public static String getNameByID(int id)
    {
        for(Restaurant re:allRestaurants)
        {
            if(re.mainID==id)
            {
                return re.name;
            }
        }
        return null;
    }
    
    
   
}
