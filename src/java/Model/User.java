/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import SqlOperation.SQLHelper;
import java.sql.Date;


/**
 *
 * @author zhichengfu
 */
public class User {
     
    public String userName, ID, password;
    
    public int level;
    
    public static boolean checkLogIn(String userName, String password) 
    { 
        String selection="select * from user where name= ? and password= ?";
        int out=SQLHelper.ExecSqlQuery(selection, userName,password);
        return out>0;
    }
    
    public static boolean checkNameExisted(String name)
    {
        String selection="select * from user where name= ?";
        int out=SQLHelper.ExecSqlQuery(selection, name);
        return out>0;
    }
    
    public static boolean addUser(String name, String password, int level)
    {
        if (!checkNameExisted(name)) {
            String insertion = "insert into user (name,password,level) values(?,?,?)";
            int out = SQLHelper.ExecSql(insertion, name, password);
            return out > 0;
        } else {
            return false;
        }
    }
    
    public static boolean modifyPassword(String name, String password)
    {
        String updation="update user set password=? where name=?";
        int out = SQLHelper.ExecSql(updation, password, name);
        return out > 0;
    }
    
    public static void addAdminRecord(String name, Date startDate, Date endDate)
    {
        
    }
    
    public static boolean deleteUser(String name)
    {
        String delete = "delete from user where name=?";
        int out = SQLHelper.ExecSql(delete, name);
        return out > 0;
    }
    
}
