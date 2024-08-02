package com.mycompany.fileapp;


import java.util.HashMap;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author arda
 */
public class Directory {
     private String name;
    private Map<String, File> files;
    private Map<String, Directory> directories;

    public Directory(String name) {
        this.name = name;
        this.files = new HashMap<>();
        this.directories = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, File> getFiles() {
        return files;
    }

    public Map<String, Directory> getDirectories() {
        return directories;
    }

    public void addFile(File file) {
        files.put(file.getName(), file);
    }

    public void addDirectory(Directory directory) {
        directories.put(directory.getName(), directory);
    }

    public void removeFile(String fileName) {
        files.remove(fileName);
    }

    public void removeDirectory(String dirName) {
        directories.remove(dirName);
    }
}
