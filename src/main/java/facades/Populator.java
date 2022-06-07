/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javax.persistence.EntityManagerFactory;

import dtos.UserDTO;
import entities.Role;
import entities.User;
import utils.EMF_Creator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        UserFacade userFacade = UserFacade.getUserFacade(emf);
        List<Role> admin = new ArrayList<>();
        List<Role> basic = new ArrayList<>();
        admin.add(new Role("admin"));
        basic.add(new Role("basic"));
        userFacade.create(new UserDTO(new User("First 1", "Last 1", "Email1", admin)));
        userFacade.create(new UserDTO(new User("First 2", "Last 2", "Email2", admin)));
        userFacade.create(new UserDTO(new User("First 3", "Last 3", "Email3", basic)));
    }
    
    public static void main(String[] args) {
        populate();
    }
}
