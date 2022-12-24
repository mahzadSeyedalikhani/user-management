package com.digipay.usermanagement;

import com.digipay.usermanagement.model.entity.Permission;
import com.digipay.usermanagement.model.entity.Role;
import com.digipay.usermanagement.service.PermissionService;
import com.digipay.usermanagement.service.RoleService;
import com.digipay.usermanagement.service.UserService;
import com.digipay.usermanagement.util.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Scanner;


public class App {
    static Scanner scanner = new Scanner(System.in);
    static Logger logger= LoggerFactory.getLogger(App.class);

    public static void getUserInfo(){
        UserService userService= Context.getUserService();
        RoleService roleService = Context.getRoleService();
        System.out.println("Enter username please");
        String username = scanner.next();
        System.out.println("enter user national code please");
        int nationalCode = scanner.nextInt();

        List<Role> roleList = roleService.displayUserRole();
        if(roleList.isEmpty()) {
            System.out.println("There is no role list yet. " +
                    "now application will terminated and then you should first create some roles" + '\n'+
                    "GoodLuck :)");
            return;
        }
        System.out.println("please select the number of required role");
        logger.info("list of roles: {}", roleList);
        String selectedRole = scanner.next();
        String[] roleId = selectedRole.split(",");
        userService.createUser(username, nationalCode, roleId);
    }


    public static void getRoleInfo(){
        PermissionService permissionService = Context.getPermissionService();
        RoleService roleService = Context.getRoleService();
        System.out.println("enter the role title please");
        String roleTitle = scanner.next();
        List<Permission> permissionList = permissionService.displayPermission();
        if(permissionList.isEmpty()) {
            System.out.println("There is no permission list yet. " +
                    "now application will terminated and then you should first create some permissions" + '\n'+
                    "GoodLuck :)");
            return;
        }
        System.out.println("please select the number(s) of required permission(s)");
        logger.info("list of permissions: {}",permissionList);
        String selectedPermission = scanner.next();
        String[] roleId = selectedPermission.split(",");
        roleService.createUserRole(roleTitle, roleId);
    }


    public static void main( String[] args ) {
//        UserService userService= Context.getUserService();
//        RoleService roleService = Context.getRoleService();
//        PermissionService permissionService = Context.getPermissionService();
//        logger.info("welcome to Digipay Management System!"+ '\n' + "Select the number of main sector");
//        logger.info("1- user operations" +'\n'+ "2- role operation"+ '\n'+ "3- permission operation");
//        int entryCommand = scanner.nextInt();
//
//        if(entryCommand == 1) {
//            logger.info("plz select one item" + '\n' + "1- create user" + '\n' + "2- list all users" + '\n' +
//                    "3- update a user" + '\n' + "4- delete a user");
//           /int userCommand = scanner.nextInt();
//
//            if(userCommand == 1)
//                getUserInfo();
//            else if(userCommand == 2)
//                logger.info("{}", userService.displayUser());
//            else if(userCommand == 3)
//                userService.updateUser(2L,"staff");
//            else if(userCommand == 4)
//                userService.removeUser(2L);
//
           Boolean key= Boolean.TRUE;
            while (key) {
            }
        }

//        else if(entryCommand == 2){
//            logger.info("plz select one item" + '\n' + "1- create role" + '\n' + "2- list all roles" + '\n' +
//                    "3- update a role" + '\n' + "4- delete a role");
//            int roleCommand = scanner.nextInt();
//
//            if(roleCommand == 1)
//                getRoleInfo();
//
//            else if(roleCommand == 2)
//                logger.info("{}",roleService.displayUserRole());
//
//            else if(roleCommand == 3)
//                roleService.updateUserRole(2L,"staff");
//
//            else if(roleCommand == 4)
//                roleService.removeUserRole(1L);
//        }
//
//        else if(entryCommand == 3){
//            logger.info("plz select one item" + '\n' + "1- create permission" + '\n' + "2- list all permissions" + '\n' +
//                    "3- update a permission" + '\n' + "4- delete a permission");
//            int permissionCommand = scanner.nextInt();
//
//            if(permissionCommand == 1) {
//                System.out.println("Enter the Permission title please");
//                String permissionTitle = scanner.next();
//                permissionService.createPermission(permissionTitle);
//            }
//            else if(permissionCommand == 2)
//                logger.info("{}",permissionService.displayPermission());
//            else if(permissionCommand == 3)
//                permissionService.updatePermission(2L,"deploy");
//            else if(permissionCommand == 4)
//                permissionService.removePermission(52L);
//        }
//    }
}
