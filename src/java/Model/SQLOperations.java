/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import SqlOperation.SQLHelper;

/**
 *
 * @author zhichengfu
 */
public class SQLOperations {
    
    public static boolean checkExisted(String table, String name, String value)
    {
        String selection="select * from "+table+" where "+name+"= ?";
        int out=SQLHelper.ExecSqlQuery(selection, value);
        return out>0;
    }
    
    
}
