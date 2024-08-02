package com.mycompany.fileapp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author arda
 */
public class File {
     private String name;
    private String content;

    public File(String name) {
        this.name = name;
        this.content = "";
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void writeContent(String content) {
        this.content = content;
    }
    
}
