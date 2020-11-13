/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sport.service;

import com.mycompany.sport.auth.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sigur
 */
public class ListAdapter {
    String name;
    ArrayList<String> names;
    
    public ArrayList<String> convertNames(List<User> userlist) {
    int i;
    
    for(i = 0; i<userlist.size(); i++)
    {
        User user = new User();
        user = userlist.get(i);
        String fname = user.getFirstName();
        String lname = user.getLastName();
        name = fname +" " + lname;
        names.add(name);
    }
        return names;
}
    
}
