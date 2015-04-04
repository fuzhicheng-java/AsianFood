/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import SqlOperation.SQLHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author zhichengfu
 */
public class Food {
    
    public int restid;
    public String name;
    public int categoryid;
    public double price; 
    public String description;
    public LinkedList<String> images=new LinkedList<>();
    public String ID;
    public int pieces;
    public int id;
    public String rename,resID;
    
    public static LinkedList<Food> allFoods=new LinkedList<>();
    
    public static boolean addNewFood(Food res) {

        String sql = "insert into food "
                + "(restid,categoryid,name,foodid,price,pieces,description)"
                + " values (?,?,?,?,?,?,?)";
        int out = SQLHelper.ExecSql(sql, res.restid, res.categoryid,res.name,res.ID, res.price,
                res.pieces, res.description);
        return out > 0;

    }
    
    public static boolean checkExisted(String name, String ID)
    {
        String query="select * from food where name= ? and foodid=?";
        int out=SQLHelper.ExecSqlQuery(query, name,ID);
        return out>0;
    }
    
    public static boolean deleteFood(int id)
    {
        String sql="delete from food where id=?";
        int out=SQLHelper.ExecSql(sql, id);
        return out>0;
    }
    
    public static boolean modifyRestaurant(Restaurant res)
    {
        String sql="UPDATE food SET "
                + "restid=?,name=?,address=?,city=?,state=?,zipcode=?, phone=?,"
                + "email=?,hourmon=?,hoursun=?,minprice=?,fee=?,logo=?, type=?"
                + " where id=?";
        int out=SQLHelper.ExecSql(sql, res.ID,res.address,res.city,res.state,
                res.zipcode,res.phone,res.email,res.monHours,res.sunHours,res.minPrice,
                res.fee,res.logoImage,res.type);
        return out>0;
    }
    
    
    public static void getAllFoods() throws SQLException
    {
        allFoods.clear();
        String query="select * from food";
        ResultSet re=SQLHelper.getResultSet(query);
        while(re.next())
        {
            Food temp=new Food();
            temp.id=re.getInt("id");
            temp.restid=re.getInt("restid");
            temp.name=re.getString("name");
            temp.ID=re.getString("foodid");
            temp.description=re.getString("description");
            temp.price=re.getDouble("price");
            temp.pieces=re.getInt("pieces");
            temp.categoryid=re.getInt("categoryid");
            Food.allFoods.add(temp);
        }
    }
    
    public static Food getFoodByID(String ID)
    {
        
        for(Food re:Food.allFoods)
        {
            if(re.ID.equals(ID))
            {
                return re;
            }
        }
        return null;
    }
    
    public static Food getFoodByRealID(int id)
    {
        
        for(Food re:Food.allFoods)
        {
            if(re.id==id)
            {
                return re;
            }
        }
        return null;
    }
    
    public static LinkedList<Food> getFoodsByName(String name)
    {
        LinkedList<Food> temp=new LinkedList<>();
        for(Food re:allFoods)
        {
            if(re.name.toLowerCase().contains(name.toLowerCase()))
            {
                temp.add(re);
            }
        }
        return temp;
    }
    
    public static int getFoodID(String foodid) throws SQLException
    {
        String query="select * from food where foodid=?";
        ResultSet re=SQLHelper.getResultSet(query,foodid);
        while(re.next())
        {
            return re.getInt("id");
        }
        return -1;
    }
    
    public static String getRestaurantNameByID(int fid)
    {
        for(Food fd:allFoods)
        {
            if(fd.id==fid)
            {
                return Restaurant.getNameByID(fd.restid);
            }
        }
        return null;
    }
    
    public static String getOneImage(int id) throws SQLException
    {
        Image.getAllImagesByID(id);
        return Image.names.getFirst().address;
    }
    
    
    
  
}
