/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gradesmartt.w;
import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Akshar
 */
public class UserList {
   private static UserList userList = new UserList();
   public static HashMap<String, User> users = new HashMap<String,User>();
   public static HashMap<String, String> userRecover = new HashMap<String,String>();
   
   private UserList() {}
   public static UserList getInstance() {
       return userList;
   }
}
