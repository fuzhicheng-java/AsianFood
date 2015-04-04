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
public class Category {
    public int ID;
    public String name;
    
    public static LinkedList<Category> names=new LinkedList<>();
    
    public static boolean addCategory(String value, int restid)
    {
        if(!checkExisted(value))
        {
            String insertion = "insert into category (restid,name) values(?,?)";
            int out = SQLHelper.ExecSql(insertion, restid,value);
            return out > 0;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean checkExisted(String name)
    {
        String selection="select * from category where name= ?";
        int out=SQLHelper.ExecSqlQuery(selection, name);
        return out>0;
    }
    
    public static LinkedList<Category> getAllCategories() throws SQLException
    {
        String selection="select * from category";
        ResultSet outs=SQLHelper.getResultSet(selection);
        names.clear();
        while(outs.next())
        {
            Category test=new Category();
            test.ID=Integer.parseInt(outs.getString("id"));
            test.name=outs.getString("name");
            names.add(test);           
        }
        return names;
    }
    
    public static String getNameByID(int id)
    {
        for(Category c:names)
        {
            if(c.ID==id)
            {
                return c.name;
            }
        }
        return null;
    }
    
    
    
}
