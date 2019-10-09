package com.company;

import java.io.Console;
import java.util.Scanner;

public class Credentials {

    private String username;
    private String password;

    private void setUsername(String username){

        this.username = username;

    }

    private void setPassword(String password){

        this.password = password;

    }

    public void requestCredentials(){
        Scanner scanner = new Scanner(System.in);
        Console console = System.console();
        System.out.println("Enter Username: ");
        String username = scanner.nextLine();
        String password = String.valueOf(console.readPassword("Enter Pass:"));

        setUsername(username);
        setPassword(password);

    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }



}