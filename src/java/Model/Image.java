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
public class Image {
    public int id;
    
    public int foodid;
    
    public String address, name;
    
    public static LinkedList<Image> names=new LinkedList<>();
    
    public static boolean addImage(String name,String address, int foodid)
    {
        if(!checkExisted(name,foodid))
        {
            String insertion = "insert into images (foodid,name,address) values(?,?,?)";
            int out = SQLHelper.ExecSql(insertion, foodid,name,address);
            return out > 0;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean checkExisted(String name,int foodid)
    {
        String selection="select * from images where name= ? and foodid=?";
        int out=SQLHelper.ExecSqlQuery(selection, name,foodid);
        return out>0;
    }
    
    public static void getAllImagesByID(int foodid) throws SQLException
    {
        String selection="select * from images where foodid=?";
        ResultSet outs=SQLHelper.getResultSet(selection,foodid);
        names.clear();
        while(outs.next())
        {
            Image test=new Image();
            test.id=Integer.parseInt(outs.getString("id"));
            test.name=outs.getString("name");
            test.address=outs.getString("address");
            test.foodid=outs.getInt("foodid");
            names.add(test);           
        }      
    }
}
