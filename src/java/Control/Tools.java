/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Category;
import Model.Food;
import Model.Restaurant;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zhichengfu
 */
public class Tools {
    
    
    public static void updateRestaurants(HttpSession session) throws SQLException {
        Restaurant.getAllRestaurants();
        if (session.getAttribute("allRestaurants") == null) {
            session.setAttribute("allRestaurants", Restaurant.allRestaurants);

        } else {
            session.removeAttribute("allRestaurants");
            session.setAttribute("allRestaurants", Restaurant.allRestaurants);

        }
    }
    
    public static void updateCategory(HttpSession session) throws SQLException
    {
         session.removeAttribute("firstCategory");
            if (session.getAttribute("firstCategory") == null) {
                LinkedList<Category> firstCategory = Category.getAllCategories();
                session.setAttribute("firstCategory", firstCategory);   
            }
            
    }
    
    public static void updateFoods(HttpSession session) throws SQLException {
        Food.getAllFoods();
        if (session.getAttribute("allFoods") == null) {
            session.setAttribute("allFoods", Food.allFoods);

        } else {
            session.removeAttribute("allFoods");
            session.setAttribute("allFoods", Food.allFoods);

        }
    }
    
  public static String CurrentTime()
  {
    Date now = new Date();

    int year = now.getYear();
    int month = now.getMonth() + 1;
    int day = now.getDate();

    int hh = now.getHours();
    int mm = now.getMinutes();
    int ss = now.getSeconds();

    String clock = year + "-";

    if (month < 10) {
      clock = clock + "0";
    }

    clock = clock + month + "-";

    if (day < 10) {
      clock = clock + "0";
    }

    clock = clock + day + "_";

    if (hh < 10) {
      clock = clock + "0";
    }

    clock = clock + hh + "_";
    if (mm < 10) {
      clock = clock + '0';
    }
    clock = clock + mm + "_";
    if (ss < 10) {
      clock = clock + '0';
    }
    clock = clock + ss;
    return clock;
  }
}
